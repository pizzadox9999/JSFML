package org.jsfml.window;

import org.jsfml.graphics.Image;
import org.jsfml.internal.IntercomHelper;
import org.jsfml.internal.JSFMLError;
import org.jsfml.internal.SFMLNative;
import org.jsfml.internal.SFMLNativeObject;
import org.jsfml.internal.wrapper.CsfmlWindowLibrary;
import org.jsfml.system.Vector2i;
import org.jsfml.window.event.*;

import jnr.ffi.Pointer;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.Objects;

/**
 * A basic window that provides an OpenGL context.
 * <p/>
 * This class implements the {@code WindowStyle} interface for quick access
 * to the constants provided by it.
 */
public class Window extends SFMLNativeObject implements WindowStyle {
    private static Event decodeEvent(IntBuffer ints) {
    	System.out.println(ints.get(0));
    	System.out.println(ints.get(1));
    	System.out.println(ints.get(2));
    	System.out.println(ints.get(3));
    	System.out.println(ints.get(4));
    	System.out.println(ints.get(5));
    	System.out.println(ints.get(6));
    	
        final Event e;
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
                    e = new SizeEvent(typeId, ints.get(1), ints.get(2));
                    break;

                case TEXT_ENTERED:
                    e = new TextEvent(typeId, ints.get(1));
                    break;

                case KEY_PRESSED:
                case KEY_RELEASED:
                    e = new KeyEvent(
                    		typeId,
                    		ints.get(1), //keyCode
                    		convertIntegerToBoolean(ints.get(2)),
                    		convertIntegerToBoolean(ints.get(3)),
                    		convertIntegerToBoolean(ints.get(4)),
                    		convertIntegerToBoolean(ints.get(5))
                    	);

                    break;

                case MOUSE_WHEEL_MOVED:
                    e = new MouseWheelEvent(typeId, ints.get(2), ints.get(3), ints.get(1));
                    break;

                case MOUSE_BUTTON_PRESSED:
                case MOUSE_BUTTON_RELEASED:
                    e = new MouseButtonEvent(typeId, ints.get(2), ints.get(3), ints.get(1));
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

                default:
                    e = null;
                    break;
            }
        } else {
            e = null;
        }

        return e;
    }

    /**
     * Constructs a new window without actually creating it (making it visible).
     *
     * @see Window#create(org.jsfml.window.VideoMode, String, int, org.jsfml.window.ContextSettings)
     */
    public Window() {
        super();
        SFMLNative.ensureDisplay();
    }

    /**
     * Constructs a new window and creates it with the specified settings.
     *
     * @param mode     the window's video mode.
     * @param title    the window title.
     * @param style    the window style.
     * @param settings the settings for the OpenGL context.
     * @see #create(VideoMode, String, int, ContextSettings)
     */
    public Window(VideoMode mode, String title, int style, ContextSettings settings) {
        this();
        create(mode, title, style, settings);
    }

    /**
     * Constructs a new window and creates it with the specified settings and default
     * context settings..
     *
     * @param mode  the window's video mode.
     * @param title the window title.
     * @param style the window style.
     */
    public Window(VideoMode mode, String title, int style) {
        this();
        create(mode, title, style, new ContextSettings());
    }

    /**
     * Constructs a new window and creates it with the specified settings and default
     * context settings and window style.
     *
     * @param mode  the window's video mode.
     * @param title the window title.
     */
    public Window(VideoMode mode, String title) {
        this();
        create(mode, title, WindowStyle.DEFAULT, new ContextSettings());
    }

    /**
     * Creates and opens a window or re-creates it if it was already opened.
     *
     * @param mode     the video mode that determines the window's size.
     *                 This must be a valid video mode in case {@link WindowStyle#FULLSCREEN} is set.
     * @param title    the window title.
     * @param style    the style of the window.
     *                 This should be a combination (using {@code OR} of the style flags
     *                 {@link WindowStyle#TITLEBAR}, {@link WindowStyle#RESIZE}, {@link WindowStyle#CLOSE} and
     *                 {@link WindowStyle#FULLSCREEN}, or {@link WindowStyle#NONE} for no style.
     *                 {@link WindowStyle#DEFAULT} provides a default combination of style flags.
     * @param settings the context settings for the created OpenGL context.
     * @see org.jsfml.window.VideoMode#isValid()
     * @see WindowStyle
     * @see ContextSettings
     */
    public void create(VideoMode mode, String title, int style, ContextSettings settings) {
        /*if (!isLegalWindowThread()) {
            throw new JSFMLError("This thread is not allowed to create a window on this system. " +
                    "If you are running on Mac OS X, you MUST run your " +
                    "application with the -XstartOnFirstThread command line argument!");
        }*/

        if ((style & FULLSCREEN) != 0 && !mode.isValid())
            throw new IllegalArgumentException("Invalid video mode for a fullscreen window.");

        title = Objects.requireNonNull(title);

        createLater(getLibrary().sfWindow_create(
        		mode,
        		title,
        		DEFAULT,
        		settings));
    }

    /**
     * Creates and opens a window or re-creates it if it was already opened.
     * The default context settings will be used for the OpenGL context.
     *
     * @param mode  the video mode that determines the window's size.
     *              This must be a valid video mode in case {@link WindowStyle#FULLSCREEN} is set.
     * @param title the window title.
     * @param style the style of the window.
     *              This should be a combination (using {@code OR} of the style flags
     *              {@link WindowStyle#TITLEBAR}, {@link WindowStyle#RESIZE}, {@link WindowStyle#CLOSE} and
     *              {@link WindowStyle#FULLSCREEN}, or {@link WindowStyle#NONE} for no style.
     *              {@link WindowStyle#DEFAULT} provides a default combination of style flags.
     * @see org.jsfml.window.VideoMode#isValid()
     * @see WindowStyle
     */
    public final void create(VideoMode mode, String title, int style) {
        create(mode, title, style, new ContextSettings());
    }

    /**
     * Creates and opens a window or re-creates it if it was already opened.
     * The {@link WindowStyle#DEFAULT} window style will be applied and default
     * context settings will be used for the OpenGL context.
     *
     * @param mode  the video mode that determines the window's size.
     * @param title the window title.
     */
    public final void create(VideoMode mode, String title) {
        create(mode, title, DEFAULT, new ContextSettings());
    }
    
    public void close() {
    	getLibrary().sfWindow_close(getPointer());
    }
    
	public boolean isOpen() {
		return SFMLNativeObject.convertIntegerToBoolean(getLibrary().sfWindow_isOpen(getPointer()));
	}
    
    /**
     * Gets the absolute position of the window's top left corner on the screen.
     *
     * @return the absolute position of the window's top left corner on the screen.
     */
    public Vector2i getPosition() {
    	Pointer pointer=getLibrary().sfWindow_getPosition(getPointer());
    	Vector2i vector2i=new Vector2i();
    	vector2i.loadFromPointer(pointer);
    	//System.out.println(vector2i.x.get());
    	return null;
    	//return IntercomHelper.decodeVector2i(getLibrary().sfWindow_getPosition(getPointer()));
    }

    /**
     * Sets the absolute position of the window's top left corner on the screen.
     *
     * @param position the new absolute position of the window's top left corner on the screen.
     */
    public void setPosition(Vector2i position) {
    	//getLibrary().sfWindow_setPosition(getPointer(), IntercomHelper.encodeVector2i(position));
    }

    /**
     * Gets the size of the window.
     *
     * @return the size of the window.
     */
    public Vector2i getSize() {
        return IntercomHelper.decodeVector2i(getLibrary().sfWindow_getSize(getPointer()));
    }

    /**
     * Sets the size of the window.
     *
     * @param size the new size of the window.
     */
    public void setSize(Vector2i size) {
    	//getLibrary().sfWindow_setSize(getPointer(), IntercomHelper.encodeVector2i(size));
    }

    /**
     * Retrieves the context settings for the window's OpenGL context.
     *
     * @return the context settings for the window's OpenGL context.
     */
    public ContextSettings getSettings() {
    	return getLibrary().sfWindow_getSettings(getPointer());
    	/*final IntBuffer settings = (IntBuffer) getLibrary().sfWindow_getSettings(getPointer());

        return new ContextSettings(
                settings.get(0),
                settings.get(1),
                settings.get(2),
                settings.get(3),
                settings.get(4),
                settings.get(5),
                SFMLNativeObject.convertIntegerToBoolean(settings.get(6)));*/
    }

    /**
     * Pops the event on top of the event stack, if any, and returns it.
     * <p/>
     * This method needs to be called regularly in order to process pending events. If this is
     * not done, the window will be unresponsive.
     *
     * @return the event currently on top of the event stack, or {@code null} if there is none.
     * @see #waitEvent()
     */
    public Event pollEvent() {
        final IntBuffer buffer = IntercomHelper.getBuffer().asIntBuffer();
        
        if(convertIntegerToBoolean(getLibrary().sfWindow_pollEvent(getPointer(), buffer)))       
        	return decodeEvent(buffer);
        else 
        	return null;
    }

    /**
     * Pops the event on top of the event stack and returns it, or, if there is none,
     * waits until an event occurs and then returns it.
     * <p/>
     * This method will block the program flow until an event is returned.
     *
     * @return the event currently on top of the event stack, or the next event that will occur.
     * @see #pollEvent()
     */
    public Event waitEvent() {
        final IntBuffer buffer = IntercomHelper.getBuffer().asIntBuffer();
        getLibrary().sfWindow_waitEvent(getPointer(), buffer);
        return decodeEvent(buffer);
    }

    /**
     * Returns an {@link Iterable} that consecutively calls {@link #pollEvent()} and
     * can be used to process all pending events.
     *
     * @return an {@code Iterable} over all pending events.
     * @see #pollEvent()
     */
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
    
    /**
     * Sets the window's title.
     *
     * @param title the window's new title.
     */
    public void setTitle(String title) {
        getLibrary().sfWindow_setTitle(getPointer(), Objects.requireNonNull(title));
    }
    
    /**
     * Activates or deactivates the window as the current OpenGL rendering target.
     * <p/>
     * If a window gets activated, all other windows operating in the same thread will
     * automatically be deactivated.
     *
     * @param active {@code true} to activate, {@code false} to deactivate.
     * @throws ContextActivationException in case window activation fails.
     */
    public void setActive(boolean active) throws ContextActivationException {
        if (!SFMLNativeObject.convertIntegerToBoolean(getLibrary().sfWindow_setActive(getPointer(), SFMLNativeObject.convertBooleanToInteger(active)))) {
            throw new ContextActivationException("Failed to " +
                    (active ? "activate" : "deactivate") +
                    " the window's context.");
        }
    }

    /**
     * Activates the window as the current OpenGL rendering target.
     * <p/>
     * If a window gets activated, all other windows operating in the same thread will
     * automatically be deactivated.
     *
     * @throws ContextActivationException in case window activation fails.
     */
    public final void setActive() throws ContextActivationException {
        setActive(true);
    }

	@Override
	protected long createNativeObject() {
		return -1;
	}

	@Override
	protected void deleteNativeObject() {
		getLibrary().sfWindow_destroy(getPointer());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CsfmlWindowLibrary getLibrary() {
		return m_csfmLibrary;
	}

	@Override
	protected boolean createLater() {
		return true;
	}
}