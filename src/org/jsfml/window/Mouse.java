package org.jsfml.window;

import org.jsfml.system.Vector2i;

public abstract class Mouse {
	public class MouseButton {
	    public static final int LEFT=0;       ///< The left mouse button
	    public static final int RIGHT=1;      ///< The right mouse button
	    public static final int MIDDLE=2;     ///< The middle (wheel) mouse button
	    public static final int XBUTTON1=3;   ///< The first extra mouse button
	    public static final int XBUTTON2=4;   ///< The second extra mouse button

	    public static final int MOUSE_BUTTON_COUNT=5; ///< Keep last -- the total number of mouse buttons
	}
	
	public class MouseWheel {
	    public static final int VERTICAL=0;   ///< The vertical mouse wheel
	    public static final int HORIZONTAL=1; ///< The horizontal mouse wheel
	}
	
	public static boolean isButtonPressed(MouseButton button) {
		
		return false;
	}
	
	public static Vector2i getPosition(Window relativeTo) {
		
		return null;
	}
	
	public static void setPosition(Vector2i position, Window window) {
		
	}
}