package org.jsfml.window;

import org.jsfml.system.Vector3f;

public abstract class Sensor {
	public class SensorType {
	    public static final int ACCELEROMETER=0; ///< Measures the raw acceleration (m/s^2)
	    public static final int GYROSCOPE=1;        ///< Measures the raw rotation rates (degrees/s)
	    public static final int MAGNETOMETER=2;     ///< Measures the ambient magnetic field (micro-teslas)
	    public static final int GRAVITY=3;          ///< Measures the direction and intensity of gravity, independent of device acceleration (m/s^2)
	    public static final int ACCELERATION=4; ///< Measures the direction and intensity of device acceleration, independent of the gravity (m/s^2)
	    public static final int ORIENTATION=5;      ///< Measures the absolute 3D orientation (degrees)
	    
	    public static final int SENSOR_COUNT=6;             ///< Keep last -- the total number of sensor types
	}
	
	public static boolean isAvailable(SensorType sensor) {
		return false;
	}

	public void setEnabled(SensorType sensor, boolean enabled) {
		
	}

	public Vector3f getValue(SensorType sensor) {
		
		return null;
	}

}