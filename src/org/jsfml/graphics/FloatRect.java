package org.jsfml.graphics;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class FloatRect extends Struct {
	public float left;
	public float top;
	public float width;
	public float height;
	
	public FloatRect() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public FloatRect(Runtime runtime) {
		super(runtime);
	}
}