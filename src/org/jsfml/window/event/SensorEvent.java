package org.jsfml.window.event;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class SensorEvent extends Struct {
	public Signed32 eventType=new Signed32();
	public Signed32 sensorType=new Signed32();
	public float        x;
	public float        y;
	public float        z;
	
	public SensorEvent() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public SensorEvent(Runtime runtime) {
		super(runtime);
	}
}