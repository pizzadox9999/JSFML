package org.jsfml.window.event.joystick;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class JoyStickEvent extends Struct {
	public Signed32 eventType=new Signed32();
	public int joystickId;
    
    public Signed32 button=new Signed32();
    
    public JoyStickEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
    public JoyStickEvent(Runtime runtime) {
		super(runtime);
	}
}