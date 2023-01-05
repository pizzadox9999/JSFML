package org.jsfml.window;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class VideoMode extends Struct{
    private Unsigned32 width;        ///< Video mode width, in pixels
    private Unsigned32 height;       ///< Video mode height, in pixels
    private Unsigned32 bitsPerPixel; ///< Video mode pixel depth, in bits per pixels
    
    public VideoMode(int width, int height) {
    	this(width, height, 32);
    }
    
    public VideoMode(int width, int height, int bitsPerPixel) {
    	this(JSFML.getCsfmlRuntime());
    	setWidth(width);
    	setHeight(height);
    	setBitsPerPixel(bitsPerPixel);
    }
    
    protected VideoMode(Runtime runtime) {
		super(runtime);
		width=new Unsigned32();
		height=new Unsigned32();
		bitsPerPixel=new Unsigned32();
	}
    
    public void setWidth(int width) {
    	this.width.set(width);
    }
    
    public void setHeight(int height) {
    	this.height.set(height);
    }
    
    public void setBitsPerPixel(int bitsPerPixel) {
    	this.bitsPerPixel.set(bitsPerPixel);
    }
}