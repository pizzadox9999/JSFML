package org.jsfml.window;

public abstract class KeyBoard {
	public enum KeyCode {
		KEY_UNKNOWN,
		A,            	///< The A key
		B,         	 ///< The B key
		C,         	 ///< The C key
		D,         	 ///< The D key
		E,          	 ///< The E key
		F,         	 ///< The F key
		G,         	 ///< The G key
		H,         	 ///< The H key
		I,         	 ///< The I key
		J,          	 ///< The J key
		K,          	 ///< The K key
		L,          	 ///< The L key
		M,          	 ///< The M key
		N,          	 ///< The N key
		O,          	 ///< The O key
		P,              ///< The P key
		Q,			 ///< The Q key
		R,           	 ///< The R key
		S,          	 ///< The S key
		T,          	 ///< The T key
		U,          	 ///< The U key
		V,          	 ///< The V key
		W,         	 ///< The W key
		X,          	 ///< The X key
		Y,          	 ///< The Y key
		Z,          	 ///< The Z key
		NUMBER_0,        ///< The 0 key
		NUMBER_1,        ///< The 1 key
		NUMBER_2,        ///< The 2 key
		NUMBER_3,        ///< The 3 key
		NUMBER_4,        ///< The 4 key
		NUMBER_5,        ///< The 5 key
		NUMBER_6,        ///< The 6 key
		NUMBER_7,        ///< The 7 key
		NUMBER_8,        ///< The 8 key
		NUMBER_9,        ///< The 9 key
		ESCAPE,           ///< The Escape key
		CONTROL,          ///< The left Control key
		SHIFT_LEFT,       ///< The left Shift key
		ALT_LEFT,         ///< The left Alt key
		SYSTEM_LEFT,     ///< The left OS specific key: window (Windows and Linux), apple (MacOS X), ...
		CONTROL_RIGHT,   ///< The right Control key
		SHIFT_RIGHT,   ///< The right Shift key
		ALT_RIGHT,       ///< The right Alt key
		SYSTEM_RIGHT,      ///< The right OS specific key: window (Windows and Linux), apple (MacOS X), ...
		MENU,         ///< The Menu key
		BRACKET_LET,     ///< The [ key
		BRACKET_RIGHT,     ///< The ] key
		SEMICOLON,   ///< The ; key
		COMMA,        ///< The , key
		PERIOD,				  ///< The . key
		QUOTE,       ///< The ' key
		SLASH,        ///< The / key
		SLAHS_BACK,    ///< The \ key
		TILDE,        ///< The ~ key
		EQUAL,       ///< The = key
		HYPHEN,      ///< The - key (hyphen)
		SPACE,        ///< The Space key
		ENTER,        ///< The Enter/Return key
		BACKSPACE,    ///< The Backspace key
		TAB,          ///< The Tabulation key
		PAGE_UP,		///< The Page up key
		PAGE_DOWN,     ///< The Page down key
		END,          ///< The End key
		HOME,			///< The Home key
		INSERT,       ///< The Insert key
		DELETE,       ///< The Delete key
		ADD,         ///< The + key
		SUBTRACT,     ///< The - key (minus, usually from numpad)
		MULTIPLY,     ///< The * key
		DIVIDE,       ///< The / key
		LEFT,         ///< Left arrow
		RIGHT,		///< Right arrow
		UP,          ///< Up arrow
		DOWN,         ///< Down arrow
		NUMPAD_0,     ///< The numpad 0 key
		NUMPAD_1,     ///< The numpad 1 key
		NUMPAD_2,     ///< The numpad 2 key
		NUMPAD_3,     ///< The numpad 3 key
		NUMPAD_4,     ///< The numpad 4 key
		NUMPAD_5,     ///< The numpad 5 key
		NUMPAD_6,     ///< The numpad 6 key
		NUMPAD_7,     ///< The numpad 7 key
		NUMPAD_8,     ///< The numpad 8 key
		NUMPAD_9,     ///< The numpad 9 key
		F1,         ///< The F1 key
		F2,         ///< The F2 key
		F3,         ///< The F3 key
		F4,         ///< The F4 key
		F5,         ///< The F5 key
		F6,         ///< The F6 key
		F7,         ///< The F7 key
		F8,         ///< The F8 key
		F9,         ///< The F8 key
		F10,         ///< The F10 key
		F11,         ///< The F11 key
		F12,         ///< The F12 key
		F13,         ///< The F13 key
		F14,         ///< The F14 key
		F15,          ///< The F15 key
	    PAUSE        ///< The Pause key
	}	
	public static boolean isKeyPressed(KeyCode key) {
		
		return false;
	}
	
	public static void setVirtualKeyboardVisible(boolean visible) {
		
	}
}