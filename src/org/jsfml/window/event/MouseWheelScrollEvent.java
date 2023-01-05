package org.jsfml.window.event;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class MouseWheelScrollEvent extends Struct {
	public Signed32 eventType=new Signed32();	
	public int x;
    public int y;
    
    public Signed32 wheel=new Signed32();
	public float delta;
    
    public MouseWheelScrollEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
    public MouseWheelScrollEvent(Runtime runtime) {
		super(runtime);
	}
}