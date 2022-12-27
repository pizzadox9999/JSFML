package org.jsfml.graphics;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class GlslBvec2 extends Struct{
	
	private int x;
	private int y;
	
	public GlslBvec2() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public GlslBvec2(Runtime runtime) {
		super(runtime);
	}
	
	public boolean x() {
		return x==0?false : true;
	}
	public boolean y() {
		return y==0?false : true;
	}
}