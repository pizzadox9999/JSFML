package org.jsfml.system;

import java.io.Serializable;

import org.jsfml.internal.SFMLNative;

import jnr.ffi.Pointer;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/**
 * Represents two-dimensional vectors using integer coordinates and provides
 * arithmetic operations on integral 2D vectors.
 */
public final class Vector2i extends Struct implements Serializable {
	private static final long serialVersionUID = 4059550337913883695L;

	/**
	 * The zero vector.
	 */
	public static final Vector2i ZERO = new Vector2i(0, 0);

	/**
	 * Adds two vectors.
	 *
	 * @param a the first vector.
	 * @param b the second vector.
	 * @return a new vector, representing the sum of the two vectors.
	 */
	/*
	 * public static Vector2i add(Vector2i a, Vector2i b) { return new Vector2i(a.x
	 * + b.x, a.y + b.y); }
	 * 
	 *//**
		 * Subtracts two vectors.
		 *
		 * @param a The first vector.
		 * @param b The second vector.
		 * @return a new vector, representing the difference between the two vectors.
		 */
	/*
	 * public static Vector2i sub(Vector2i a, Vector2i b) { return new Vector2i(a.x
	 * - b.x, a.y - b.y); }
	 * 
	 * 
	 *//**
		 * Performs a component-wise multiplication of two vectors.
		 *
		 * @param a the left vector.
		 * @param b the right vector.
		 * @return a new vector, representing the "product" of the two vectors.
		 */
	/*
	 * public static Vector2i componentwiseMul(Vector2i a, Vector2i b) { return new
	 * Vector2i(a.x * b.x, a.y * b.y); }
	 * 
	 *//**
		 * Performs a component-wise division of two vectors.
		 *
		 * @param a the left vector.
		 * @param b the right vector.
		 * @return a new vector, representing the "quotient" of the two vectors.
		 */
	/*
	 * public static Vector2i componentwiseDiv(Vector2i a, Vector2i b) { return new
	 * Vector2i(a.x / b.x, a.y / b.y); }
	 * 
	 *//**
		 * Multiplies a vector by a scalar.
		 *
		 * @param a the vector.
		 * @param s the scalar.
		 * @return a new vector, representing the scaled vector.
		 */
	/*
	 * public static Vector2i mul(Vector2i a, int s) { return new Vector2i(a.x * s,
	 * a.y * s); }
	 * 
	 *//**
		 * Multiplies a vector by the inverse of a scalar.
		 *
		 * @param a the vector.
		 * @param s the scalar to multiply by.
		 * @return a new vector, representing the scaled vector.
		 */
	/*
	 * public static Vector2i div(Vector2i a, int s) { return new Vector2i(a.x / s,
	 * a.y / s); }
	 * 
	 *//**
		 * Computes the negation of a vector.
		 *
		 * @param v the vector.
		 * @return a new vector, representing the negation of the given vector.
		 *//*
			 * public static Vector2i neg(Vector2i v) { return new Vector2i(-v.x, -v.y); }
			 */

	/**
	 * The vector's X coordinate.
	 */
	public final Signed32 x = new Signed32();

	/**
	 * The vector's Y coordinate.
	 */
	public final Signed32 y = new Signed32();

	/**
	 * Constructs a new vector with the given coordinates.
	 *
	 * @param x the X coordinate.
	 * @param y the Y coordinate.
	 */
	public Vector2i(int x, int y) {
		this();
		this.x.set(x);
		this.y.set(y);
	}

	/**
	 * Constructs a new vector by converting a floating point vector.
	 * <p/>
	 * The fractions of the coordinates will be cut off.
	 *
	 * @param v the vector to convert.
	 */
	public Vector2i(Vector2f v) {
		this((int) v.x, (int) v.y);
	}
	
	public Vector2i(jnr.ffi.Pointer pointer) {
		this();
		useMemory(pointer);
	}
	
	public Vector2i() {
		this(SFMLNative.getCsfmlRuntime());
	} 
	
	public Vector2i(Runtime runtime) {
		super(runtime);
	}
	
	public void loadFromPointer(jnr.ffi.Pointer pointer) {
		int[] test=new int[2];
		pointer.get(0, test, 0, 2);
		//System.out.println(pointer.getInt(0));
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Vector2i && ((Vector2i) o).x == x && ((Vector2i) o).y == y);
	}

	@Override
	public int hashCode() {
		return (x.get() * 0x1F1F1F1F) ^ y.get();
	}

	@Override
	public java.lang.String toString() {
		return "Vector2i{" + "x=" + x.get() + ", y=" + y.get() + '}';
	}
}
