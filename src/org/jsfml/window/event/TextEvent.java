package org.jsfml.window.event;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.Struct.Signed32;

public class TextEvent extends Struct {
	public Signed32 type=new Signed32();
	public Signed32 unicode=new Signed32();
	
	public TextEvent() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public TextEvent(Runtime runtime) {
		super(runtime);
	}
}
