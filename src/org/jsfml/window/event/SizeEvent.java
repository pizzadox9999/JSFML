package org.jsfml.window.event;

import org.jsfml.JSFML;
import org.jsfml.window.event.Event.EventType;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class SizeEvent extends Struct {
	public Signed32 eventType=new Signed32();
	public int width;
    public int height;
    
    public SizeEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
	public SizeEvent(Runtime runtime) {
		super(runtime);
	}
}