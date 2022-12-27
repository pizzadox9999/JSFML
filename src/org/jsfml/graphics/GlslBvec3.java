package org.jsfml.graphics;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class GlslBvec3 extends Struct{
	
	private int x;
	private int y;
	private int z;
	
	public GlslBvec3() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public GlslBvec3(Runtime runtime) {
		super(runtime);
	}
	
	public boolean x() {
		return x==0?false : true;
	}
	public boolean y() {
		return y==0?false : true;
	}
	public boolean z() {
		return z==0?false : true;
	}
}