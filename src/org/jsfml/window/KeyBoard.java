package org.jsfml.window;

public abstract class KeyBoard {
	public class KeyCode {
		public static final int KEY_UNKNOWN=-1;
		public static final int A=0;            	///< The A key
		public static final int B=1;            	 ///< The B key
		public static final int C=2;            	 ///< The C key
		public static final int D=3;            	 ///< The D key
		public static final int E=4;             	 ///< The E key
		public static final int F=5;            	 ///< The F key
		public static final int G=6;            	 ///< The G key
		public static final int H=7;            	 ///< The H key
		public static final int I=8;            	 ///< The I key
		public static final int J=9;            	 ///< The J key
		public static final int K=10;            	 ///< The K key
		public static final int L=11;            	 ///< The L key
		public static final int M=12;            	 ///< The M key
		public static final int N=13;            	 ///< The N key
		public static final int O=14;            	 ///< The O key
		public static final int P=15;                ///< The P key
		public static final int Q=16; 				 ///< The Q key
		public static final int R=17;             	 ///< The R key
		public static final int S=18;            	 ///< The S key
		public static final int T=19;            	 ///< The T key
		public static final int U=20;            	 ///< The U key
		public static final int V=21;            	 ///< The V key
		public static final int W=22;           	 ///< The W key
		public static final int X=23;            	 ///< The X key
		public static final int Y=24;            	 ///< The Y key
		public static final int Z=25;            	 ///< The Z key
		public static final int NUMBER_0=26;         ///< The 0 key
		public static final int NUMBER_1=27;         ///< The 1 key
		public static final int NUMBER_2=28;         ///< The 2 key
		public static final int NUMBER_3=29;         ///< The 3 key
		public static final int NUMBER_4=30;         ///< The 4 key
		public static final int NUMBER_5=31;         ///< The 5 key
		public static final int NUMBER_6=32;         ///< The 6 key
		public static final int NUMBER_7=33;         ///< The 7 key
		public static final int NUMBER_8=34;         ///< The 8 key
		public static final int NUMBER_9=35;         ///< The 9 key
		public static final int ESCAPE=36;          ///< The Escape key
		public static final int CONTROL=37;          ///< The left Control key
		public static final int SHIFT_LEFT=38;       ///< The left Shift key
		public static final int ALT_LEFT=39;         ///< The left Alt key
		public static final int SYSTEM_LEFT=40;      ///< The left OS specific key: window (Windows and Linux), apple (MacOS X), ...
		public static final int CONTROL_RIGHT=41;    ///< The right Control key
		public static final int SHIFT_RIGHT=42;   ///< The right Shift key
		public static final int ALT_RIGHT=43;       ///< The right Alt key
		public static final int SYSTEM_RIGHT=44;      ///< The right OS specific key: window (Windows and Linux), apple (MacOS X), ...
		public static final int MENU=45;         ///< The Menu key
		public static final int BRACKET_LET=46;     ///< The [ key
		public static final int BRACKET_RIGHT=47;     ///< The ] key
		public static final int SEMICOLON=48;    ///< The ; key
		public static final int COMMA=49;        ///< The , key
		public static final int PERIOD=50;				  ///< The . key
		public static final int QUOTE=51;        ///< The ' key
		public static final int SLASH=52;        ///< The / key
		public static final int SLAHS_BACK=53;    ///< The \ key
		public static final int TILDE=54;        ///< The ~ key
		public static final int EQUAL=55;        ///< The = key
		public static final int HYPHEN=56;       ///< The - key (hyphen)
		public static final int SPACE=57;        ///< The Space key
		public static final int ENTER=58;        ///< The Enter/Return key
		public static final int BACKSPACE=59;    ///< The Backspace key
		public static final int TAB=60;          ///< The Tabulation key
		public static final int PAGE_UP=61;		///< The Page up key
		public static final int PAGE_DOWN=62;     ///< The Page down key
		public static final int END=63;          ///< The End key
		public static final int HOME=64;			///< The Home key
		public static final int INSERT=65;       ///< The Insert key
		public static final int DELETE=66;       ///< The Delete key
		public static final int ADD=67;          ///< The + key
		public static final int SUBTRACT=68;     ///< The - key (minus, usually from numpad)
		public static final int MULTIPLY=69;     ///< The * key
		public static final int DIVIDE=70;       ///< The / key
		public static final int LEFT=71;         ///< Left arrow
		public static final int RIGHT=72;		///< Right arrow
		public static final int UP=73;           ///< Up arrow
		public static final int DOWN=74;         ///< Down arrow
		public static final int NUMPAD_0=75;      ///< The numpad 0 key
	    public static final int NUMPAD_1=76;      ///< The numpad 1 key
	    public static final int NUMPAD_2=77;      ///< The numpad 2 key
	    public static final int NUMPAD_3=78;      ///< The numpad 3 key
	    public static final int NUMPAD_4=79;      ///< The numpad 4 key
	    public static final int NUMPAD_5=80;      ///< The numpad 5 key
	    public static final int NUMPAD_6=81;      ///< The numpad 6 key
	    public static final int NUMPAD_7=82;      ///< The numpad 7 key
	    public static final int NUMPAD_8=83;      ///< The numpad 8 key
	    public static final int NUMPAD_9=84;      ///< The numpad 9 key
	    public static final int F1=85;           ///< The F1 key
	    public static final int F2=86;           ///< The F2 key
	    public static final int F3=87;           ///< The F3 key
	    public static final int F4=88;           ///< The F4 key
	    public static final int F5=89;           ///< The F5 key
	    public static final int F6=90;           ///< The F6 key
	    public static final int F7=91;           ///< The F7 key
	    public static final int F8=92;           ///< The F8 key
	    public static final int F9=93;           ///< The F8 key
	    public static final int F10=94;          ///< The F10 key
	    public static final int F11=95;          ///< The F11 key
	    public static final int F12=96;          ///< The F12 key
	    public static final int F13=97;          ///< The F13 key
	    public static final int F14=98;          ///< The F14 key
	    public static final int F15=99;          ///< The F15 key
	    public static final int PAUSE=100;        ///< The Pause key
	}
	
	public static boolean isKeyPressed(KeyCode key) {
		
		return false;
	}
	
	public static void setVirtualKeyboardVisible(boolean visible) {
		
	}
}