package org.jsfml.graphics;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class GlslVec4 extends Struct{
	public float x;
	public float y;
	public float z;
	public float w;
	
	public GlslVec4() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public GlslVec4(Runtime runtime) {
		super(runtime);
	}
}