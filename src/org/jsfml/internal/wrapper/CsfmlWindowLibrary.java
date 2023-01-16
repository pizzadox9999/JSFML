package org.jsfml.internal.wrapper;

import java.nio.Buffer;

import org.jsfml.system.Vector2i;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;

import jnr.ffi.Pointer;
import jnr.ffi.Struct;

public interface CsfmlWindowLibrary {
	//Window.h Wrapper
	public long sfWindow_create(VideoMode videoModeBuffer, String title, int style, ContextSettings contextSettingsBuffer);
	
	public void sfWindow_destroy(long windowPointer);
	
	public void sfWindow_close(long windowPointer);

	public int sfWindow_isOpen(Long windowPointer);

	public ContextSettings sfWindow_getSettings(long windowPointer);
	
	public int sfWindow_pollEvent(long windowPointer, Buffer eventBuffer);
	
	public int sfWindow_waitEvent(long windowPointer, Buffer eventBuffer);

	public Pointer sfWindow_getPosition(long windowPointer);

	public void sfWindow_setPosition(long windowPointer, long positionVector2i);

	public long sfWindow_getSize(long windowPointer);

	public void sfWindow_setSize(long windowPointer, long sizeVector2i);

	public void sfWindow_setTitle(long windowPointer, String title);

	public void sfWindow_setIcon(long windowPointer, int width, int height, Buffer pixelsBuffer);

	public void sfWindow_setVisible(long windowPointer, int visibleBoolean);

	public void sfWindow_setVerticalSyncEnabled(long windowPointer, int enabledBoolean);

	public void sfWindow_setMouseCursorVisible(long windowPointer, int visibleBoolean);

	public void sfWindow_setMouseCursorGrabbed(long windowPointer, int grabbedBoolean);

	
	public int sfWindow_setActive(long windowPointer, int active);
	
	//Context.h Wrapper
	public long sfContext_create();
	
	public void sfContext_destroy(long contextPointer);
	
	/**
	 * @param contextPointer
	 * @param active boolean as int
	 * @return boolean as int true on success false otherwise
	 */
	public int sfContext_setActive(long contextPointer, int active);
	
	public ContextSettings sfContext_getSettings(long contextPointer);
	
	public int sfContext_getActiveContextId();
	
	//VideoMode.h Wrapper
	public VideoMode sfVideoMode_getDesktopMode();
	
	public Pointer[] sfVideoMode_getFullscreenModes(int count);
	
	public int sfVideoMode_isValid(VideoMode videoModeBuffer);
}