package org.jsfml.window.event.joystick;



import org.jsfml.internal.JSFML;
import org.jsfml.window.Joystick.JoystickAxis;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class JoystickMoveEvent extends Struct {
	public Signed32 type=new Signed32();
    public Unsigned32 joystickId=new Unsigned32();
    //sfJoystickAxis axis;
    public Signed32 position;
	
    public JoystickMoveEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
    public JoystickMoveEvent(Runtime runtime) {
		super(runtime);
	}
}