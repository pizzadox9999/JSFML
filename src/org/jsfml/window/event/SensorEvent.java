package org.jsfml.window.event;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class SensorEvent extends Struct {
	public Signed32 type=new Signed32();
	public Signed32 sensorType=new Signed32();
	public Signed64 x=new Signed64();
	public Signed64 y=new Signed64();
	public Signed64 z=new Signed64();
	
	public SensorEvent() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public SensorEvent(Runtime runtime) {
		super(runtime);
	}
}