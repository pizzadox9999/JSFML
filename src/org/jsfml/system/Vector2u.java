package org.jsfml.system;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Vector2u extends Struct {
	public long x;
	public long y;
	
	public Vector2u(long x, long y) {
		this(JSFML.getCsfmlSystemRuntime());
		this.x=x;
		this.y=y;
	}
	
	public Vector2u(Runtime runtime) {
		super(runtime);
	}
	
}