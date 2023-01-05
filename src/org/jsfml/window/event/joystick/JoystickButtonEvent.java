package org.jsfml.window.event.joystick;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class JoystickButtonEvent extends Struct {
	public int button;
	
	public JoystickButtonEvent() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public JoystickButtonEvent(Runtime runtime) {
		super(runtime);
	}
}