package org.jsfml.window;

public abstract class KeyBoard {
	public class KeyCode {
		public static final int KEY_UNKNOWN=0;
		public static final int A=1;            	///< The A key
		public static final int B=2;            	 ///< The B key
		public static final int C=3;            	 ///< The C key
		public static final int D=4;            	 ///< The D key
		public static final int E=5;             	 ///< The E key
		public static final int F=6;            	 ///< The F key
		public static final int G=7;            	 ///< The G key
		public static final int H=8;            	 ///< The H key
		public static final int I=9;            	 ///< The I key
		public static final int J=10;            	 ///< The J key
		public static final int K=11;            	 ///< The K key
		public static final int L=12;            	 ///< The L key
		public static final int M=13;            	 ///< The M key
		public static final int N=14;            	 ///< The N key
		public static final int O=15;            	 ///< The O key
		public static final int P=16;                ///< The P key
		public static final int Q=17; 				 ///< The Q key
		public static final int R=18;             	 ///< The R key
		public static final int S=19;            	 ///< The S key
		public static final int T=20;            	 ///< The T key
		public static final int U=21;            	 ///< The U key
		public static final int V=22;            	 ///< The V key
		public static final int W=23;           	 ///< The W key
		public static final int X=24;            	 ///< The X key
		public static final int Y=25;            	 ///< The Y key
		public static final int Z=26;            	 ///< The Z key
		public static final int NUMBER_0=27;         ///< The 0 key
		public static final int NUMBER_1=28;         ///< The 1 key
		public static final int NUMBER_2=29;         ///< The 2 key
		public static final int NUMBER_3=30;         ///< The 3 key
		public static final int NUMBER_4=31;         ///< The 4 key
		public static final int NUMBER_5=32;         ///< The 5 key
		public static final int NUMBER_6=33;         ///< The 6 key
		public static final int NUMBER_7=34;         ///< The 7 key
		public static final int NUMBER_8=35;         ///< The 8 key
		public static final int NUMBER_9=36;         ///< The 9 key
		public static final int ESCAPE=37;           ///< The Escape key
		public static final int CONTROL=38;          ///< The left Control key
		public static final int SHIFT_LEFT=39;       ///< The left Shift key
		public static final int ALT_LEFT=40;         ///< The left Alt key
		public static final int SYSTEM_LEFT=41;      ///< The left OS specific key: window (Windows and Linux), apple (MacOS X), ...
		public static final int CONTROL_RIGHT=42;    ///< The right Control key
		public static final int SHIFT_RIGHT=43;   ///< The right Shift key
		public static final int ALT_RIGHT=44;       ///< The right Alt key
		public static final int SYSTEM_RIGHT=45;      ///< The right OS specific key: window (Windows and Linux), apple (MacOS X), ...
		public static final int MENU=46;         ///< The Menu key
		public static final int BRACKET_LET=47;     ///< The [ key
		public static final int BRACKET_RIGHT=48;     ///< The ] key
		public static final int SEMICOLON=49;    ///< The ; key
		public static final int COMMA=50;        ///< The , key
		public static final int PERIOD=51;				  ///< The . key
		public static final int QUOTE=52;        ///< The ' key
		public static final int SLASH=53;        ///< The / key
		public static final int SLAHS_BACK=54;    ///< The \ key
		public static final int TILDE=55;        ///< The ~ key
		public static final int EQUAL=56;        ///< The = key
		public static final int HYPHEN=57;       ///< The - key (hyphen)
		public static final int SPACE=58;        ///< The Space key
		public static final int ENTER=59;        ///< The Enter/Return key
		public static final int BACKSPACE=60;    ///< The Backspace key
		public static final int TAB=61;          ///< The Tabulation key
		public static final int PAGE_UP=62;		///< The Page up key
		public static final int PAGE_DOWN=63;     ///< The Page down key
		public static final int END=64;          ///< The End key
		public static final int HOME=65;			///< The Home key
		public static final int INSERT=66;       ///< The Insert key
		public static final int DELETE=67;       ///< The Delete key
		public static final int ADD=68;          ///< The + key
		public static final int SUBTRACT=69;     ///< The - key (minus, usually from numpad)
		public static final int MULTIPLY=70;     ///< The * key
		public static final int DIVIDE=71;       ///< The / key
		public static final int LEFT=72;         ///< Left arrow
		public static final int RIGHT=73;		///< Right arrow
		public static final int UP=74;           ///< Up arrow
		public static final int DOWN=75;         ///< Down arrow
		public static final int NUMPAD_0=76;      ///< The numpad 0 key
	    public static final int NUMPAD_1=77;      ///< The numpad 1 key
	    public static final int NUMPAD_2=78;      ///< The numpad 2 key
	    public static final int NUMPAD_3=79;      ///< The numpad 3 key
	    public static final int NUMPAD_4=80;      ///< The numpad 4 key
	    public static final int NUMPAD_5=81;      ///< The numpad 5 key
	    public static final int NUMPAD_6=82;      ///< The numpad 6 key
	    public static final int NUMPAD_7=83;      ///< The numpad 7 key
	    public static final int NUMPAD_8=84;      ///< The numpad 8 key
	    public static final int NUMPAD_9=85;      ///< The numpad 9 key
	    public static final int F1=86;           ///< The F1 key
	    public static final int F2=87;           ///< The F2 key
	    public static final int F3=88;           ///< The F3 key
	    public static final int F4=89;           ///< The F4 key
	    public static final int F5=90;           ///< The F5 key
	    public static final int F6=91;           ///< The F6 key
	    public static final int F7=92;           ///< The F7 key
	    public static final int F8=93;           ///< The F8 key
	    public static final int F9=94;           ///< The F8 key
	    public static final int F10=95;          ///< The F10 key
	    public static final int F11=96;          ///< The F11 key
	    public static final int F12=97;          ///< The F12 key
	    public static final int F13=98;          ///< The F13 key
	    public static final int F14=99;          ///< The F14 key
	    public static final int F15=100;          ///< The F15 key
	    public static final int PAUSE=101;        ///< The Pause key
	}
	
	public static boolean isKeyPressed(KeyCode key) {
		
		return false;
	}
	
	public static void setVirtualKeyboardVisible(boolean visible) {
		
	}
}