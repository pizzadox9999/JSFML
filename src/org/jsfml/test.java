package org.jsfml;

import java.io.File;

import org.jsfml.converter.Converter;
import org.jsfml.internal.JSFML;
import org.jsfml.system.Vector2i;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;
import org.jsfml.window.Window;
import org.jsfml.window.Window.WindowStyle;
import org.jsfml.window.event.Event;

public class test {

	public static void main(String[] args) {
		/*File file=new File("./CSFML_header/Window/");
		/*Converter converter=new Converter(new String[] {
				"./CSFML_header/Graphics/RenderWindow.h",
				"./CSFML_header/Graphics/Sprite.h"
		});
		Converter converter=new Converter(file.listFiles());
		//converter.convertAndSave("./test.java", "CsfmlGraphicsLibrary", new String[] {"RenderWindow", "Sprite"});
		System.out.println("converting");
		converter.convertAndSaveWithPath("CsfmlWindowLibrary", "./");
		System.out.println("converted");
		System.exit(0);
		
		*/
		JSFML.init();
		
		Window window=new Window();
        
        window.create(new VideoMode(800, 600), "test", WindowStyle.DEFAULT_STYLE, new ContextSettings());
        
        // window.getSettings();
        
        // window.setPosition(new Vector2i(100, 100) );
        
        // System.out.println(window.getPosition());
        
        // window.setSize(new Vector2u(800, 600));
        
        while(window.isOpen()) {
        	Event event;
        	while((event=window.pollEvent())!=null) {
        		switch (event.type) {
				case CLOSED:
					window.close();
					break;
				case KEY_PRESSED:
					System.out.println(event.asKeyEvent());
					break;
				}
        	}
        }
        
        
    }
}