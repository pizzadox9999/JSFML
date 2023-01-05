package org.jsfml.window.event;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;

public class KeyEvent extends Event {
	//public Signed32 eventType=new Signed32();
	public Signed32 code=new Signed32();
	public int alt;
	public int control;
	public int shift;
	public int system;
	
	public KeyEvent(int eventType) {
		this();
		this.type.set(eventType);
	}
	
	public KeyEvent() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public KeyEvent(Runtime runtime) {
		super(runtime);
	}
}