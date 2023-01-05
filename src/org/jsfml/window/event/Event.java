package org.jsfml.window.event;

import org.jsfml.internal.JSFML;
import org.jsfml.window.event.joystick.JoystickButtonEvent;
import org.jsfml.window.event.joystick.JoystickConnectEvent;
import org.jsfml.window.event.joystick.JoystickMoveEvent;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.Union;

public class Event {
    /**
     * The type of the window event.
     *
     * @see Type
     */
    public final int type;

    /**
     * Constructs a new event.
     *
     * @param type the type of the event.
     *             This must be a valid ordinal in the {@link Event.Type} enumeration.
     */
    public Event(int type) {
        this.type = type;
    }

    /**
     * Attempts to cast this event to a {@link JoystickButtonEvent}.
     *
     * @return the event cast to a {@code JoystickButtonEvent} if its type is either
     *         {@link Type#JOYSTICK_BUTTON_PRESSED} or {@link Type#JOYSTICK_BUTTON_RELEASED},
     *         {@code null} otherwise.
     */
    public JoystickButtonEvent asJoystickButtonEvent() {
        return null;
    }

    /**
     * Attempts to cast this event to a {@link JoystickEvent}.
     *
     * @return the event cast to a {@code JoystickEvent} if its type is one of
     *         {@link Type#JOYSTICK_CONNECTED}, {@link Type#JOYSTICK_DISCONNECTED},
     *         {@link Type#JOYSTICK_BUTTON_PRESSED}, {@link Type#JOYSTICK_BUTTON_RELEASED} or
     *         {@link Type#JOYSTICK_MOVED}, {@code null} otherwise.
     
    public JoystickEvent asJoystickEvent() {
        return null;
    }*/

    /**
     * Attempts to cast this event to a {@link JoystickMoveEvent}.
     *
     * @return the event cast to a {@code JoystickButtonEvent} if its type is
     *         {@link Type#JOYSTICK_MOVED}, {@code null} otherwise.
     */
    public JoystickMoveEvent asJoystickMoveEvent() {
        return null;
    }

    /**
     * Attempts to cast this event to a {@link KeyEvent}.
     *
     * @return the event cast to a {@code KeyEvent} if its type is either
     *         {@link Type#KEY_PRESSED} or {@link Type#KEY_RELEASED},
     *         {@code null} otherwise.
     */
    public KeyEvent asKeyEvent() {
        return null;
    }

    /**
     * Attempts to cast this event to a {@link MouseButtonEvent}.
     *
     * @return the event cast to a {@code MouseButtonEvent} if its type is either
     *         {@link Type#MOUSE_BUTTON_PRESSED} or {@link Type#MOUSE_BUTTON_RELEASED},
     *         {@code null} otherwise.
     */
    public MouseButtonEvent asMouseButtonEvent() {
        return null;
    }

    /**
     * Attempts to cast this event to a {@link MouseEvent}.
     *
     * @return the event cast to a {@code MouseEvent} if its type is one of
     *         {@link Type#MOUSE_ENTERED}, {@link Type#MOUSE_MOVED},
     *         {@link Type#MOUSE_LEFT}, {@link Type#MOUSE_BUTTON_PRESSED},
     *         {@link Type#MOUSE_BUTTON_RELEASED} or {@link Type#MOUSE_WHEEL_MOVED},
     *         {@code null} otherwise.
     
    public MouseEvent asMouseEvent() {
        return null;
    }*/

    /**
     * Attempts to cast this event to a {@link MouseWheelEvent}.
     *
     * @return the event cast to a {@code MouseWheelEvent} if its type is
     *         {@link Type#MOUSE_WHEEL_MOVED}, {@code null} otherwise.
     
    public MouseWheelEvent asMouseWheelEvent() {
        return null;
    }*/

    /**
     * Attempts to cast this event to a {@link SizeEvent}.
     *
     * @return the event cast to a {@code SizeEvent} if its type is
     *         {@link Type#RESIZED}, {@code null} otherwise.
     */
    public SizeEvent asSizeEvent() {
        return null;
    }

    /**
     * Attempts to cast this event to a {@link TextEvent}.
     *
     * @return the event cast to a {@code TextEvent} if its type is
     *         {@link Type#TEXT_ENTERED}, {@code null} otherwise.
     */
    public TextEvent asTextEvent() {
        return null;
    }
}