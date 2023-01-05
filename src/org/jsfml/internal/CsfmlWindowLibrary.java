package org.jsfml.internal;

import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import jnr.ffi.Pointer;

public interface CsfmlWindowLibrary {
	//Window Api
	public Pointer sfWindow_create(VideoMode mode, String title, int style, Pointer contextSettingsPointer);
	public int sfWindow_isOpen(Pointer windowPointer);
	public void sfWindow_display(Pointer windowPointer);
	public int sfWindow_pollEvent(Pointer window, Pointer eventPointer);
	public int sfWindow_waitEvent(Pointer window, Pointer eventPointer);
	
	public void sfWindow_destroy(Pointer window);
	public void sfWindow_close(Pointer window);
}