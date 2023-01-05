package org.jsfml.window.event.joystick;

import jnr.ffi.Runtime;

public class JoystickConnectEvent extends JoyStickEvent {
	
	public JoystickConnectEvent(Runtime runtime) {
		super(runtime);
	}
}