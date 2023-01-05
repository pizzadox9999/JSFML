package org.jsfml.window.event;

/**
 * Base class for window events.
 * <p/>
 * Window events must be polled from a window on a regular basis to keep
 * the window responsive.
 * <p/>
 * Events are of a certain type, some of which provide additional data. For
 * various special types, subclasses of this class exist. This class provides
 * convenience methods to cast {@code Event} objects to one of these special
 * subclasses (e.g. {@link #asKeyEvent()}, which will cast the event to a {@code KeyEvent},
 * if possible).
 *
 * @see org.jsfml.window.Window#pollEvents()
 * @see Type
 */
public class Event {
    /**
     * Enumeration of available window event types.
     */
    public static enum Type {
        /**
         * Fired when the user clicked on the window's close button.
         */
        CLOSED,

        /**
         * Fired when the window was resized.
         */
        RESIZED,

        /**
         * Fired when the window lost focus.
         */
        LOST_FOCUS,

        /**
         * Fired when the window gained focus.
         */
        GAINED_FOCUS,

        /**
         * Fired when a text character was entered using the keyboard while the
         * window had focus.
         * <p/>
         * Events of this type can be cast to {@link TextEvent} using the
         * {@link #asTextEvent()} method.
         */
        TEXT_ENTERED,

        /**
         * Fired when a keyboard key was pressed while the window had focus.
         * <p/>
         * Events of this type can be cast to {@link KeyEvent} using the
         * {@link #asKeyEvent()} method.
         */
        KEY_PRESSED,

        /**
         * Fired when a keyboard key was released while the window had focus.
         * <p/>
         * Events of this type can be cast to {@link KeyEvent} using the
         * {@link #asKeyEvent()} method.
         */
        KEY_RELEASED,

        /**
         * Fired when the mouse wheel was moved while the window had focus.
         * <p/>
         * Events of this type can be cast to {@link MouseWheelEvent} using the
         * {@link #asMouseWheelEvent()} method.
         */
        MOUSE_WHEEL_MOVED,

        /**
         * Fired when a mouse button was pressed while the window had focus.
         * <p/>
         * Events of this type can be cast to {@link MouseButtonEvent} using the
         * {@link #asMouseButtonEvent()} method.
         */
        MOUSE_BUTTON_PRESSED,

        /**
         * Fired when a mouse button was released while the window had focus.
         * <p/>
         * Events of this type can be cast to {@link MouseButtonEvent} using the
         * {@link #asMouseButtonEvent()} method.
         */
        MOUSE_BUTTON_RELEASED,

        /**
         * Fired when the mouse cursor was moved within the window's boundaries.
         * <p/>
         * Events of this type can be cast to {@link MouseEvent} using the
         * {@link #asMouseEvent()} method.
         */
        MOUSE_MOVED,

        /**
         * Fired when the mouse cursor entered the window's boundaries.
         * <p/>
         * Events of this type can be cast to {@link MouseEvent} using the
         * {@link #asMouseEvent()} method.
         */
        MOUSE_ENTERED,

        /**
         * Fired when the mouse cursor left the window's boundaries.
         * <p/>
         * Events of this type can be cast to {@link MouseEvent} using the
         * {@link #asMouseEvent()} method.
         */
        MOUSE_LEFT,

        /**
         * Fired when a joystick or gamepad button was pressed while the window
         * had focus.
         * <p/>
         * Events of this type can be cast to {@link JoystickButtonEvent} using the
         * {@link #asJoystickButtonEvent()} method.
         */
        JOYSTICK_BUTTON_PRESSED,

        /**
         * Fired when a joystick or gamepad button was released while the window
         * had focus.
         * <p/>
         * Events of this type can be cast to {@link JoystickButtonEvent} using the
         * {@link #asJoystickButtonEvent()} method.
         */
        JOYSTICK_BUTTON_RELEASED,

        /**
         * Fired when a joystick or gamepad axis was moved while the window
         * had focus.
         * <p/>
         * Events of this type can be cast to {@link JoystickMoveEvent} using the
         * {@link #asJoystickMoveEvent()} method.
         */
        JOYSTICK_MOVED,

        /**
         * Fired when a joystick or gamepad was connected.
         * <p/>
         * Events of this type can be cast to {@link JoystickEvent} using the
         * {@link #asJoystickEvent()} method.
         */
        JOYSTICK_CONNECTED,

        /**
         * Fired when a joystick or gamepad was disconnected.
         * <p/>
         * Events of this type can be cast to {@link JoystickEvent} using the
         * {@link #asJoystickEvent()} method.
         */
        JOYSTICK_DISCONNECTED
    }

    /**
     * The type of the window event.
     *
     * @see Type
     */
    public final Type type;

    /**
     * Constructs a new event.
     *
     * @param type the type of the event.
     *             This must be a valid ordinal in the {@link Event.Type} enumeration.
     */
    public Event(int type) {
        this.type = Type.values()[type];
    }   
}