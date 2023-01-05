package org.jsfml.graphics;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class GlslBvec4 extends Struct{
	
	private int x;
	private int y;
	private int z;
	private int w;
	
	public GlslBvec4() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public GlslBvec4(Runtime runtime) {
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
	public boolean w() {
		return w==0?false : true;
	}
}