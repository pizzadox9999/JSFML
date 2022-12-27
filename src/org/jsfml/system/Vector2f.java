package org.jsfml.system;

import org.jsfml.JSFML;
import org.jsfml.MathUtil;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Vector2f extends Struct implements Comparable<Vector2f>{
	public static final Vector2f ZERO=new Vector2f(0, 0);
	public float x;
	public float y;
	
	public Vector2f(Vector2f v) {
		this(v.x, v.y);
	}
	
	public Vector2f(float x, float y) {
		this(JSFML.getCsfmlRuntime());
		setX(x);
		setY(y);
	}
	
	public Vector2f(Runtime runtime) {
		super(runtime);
		x=0;
		y=0;
	}
	
	public Vector2f setX(float x) {
		this.x=x;
		return this;
	}
	
	public Vector2f setY(float y) {
		this.y=y;
		return this;
	}
	
	public float length() {
		return (float) MathUtil.sqrtRoot(lengthFast());
	}
	
	public float lengthFast() {
		return x*x+y*y;
	}
	
	public int compareTo(Vector2f v) {
		float myLength=lengthFast();
		float length=v.lengthFast();
		if(myLength>length) {
			return 1;
		} 
		if(myLength==length) {
			return 0;
		}
		if(myLength<length) {
			return -1;
		}
		throw new RuntimeException("Something went wrong in Vector2");
	}
	
	public java.lang.String toString() {
		return "{"+getClass().getSimpleName()+": (X:"+x+", Y:"+y+")}";
	}
}