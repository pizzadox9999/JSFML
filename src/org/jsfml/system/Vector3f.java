package org.jsfml.system;

import java.io.Serializable;

/**
 * Represents two-dimensional vectors using floating point coordinates and provides
 * arithmetic operations on floating point 2D vectors.
 */
public final strictfp class Vector3f implements Serializable, Comparable<Vector3f> {
	private static final long serialVersionUID = -2082611034304583379L;
	
	/**
     * The zero vector.
     */
	public static final Vector3f ZERO=new Vector3f(0, 0, 0);
	
	/**
     * The vector's X coordinate.
     */
	public float x;
	
	/**
     * The vector's Y coordinate.
     */
	public float y;
	
	/**
     * The vector's Z coordinate.
     */
	public float z;
	
	
	/**
	 * Constructs a new vector with the given coordinates.
	 * 
	 * @param v the copy Constructor
	 */
	public Vector3f(Vector2f v) {
		this(v.x, v.y, 0);
	}
	
	/**
     * Constructs a new vector by converting an integral vector.
     * <p/>
     * The fractions of the coordinates will be zero.
     *
     * @param v the vector to convert.
     */
    public Vector3f(Vector2i v) {
        this(v.x, v.y, 0);
    }
    
    /**
     * Constructs a new vector with the given coordinates.
     *
     * @param x the X coordinate.
     * @param y the Y coordinate.
     */
	public Vector3f(float x, float y, float z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public Vector3f setX(float x) {
		this.x=x;
		return this;
	}
	
	public Vector3f setY(float y) {
		this.y=y;
		return this;
	}
	
	public Vector3f setZ(float z) {
		this.z=z;
		return this;
	}
	
	public float length() {
		//return (float) MathUtil.sqrtRoot(lengthFast());
		return (float)Math.sqrt(lengthFast());
	}
	
	public float lengthFast() {
		return x*x+y*y+z*z;
	}
	
	public int compareTo(Vector3f v) {
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
		throw new RuntimeException("Something went wrong in Vector3");
	}
    

    /**
     * Adds two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the sum of the two vectors.
     */
    public Vector3f add(Vector3f v) {
        return add(v.x, v.y, v.z);
    }
    
    public Vector3f add(float x, float y, float z) {
    	return new Vector3f(this.x+x, this.y+y, this.z+z);
    }

    /**
     * Subtracts two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the difference between the two vectors.
     */
    public Vector3f sub(Vector3f v) {
    	return sub(v.x, v.y, v.z);
    }

    public Vector3f sub(float x, float y, float z) {
    	return new Vector3f(this.x - x, this.y - y, this.z - z);	
    }
    
    /**
     * Performs a component-wise multiplication of two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the "product" of the two vectors.
     */
    public Vector3f componentwiseMul(Vector3f v) {
        return new Vector3f(x * v.x, y * v.y, z * v.z);
    }

    /**
     * Performs a component-wise division of two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the "quotient" of the two vectors.
     */
    public Vector3f componentwiseDiv(Vector3f v) {
        return new Vector3f(x / v.x, y / v.y, z / v.z);
    }

    /**
     * Multiplies a vector by a scalar.
     *
     * @param a the vector.
     * @param s the scalar to multiply by.
     * @return a new vector, representing the scaled vector.
     */
    public Vector3f mul(float s) {
        return new Vector3f(x * s, y * s, z * s);
    }

    /**
     * Multiplies a vector by the inverse of a scalar.
     *
     * @param a the vector.
     * @param s the scalar to divide by.
     * @return a new vector, representing the scaled vector.
     */
    public Vector3f div(float s) {
        return new Vector3f(x / s, y / s, z / s);
    }

    /**
     * Computes the negation of a vector.
     *
     * @param v the vector.
     * @return a new vector, representing the negation of the given vector.
     */
    public Vector3f neg() {
        return new Vector3f(-x, -y, -z);
    }

    public boolean equals(Vector3f v) {
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