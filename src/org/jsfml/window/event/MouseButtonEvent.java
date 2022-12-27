package org.jsfml.window.event;

import org.jsfml.JSFML;
import org.jsfml.window.Mouse.MouseButton;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.Struct.Signed32;

public class MouseButtonEvent extends Struct {
	public Signed32 eventType=new Signed32();
	public Signed32 button=new Signed32();
	
	public int x;
    public int y;
    
    public MouseButtonEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
    public MouseButtonEvent(Runtime runtime) {
		super(runtime);
	}
}