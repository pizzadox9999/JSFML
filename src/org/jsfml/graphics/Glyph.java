package org.jsfml.graphics;

import org.jsfml.JSFML;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Glyph extends Struct{
	
	float     advance=0;     ///< Offset to move horizontically to the next character
    FloatRect bounds=null;      ///< Bounding rectangle of the glyph, in coordinates relative to the baseline
    IntRect   textureRect=null; ///< Texture coordinates of the glyph inside the font's image
	
	public Glyph() {
		this(JSFML.getCsfmlRuntime());
	}
	
	public Glyph(Runtime runtime) {
		super(runtime);
	}
}
