package org.jsfml.graphics;

import org.jsfml.internal.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class FontInfo extends Struct {
	public String family;
	
	public FontInfo() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public FontInfo(Runtime runtime) {
		super(runtime);
	}	
}