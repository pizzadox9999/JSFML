package org.jsfml.graphics;

import org.jsfml.JSFML;
import org.jsfml.system.Vector2f;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Vertex extends Struct {
	/*
	public class VertexBufferUsage {
	    public static final int VERTEX_BUFFER_STREAM=0; ///< Constantly changing data
	    public static final int VERTEX_BUFFER_DYNAMIC=1;///< Occasionally changing data
	    public static final int VERTEX_BUFFER_STATIC=2; ///< Rarely changing data
	}
	public class PrimitiveType {
		public static final int POINTS=0;        ///< List of individual points
		public static final int LINES=1;         ///< List of individual lines
		public static final int LINE_STRIP=2;    ///< List of connected lines, a point uses the previous point to form a line
		public static final int TRIANGLES=3;	 ///< List of individual triangles
		public static final int TRIANGLE_STRIP=4;///< List of connected triangles, a point uses the two previous points to form a triangle
		public static final int TRIANGLE_FAN=5;  ///< List of connected triangles, a point uses the common center and the previous point to form a triangle
		public static final int QUADS=6;         ///< List of individual quads
	}*/
	public enum VertexBufferUsage {
	    VERTEX_BUFFER_STREAM, ///< Constantly changing data
	    VERTEX_BUFFER_DYNAMIC,///< Occasionally changing data
	    VERTEX_BUFFER_STATIC; ///< Rarely changing data
	}
	public enum PrimitiveType {
		POINTS,        ///< List of individual points
		LINES,         ///< List of individual lines
		LINE_STRIP,    ///< List of connected lines, a point uses the previous point to form a line
		TRIANGLES,	 ///< List of individual triangles
		TRIANGLE_STRIP,///< List of connected triangles, a point uses the two previous points to form a triangle
		TRIANGLE_FAN,  ///< List of connected triangles, a point uses the common center and the previous point to form a triangle
		QUADS;         ///< List of individual quads
	}
	public Vector2f position;  ///< Position of the vertex
	public Color    color;     ///< Color of the vertex
    public Vector2f texCoords; ///< Coordinates of the texture's pixel to map to the vertex
    
	public Vertex() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public Vertex(Runtime runtime) {
		super(runtime);
	}
}