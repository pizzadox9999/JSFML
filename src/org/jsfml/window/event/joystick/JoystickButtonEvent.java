package org.jsfml.window.event.joystick;

import jnr.ffi.Runtime;

public class JoystickButtonEvent extends JoyStickEvent{
	public int button;
	
	public JoystickButtonEvent(Runtime runtime) {
		super(runtime);
	}
}