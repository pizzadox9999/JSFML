package org.jsfml.window;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class ContextSettings extends Struct{

	public Unsigned32 depthBits=new Unsigned32();         ///< Bits of the depth buffer
	public Unsigned32 stencilBits=new Unsigned32();       ///< Bits of the stencil buffer
	public Unsigned32 antialiasingLevel=new Unsigned32(); ///< Level of antialiasing
	public Unsigned32 majorVersion=new Unsigned32();      ///< Major number of the context version to create
	public Unsigned32 minorVersion=new Unsigned32();      ///< Minor number of the context version to create
	public Unsigned32 attributeFlags=new Unsigned32();    ///< The attribute flags to create the context with
	public int sRgbCapable=0;       					  ///< Whether the context framebuffer is sRGB capable
	
	public ContextSettings() {
		this(0, 0, 0, 1, 1, 0, false);
	}
	
	public ContextSettings(int depthBits, int stencilBits, int antialiasingLevel, int majorVersion, int minorVersion, int attributeFlags, boolean sRgbCapable) {
		this(JSFML.getCsfmlRuntime());
		setDepthBits(depthBits);
		setStencilBits(stencilBits);
		setAntialiasingLevel(antialiasingLevel);
		setMajorVersion(majorVersion);
		setMinorVersion(minorVersion);
		setAttributeFlags(attributeFlags);
		setSRgbCapable(sRgbCapable);
	}
	
	public ContextSettings(Runtime runtime) {
		super(runtime);
	}
	
	public void setDepthBits(int depthBits) {
		this.depthBits.set(depthBits);
	}
	
	public void setStencilBits(int stencilBits) {
		this.stencilBits.set(stencilBits);
	}
	
	public void setAntialiasingLevel(int antialiasingLevel) {
		this.antialiasingLevel.set(antialiasingLevel);
	}
	
	public void setMajorVersion(int majorVersion) {
		this.majorVersion.set(majorVersion);
	}
	
	public void setMinorVersion(int minorVersion) {
		this.minorVersion.set(minorVersion);
	}
	
	public void setAttributeFlags(int attributeFlags) {
		this.attributeFlags.set(attributeFlags);
	}
	
	public void setSRgbCapable(boolean sRgbCapable) {
		this.sRgbCapable=(sRgbCapable?1 : 0);
	}
}