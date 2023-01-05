package org.jsfml.window.event;

import org.jsfml.internal.JSFML;
import org.jsfml.window.event.EventType;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class MouseMoveEvent extends Struct {
	public Signed32 type=new Signed32();
	public Signed32 x=new Signed32();
    public Signed32 y=new Signed32();
    
    public MouseMoveEvent(int evenType) {
    	this();
    }
    
    public MouseMoveEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
    public MouseMoveEvent(Runtime runtime) {
		super(runtime);
	}
}