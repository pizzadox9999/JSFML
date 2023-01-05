package org.jsfml.internal;

import java.nio.Buffer;

import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import jnr.ffi.Pointer;

public interface CsfmlWindowLibrary {
	//Window Api
	public Pointer sfWindow_create(VideoMode mode, String title, int style, Pointer contextSettingsPointer);
	public int sfWindow_isOpen(Pointer windowPointer);
	public void sfWindow_display(Pointer windowPointer);
	public int sfWindow_pollEvent(Pointer window, Buffer eventBuffer);
	public void sfWindow_destroy(Pointer window);
	public void sfWindow_close(Pointer window);
}