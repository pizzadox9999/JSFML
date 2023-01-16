package org.jsfml.window;

import java.nio.IntBuffer;

import org.jsfml.internal.IntercomHelper;
import org.jsfml.internal.SFMLNativeObject;
import org.jsfml.internal.wrapper.CsfmlWindowLibrary;

/**
 * Holds a valid OpenGL drawing context.
 * <p/>
 * For every OpenGL call, a valid context is required. Using this class, by creating
 * an instance, you can obtain a valid context.
 * <p/>
 * This is only required if you do not have an active window that provides an OpenGL context.
 */
public final class Context extends SFMLNativeObject {
    private static final ThreadLocal<Context> threadContext = new ThreadLocal<>();

    /**
     * Creates and activates a valid OpenGL context on the current thread.
     * <p/>
     * If there already is a context in the current thread,
     * it will simply be activated.
     *
     * @return the activated OpenGL context.
     */
    public static Context getContext() {
        Context context = threadContext.get();
        if (context != null) {
            try {
                context.setActive(true);
            } catch (ContextActivationException ex) {
                //
            }
        } else {
            context = new Context();
            threadContext.set(context);
        }

        return context;
    }

    private Context() {
    	super();
    }

    /**
     * Explictly activates or deactivates the OpenGL context.
     *
     * @param active {@code true} to activate, {@code false} to deactivate.
     * @throws ContextActivationException if activating or deactivating the context failed.
     */
    public void setActive(boolean active) throws ContextActivationException {
        boolean success=convertIntegerToBoolean(getLibrary().sfContext_setActive(getPointer(), convertBooleanToInteger(active)));
    	if (!success) {
            throw new ContextActivationException("Failed to " +
                    (active ? "activate" : "deactivate") +
                    " the context.");
        }
    }
    
    public ContextSettings getSettings() {
    	return getLibrary().sfContext_getSettings(getPointer());
    	/*IntBuffer contextSettingsBuffer=(IntBuffer) getLibrary().sfContext_getSettings(getPointer());
    	return IntercomHelper.decodeContextSettings(contextSettingsBuffer);*/
    }
    
    public int getActiveContextId() {
    	return getLibrary().sfContext_getActiveContextId();
    }
    
	@Override
	protected long createNativeObject() {
		return getLibrary().sfContext_create();
	}

	@Override
	protected void deleteNativeObject() {
		getLibrary().sfContext_destroy(getPointer());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CsfmlWindowLibrary getLibrary() {
		return m_csfmLibrary;
	}

	@Override
	protected boolean createLater() {
		return false;
	}
}
