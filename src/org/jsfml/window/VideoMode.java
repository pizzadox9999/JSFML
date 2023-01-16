package org.jsfml.window;

import org.jsfml.internal.IntercomHelper;
import org.jsfml.internal.SFMLNative;
import org.jsfml.internal.SFMLNativeObject;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.byref.IntByReference;

import java.io.Serializable;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a video mode (width, height and bits per pixel).
 * <p/>
 * It defines the width, height and pixel depth of a window and must be
 * supported by the monitor hardware in order to be used in fullscreen.
 *
 * @see Window#create(VideoMode, String, int)
 */
public final class VideoMode extends Struct implements Serializable {
    private static final long serialVersionUID = 8608938390916786270L;

    //cache
    private static VideoMode desktopMode = null;
    private static Set<VideoMode> fullscreenModes = null;

    /**
     * Retrieves the desktop's current video mode / screen resolution.
     *
     * @return the desktop's current video mode.
     */
    public static VideoMode getDesktopMode() {
        if (desktopMode == null) {
        	desktopMode = SFMLNative.getCsfmlWindowLibrary().sfVideoMode_getDesktopMode();
        }
        return desktopMode;
    }

    /*private static Set<VideoMode> getFullscreenModeSet() {
    	
        if (fullscreenModes == null) {
        	IntBuffer fullscreenModesCounterBuffer=IntercomHelper.getBuffer().asIntBuffer();
            int fullscreenModecount = -1;
            IntBuffer buffer = (IntBuffer) SFMLNative.getCsfmlWindowLibrary().sfVideoMode_getFullscreenModes(fullscreenModesCounterBuffer);
            
            fullscreenModecount = fullscreenModesCounterBuffer.get(0);
            
            fullscreenModes = new HashSet<>(fullscreenModecount);
            for (int i = 0; i < fullscreenModecount; i++) {
                fullscreenModes.add(new VideoMode(
                        buffer.get(3 * i),
                        buffer.get(3 * i + 1),
                        buffer.get(3 * i + 2)));
            }
        }

        return fullscreenModes;
    }*/

    /**
     * Retrieves the list of supported fullscreen video modes.
     *
     * @return the list of supported fullscreen video modes.
     */
    public static VideoMode[] getFullscreenModes() {
        return null;
    	//return SFMLNative.getCsfmlWindowLibrary().sfVideoMode_getFullscreenModes(count);
    	/*final Set<VideoMode> modes = getFullscreenModeSet();
        return modes.toArray(new VideoMode[modes.size()]);*/
    }

    /**
     * The width of the video mode, in pixels.
     */
    public Signed32 width=new Signed32();

    /**
     * The height of the video mode, in pixels.
     */
    public Signed32 height=new Signed32();

    /**
     * The pixel depth, in bits per pixel, of the video mode.
     */
    public Signed32 bitsPerPixel=new Signed32();

    /**
     * Constructs a new video mode.
     *
     * @param width        the width, in pixels.
     * @param height       the height, in pixels.
     * @param bitsPerPixel the pixel depth, in bits per pixel.
     */
    public VideoMode(int width, int height, int bitsPerPixel) {
    	this(SFMLNative.getCsfmlWindowRuntime());
    	this.width.set(width);
        this.height.set(height);
        this.bitsPerPixel.set(bitsPerPixel);
    }

    /**
     * Constructs a new video mode with a pixel depth of 32 bits per pixel.
     *
     * @param width  the width, in pixels.
     * @param height the height, in pixels.
     */
    public VideoMode(int width, int height) {
        this(width, height, 32);
    }
    
    public VideoMode(Runtime runtime) {
    	super(runtime);
    }
    
    /**
     * Checks whether this display mode is a valid fullscreen mode, ie whether
     * the current monitor supports it for fullscreen.
     *
     * @return {@code true} if this video mode is a valid fullscreen mode,
     *         {@code false} otherwise.
     */    
    public boolean isValid() {
    	return isValidVideoMode(this);
    }
    
    public static boolean isValidVideoMode(VideoMode videoMode) {
    	return SFMLNativeObject.convertIntegerToBoolean(SFMLNative.getCsfmlWindowLibrary().sfVideoMode_isValid(videoMode));
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof VideoMode) {
            VideoMode v = (VideoMode) o;
            return (v.width == width &&
                    v.height == height &&
                    v.bitsPerPixel == bitsPerPixel);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = width.get();
        result = 31 * result + height.get();
        result = 31 * result + bitsPerPixel.get();
        return result;
    }

    @Override
    public java.lang.String toString() {
        return "VideoMode{" +
                "width=" + width +
                ", height=" + height +
                ", bitsPerPixel=" + bitsPerPixel +
                '}';
    }
}
