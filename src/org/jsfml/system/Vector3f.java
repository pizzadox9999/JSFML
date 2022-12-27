package org.jsfml.system;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Vector3f extends Struct{
	public float x;
	public float y;
	public float z;
	
	public Vector3f(Runtime runtime) {
		super(runtime);
	}
	
	public java.lang.String toString() {
		return "{"+getClass().getSimpleName()+": (X:"+x+", Y:"+y+", Z: "+z+")}";
	}
}