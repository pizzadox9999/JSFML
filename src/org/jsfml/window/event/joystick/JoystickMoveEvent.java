package org.jsfml.window.event.joystick;



import org.jsfml.JSFML;
import org.jsfml.window.Joystick.JoystickAxis;

import jnr.ffi.Runtime;

public class JoystickMoveEvent extends JoyStickEvent {
	public JoystickAxis axis;
    public float position;
	
    public JoystickMoveEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
    public JoystickMoveEvent(Runtime runtime) {
		super(runtime);
	}
}