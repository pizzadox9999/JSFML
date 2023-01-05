package org.jsfml.window.event;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class TouchEvent extends Struct {
	public Signed32 type=new Signed32();
	public Signed32 finger=new Signed32();
	public Signed32 x=new Signed32();
	public Signed32 y=new Signed32();
	
	public TouchEvent() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public TouchEvent(Runtime runtime) {
		super(runtime);
	}
}