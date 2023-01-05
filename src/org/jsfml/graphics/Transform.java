package org.jsfml.graphics;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Transform extends Struct {
	public final float[] matrix=new float[9];
	
	public Transform() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public Transform(Runtime runtime) {
		super(runtime);
	}
}