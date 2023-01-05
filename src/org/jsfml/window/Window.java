package org.jsfml.window;

import java.nio.IntBuffer;

import org.jsfml.internal.CsfmlWindowLibrary;
import org.jsfml.internal.IntercomHelper;
import org.jsfml.internal.JSFML;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Window extends Struct {
	 private static Event decodeEvent(IntBuffer ints) {
		Event e = null;
        final int typeId = ints.get(0);
        if (typeId >= 0) {
            final Event.Type type = Event.Type.values()[typeId];
            switch (type) {
                case CLOSED:
                case GAINED_FOCUS:
                case LOST_FOCUS:
                    e = new Event(typeId);
                    break;

                case RESIZED:
                    //e = new SizeEvent(typeId, ints.get(1), ints.get(2));
                    break;

                case TEXT_ENTERED:
                	//e = new TextEvent(typeId, ints.get(1));
                    break;

                case KEY_PRESSED:
                case KEY_RELEASED:
                    final int keyCode = ints.get(1);
                    final int flags = ints.get(2);
                    e = new KeyEvent(typeId, keyCode,
                            (flags & 0x01) != 0,
                            (flags & 0x02) != 0,
                            (flags & 0x04) != 0,
                            (flags & 0x08) != 0);

                    break;

                case MOUSE_WHEEL_MOVED:
                	//e = new MouseWheelEvent(typeId, ints.get(1), ints.get(2), ints.get(3));
                    break;

                case MOUSE_BUTTON_PRESSED:
                case MOUSE_BUTTON_RELEASED:
                	//e = new MouseButtonEvent(typeId, ints.get(1), ints.get(2), ints.get(3));
                    break;

                case MOUSE_MOVED:
                case MOUSE_LEFT:
                case MOUSE_ENTERED:
                	//e = new MouseEvent(typeId, ints.get(1), ints.get(2));
                    break;

                case JOYSTICK_BUTTON_PRESSED:
                case JOYSTICK_BUTTON_RELEASED:
                	//e = new JoystickButtonEvent(typeId, ints.get(1), ints.get(2));
                    break;

                case JOYSTICK_MOVED:
                	//e = new JoystickMoveEvent(typeId, ints.get(1), ints.get(2),
                	//Float.intBitsToFloat(ints.get(3)));
                    break;

                case JOYSTICK_CONNECTED:
                case JOYSTICK_DISCONNECTED:
                	//e = new JoystickEvent(typeId, ints.get(1));
                    break;

                default:
                    e = null;
                    break;
            }
        } else {
            e = null;
        }

        return e;
    }
	public final class WindowStyle {
		public static final int NONE          = 0;      ///< No border / title bar (this flag and all others are mutually exclusive)
		public static final int TITLEBAR      = 1 << 0; ///< Title bar + fixed border
		public static final int RESIZE        = 1 << 1; ///< Titlebar + resizable border + maximize button
		public static final int CLOSE         = 1 << 2; ///< Titlebar + close button
		public static final int FULLSCREEN    = 1 << 3; ///< Fullscreen mode (this flag and all others are mutually exclusive)
		public static final int DEFAULT_STYLE = TITLEBAR | RESIZE | CLOSE; ///< Default window style
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
		m_csfmlWindowLibrary=JSFML.getCsfmlWindowLib();
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
	
	public Event pollEvent() {				
		final IntBuffer buffer = IntercomHelper.getBuffer().asIntBuffer();
        
		return (m_csfmlWindowLibrary.sfWindow_pollEvent(m_nativeWindowPointer, buffer)==1) ? decodeEvent(buffer) : null; 
	}
	
	public void close() {
		m_csfmlWindowLibrary.sfWindow_close(m_nativeWindowPointer);
	}
}