package org.jsfml.system;

import java.io.Serializable;

/**
 * Represents two-dimensional vectors using floating point coordinates and provides
 * arithmetic operations on floating point 2D vectors.
 */
public final strictfp class Vector2f implements Serializable, Comparable<Vector2f> {
	private static final long serialVersionUID = -2082611034304583379L;
	
	/**
     * The zero vector.
     */
	public static final Vector2f ZERO=new Vector2f(0, 0);
	
	/**
     * The vector's X coordinate.
     */
	public float x;
	
	/**
     * The vector's Y coordinate.
     */
	public float y;
	
	/**
	 * Constructs a new vector with the given coordinates.
	 * 
	 * @param v the copy Constructor
	 */
	public Vector2f(Vector2f v) {
		this(v.x, v.y);
	}
	
	/**
     * Constructs a new vector by converting an integral vector.
     * <p/>
     * The fractions of the coordinates will be zero.
     *
     * @param v the vector to convert.
     */
    public Vector2f(Vector2i v) {
        this((float) v.x, (float) v.y);
    }
    
    /**
     * Constructs a new vector with the given coordinates.
     *
     * @param x the X coordinate.
     * @param y the Y coordinate.
     */
	public Vector2f(float x, float y) {
		setX(x);
		setY(y);
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
		//return (float) MathUtil.sqrtRoot(lengthFast());
		return (float)Math.sqrt(lengthFast());
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
    

    /**
     * Adds two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the sum of the two vectors.
     */
    public Vector2f add(Vector2f v) {
        return new Vector2f(x + v.x, y + v.y);
    }

    /**
     * Subtracts two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the difference between the two vectors.
     */
    public Vector2f sub(Vector2f v) {
        return new Vector2f(x - v.x, y - v.y);
    }

    /**
     * Performs a component-wise multiplication of two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the "product" of the two vectors.
     */
    public Vector2f componentwiseMul(Vector2f v) {
        return new Vector2f(x * v.x, y * v.y);
    }

    /**
     * Performs a component-wise division of two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the "quotient" of the two vectors.
     */
    public Vector2f componentwiseDiv(Vector2f v) {
        return new Vector2f(x / v.x, y / v.y);
    }

    /**
     * Multiplies a vector by a scalar.
     *
     * @param a the vector.
     * @param s the scalar to multiply by.
     * @return a new vector, representing the scaled vector.
     */
    public Vector2f mul(float s) {
        return new Vector2f(x * s, y * s);
    }

    /**
     * Multiplies a vector by the inverse of a scalar.
     *
     * @param a the vector.
     * @param s the scalar to divide by.
     * @return a new vector, representing the scaled vector.
     */
    public Vector2f div(float s) {
        return new Vector2f(x / s, y / s);
    }

    /**
     * Computes the negation of a vector.
     *
     * @param v the vector.
     * @return a new vector, representing the negation of the given vector.
     */
    public Vector2f neg() {
        return new Vector2f(-x, -y);
    }

    public boolean equals(Vector2f v) {
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
        return "Vector2f{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}