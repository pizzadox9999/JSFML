package org.jsfml.window;

import org.jsfml.internal.CsfmlWindowLibrary;
import org.jsfml.internal.JSFML;
import org.jsfml.window.event.Event;

import jnr.ffi.ObjectReferenceManager;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.Struct.Pointer;

public class Window extends Struct {
	public final class WindowStyle {
		public static final int NONE         =0;      ///< No border / title bar (this flag and all others are mutually exclusive)
		public static final int TITLEBAR     =1 << 0; ///< Title bar + fixed border
		public static final int RESIZE       =1 << 1; ///< Titlebar + resizable border + maximize button
		public static final int CLOSE        =1 << 2; ///< Titlebar + close button
		public static final int FULLSCREEN   =1 << 3; ///< Fullscreen mode (this flag and all others are mutually exclusive)
		public static final int DEFAULT_STYLE=TITLEBAR | RESIZE | CLOSE; ///< Default window style
	}
	public final class ContextAttribute {
		public static final int CONTEXT_DEFAULT=0;
		public static final int CONTEXT_CORE=1 << 0;
		public static final int CONTEXT_DEBUG=1 << 2;
	}
	protected CsfmlWindowLibrary m_csfmlWindowLibrary;
	protected jnr.ffi.Pointer m_nativeWindowPointer;
	
	public Window() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public Window(Runtime runtime) {
		super(runtime);
		m_csfmlWindowLibrary=JSFML.getCsfmlWindowLibrary();
	}
	
	public void create(VideoMode videoMode, java.lang.String title, int style) {
		create(videoMode, title, style, new ContextSettings());
	}
	
	public void create(VideoMode videoMode, java.lang.String title, int style, ContextSettings contextSettings) {
		m_nativeWindowPointer=m_csfmlWindowLibrary.sfWindow_create(videoMode, title, style, getMemory(contextSettings));
	}
	
	public boolean isOpen() {
		return (m_csfmlWindowLibrary.sfWindow_isOpen(m_nativeWindowPointer)==1)?true : false;
	}
	
	public boolean pollEvent(Event event) {				
		boolean toReturn=false;//(m_csfmlWindowLibrary.sfWindow_pollEvent(m_nativeWindowPointer, getMemory(event))==1)?true : false;
		//System.out.println(event.type);
		
		
		
		if(JSFML.getCsfmlGraphicsRuntime().getLastError()!=0) {
			System.out.println(JSFML.getCsfmlGraphicsRuntime().getLastError());
			System.exit(0);
		}
		
		//System.out.println(event);
		
		return toReturn;
	}
	
	public boolean waitEvent(Event event) {
		return false;//return (m_csfmlWindowLibrary.sfWindow_waitEvent(m_nativeWindowPointer, getMemory(event))==1)?true : false;
	}
	
	public void close() {
		m_csfmlWindowLibrary.sfWindow_close(m_nativeWindowPointer);
	}
	
}