package org.jsfml.window.event;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class MouseWheelScrollEvent extends Struct {
	public Signed32 type=new Signed32();	
	public Signed32 x=new Signed32();
    public Signed32 y=new Signed32();
    
    public Signed32 wheel=new Signed32();
	public float delta;
    
    public MouseWheelScrollEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
    public MouseWheelScrollEvent(Runtime runtime) {
		super(runtime);
	}
}