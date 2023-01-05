package org.jsfml.window.event;

import org.jsfml.window.KeyBoard.KeyCode;

/**
 * Represents keyboard key events.
 * <p/>
 * Objects of this class are created for events of type
 * {@link Event.Type#KEY_PRESSED} or
 * {@link Event.Type#KEY_RELEASED}.
 */
public final class KeyEvent extends Event {
    /**
     * The code of the key that was pressed or released.
     */
    public final KeyCode key;

    /**
     * {@code true} if an {@code ALT} key (left or right) was pressed when the event occured,
     * {@code false} if not.
     */
    @Deprecated
    public final boolean alt;

    /**
     * {@code true} if a {@code SHIFT} key (left or right) was pressed when the event occured,
     * {@code false} if not.
     */
    @Deprecated
    public final boolean shift;

    /**
     * {@code true} if a {@code CTRL} key (left or right) was pressed when the event occured,
     * {@code false} if not.
     */
    @Deprecated
    public final boolean control;

    /**
     * {@code true} if a system key was pressed when the event occured,
     * {@code false} if not.
     */
    @Deprecated
    public final boolean system;

    /**
     * Constructs a new key event.
     *
     * @param type    the type of the event.
     *                This must be a valid ordinal in the {@link Event.Type} enumeration.
     * @param keyCode the code of the key that was pressed.
     *                This must be a valid ordinal in the {@link org.jsfml.window.Keyboard.Key}
     *                enumeration.
     * @param alt     {@code true} to indicate that an {@code ALT} key was pressed.
     * @param shift   {@code true} to indicate that a {@code SHIFT} key was pressed.
     * @param control {@code true} to indicate that a {@code CTRL} key was pressed.
     * @param system  {@code true} to indicate that a system key was pressed.
     */
    public KeyEvent(int type, int keyCode, boolean alt, boolean shift, boolean control, boolean system) {
        super(type);
        this.key = KeyCode.values()[keyCode + 1];
        this.alt = alt;
        this.shift = shift;
        this.control = control;
        this.system = system;
    }

    @Override
    public KeyEvent asKeyEvent() {
        return this;
    }
    
    public String toString() {
    	return "TYPE: "+type+" KEY: "+key+" ALT: "+alt+" SHIFT: "+shift+" CONTROL: "+control+" SYSTEM: "+system;
    }
}