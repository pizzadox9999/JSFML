package org.jsfml.internal;

import org.jsfml.internal.wrapper.CsfmlLibrary;

import jnr.ffi.Runtime;

/**
 * Abstract base class for CSFML classes.
 */
public abstract class SFMLNativeObject {
    /**
     * Pointer to the underlying SFML object.
     */
    private long m_pointer = 0;
    
    private Runtime m_runtime;
    
    private boolean m_createLater=false;
    
    protected CsfmlLibrary m_csfmLibrary;
    
    protected SFMLNativeObject() {
    	if(!createLater()) {
    		setPointer(createNativeObject());
    	} else {
			m_createLater=true;
		}
    	init();
    }
    
    protected SFMLNativeObject(long pointer) {
    	setPointer(pointer);
    	init();
    }
    
    private void init() {
    	m_csfmLibrary=SFMLNative.getCsfmlLibrary();
    }
    
    protected void createLater(long pointer) {
    	if(m_createLater) {
    		setPointer(pointer);
    		m_createLater=false;
    	}
    }
    
    private void setPointer(long pointer) {
    	m_pointer=pointer;
    }
    
    protected abstract long createNativeObject();
    
    protected abstract void deleteNativeObject();
    
    protected abstract boolean createLater();
    
    protected abstract <T> T getLibrary();
    
    protected long getPointer() {
    	return m_pointer;
    }
    
    protected boolean isCreated() {
    	return m_pointer!=0;
    }
    
    /*protected void setPointer(long pointer) {
    	m_pointer=pointer;
    }*/
    
    @Override
    protected void finalize() throws Throwable {
    	super.finalize();
    	deleteNativeObject();
    }
    
    /**
     * ZERO is FALSE otherwise TRUE
     * @param IntegerAsBoolean
     * @return
     */
    public static boolean convertIntegerToBoolean(int integerAsBoolean) {
    	return integerAsBoolean!=0;
    }
    
    public static int convertBooleanToInteger(boolean booleanAsInteger) {
    	return booleanAsInteger?1 : 0;
    }
}