package org.jsfml.window.event;

public class KeyEvent extends Event {
	public int code=0;
	public boolean alt=false;
	public boolean control=false;
	public boolean shift=false;
	public boolean system=false;
	
	public KeyEvent(int type, int code, boolean alt, boolean control, boolean shift, boolean system) {
		super(type);
		this.code=code;
		this.alt=alt;
		this.control=control;
		this.shift=shift;
		this.system=system;
	}
	
	@Override
	public KeyEvent asKeyEvent() {
		return this;
	}
	
	public String toString() {
		return "TYPE: "+type+" CODE: "+code+" ALT: "+alt+" CONTROL: "+control+" SHIFT: "+shift+" SYSTEM: "+system;
	}
}