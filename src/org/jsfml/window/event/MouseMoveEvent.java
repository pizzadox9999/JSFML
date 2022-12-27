package org.jsfml.window.event;

import org.jsfml.JSFML;
import org.jsfml.window.event.Event.EventType;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class MouseMoveEvent extends Struct {
	public Signed32 type;
	public Signed32 x;
    public Signed32 y;
    
    public MouseMoveEvent(int evenType) {
    	this();
    }
    
    public MouseMoveEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
    public MouseMoveEvent(Runtime runtime) {
		super(runtime);
		type=new Signed32();
		x=new Signed32();
		y=new Signed32();
	}
}