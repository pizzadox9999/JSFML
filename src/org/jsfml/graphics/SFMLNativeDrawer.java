package org.jsfml.graphics;

import org.jsfml.internal.IntercomHelper;

import java.nio.*;

/**
 * Provides generic implementations of the {@code draw} methods for
 * native SFML drawables and vertices.
 */
final class SFMLNativeDrawer {
    private static final int NATIVE_VERTEX_SIZE = 20;

    private static final ThreadLocal<ByteBuffer> vertexBuffer = new ThreadLocal<ByteBuffer>();

    static {
        ensureBuffer(1024);
    }

    private static ByteBuffer ensureBuffer(int numVertices) {
        ByteBuffer buffer = vertexBuffer.get();
        if (buffer == null || (buffer.capacity() / NATIVE_VERTEX_SIZE) < numVertices) {
            buffer = ByteBuffer.allocateDirect(numVertices * NATIVE_VERTEX_SIZE).order(ByteOrder.nativeOrder());
            vertexBuffer.set(buffer);
        }

        return buffer;
    }

    private static native void nativeDrawVertices(
            int num,
            Buffer vbuf,
            int type,
            RenderTarget target,
            Buffer xformAndBlendMode,
            ConstTexture texture,
            ConstShader shader);

    static void drawVertices(Vertex[] vertices, PrimitiveType type, RenderTarget target, RenderStates states) {
        final ByteBuffer vbuf = ensureBuffer(vertices.length);
        final FloatBuffer vfloats = vbuf.asFloatBuffer();
        final IntBuffer vints = vbuf.asIntBuffer();

        final int sz = NATIVE_VERTEX_SIZE / 4;
        for (int i = 0; i < vertices.length; i++) {
            final Vertex v = vertices[i];
            final int x = i * sz;

            //keep away from children!
            vfloats.put(x, v.position.x);
            vfloats.put(x + 1, v.position.y);
            vints.put(x + 2, IntercomHelper.encodeColor(v.color));
            vfloats.put(x + 3, v.texCoords.x);
            vfloats.put(x + 4, v.texCoords.y);
        }

        nativeDrawVertices(
                vertices.length,
                vbuf,
                type.ordinal(),
                target,
                IntercomHelper.encodeTransformAndBlendMode(states.transform, states.blendMode),
                states.texture,
                states.shader);
    }

    private static native void nativeDrawDrawable(
            Drawable drawable,
            RenderTarget target,
            Buffer xformAndBlendMode,
            ConstTexture texture,
            ConstShader shader);

    static void draw(Drawable drawable, RenderTarget target, RenderStates states) {
        nativeDrawDrawable(
                drawable,
                target,
                IntercomHelper.encodeTransformAndBlendMode(states.transform, states.blendMode),
                states.texture,
                states.shader);
    }
}
