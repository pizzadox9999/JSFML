package org.jsfml.system;

import java.io.Serializable;

/**
 * Represents two-dimensional vectors using inting point coordinates and provides
 * arithmetic operations on inting point 2D vectors.
 */
public final strictfp class Vector2i implements Serializable, Comparable<Vector2i> {
	private static final long serialVersionUID = -2082611034304583379L;
	
	/**
     * The zero vector.
     */
	public static final Vector2i ZERO=new Vector2i(0, 0);
	
	/**
     * The vector's X coordinate.
     */
	public int x;
	
	/**
     * The vector's Y coordinate.
     */
	public int y;
	
	/**
	 * Constructs a new vector with the given coordinates.
	 * 
	 * @param v the copy Constructor
	 */
	public Vector2i(Vector2f v) {
		this((int)v.x, (int)v.y);
	}
	
	/**
     * Constructs a new vector by converting an integral vector.
     * <p/>
     * The fractions of the coordinates will be zero.
     *
     * @param v the vector to convert.
     */
    public Vector2i(Vector2i v) {
        this((int) v.x, (int) v.y);
    }
    
    /**
     * Constructs a new vector with the given coordinates.
     *
     * @param x the X coordinate.
     * @param y the Y coordinate.
     */
	public Vector2i(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public Vector2i setX(int x) {
		this.x=x;
		return this;
	}
	
	public Vector2i setY(int y) {
		this.y=y;
		return this;
	}
	
	public int length() {
		//return (int) MathUtil.sqrtRoot(lengthFast());
		return (int)Math.sqrt(lengthFast());
	}
	
	public int lengthFast() {
		return x*x+y*y;
	}
	
	public int compareTo(Vector2i v) {
		int myLength=lengthFast();
		int length=v.lengthFast();
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
    

    /**
     * Adds two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the sum of the two vectors.
     */
    public Vector2i add(Vector2i v) {
        return new Vector2i(x + v.x, y + v.y);
    }

    /**
     * Subtracts two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the difference between the two vectors.
     */
    public Vector2i sub(Vector2i v) {
        return new Vector2i(x - v.x, y - v.y);
    }

    /**
     * Performs a component-wise multiplication of two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the "product" of the two vectors.
     */
    public Vector2i componentwiseMul(Vector2i v) {
        return new Vector2i(x * v.x, y * v.y);
    }

    /**
     * Performs a component-wise division of two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the "quotient" of the two vectors.
     */
    public Vector2i componentwiseDiv(Vector2i v) {
        return new Vector2i(x / v.x, y / v.y);
    }

    /**
     * Multiplies a vector by a scalar.
     *
     * @param a the vector.
     * @param s the scalar to multiply by.
     * @return a new vector, representing the scaled vector.
     */
    public Vector2i mul(int s) {
        return new Vector2i(x * s, y * s);
    }

    /**
     * Multiplies a vector by the inverse of a scalar.
     *
     * @param a the vector.
     * @param s the scalar to divide by.
     * @return a new vector, representing the scaled vector.
     */
    public Vector2i div(int s) {
        return new Vector2i(x / s, y / s);
    }

    /**
     * Computes the negation of a vector.
     *
     * @param v the vector.
     * @return a new vector, representing the negation of the given vector.
     */
    public Vector2i neg() {
        return new Vector2i(-x, -y);
    }

    public boolean equals(Vector2i v) {
        return compareTo(v)==0;
    }

    @Override
    public int hashCode() {
        final int ix = x != 0.0f ? Float.floatToIntBits(x) : 0;
        final int iy = y != 0.0f ? Float.floatToIntBits(y) : 0;
        return (ix * 0x1F1F1F1F) ^ iy;
    }

    @Override
    public String toString() {
        return "Vector2i{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}