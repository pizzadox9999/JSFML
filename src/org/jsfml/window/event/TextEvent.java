package org.jsfml.window.event;

import org.jsfml.JSFML;
import org.jsfml.window.event.Event.EventType;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class TextEvent extends Struct {
	public Signed32 eventType=new Signed32();
	public int unicode;
	
	public TextEvent() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public TextEvent(Runtime runtime) {
		super(runtime);
	}
}
