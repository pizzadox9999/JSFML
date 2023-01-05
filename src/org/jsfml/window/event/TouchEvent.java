package org.jsfml.window.event;

import org.jsfml.JSFML;
import org.jsfml.window.event.Event.EventType;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class TouchEvent extends Struct {
	public Signed32 eventType=new Signed32();
	public int finger;
	public int x;
	public int y;
	
	public TouchEvent() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public TouchEvent(Runtime runtime) {
		super(runtime);
	}
}