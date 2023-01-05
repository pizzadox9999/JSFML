package org.jsfml.graphics;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Iterator;

import org.jsfml.internal.CsfmlGraphicsLibrary;
import org.jsfml.internal.JSFML;
import org.jsfml.internal.SFMLNativeObject;
import org.jsfml.system.Vector2i;
import org.jsfml.system.Vector2u;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;
import org.jsfml.window.event.MouseMoveEvent;
import org.jsfml.window.event.EventType;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class RenderWindow extends SFMLNativeObject {
	
	public RenderWindow() {
		super();
	}
	
	private CsfmlGraphicsLibrary getCsfmlGraphicsLibrary() {
		return (CsfmlGraphicsLibrary) m_csfmlLibrary;
	}
	
	/*✓*/
	public void create(VideoMode mode, java.lang.String title, int style, ContextSettings settings) {
		m_nativePointer=getCsfmlGraphicsLibrary().sfRenderWindow_create(mode, title, style, getMemory(settings));
	}
	/*✓*/
	public void destroy() {
		getCsfmlGraphicsLibrary().sfRenderWindow_destroy(m_nativePointer);
	}
	/*✓*/
	public void close() {
		getCsfmlGraphicsLibrary().sfRenderWindow_close(m_nativePointer);
	}
	/*✓*/
	public boolean isOpen() {
		return (getCsfmlGraphicsLibrary().sfRenderWindow_isOpen(m_nativePointer)==1)?true : false;
	}
	
	public ContextSettings getSettings() {
		return getCsfmlGraphicsLibrary().sfRenderWindow_getSettings(m_nativePointer);
	}
	/*✓*/
	private static final ThreadLocal<ByteBuffer> BUFFER =
            new ThreadLocal<ByteBuffer>() {
                @Override
                protected ByteBuffer initialValue() {
                    return ByteBuffer.allocateDirect(256).order(ByteOrder.nativeOrder());
                }
            };
    private static Event decodeEvent(IntBuffer ints) {
        final Event e;
        final int typeId = ints.get(0);
        if (typeId >= 0) {
            switch (typeId) {
                case EventType.CLOSED:/*
                case EventType.FOCUS_GAINED:
                case EventType.FOCUS_LOST:
                    e = new Event(typeId);
                    break;

                case RESIZED:
                    e = new SizeEvent(typeId, ints.get(1), ints.get(2));
                    break;

                case TEXT_ENTERED:
                    e = new TextEvent(typeId, ints.get(1));
                    break;
                    */
                case EventType.KEY_PRESSED:
                case EventType.KEY_RELEASED:
                    final int keyCode = ints.get(1);
                    final int flags = ints.get(2);
                    e = new KeyEvent(typeId, keyCode,
                            (flags & 0x01) != 0,
                            (flags & 0x02) != 0,
                            (flags & 0x04) != 0,
                            (flags & 0x08) != 0);
                    break;
                    /*
                case MOUSE_WHEEL_MOVED:
                    e = new MouseWheelEvent(typeId, ints.get(1), ints.get(2), ints.get(3));
                    break;

                case MOUSE_BUTTON_PRESSED:
                case MOUSE_BUTTON_RELEASED:
                    e = new MouseButtonEvent(typeId, ints.get(1), ints.get(2), ints.get(3));
                    break;

                case MOUSE_MOVED:
                case MOUSE_LEFT:
                case MOUSE_ENTERED:
                    e = new MouseEvent(typeId, ints.get(1), ints.get(2));
                    break;

                case JOYSTICK_BUTTON_PRESSED:
                case JOYSTICK_BUTTON_RELEASED:
                    e = new JoystickButtonEvent(typeId, ints.get(1), ints.get(2));
                    break;

                case JOYSTICK_MOVED:
                    e = new JoystickMoveEvent(typeId, ints.get(1), ints.get(2),
                            Float.intBitsToFloat(ints.get(3)));
                    break;

                case JOYSTICK_CONNECTED:
                case JOYSTICK_DISCONNECTED:
                    e = new JoystickEvent(typeId, ints.get(1));
                    break;
                    */
                default:
                    e = null;
                    break;
            }
        } else {
            e = null;
        }

        return e;
    }        
	public Event pollEvent() {	
		IntBuffer intBuffer=BUFFER.get().asIntBuffer();
		
		boolean result=(getCsfmlGraphicsLibrary().sfRenderWindow_pollEvent(m_nativePointer, intBuffer)==0)?false : true;
		
		
		return decodeEvent(intBuffer);
	}
	/*✓*/
	/*public boolean waitEvent(Event event) {
		return (m_csfmlGraphicsLibrary.sfRenderWindow_waitEvent(m_nativePointer, getMemory(event))==0)?false : true;
	}
	
	private Event pollEvent() {
		Event event=new Event();
		Event returnEvent=null;
		if(waitEvent(event)) {
			switch (event.getType()) {
			case EventType.KEY_PRESSED:
				//returnEvent=new KeyEvent(event.getType());
				break;
			case EventType.MOUSE_MOVED:
				returnEvent=null;
				break;
			}
		}
		return returnEvent;
	}
	
	public Iterable<Event> pollEvents() {
        return new Iterable<Event>() {
            @Override
            public Iterator<Event> iterator() {
                return new Iterator<Event>() {
                    private Event nextEvent = pollEvent();

                    @Override
                    public boolean hasNext() {
                        return (nextEvent != null);
                    }

                    @Override
                    public Event next() {
                        Event currentEvent = nextEvent;
                        nextEvent = pollEvent();
                        return currentEvent;
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }*/
	
	public Vector2i getPosition() {
		return getCsfmlGraphicsLibrary().sfRenderWindow_getPosition(m_nativePointer);
	}
	public void setPosition(Vector2i position) {
		getCsfmlGraphicsLibrary().sfRenderWindow_setPosition(m_nativePointer, position);
	}
	public Vector2i getSize(RenderWindow renderWindow) {
		Vector2u vector2u=getCsfmlGraphicsLibrary().sfRenderWindow_getSize(m_nativePointer);
		System.out.println(vector2u);
		return new Vector2i((int)vector2u.x, (int)vector2u.y);
	}
	public void setSize(Vector2u size) {
		getCsfmlGraphicsLibrary().sfRenderWindow_setSize(m_nativePointer, size);
	}
	public void setTitle(java.lang.String title) {
		getCsfmlGraphicsLibrary().sfRenderWindow_setTitle(m_nativePointer, title);
	}
}