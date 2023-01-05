package org.jsfml.window.event.joystick;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class JoystickConnectEvent extends Struct {
	
	public JoystickConnectEvent() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public JoystickConnectEvent(Runtime runtime) {
		super(runtime);
	}
}