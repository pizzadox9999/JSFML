package org.jsfml.window.event;

import org.jsfml.JSFML;
import org.jsfml.window.event.joystick.JoystickButtonEvent;
import org.jsfml.window.event.joystick.JoystickConnectEvent;
import org.jsfml.window.event.joystick.JoystickMoveEvent;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.Union;

public class Event extends Union {
	public class EventType {
		public static final int CLOSED=0;                 ///< The window requested to be closed (no data)
		public static final int RESIZED=1;                ///< The window was resized (data in event.size)
		public static final int FOCUS_LOST=2;             ///< The window lost the focus (no data)
		public static final int FOCUS_GAINED=3;            ///< The window gained the focus (no data)
		public static final int TEXT_ENTERED=4;            ///< A character was entered (data in event.text)
		public static final int KEY_PRESSED=5;             ///< A key was pressed (data in event.key)
		public static final int KEY_RELEASED=6;            ///< A key was released (data in event.key)
		@Deprecated
		public static final int sfEvtMouseWheelMoved=7;        ///< The mouse wheel was scrolled (data in event.mouseWheel) (deprecated)
		public static final int MOUSE_WHEEL_SCROLLED=8;     ///< The mouse wheel was scrolled (data in event.mouseWheelScroll)
		public static final int MOUSE_BUTTON_PRESSED=9;     ///< A mouse button was pressed (data in event.mouseButton)
		public static final int MOUSE_BUTTON_RELEASED=10;    ///< A mouse button was released (data in event.mouseButton)
		public static final int MOUSE_MOVED=11;             ///< The mouse cursor moved (data in event.mouseMove)
		public static final int MOUSE_ENTERED=12;           ///< The mouse cursor entered the area of the window (no data)
		public static final int MOUSE_LEFT=13;              ///< The mouse cursor left the area of the window (no data)
		public static final int JOYSTICK_BUTTON_PRESSED=14;  ///< A joystick button was pressed (data in event.joystickButton)
		public static final int JOYSTICK_BUTTON_RELEASED=15; ///< A joystick button was released (data in event.joystickButton)
		public static final int JOYSTICK_MOVED=16;         ///< The joystick moved along an axis (data in event.joystickMove)
		public static final int JOYSTICK_CONNECTED=17;      ///< A joystick was connected (data in event.joystickConnect)
		public static final int JOYSTICK_DISCONNECTED=18;   ///< A joystick was disconnected (data in event.joystickConnect)
		public static final int TOUCH_BEGAN=19;             ///< A touch event began (data in event.touch)
		public static final int TOUCH_MOVED=20;             ///< A touch moved (data in event.touch)
		public static final int TOUCH_ENDED=21;            ///< A touch event ended (data in event.touch)
		public static final int SENSOR_CHANGED=22;          ///< A sensor value changed (data in event.sensor)

		public static final int sfEvtCount=23;                  ///< Keep last -- the total number of event types
	}
	
	public Signed32              type;             ///< Type of the event
	public SizeEvent             size;             ///< Size event parameters
	public KeyEvent              key;              ///< Key event parameters
	public TextEvent             text;             ///< Text event parameters
	public MouseMoveEvent        mouseMove;        ///< Mouse move event parameters
	public MouseButtonEvent      mouseButton;      ///< Mouse button event parameters
	public MouseWheelScrollEvent mouseWheelScroll; ///< Mouse wheel event parameters
	public JoystickMoveEvent     joystickMove;     ///< Joystick move event parameters
	public JoystickButtonEvent   joystickButton;   ///< Joystick button event parameters
	public JoystickConnectEvent  joystickConnect;  ///< Joystick (dis)connect event parameters
	public TouchEvent            touch;            ///< Touch events parameters
	public SensorEvent           sensor;           ///< Sensor event parameters
	
	
	
	public Event(int eventType) {
		this();
		this.type.set(eventType);
		
		switch (eventType) {
		case EventType.MOUSE_MOVED:

			mouseMove=new MouseMoveEvent(eventType); 
			break;
		}
	}
	
	public Event() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public Event(Runtime runtime) {
		super(runtime);
		type=new Signed32();
	}
	
	public int getType() {
		return type.get();
	}
}