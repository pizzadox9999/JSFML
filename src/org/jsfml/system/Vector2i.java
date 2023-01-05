package org.jsfml.system;

import org.jsfml.internal.JSFML;
import org.jsfml.internal.MathUtil;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Vector2i extends Struct implements Comparable<Vector2i>{
	public static final Vector2i ZERO=new Vector2i(0, 0);
	public int x;
	public int y;
	
	public Vector2i(Vector2i v) {
		this(v.x, v.y);
	}
	
	public Vector2i(int x, int y) {
		this(JSFML.getCsfmlRuntime());
		this.x=x;
		this.y=y;
	}
	
	public Vector2i(Runtime runtime) {
		super(runtime);
	}
	
	public float length() {
		return MathUtil.sqrtRoot(lengthFast());
	}
	
	public float lengthFast() {
		return x*x+y*y;
	}
	
	public int compareTo(Vector2i v) {
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



/*
public class Vector2i extends Struct {
	public static final Vector2i ZERO=new Vector2i(0, 0);
	public int x;
	public int y;
	
	public Vector2i(Vector2i v) {
		this(v.x, v.y);
	}
	
	public Vector2i(int x, int y) {
		this(JSFML.getJSFML().getCsfmlRuntime());
		setX(x);
		setY(y);
	}
	
	public Vector2i(Runtime runtime) {
		super(runtime);
		x=0;
		y=0;
	}
	
	public Vector2i setX(int x) {
		this.x=x;
		return this;
	}
	
	public Vector2i setY(int y) {
		this.y=y;
		return this;
	}
	
	public float length() {
		return (float) MathUtil.sqrtRoot(lengthFast());
	}
	
	public float lengthFast() {
		return x*x+y*y;
	}
	
	public int compareTo(Vector2i v) {
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


package org.jsfml.system;

import org.jsfml.JSFML;
import org.jsfml.MathUtil;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Vector2i extends Struct implements Comparable<Vector2i>{
	public static final Vector2i ZERO=new Vector2i(0, 0);
	public Signed32 x;
	public Signed32 y;
	
	public Vector2i(Vector2i v) {
		this(v.x(), v.y());
	}
	
	public Vector2i(int x, int y) {
		this(JSFML.getJSFML().getCsfmlRuntime());
		setX(x);
		setY(y);
	}
	
	public Vector2i(Runtime runtime) {
		super(runtime);
		x=new Signed32();
		y=new Signed32();
	}
	
	public Vector2i setX(int x) {
		this.x.set(x);
		return this;
	}
	
	public Vector2i setY(int y) {
		this.y.set(y);
		return this;
	}
	
	public float length() {
		return (float) MathUtil.sqrtRoot(lengthFast());
	}
	
	public float lengthFast() {
		return x()*x()+y()*y();
	}
	
	public int compareTo(Vector2i v) {
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
	
	public int x() {
		return x.get();
	}
	
	public int y() {
		return y.get();
	}
	
	public java.lang.String toString() {
		return "{"+getClass().getSimpleName()+": (X:"+x+", Y:"+y+")}";
	}
}*/