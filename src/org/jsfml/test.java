package org.jsfml;

import java.io.File;

import org.jsfml.internal.SFMLNative;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;
import org.jsfml.window.Window;
import org.jsfml.window.event.Event;

public class test {

	public static void main(String[] args) {
		SFMLNative.loadNativeLibraries();
		
		Window window=new Window();
        
        window.create(new VideoMode(800, 600), "test", org.jsfml.window.WindowStyle.DEFAULT, new ContextSettings());
        
        // window.getSettings();
        
        // window.setPosition(new Vector2i(100, 100) );
        
        // System.out.println(window.getPosition());
        
        // window.setSize(new Vector2u(800, 600));
        
        window.getPosition();
        
        while(window.isOpen()) {
        	
        	//System.out.println(window.getPosition());
        	for(Event event : window.pollEvents()) {
        		switch (event.type) {
				case CLOSED:
					window.close();
					break;
				}
        	}
        }
        
        /*while(window.isOpen()) {
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
        }*/
        
        
    }
}