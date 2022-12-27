package org.jsfml.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Converter {
	public static final String[][] TYPE_REPLACE=new String[][] {
		{"unsigned", "/*unsigned*/"},
		{"sfBool", "int"},
		{"sfVector2f", "Vector2f"},
		{"sfVector2i", "Vector2i"},
		{"sfVector2u", "Vector2u"},
		{"sfTransform", "Transform"},
		{"sfIntRect", "IntRect"},
		{"sfFloatRect", "FloatRect"},
		{"sfColor", "Color"},
		{"sfVideoMode", "VideoMode"}
	};
	public static final String STRING_TAB="\t";
	private File[] m_filesToConvert;
	private String[] m_convertedFiles;
	
	private int m_currentFileLineCounter=0;
	private String m_currentFileName;
	private Scanner m_currentFileScanner;
	
	public Converter(ArrayList<File> files) {
		init(files.toArray(new File[files.size()]));
	}
	
	public Converter(String[] files) {
		File[] fileArray=new File[files.length];
		for(int i=0; i<files.length; i++) {
			fileArray[i]=new File(files[i]);
		}
		init(fileArray);
	}
	
	public Converter(File[] files) {
		init(files);
	}
	
	private void init(File[] files) {
		m_filesToConvert=files;
		m_convertedFiles=new String[files.length];
	}
	
	public void convert() {
		for(int i=0; i<m_filesToConvert.length; i++) {
			try {
				m_convertedFiles[i]=convertFile(m_filesToConvert[i]);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(m_currentFileName+" "+m_currentFileLineCounter);
				System.exit(0);
			}
		}
	}
	
	public void convertAndSaveWithPath(String javaInterfaceName, String path) {
		convertAndSave(path+"/"+javaInterfaceName+".java", javaInterfaceName);
	}
	
	public void convertAndSave(String outputFileName, String javaInterfaceName) {
		String[] sectionNames=new String[m_filesToConvert.length];
		for(int i=0; i<sectionNames.length; i++) {
			sectionNames[i]=m_filesToConvert[i].getName();
		}
		convertAndSave(outputFileName, javaInterfaceName, sectionNames);
	}
	
	public void convertAndSave(String outputFileName, String javaInterfaceName, String[] sectionNames) {
		convert();
		
		StringBuilder api=new StringBuilder();
		
		api.append("public interface "+javaInterfaceName+" {\n");
		for(int i=0; i<sectionNames.length; i++) {
			api.append(STRING_TAB+"// "+sectionNames[i]+"\n");
			api.append(m_convertedFiles[i]);
			api.append("\n");
		}
		
		api.append("}");
		
		try {
			File file=new File(outputFileName);
			FileWriter fileWriter=null;
			file.createNewFile();
			fileWriter=new FileWriter(file);
			fileWriter.write(api.toString());
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String convertFile(File f) {
		StringBuilder newFile=new StringBuilder();
		m_currentFileName=f.getAbsolutePath();
		try {
			setCurrentFileScanner(new Scanner(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String line=null;
		fileLoop: while(m_currentFileScanner.hasNext()) {
			line=getNextLineFromCurrentFile();
			if(isDocCommentStart(line)) {
				generateDocComments(newFile);
			}
			line=cutDocComment(line);
			if(line.contains("{") && !line.contains("}")) {
				while(!line.contains("}")){
					line=getNextLineFromCurrentFile();
				}
			}
			if(!isValidLine(line)) {
				continue fileLoop;
			}
			if(isMultiLineStart(line)) {
				ArrayList<String> lines=new ArrayList<String>();
				lines.add(line);
				String multiLinePart="";
				while(!isMultiLineEnd(multiLinePart)) {
					multiLinePart=getNextLineFromCurrentFile();
					lines.add(multiLinePart);
				}
				line=convertMultiLineToSingleLine(lines.toArray(new String[lines.size()]));
			}
			convertFileLine(line.replaceAll("const", ""), newFile);
		}
		return newFile.toString();
	}
	
	private void convertFileLine(String line, StringBuilder newFile) {
		if(!line.startsWith("CSFML")) return;
		while(line.startsWith("CSFML")) {
			line=line.substring(line.indexOf(" ")).trim(); //cut the csfml thingy
		}
		//System.out.println(line+" "+m_currentFileName+" "+m_currentFileLineCounter);
		String functionReturnType=line.substring(0, line.indexOf(" ")).trim();
		line=line.substring(line.indexOf(" ")).trim();
		
		String functionName=line.substring(0, line.indexOf("(")).trim();
		line=line.substring(line.indexOf("(")+1, line.indexOf(")")).trim();
		String functionModifier="public";
		String[] functionParameters=new String[] {};
		if(!line.isEmpty() && countInString(line, ",")==0) {
			//one parameter
			functionParameters=new String[] {line};
		} else {
			//many parameters
			functionParameters=line.split(",");
		}
		newFile.append(STRING_TAB+buildJavaFunction(functionModifier, functionReturnType, functionName, functionParameters)+"\n");
	}
	
	private int countInString(String s, String what) {
		return (int)(s.length() - s.replace(what, "").length())/what.length();
	}
	
	private String convertCParameterToJavaParameter(String cParameter) {
		String replaceWith=null;
		if(cParameter.contains("char*")) {
			replaceWith="String";
		} else if(cParameter.contains("*")) {
			replaceWith="Pointer";
		}
		if(replaceWith!=null) {
			String nonPointer=cParameter.substring(0, cParameter.indexOf("*")+1);
			cParameter=replaceWith+"/*("+nonPointer+")*/"+cParameter.substring(cParameter.indexOf("*")+1);
		} else {
			cParameter=cParameter.replace("const", "");
		}
		return replaceSpecial(cParameter);
	}
	
	private String replaceSpecial(String string) {
		String returnString=string;
		for(int i=0; i<TYPE_REPLACE.length; i++) {
			if(returnString.contains(TYPE_REPLACE[i][0])) {
				returnString=returnString.replace(TYPE_REPLACE[i][0], TYPE_REPLACE[i][1]);
			}
		}
		return returnString;
	}
	
	private String[] convertCParametersToJavaParameter(String[] cParameter) {
		for(int i=0; i<cParameter.length; i++) {
			cParameter[i]=convertCParameterToJavaParameter(cParameter[i]);
		}
		return cParameter;
	}
	
	private String buildJavaFunction(String modifier, String returnType, String name, String[] arguments) {
		StringBuilder args=new StringBuilder();
		for(String string : arguments) {
			args.append(convertCParameterToJavaParameter(string)+", ");
		}
		String functionArguments=args.toString();
		functionArguments=functionArguments.substring(0, functionArguments.lastIndexOf(","));
		return modifier+" "+convertCParameterToJavaParameter(returnType)+" "+name+"("+functionArguments+");";
	}
	
	private String convertMultiLineToSingleLine(String[] multiLine) {
		StringBuilder stringBuilder=new StringBuilder();
		for(String string : multiLine) {
			stringBuilder.append(string.trim()+" ");
		}
		return stringBuilder.toString().trim();
	}
	
	private boolean isMultiLineStart(String line) {
		return line.contains("(") && !line.contains(");");
	}
	
	private boolean isMultiLineEnd(String line) {
		return !line.contains("(") && line.contains(");");
	}
	
	private boolean isValidLine(String line) {
		return !line.startsWith("#") && !line.startsWith("/") &&
			   !line.isEmpty() && !line.contains("typedef") && 
			   line.contains("(") && line.contains(")");
	}
	
	private String cutDocComment(String line) {
		if(line.contains("///")) {
			return line.substring(line.indexOf("///"), line.length()-1);
		} else {
			return line;
		}
	}
	
	private boolean isDocCommentStart(String line) {
		return line.startsWith("////////////////////////////////////////////////////////////") && !isValidLine(line); 
	}
	
	private boolean isDocCommentEnd(String line) {
		return isDocCommentStart(line) || line.isEmpty();
	}
	
	private void setCurrentFileScanner(Scanner s) {
		m_currentFileLineCounter=0;
		m_currentFileScanner=s;
		m_isFirstDocComment=true;
	}
	
	private String getNextLineFromCurrentFile() {
		m_currentFileLineCounter++;
		if(m_currentFileScanner.hasNext())
			return m_currentFileScanner.nextLine();
		else {
			return "";
		}
			
	}
	
	private boolean m_isFirstDocComment=true;
	
	private void generateDocComments(StringBuilder newFile) {
		String currentLine=getNextLineFromCurrentFile();
		
		
		StringBuilder docCommentBuilder=new StringBuilder();
		docCommentBuilder.append("\n"+STRING_TAB+"/**\n");
		while(!isDocCommentEnd(currentLine)) {
			docCommentBuilder.append(STRING_TAB+" *"+currentLine.replaceAll("/", "").replace("\\", "@")+"\n");
			currentLine=getNextLineFromCurrentFile();
		}
		docCommentBuilder.append(STRING_TAB+"*/\n");
		if(!m_isFirstDocComment)
			newFile.append(docCommentBuilder);
		else 
			m_isFirstDocComment=false;
	}
}