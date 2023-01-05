package org.jsfml;

import java.util.HashMap;
import java.util.Map;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.internal.JSFML;
import org.jsfml.system.Vector2i;
import org.jsfml.system.Vector2u;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;
import org.jsfml.window.Window;
import org.jsfml.window.Window.WindowStyle;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;
import org.jsfml.window.event.MouseMoveEvent;
import org.jsfml.window.event.EventType;

import jnr.ffi.LibraryLoader;
import jnr.ffi.LibraryOption;

public class test {

	public static void main(String[] args) {
		/*File file=new File("./CSFML_header/Graphics/");
		Converter converter=new Converter(new String[] {
				"./CSFML_header/Graphics/RenderWindow.h",
				"./CSFML_header/Graphics/Sprite.h"
		});
		Converter converter=new Converter(file.listFiles());
		//converter.convertAndSave("./test.java", "CsfmlGraphicsLibrary", new String[] {"RenderWindow", "Sprite"});
		converter.convertAndSaveWithPath("CsfmlGraphicsLibrary", "./");
		
		*/
		JSFML.init();
		
		RenderWindow window=new RenderWindow();
        
        window.create(new VideoMode(800, 600), "test", WindowStyle.DEFAULT_STYLE, new ContextSettings());
        
        // window.getSettings();
        
        // window.setPosition(new Vector2i(100, 100) );
        
        // System.out.println(window.getPosition());
        
        // window.setSize(new Vector2u(800, 600));
        
        while(window.isOpen()) {
        	System.out.println("test");
        	Event event=null;
        	while((event=window.pollEvent())!=null) {
        		switch (event.type){
        		case EventType.CLOSED:
					window.destroy();
					break;
				case EventType.KEY_PRESSED:
					System.out.println(event.asKeyEvent());
					break;
				}	
        	}
        	
        	/*for(Event event : window.pollEvents()) {
    			switch (event.getType()) {
    			case EventType.CLOSED:
    				window.close();
    				break;
				case EventType.MOUSE_MOVED:
					System.out.println(event);
					break;
				case EventType.KEY_PRESSED:
					System.out.println(event);
					break;
				}
    		}*/
        }
    }
}