package org.jsfml.graphics;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Color extends Struct {
	private Unsigned32 r;
	private Unsigned32 g;
	private Unsigned32 b;
	private Unsigned32 a;
    
	public Color() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public Color(Runtime runtime) {
		super(runtime);
		r=new Unsigned32();
		g=new Unsigned32();
		b=new Unsigned32();
		a=new Unsigned32();
	}
	
	public int r() {
		return (int)r.get();
	}
	public int g() {
		return (int)g.get();
	}
	public int b() {
		return (int)b.get();
	}
	public int a() {
		return (int)a.get();
	}
}