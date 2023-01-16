package org.jsfml.window;

import java.io.Serializable;

import org.jsfml.internal.SFMLNative;
import org.jsfml.internal.SFMLNativeObject;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

/**
 * Holds the settings for an OpenGL context attached to a window.
 * <p/>
 * Unless you need anti-aliasing for primitives or require your window to hold an OpenGL context
 * for a specific OpenGL version (e.g. for custom OpenGL rendering), you will most likely not
 * need this.
 * <p/>
 * All settings provided by this class are handled as <i>hints</i> to the created OpenGL context. If a
 * feature is not supported by the hardware, the respective setting will be ignored and a supported
 * default is used instead.
 */
public final class ContextSettings extends Struct implements Serializable {
    private static final long serialVersionUID = -3658200233541780345L;

    /**
     * The amount of depth buffer bits.
     */
    public Signed32 depthBits=new Signed32();

    /**
     * The amount of stencil buffer bits.
     */
    public Signed32 stencilBits=new Signed32();

    /**
     * The level of anti-aliasing.
     */
    public Signed32 antialiasingLevel=new Signed32();

    /**
     * The desired major OpenGL version number.
     */
    public Signed32 majorVersion=new Signed32();

    /**
     * The desired minor OpenGL version number.
     */
    public Signed32 minorVersion=new Signed32();

    /**
     * The attribute flags to create the context with
     */
    public Signed32 attributeFlags=new Signed32();
    
    /**
     * Whether the context framebuffer is sRGB capable
     */
    public Signed32 sRgbCapable=new Signed32();
    
    /**
     * Constructs new context settings with default values (OpenGL 2.0, no depth or stencil bits,
     * no anti-aliasing).
     */
    public ContextSettings() {
        this(0, 0, 0, 2, 0, 0, false);
    }

    /**
     * Constructs new context settings with the specified level of anti-aliasing and OpenGL 2.0,
     * no depth or stencil bits.
     *
     * @param antialiasingLevel the level of anti-aliasing.
     */
    public ContextSettings(int antialiasingLevel) {
        this(0, 0, antialiasingLevel, 2, 0, 0 , false);
    }

    /**
     * Constructs new context settings with the specified OpenGL version, no depth or stencil
     * bits and no anti-aliasing.
     *
     * @param majorVersion the desired major OpenGL version number.
     * @param minorVersion the desired minor OpenGL version number.
     */
    public ContextSettings(int majorVersion, int minorVersion) {
        this(0, 0, 0, majorVersion, minorVersion, 0, false);
    }

    /**
     * Constructs new context settings with the specified OpenGL version and anti-aliasing level and
     * no depth or stencil bits.
     *
     * @param antialiasingLevel the level of anti-aliasing.
     * @param majorVersion      the desired major OpenGL version number.
     * @param minorVersion      the desired minor OpenGL version number.
     */
    public ContextSettings(int antialiasingLevel, int majorVersion, int minorVersion) {
        this(0, 0, antialiasingLevel, majorVersion, minorVersion, 0, false);
    }

    /**
     * Constructs new context settings.
     *
     * @param depthBits         the amount of depth buffer bits.
     * @param stencilBits       the amount of stencil buffer bits.
     * @param antialiasingLevel the level of anti-aliasing.
     * @param majorVersion      the desired major OpenGL version number.
     * @param minorVersion      the desired minor OpenGL version number.
     */
    public ContextSettings(int depthBits, int stencilBits, int antialiasingLevel, int majorVersion, int minorVersion, int attributeFlags, boolean sRgbCapable) {
    	this(SFMLNative.getCsfmlWindowRuntime());
    	this.depthBits.set(depthBits);
        this.stencilBits.set(stencilBits);
        this.antialiasingLevel.set(antialiasingLevel);
        this.majorVersion.set(minorVersion);
        this.minorVersion.set(majorVersion);
        this.attributeFlags.set(attributeFlags);
        this.sRgbCapable.set(SFMLNativeObject.convertBooleanToInteger(sRgbCapable));
    }
    
    public ContextSettings(Runtime runtime) {
    	super(runtime);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ContextSettings) {
            ContextSettings c = (ContextSettings) o;
            return (c.antialiasingLevel == antialiasingLevel &&
                    c.depthBits == depthBits &&
                    c.majorVersion == majorVersion &&
                    c.minorVersion == minorVersion &&
                    c.stencilBits == stencilBits &&
                    c.attributeFlags == attributeFlags &&
                    c.sRgbCapable == sRgbCapable);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = depthBits.get();
        result = 31 * result + stencilBits.get();
        result = 31 * result + antialiasingLevel.get();
        result = 31 * result + majorVersion.get();
        result = 31 * result + minorVersion.get();
        result = 31 * result + attributeFlags.get();
        result = 31 * result + sRgbCapable.get();
        return result;
    }

    @Override
    public java.lang.String toString() {
        return "ContextSettings{" +
                "depthBits=" + depthBits +
                ", stencilBits=" + stencilBits +
                ", antialiasingLevel=" + antialiasingLevel +
                ", majorVersion=" + majorVersion +
                ", minorVersion=" + minorVersion +
                ", attributeFlags=" + attributeFlags +
                ", sRgbCapable=" + sRgbCapable +
                '}';
    }
}
