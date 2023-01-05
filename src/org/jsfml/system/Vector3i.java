package org.jsfml.system;

import java.io.Serializable;

/**
 * Represents two-dimensional vectors using floating point coordinates and provides
 * arithmetic operations on floating point 2D vectors.
 */
public final strictfp class Vector3i implements Serializable, Comparable<Vector3i> {
	private static final long serialVersionUID = -2082611034304583379L;
	
	/**
     * The zero vector.
     */
	public static final Vector3i ZERO=new Vector3i(0, 0, 0);
	
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
	public Vector3i(Vector2f v) {
		this(v.x, v.y, 0);
	}
	
	/**
     * Constructs a new vector by converting an integral vector.
     * <p/>
     * The fractions of the coordinates will be zero.
     *
     * @param v the vector to convert.
     */
    public Vector3i(Vector2i v) {
        this(v.x, v.y, 0);
    }
    
    /**
     * Constructs a new vector from the given one.
     *
     * @param v the Vector3i to copy.
     */
    public Vector3i(Vector3i v) {
    	this(v.x, v.y, v.z);
    }
    
    /**
     * Constructs a new vector with the given coordinates.
     *
     * @param x the X coordinate.
     * @param y the Y coordinate.
     * @param z the Z coordinate.
     */
	public Vector3i(float x, float y, float z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	/**
	 * 
	 * @param x
	 * @return Vector3i
	 */
	public Vector3i setX(float x) {
		this.x=x;
		return this;
	}
	
	public Vector3i setY(float y) {
		this.y=y;
		return this;
	}
	
	public Vector3i setZ(float z) {
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
	
	public int compareTo(Vector3i v) {
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
    public Vector3i add(Vector3i v) {
        return add(v.x, v.y, v.z);
    }
    
    public Vector3i add(float x, float y, float z) {
    	return new Vector3i(this.x+x, this.y+y, this.z+z);
    }

    /**
     * Subtracts two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the difference between the two vectors.
     */
    public Vector3i sub(Vector3i v) {
    	return sub(v.x, v.y, v.z);
    }

    public Vector3i sub(float x, float y, float z) {
    	return new Vector3i(this.x - x, this.y - y, this.z - z);	
    }
    
    /**
     * Performs a component-wise multiplication of two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the "product" of the two vectors.
     */
    public Vector3i componentwiseMul(Vector3i v) {
        return new Vector3i(x * v.x, y * v.y, z * v.z);
    }

    /**
     * Performs a component-wise division of two vectors.
     *
     * @param a the first vector.
     * @param b the second vector.
     * @return a new vector, representing the "quotient" of the two vectors.
     */
    public Vector3i componentwiseDiv(Vector3i v) {
        return new Vector3i(x / v.x, y / v.y, z / v.z);
    }

    /**
     * Multiplies a vector by a scalar.
     *
     * @param a the vector.
     * @param s the scalar to multiply by.
     * @return a new vector, representing the scaled vector.
     */
    public Vector3i mul(float s) {
        return new Vector3i(x * s, y * s, z * s);
    }

    /**
     * Multiplies a vector by the inverse of a scalar.
     *
     * @param a the vector.
     * @param s the scalar to divide by.
     * @return a new vector, representing the scaled vector.
     */
    public Vector3i div(float s) {
        return new Vector3i(x / s, y / s, z / s);
    }

    /**
     * Computes the negation of a vector.
     *
     * @param v the vector.
     * @return a new vector, representing the negation of the given vector.
     */
    public Vector3i neg() {
        return new Vector3i(-x, -y, -z);
    }

    public boolean equals(Vector3i v) {
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