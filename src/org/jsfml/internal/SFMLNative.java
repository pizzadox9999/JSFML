package org.jsfml.internal;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.jsfml.internal.wrapper.CsfmlGraphicsLibrary;
import org.jsfml.internal.wrapper.CsfmlLibrary;
import org.jsfml.internal.wrapper.CsfmlSystemLibrary;
import org.jsfml.internal.wrapper.CsfmlWindowLibrary;

import jnr.ffi.LibraryLoader;
import jnr.ffi.LibraryOption;

/**
 * Native library loader.
 * <p/>
 * This class contains the "self-containedness" functionality of JSFML.
 *
 * @see #loadNativeLibraries() for more information.
 */
public final class SFMLNative {
    private static final Path JSFML_USER_HOME = Paths.get(System.getProperty("user.home"), ".jsfml");

    private static final String JSFML_BIN_RESOURCE_PATH = "/bin/";

    private static final String MD5_EXT = ".MD5";
    private static final int MD5_LENGTH = 32;

    /**
     * The substring of the {@code os.name} system property
     * to look for to detect Windows systems.
     */
    public static final String OS_NAME_WINDOWS = "Windows";

    /**
     * The substring of the {@code os.name} system property
     * to look for to detect Linux systems.
     */
    public static final String OS_NAME_LINUX = "Linux";

    /**
     * The substring of the {@code os.name} system property
     * to look for to detect Mac OS X systems.
     */
    public static final String OS_NAME_MACOSX = "Mac OS X";
    
    private static boolean m_isLoaded=false;
	
	private static CsfmlWindowLibrary m_csfmlWindowLibrary; 
	private static CsfmlSystemLibrary m_csfmlSystemLibrary;
	private static CsfmlGraphicsLibrary m_csfmlGraphicsLibrary;
	private static CsfmlLibrary m_csfmlLibrary;
	
	private static String m_windowsLibraryDir="./lib/";
	private static String m_windowsCsfmlSystemLibraryName="csfml-system-2.dll";
	private static String m_windowsCsfmlWindowLibraryName="csfml-window-2.dll";
	private static String m_windowsCsfmlGraphicsLibraryName="csfml-graphics-2.dll";
	
	private static String m_linuxLibraryDir="";
	private static String m_linuxCsfmlSystemLibraryName="csfml-system-2.dll";
	private static String m_linuxCsfmlWindowLibraryName="csfml-window-2.dll";
	private static String m_linuxCsfmlGraphicsLibraryName="csfml-graphics-2.dll";
	
	
	
	public static void loadNativeLibraries() {
		if(m_isLoaded) {
			return;
		} else {
			m_isLoaded=true;
		}
		
		loadLibrary();
        
		m_csfmlWindowLibrary=m_csfmlLibrary;
		m_csfmlSystemLibrary=m_csfmlLibrary;
		m_csfmlGraphicsLibrary=m_csfmlLibrary;
	}
	
	private static void loadLibrary() {
		final String osName = System.getProperty("os.name");
        //final String osArch = System.getProperty("os.arch");
		//load
		Map<LibraryOption, Object> libraryOptions = new HashMap<>();
        libraryOptions.put(LibraryOption.LoadNow, true); // load immediately instead of lazily (ie on first use)
        libraryOptions.put(LibraryOption.IgnoreError, true); // calls shouldn't save last errno after call
		
        if(osName.contains(OS_NAME_WINDOWS)) {
        	loadLibraryWindows(libraryOptions);
        }
        
        if(osName.contains(OS_NAME_LINUX)) {
        	loadLibraryLinux(libraryOptions);
        }
	}
	
	private static void loadLibraryWindows(Map<LibraryOption, Object> libraryOptions) {
		m_csfmlLibrary=LibraryLoader.loadLibrary(
                CsfmlLibrary.class,
                libraryOptions,
                m_windowsLibraryDir+m_windowsCsfmlSystemLibraryName,
                m_windowsLibraryDir+m_windowsCsfmlWindowLibraryName,
                m_windowsLibraryDir+m_windowsCsfmlGraphicsLibraryName
        );
	}
	
	private static void loadLibraryLinux(Map<LibraryOption, Object> libraryOptions) {
		m_csfmlLibrary=LibraryLoader.loadLibrary(
                CsfmlLibrary.class,
                libraryOptions,
                m_linuxLibraryDir+m_linuxCsfmlSystemLibraryName,
                m_linuxLibraryDir+m_linuxCsfmlWindowLibraryName,
                m_linuxLibraryDir+m_linuxCsfmlGraphicsLibraryName
        );
	}
	
	public static CsfmlWindowLibrary getCsfmlWindowLibrary() {
		return m_csfmlWindowLibrary;
	}
	
	public static jnr.ffi.Runtime getCsfmlWindowRuntime() {
		return getRuntimeFor(m_csfmlWindowLibrary);
	}
	
	public static CsfmlSystemLibrary getCsfmlSystemLibrary() {
		return m_csfmlSystemLibrary;
	}
	
	public static jnr.ffi.Runtime getCsfmlSystemRuntime() {
		return getRuntimeFor(m_csfmlSystemLibrary);
	}
	
	public static CsfmlGraphicsLibrary getCsfmlGraphicsLibrary() {
		return m_csfmlGraphicsLibrary;
	}
	
	public static jnr.ffi.Runtime getCsfmlGraphicsRuntime() {
		return getRuntimeFor(m_csfmlGraphicsLibrary);
	}
	
	public static CsfmlLibrary getCsfmlLibrary() {
		return m_csfmlLibrary;
	}
	
	public static jnr.ffi.Runtime getCsfmlRuntime() {
		return getRuntimeFor(m_csfmlLibrary);
	}
	
	private static jnr.ffi.Runtime getRuntimeFor(Object library) {
		return jnr.ffi.Runtime.getRuntime(library);
	}

    /**
     * Ensures that a display is available on this system.
     * <p/>
     * If that is not the case, a {@link HeadlessException} is thrown to indicate that the desired
     * JSFML feature is not available.
     */
    public static void ensureDisplay() {
        if (GraphicsEnvironment.isHeadless())
            throw new HeadlessException("This JSFML feature is not available in a headless environment");
    }

    private SFMLNative() {
        //disallow instantiation
    }
}
