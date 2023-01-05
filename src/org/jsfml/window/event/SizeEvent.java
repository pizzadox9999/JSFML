package org.jsfml.window.event;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class SizeEvent extends Struct {
	public Signed32 type=new Signed32();
	public Signed32 width=new Signed32();
    public Signed32 height=new Signed32();
    
    public SizeEvent() {
    	this(JSFML.getCsfmlRuntime());
    }
    
	public SizeEvent(Runtime runtime) {
		super(runtime);
	}
}