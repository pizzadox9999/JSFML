package org.jsfml.graphics;

import java.util.Iterator;

import org.jsfml.CsfmlGraphicsLibrary;
import org.jsfml.JSFML;
import org.jsfml.system.Vector2i;
import org.jsfml.system.Vector2u;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;
import org.jsfml.window.event.MouseMoveEvent;
import org.jsfml.window.event.Event.EventType;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class RenderWindow extends Struct {
	private CsfmlGraphicsLibrary m_csfmlGraphicsLibrary;
	private jnr.ffi.Pointer m_nativePointer;
	
	public RenderWindow() {
		this(JSFML.getCsfmlGraphicsRuntime());
	}
	
	public RenderWindow(Runtime runtime) {
		super(runtime);
		m_csfmlGraphicsLibrary=JSFML.getCsfmlGraphicsLibrary();
	}
	/*✓*/
	public void create(VideoMode mode, java.lang.String title, int style, ContextSettings settings) {
		m_nativePointer=m_csfmlGraphicsLibrary.sfRenderWindow_create(mode, title, style, getMemory(settings));
	}
	/*✓*/
	public void destroy() {
		m_csfmlGraphicsLibrary.sfRenderWindow_destroy(m_nativePointer);
	}
	/*✓*/
	public void close() {
		m_csfmlGraphicsLibrary.sfRenderWindow_close(m_nativePointer);
	}
	/*✓*/
	public boolean isOpen() {
		return (m_csfmlGraphicsLibrary.sfRenderWindow_isOpen(m_nativePointer)==1)?true : false;
	}
	
	public ContextSettings getSettings() {
		return m_csfmlGraphicsLibrary.sfRenderWindow_getSettings(m_nativePointer);
	}
	/*✓*/
	public boolean pollEvent(Event event) {	
		
		return (m_csfmlGraphicsLibrary.sfRenderWindow_pollEvent(m_nativePointer, getMemory(event))==1)?true : false;
	}
	/*✓*/
	public boolean waitEvent(Event event) {
		return (m_csfmlGraphicsLibrary.sfRenderWindow_waitEvent(m_nativePointer, getMemory(event))==1)?true : false;
	}
	
	private Event pollEvent() {
		Event event=new Event();
		Event returnEvent=null;
		if(waitEvent(event)) {
			switch (event.getType()) {
			case EventType.KEY_PRESSED:
				returnEvent=new KeyEvent(event.getType());
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
    }
	
	public Vector2i getPosition() {
		return m_csfmlGraphicsLibrary.sfRenderWindow_getPosition(m_nativePointer);
	}
	public void setPosition(Vector2i position) {
		m_csfmlGraphicsLibrary.sfRenderWindow_setPosition(m_nativePointer, position);
	}
	public Vector2i getSize(RenderWindow renderWindow) {
		Vector2u vector2u=m_csfmlGraphicsLibrary.sfRenderWindow_getSize(m_nativePointer);
		System.out.println(vector2u);
		return new Vector2i((int)vector2u.x, (int)vector2u.y);
	}
	public void setSize(Vector2u size) {
		m_csfmlGraphicsLibrary.sfRenderWindow_setSize(m_nativePointer, size);
	}
	public void setTitle(java.lang.String title) {
		m_csfmlGraphicsLibrary.sfRenderWindow_setTitle(m_nativePointer, title);
	}
}