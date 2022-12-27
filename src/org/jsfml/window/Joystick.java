package org.jsfml.window;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public abstract class Joystick {
	public class JoystickIdentification extends Struct {
		public String name;
	    public int vendorId;
	    public int productId;
	    
		public JoystickIdentification(Runtime runtime) {
			super(runtime);
		}
	}
	
	public enum JoystickAxis {
		sfJoystickX,    ///< The X axis
		sfJoystickY,    ///< The Y axis
		sfJoystickZ,    ///< The Z axis
		sfJoystickR,    ///< The R axis
		sfJoystickU,    ///< The U axis
		sfJoystickV,    ///< The V axis
		sfJoystickPovX, ///< The X axis of the point-of-view hat
		sfJoystickPovY  ///< The Y axis of the point-of-view hat
	}
	
	public static final int sfJoystickCount=8;
	public static final int sfJoystickButtonCount=32;
	public static final int sfJoystickAxisCount=8;
	
	public static boolean isConnected(int joystick) {
		
		return false;
	}
	
	public static int getButtonCount(int joystick) {
		return 0;
	}
	
	public static boolean hasAxis(int joystick, JoystickAxis axis) {
		return false;
	}
	
	public static boolean isButtonPressed(int joystick, int button) {
		
		return false;
	}
	
	public static float getAxisPosition(int joystick, JoystickAxis axis) {
		
		return 0;
	}
	
	public static JoystickIdentification sfJoystick_getIdentification(int joystick) {
		
		return null;
	}
}