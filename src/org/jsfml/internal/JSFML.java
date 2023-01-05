package org.jsfml.internal;

import java.util.HashMap;
import java.util.Map;

import jnr.ffi.LibraryLoader;
import jnr.ffi.LibraryOption;
import jnr.ffi.Runtime;

public final class JSFML {
	private static boolean m_isLoaded=false;
	
	private static CsfmlWindowLibrary m_csfmlWindowLib; 
	private static CsfmlSystemLibrary m_csfmlSystemLib;
	private static CsfmlGraphicsLibrary m_csfmlGraphicsLib;
	private static CsfmlLibrary m_csfmlLib;
	
	private static String m_libDir="./lib/";
	private static String m_csfmlWindowLibName="csfml-window-2.dll";
	private static String m_csfmlSystemLibName="csfml-system-2.dll";
	private static String m_csfmlGraphicsLibName="csfml-graphics-2.dll";
	
	
	private JSFML() {}
	
	public static void init() {
		if(m_isLoaded) {
			return;
		} else {
			m_isLoaded=true;
		}
		//load
		Map<LibraryOption, Object> libraryOptions = new HashMap<>();
        libraryOptions.put(LibraryOption.LoadNow, true); // load immediately instead of lazily (ie on first use)
        libraryOptions.put(LibraryOption.IgnoreError, true); // calls shouldn't save last errno after call
		
        m_csfmlLib=LibraryLoader.loadLibrary(
                CsfmlLibrary.class,
                libraryOptions,
                m_libDir+m_csfmlSystemLibName,
                m_libDir+m_csfmlWindowLibName,
                m_libDir+m_csfmlGraphicsLibName
        );
        
		m_csfmlWindowLib=m_csfmlLib;
		m_csfmlSystemLib=m_csfmlLib;
		m_csfmlGraphicsLib=m_csfmlLib;
	}
	
	public static CsfmlWindowLibrary getCsfmlWindowLibrary() {
		return m_csfmlWindowLib;
	}
	
	public static Runtime getCsfmlWindowRuntime() {
		return getRuntimeFor(m_csfmlSystemLib);
	}
	
	public static CsfmlSystemLibrary getCsfmlSystemLib() {
		return m_csfmlSystemLib;
	}
	
	public static Runtime getCsfmlSystemRuntime() {
		return getRuntimeFor(m_csfmlSystemLib);
	}
	
	public static CsfmlGraphicsLibrary getCsfmlGraphicsLibrary() {
		return m_csfmlGraphicsLib;
	}
	
	public static Runtime getCsfmlGraphicsRuntime() {
		return getRuntimeFor(m_csfmlGraphicsLib);
	}
	
	public static CsfmlLibrary getCsfmlLibrary() {
		return m_csfmlLib;
	}
	
	public static Runtime getCsfmlRuntime() {
		return getRuntimeFor(m_csfmlLib);
	}
	
	private static Runtime getRuntimeFor(Object library) {
		return Runtime.getRuntime(library);
	}
}