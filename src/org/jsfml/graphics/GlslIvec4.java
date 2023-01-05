package org.jsfml.graphics;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class GlslIvec4 extends Struct {
	public int x;
	public int y;
	public int z;
	public int w;
	
	public GlslIvec4() {
		this(JSFML.getCsfmlRuntime());
	}
	public GlslIvec4(Runtime runtime) {
		super(runtime);
	}
}