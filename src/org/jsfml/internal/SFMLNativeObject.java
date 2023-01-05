package org.jsfml.internal;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public abstract class SFMLNativeObject extends Struct {
	protected CsfmlLibrary m_csfmlLibrary;
	protected jnr.ffi.Pointer m_nativePointer;
	
	public SFMLNativeObject() {
		this(JSFML.getCsfmlRuntime());
		m_csfmlLibrary=JSFML.getCsfmlLibrary();
	}
	
	public SFMLNativeObject(Runtime runtime) {
		super(runtime);
	}
	
	protected jnr.ffi.Pointer getPointer() {
		return m_nativePointer;
	}
}