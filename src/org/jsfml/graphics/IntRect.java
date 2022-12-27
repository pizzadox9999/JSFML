package org.jsfml.graphics;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class IntRect extends Struct {
	public int left;
	public int top;
	public int width;
	public int height;
    
	public IntRect() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public IntRect(Runtime runtime) {
		super(runtime);
	}
	
}