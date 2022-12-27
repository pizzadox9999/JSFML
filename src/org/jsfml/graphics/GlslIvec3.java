package org.jsfml.graphics;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class GlslIvec3 extends Struct {
	public int x;
	public int y;
	public int z;
	
	public GlslIvec3() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public GlslIvec3(Runtime runtime) {
		super(runtime);
	}
}