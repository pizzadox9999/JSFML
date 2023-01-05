////////////////////////////////////////////////////////////
//
// SFML - Simple and Fast Multimedia Library
// Copyright (C) 2007-2018 Laurent Gomila (laurent@sfml-dev.org)
//
// This software is provided 'as-is', without any express or implied warranty.
// In no event will the authors be held liable for any damages arising from the use of this software.
//
// Permission is granted to anyone to use this software for any purpose,
// including commercial applications, and to alter it and redistribute it freely,
// subject to the following restrictions:
//
// 1. The origin of this software must not be misrepresented;
//    you must not claim that you wrote the original software.
//    If you use this software in a product, an acknowledgment
//    in the product documentation would be appreciated but is not required.
//
// 2. Altered source versions must be plainly marked as such,
//    and must not be misrepresented as being the original software.
//
// 3. This notice may not be removed or altered from any source distribution.
//
////////////////////////////////////////////////////////////

package org.jsfml.internal;

import java.nio.Buffer;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.FontInfo;
import org.jsfml.graphics.GlslBvec2;
import org.jsfml.graphics.GlslBvec3;
import org.jsfml.graphics.GlslBvec4;
import org.jsfml.graphics.GlslIvec3;
import org.jsfml.graphics.GlslIvec4;
import org.jsfml.graphics.GlslVec4;
import org.jsfml.graphics.Glyph;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Vertex.PrimitiveType;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Transform;
import org.jsfml.graphics.Vertex;
import org.jsfml.graphics.Vertex.VertexBufferUsage;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.system.Vector2u;
import org.jsfml.system.Vector3f;
import org.jsfml.window.ContextSettings;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

import jnr.ffi.Pointer;/*✓*/
import jnr.ffi.annotations.In;
import jnr.ffi.annotations.Out;

/*
public interface CsfmlGraphicsLibrary {
	//RenderWindow Api
	public Pointer sfRenderWindow_create(VideoMode mode, String title, int style, ContextSettings settings);
	public void sfRenderWindow_destroy(Pointer renderWindow);
	public void sfRenderWindow_close(Pointer renderWindow);
	public int sfRenderWindow_isOpen(Pointer renderWindow);
	public ContextSettings sfRenderWindow_getSettings(Pointer renderWindow);
	public int sfRenderWindow_pollEvent(Pointer renderWindow, Pointer event);
	public int sfRenderWindow_waitEvent(Pointer renderWindow, Pointer event);
	public Vector2i sfRenderWindow_getPosition(Pointer renderWindow);
	public void sfRenderWindow_setPosition(Pointer renderWindow, Vector2i position);
	public Vector2u sfRenderWindow_getSize(Pointer renderWindow);
	public void sfRenderWindow_setSize(Pointer renderWindow, Vector2u size);
	public void sfRenderWindow_setTitle(Pointer renderWindow, String title);
}*/

public interface CsfmlGraphicsLibrary {
	// BlendMode.h

	/**
	 * Headers
	*/

	/**
	 * @brief Enumeration of the blending factors
	 *
	*/

	/**
	 * @brief Enumeration of the blending equations
	 *
	*/

	/**
	 * @brief Blending mode for drawing
	 *
	*/

	// CircleShape.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a new circle shape
	 *
	 * @return A new sfCircleShape object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfCircleShape*)*/ sfCircleShape_create();

	/**
	 * @brief Copy an existing circle shape
	 *
	 * @param shape Shape to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfCircleShape*)*/ sfCircleShape_copy(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Destroy an existing circle Shape
	 *
	 * @param shape Shape to delete
	 *
	*/
	public void sfCircleShape_destroy(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Set the position of a circle shape
	 *
	 * This function completely overwrites the previous position.
	 * See sfCircleShape_move to apply an offset based on the previous position instead.
	 * The default position of a circle Shape object is (0, 0).
	 *
	 * @param shape    Shape object
	 * @param position New position
	 *
	*/
	public void sfCircleShape_setPosition(Pointer/*(sfCircleShape*)*/ shape,  Vector2f position);

	/**
	 * @brief Set the orientation of a circle shape
	 *
	 * This function completely overwrites the previous rotation.
	 * See sfCircleShape_rotate to add an angle based on the previous rotation instead.
	 * The default rotation of a circle Shape object is 0.
	 *
	 * @param shape Shape object
	 * @param angle New rotation, in degrees
	 *
	*/
	public void sfCircleShape_setRotation(Pointer/*(sfCircleShape*)*/ shape,  float angle);

	/**
	 * @brief Set the scale factors of a circle shape
	 *
	 * This function completely overwrites the previous scale.
	 * See sfCircleShape_scale to add a factor based on the previous scale instead.
	 * The default scale of a circle Shape object is (1, 1).
	 *
	 * @param shape Shape object
	 * @param scale New scale factors
	 *
	*/
	public void sfCircleShape_setScale(Pointer/*(sfCircleShape*)*/ shape,  Vector2f scale);

	/**
	 * @brief Set the local origin of a circle shape
	 *
	 * The origin of an object defines the center point for
	 * all transformations (position, scale, rotation).
	 * The coordinates of this point must be relative to the
	 * top-left corner of the object, and ignore all
	 * transformations (position, scale, rotation).
	 * The default origin of a circle Shape object is (0, 0).
	 *
	 * @param shape  Shape object
	 * @param origin New origin
	 *
	*/
	public void sfCircleShape_setOrigin(Pointer/*(sfCircleShape*)*/ shape,  Vector2f origin);

	/**
	 * @brief Get the position of a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current position
	 *
	*/
	public Vector2f sfCircleShape_getPosition(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the orientation of a circle shape
	 *
	 * The rotation is always in the range [0, 360].
	 *
	 * @param shape Shape object
	 *
	 * @return Current rotation, in degrees
	 *
	*/
	public float sfCircleShape_getRotation(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the current scale of a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current scale factors
	 *
	*/
	public Vector2f sfCircleShape_getScale(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the local origin of a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current origin
	 *
	*/
	public Vector2f sfCircleShape_getOrigin(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Move a circle shape by a given offset
	 *
	 * This function adds to the current position of the object,
	 * unlike sfCircleShape_setPosition which overwrites it.
	 *
	 * @param shape  Shape object
	 * @param offset Offset
	 *
	*/
	public void sfCircleShape_move(Pointer/*(sfCircleShape*)*/ shape,  Vector2f offset);

	/**
	 * @brief Rotate a circle shape
	 *
	 * This function adds to the current rotation of the object,
	 * unlike sfCircleShape_setRotation which overwrites it.
	 *
	 * @param shape Shape object
	 * @param angle Angle of rotation, in degrees
	 *
	*/
	public void sfCircleShape_rotate(Pointer/*(sfCircleShape*)*/ shape,  float angle);

	/**
	 * @brief Scale a circle shape
	 *
	 * This function multiplies the current scale of the object,
	 * unlike sfCircleShape_setScale which overwrites it.
	 *
	 * @param shape   Shape object
	 * @param factors Scale factors
	 *
	*/
	public void sfCircleShape_scale(Pointer/*(sfCircleShape*)*/ shape,  Vector2f factors);

	/**
	 * @brief Get the combined transform of a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Transform combining the positionrotationscaleorigin of the object
	 *
	*/
	public Transform sfCircleShape_getTransform(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the inverse of the combined transform of a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Inverse of the combined transformations applied to the object
	 *
	*/
	public Transform sfCircleShape_getInverseTransform(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Change the source texture of a circle shape
	 *
	 * The @a texture argument refers to a texture that must
	 * exist as long as the shape uses it. Indeed, the shape
	 * doesn't store its own copy of the texture, but rather keeps
	 * a pointer to the one that you passed to this function.
	 * If the source texture is destroyed and the shape tries to
	 * use it, the behaviour is undefined.
	 * @a texture can be NULL to disable texturing.
	 * If @a resetRect is true, the TextureRect property of
	 * the shape is automatically adjusted to the size of the new
	 * texture. If it is false, the texture rect is left unchanged.
	 *
	 * @param shape     Shape object
	 * @param texture   New texture
	 * @param resetRect Should the texture rect be reset to the size of the new texture?
	 *
	*/
	public void sfCircleShape_setTexture(Pointer/*(sfCircleShape*)*/ shape, Pointer/*(  sfTexture*)*/ texture,  int resetRect);

	/**
	 * @brief Set the sub-rectangle of the texture that a circle shape will display
	 *
	 * The texture rect is useful when you don't want to display
	 * the whole texture, but rather a part of it.
	 * By default, the texture rect covers the entire texture.
	 *
	 * @param shape Shape object
	 * @param rect  Rectangle defining the region of the texture to display
	 *
	*/
	public void sfCircleShape_setTextureRect(Pointer/*(sfCircleShape*)*/ shape,  IntRect rect);

	/**
	 * @brief Set the fill color of a circle shape
	 *
	 * This color is modulated (multiplied) with the shape's
	 * texture if any. It can be used to colorize the shape,
	 * or change its global opacity.
	 * You can use sfTransparent to make the inside of
	 * the shape transparent, and have the outline alone.
	 * By default, the shape's fill color is opaque white.
	 *
	 * @param shape Shape object
	 * @param color New color of the shape
	 *
	*/
	public void sfCircleShape_setFillColor(Pointer/*(sfCircleShape*)*/ shape,  Color color);

	/**
	 * @brief Set the outline color of a circle shape
	 *
	 * You can use sfTransparent to disable the outline.
	 * By default, the shape's outline color is opaque white.
	 *
	 * @param shape Shape object
	 * @param color New outline color of the shape
	 *
	*/
	public void sfCircleShape_setOutlineColor(Pointer/*(sfCircleShape*)*/ shape,  Color color);

	/**
	 * @brief Set the thickness of a circle shape's outline
	 *
	 * This number cannot be negative. Using zero disables
	 * the outline.
	 * By default, the outline thickness is 0.
	 *
	 * @param shape     Shape object
	 * @param thickness New outline thickness
	 *
	*/
	public void sfCircleShape_setOutlineThickness(Pointer/*(sfCircleShape*)*/ shape,  float thickness);

	/**
	 * @brief Get the source texture of a circle shape
	 *
	 * If the shape has no source texture, a NULL pointer is returned.
	 * The returned pointer is const, which means that you can't
	 * modify the texture when you retrieve it with this function.
	 *
	 * @param shape Shape object
	 *
	 * @return Pointer to the shape's texture
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfCircleShape_getTexture(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the sub-rectangle of the texture displayed by a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Texture rectangle of the shape
	 *
	*/
	public IntRect sfCircleShape_getTextureRect(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the fill color of a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Fill color of the shape
	 *
	*/
	public Color sfCircleShape_getFillColor(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the outline color of a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Outline color of the shape
	 *
	*/
	public Color sfCircleShape_getOutlineColor(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the outline thickness of a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Outline thickness of the shape
	 *
	*/
	public float sfCircleShape_getOutlineThickness(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the total number of points of a circle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Number of points of the shape
	 *
	*/
	public int sfCircleShape_getPointCount(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get a point of a circle shape
	 *
	 * The result is undefined if @a index is out of the valid range.
	 *
	 * @param shape Shape object
	 * @param index Index of the point to get, in range [0 .. getPointCount() - 1]
	 *
	 * @return Index-th point of the shape
	 *
	*/
	public Vector2f sfCircleShape_getPoint(Pointer/*(sfCircleShape*)*/ shape,  int index);

	/**
	 * @brief Set the radius of a circle
	 *
	 * @param shape  Shape object
	 * @param radius New radius of the circle
	 *
	*/
	public void sfCircleShape_setRadius(Pointer/*(sfCircleShape*)*/ shape,  float radius);

	/**
	 * @brief Get the radius of a circle
	 *
	 * @param shape Shape object
	 *
	 * @return Radius of the circle
	 *
	*/
	public float sfCircleShape_getRadius(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Set the number of points of a circle
	 *
	 * @param shape Shape object
	 * @param count New number of points of the circle
	 *
	*/
	public void sfCircleShape_setPointCount(Pointer/*(sfCircleShape*)*/ shape,  int count);

	/**
	 * @brief Get the local bounding rectangle of a circle shape
	 *
	 * The returned rectangle is in local coordinates, which means
	 * that it ignores the transformations (translation, rotation,
	 * scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * entity in the entity's coordinate system.
	 *
	 * @param shape Shape object
	 *
	 * @return Local bounding rectangle of the entity
	 *
	*/
	public FloatRect sfCircleShape_getLocalBounds(Pointer/*(sfCircleShape*)*/ shape);

	/**
	 * @brief Get the global bounding rectangle of a circle shape
	 *
	 * The returned rectangle is in global coordinates, which means
	 * that it takes in account the transformations (translation,
	 * rotation, scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * sprite in the global 2D world's coordinate system.
	 *
	 * @param shape Shape object
	 *
	 * @return Global bounding rectangle of the entity
	 *
	*/
	public FloatRect sfCircleShape_getGlobalBounds(Pointer/*(sfCircleShape*)*/ shape);

	// Color.h

	/**
	 * Headers
	*/

	/**
	 * @brief Utility class for manpulating RGBA colors
	 *
	*/

	/**
	 * @brief Construct a color from its 3 RGB components
	 *
	 * @param red   Red component   (0 .. 255)
	 * @param green Green component (0 .. 255)
	 * @param blue  Blue component  (0 .. 255)
	 *
	 * @return sfColor constructed from the components
	 *
	*/
	public Color sfColor_fromRGB(int red,  int green,  int blue);

	/**
	 * @brief Construct a color from its 4 RGBA components
	 *
	 * @param red   Red component   (0 .. 255)
	 * @param green Green component (0 .. 255)
	 * @param blue  Blue component  (0 .. 255)
	 * @param alpha Alpha component (0 .. 255)
	 *
	 * @return sfColor constructed from the components
	 *
	*/
	public Color sfColor_fromRGBA(int red,  int green,  int blue,  int alpha);

	/**
	 * @brief Construct the color from 32-bit unsigned integer
	 *
	 * @param color Number containing the RGBA components (in that order)
	 *
	 * @return sfColor constructed from the 32-bit unsigned integer
	 *
	*/
	public Color sfColor_fromInteger(long color);

	/**
	 * @brief Convert a color to a 32-bit unsigned integer
	 *
	 * @return Color represented as a 32-bit unsigned integer
	 *
	*/
	public long sfColor_toInteger(Color color);

	/**
	 * @brief Add two colors
	 *
	 * @param color1 First color
	 * @param color2 Second color
	 *
	 * @return Component-wise saturated addition of the two colors
	 *
	*/
	public Color sfColor_add(Color color1,  Color color2);

	/**
	 * @brief Subtract two colors
	 *
	 * @param color1 First color
	 * @param color2 Second color
	 *
	 * @return Component-wise saturated subtraction of the two colors
	 *
	*/
	public Color sfColor_subtract(Color color1,  Color color2);

	/**
	 * @brief Modulate two colors
	 *
	 * @param color1 First color
	 * @param color2 Second color
	 *
	 * @return Component-wise multiplication of the two colors
	 *
	*/
	public Color sfColor_modulate(Color color1,  Color color2);

	// ConvexShape.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a new convex shape
	 *
	 * @return A new sfConvexShape object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfConvexShape*)*/ sfConvexShape_create();

	/**
	 * @brief Copy an existing convex shape
	 *
	 * @param shape Shape to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfConvexShape*)*/ sfConvexShape_copy(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Destroy an existing convex Shape
	 *
	 * @param shape Shape to delete
	 *
	*/
	public void sfConvexShape_destroy(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Set the position of a convex shape
	 *
	 * This function completely overwrites the previous position.
	 * See sfConvexShape_move to apply an offset based on the previous position instead.
	 * The default position of a circle Shape object is (0, 0).
	 *
	 * @param shape    Shape object
	 * @param position New position
	 *
	*/
	public void sfConvexShape_setPosition(Pointer/*(sfConvexShape*)*/ shape,  Vector2f position);

	/**
	 * @brief Set the orientation of a convex shape
	 *
	 * This function completely overwrites the previous rotation.
	 * See sfConvexShape_rotate to add an angle based on the previous rotation instead.
	 * The default rotation of a circle Shape object is 0.
	 *
	 * @param shape Shape object
	 * @param angle New rotation, in degrees
	 *
	*/
	public void sfConvexShape_setRotation(Pointer/*(sfConvexShape*)*/ shape,  float angle);

	/**
	 * @brief Set the scale factors of a convex shape
	 *
	 * This function completely overwrites the previous scale.
	 * See sfConvexShape_scale to add a factor based on the previous scale instead.
	 * The default scale of a circle Shape object is (1, 1).
	 *
	 * @param shape Shape object
	 * @param scale New scale factors
	 *
	*/
	public void sfConvexShape_setScale(Pointer/*(sfConvexShape*)*/ shape,  Vector2f scale);

	/**
	 * @brief Set the local origin of a convex shape
	 *
	 * The origin of an object defines the center point for
	 * all transformations (position, scale, rotation).
	 * The coordinates of this point must be relative to the
	 * top-left corner of the object, and ignore all
	 * transformations (position, scale, rotation).
	 * The default origin of a circle Shape object is (0, 0).
	 *
	 * @param shape  Shape object
	 * @param origin New origin
	 *
	*/
	public void sfConvexShape_setOrigin(Pointer/*(sfConvexShape*)*/ shape,  Vector2f origin);

	/**
	 * @brief Get the position of a convex shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current position
	 *
	*/
	public Vector2f sfConvexShape_getPosition(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the orientation of a convex shape
	 *
	 * The rotation is always in the range [0, 360].
	 *
	 * @param shape Shape object
	 *
	 * @return Current rotation, in degrees
	 *
	*/
	public float sfConvexShape_getRotation(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the current scale of a convex shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current scale factors
	 *
	*/
	public Vector2f sfConvexShape_getScale(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the local origin of a convex shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current origin
	 *
	*/
	public Vector2f sfConvexShape_getOrigin(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Move a convex shape by a given offset
	 *
	 * This function adds to the current position of the object,
	 * unlike sfConvexShape_setPosition which overwrites it.
	 *
	 * @param shape  Shape object
	 * @param offset Offset
	 *
	*/
	public void sfConvexShape_move(Pointer/*(sfConvexShape*)*/ shape,  Vector2f offset);

	/**
	 * @brief Rotate a convex shape
	 *
	 * This function adds to the current rotation of the object,
	 * unlike sfConvexShape_setRotation which overwrites it.
	 *
	 * @param shape Shape object
	 * @param angle Angle of rotation, in degrees
	 *
	*/
	public void sfConvexShape_rotate(Pointer/*(sfConvexShape*)*/ shape,  float angle);

	/**
	 * @brief Scale a convex shape
	 *
	 * This function multiplies the current scale of the object,
	 * unlike sfConvexShape_setScale which overwrites it.
	 *
	 * @param shape   Shape object
	 * @param factors Scale factors
	 *
	*/
	public void sfConvexShape_scale(Pointer/*(sfConvexShape*)*/ shape,  Vector2f factors);

	/**
	 * @brief Get the combined transform of a convex shape
	 *
	 * @param shape shape object
	 *
	 * @return Transform combining the positionrotationscaleorigin of the object
	 *
	*/
	public Transform sfConvexShape_getTransform(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the inverse of the combined transform of a convex shape
	 *
	 * @param shape shape object
	 *
	 * @return Inverse of the combined transformations applied to the object
	 *
	*/
	public Transform sfConvexShape_getInverseTransform(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Change the source texture of a convex shape
	 *
	 * The @a texture argument refers to a texture that must
	 * exist as long as the shape uses it. Indeed, the shape
	 * doesn't store its own copy of the texture, but rather keeps
	 * a pointer to the one that you passed to this function.
	 * If the source texture is destroyed and the shape tries to
	 * use it, the behaviour is undefined.
	 * @a texture can be NULL to disable texturing.
	 * If @a resetRect is true, the TextureRect property of
	 * the shape is automatically adjusted to the size of the new
	 * texture. If it is false, the texture rect is left unchanged.
	 *
	 * @param shape     Shape object
	 * @param texture   New texture
	 * @param resetRect Should the texture rect be reset to the size of the new texture?
	 *
	*/
	public void sfConvexShape_setTexture(Pointer/*(sfConvexShape*)*/ shape, Pointer/*(  sfTexture*)*/ texture,  int resetRect);

	/**
	 * @brief Set the sub-rectangle of the texture that a convex shape will display
	 *
	 * The texture rect is useful when you don't want to display
	 * the whole texture, but rather a part of it.
	 * By default, the texture rect covers the entire texture.
	 *
	 * @param shape Shape object
	 * @param rect  Rectangle defining the region of the texture to display
	 *
	*/
	public void sfConvexShape_setTextureRect(Pointer/*(sfConvexShape*)*/ shape,  IntRect rect);

	/**
	 * @brief Set the fill color of a convex shape
	 *
	 * This color is modulated (multiplied) with the shape's
	 * texture if any. It can be used to colorize the shape,
	 * or change its global opacity.
	 * You can use sfTransparent to make the inside of
	 * the shape transparent, and have the outline alone.
	 * By default, the shape's fill color is opaque white.
	 *
	 * @param shape Shape object
	 * @param color New color of the shape
	 *
	*/
	public void sfConvexShape_setFillColor(Pointer/*(sfConvexShape*)*/ shape,  Color color);

	/**
	 * @brief Set the outline color of a convex shape
	 *
	 * You can use sfTransparent to disable the outline.
	 * By default, the shape's outline color is opaque white.
	 *
	 * @param shape Shape object
	 * @param color New outline color of the shape
	 *
	*/
	public void sfConvexShape_setOutlineColor(Pointer/*(sfConvexShape*)*/ shape,  Color color);

	/**
	 * @brief Set the thickness of a convex shape's outline
	 *
	 * This number cannot be negative. Using zero disables
	 * the outline.
	 * By default, the outline thickness is 0.
	 *
	 * @param shape     Shape object
	 * @param thickness New outline thickness
	 *
	*/
	public void sfConvexShape_setOutlineThickness(Pointer/*(sfConvexShape*)*/ shape,  float thickness);

	/**
	 * @brief Get the source texture of a convex shape
	 *
	 * If the shape has no source texture, a NULL pointer is returned.
	 * The returned pointer is const, which means that you can't
	 * modify the texture when you retrieve it with this function.
	 *
	 * @param shape Shape object
	 *
	 * @return Pointer to the shape's texture
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfConvexShape_getTexture(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the sub-rectangle of the texture displayed by a convex shape
	 *
	 * @param shape Shape object
	 *
	 * @return Texture rectangle of the shape
	 *
	*/
	public IntRect sfConvexShape_getTextureRect(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the fill color of a convex shape
	 *
	 * @param shape Shape object
	 *
	 * @return Fill color of the shape
	 *
	*/
	public Color sfConvexShape_getFillColor(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the outline color of a convex shape
	 *
	 * @param shape Shape object
	 *
	 * @return Outline color of the shape
	 *
	*/
	public Color sfConvexShape_getOutlineColor(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the outline thickness of a convex shape
	 *
	 * @param shape Shape object
	 *
	 * @return Outline thickness of the shape
	 *
	*/
	public float sfConvexShape_getOutlineThickness(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the total number of points of a convex shape
	 *
	 * @param shape Shape object
	 *
	 * @return Number of points of the shape
	 *
	*/
	public int sfConvexShape_getPointCount(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get a point of a convex shape
	 *
	 * The result is undefined if @a index is out of the valid range.
	 *
	 * @param shape Shape object
	 * @param index Index of the point to get, in range [0 .. getPointCount() - 1]
	 *
	 * @return Index-th point of the shape
	 *
	*/
	public Vector2f sfConvexShape_getPoint(Pointer/*(sfConvexShape*)*/ shape,  int index);

	/**
	 * @brief Set the number of points of a convex shap
	 *
	 * @a count must be greater than 2 to define a valid shape.
	 *
	 * @param shape Shape object
	 * @param count New number of points of the shape
	 *
	*/
	public void sfConvexShape_setPointCount(Pointer/*(sfConvexShape*)*/ shape,  int count);

	/**
	 * @brief Set the position of a point in a convex shape
	 *
	 * Don't forget that the polygon must remain convex, and
	 * the points need to stay ordered!
	 * setPointCount must be called first in order to set the total
	 * number of points. The result is undefined if @a index is out
	 * of the valid range.
	 *
	 * @param shape Shape object
	 * @param index Index of the point to change, in range [0 .. GetPointCount() - 1]
	 * @param point New point
	 *
	*/
	public void sfConvexShape_setPoint(Pointer/*(sfConvexShape*)*/ shape,  int index,  Vector2f point);

	/**
	 * @brief Get the local bounding rectangle of a convex shape
	 *
	 * The returned rectangle is in local coordinates, which means
	 * that it ignores the transformations (translation, rotation,
	 * scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * entity in the entity's coordinate system.
	 *
	 * @param shape Shape object
	 *
	 * @return Local bounding rectangle of the entity
	 *
	*/
	public FloatRect sfConvexShape_getLocalBounds(Pointer/*(sfConvexShape*)*/ shape);

	/**
	 * @brief Get the global bounding rectangle of a convex shape
	 *
	 * The returned rectangle is in global coordinates, which means
	 * that it takes in account the transformations (translation,
	 * rotation, scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * sprite in the global 2D world's coordinate system.
	 *
	 * @param shape Shape object
	 *
	 * @return Global bounding rectangle of the entity
	 *
	*/
	public FloatRect sfConvexShape_getGlobalBounds(Pointer/*(sfConvexShape*)*/ shape);

	// Export.h

	/**
	 * Headers
	*/

	/**
	 * Define portable import  export macros
	*/

	// Font.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a new font from a file
	 *
	 * @param filename Path of the font file to load
	 *
	 * @return A new sfFont object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfFont*)*/ sfFont_createFromFile(String/*(char*)*/ filename);

	/**
	 * @brief Create a new image font a file in memory
	 *
	 * @param data        Pointer to the file data in memory
	 * @param sizeInBytes Size of the data to load, in bytes
	 *
	 * @return A new sfFont object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfFont*)*/ sfFont_createFromMemory(Pointer/*(void*)*/ data,  int sizeInBytes);

	/**
	 * @brief Create a new image font a custom stream
	 *
	 * @param stream Source stream to read from
	 *
	 * @return A new sfFont object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfFont*)*/ sfFont_createFromStream(Pointer/*(sfInputStream*)*/ stream);

	/**
	 * @brief Copy an existing font
	 *
	 * @param font Font to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfFont*)*/ sfFont_copy(Pointer/*(sfFont*)*/ font);

	/**
	 * @brief Destroy an existing font
	 *
	 * @param font Font to delete
	 *
	*/
	public void sfFont_destroy(Pointer/*(sfFont*)*/ font);

	/**
	 * @brief Get a glyph in a font
	 *
	 * @param font             Source font
	 * @param codePoint        Unicode code point of the character to get
	 * @param characterSize    Character size, in pixels
	 * @param bold             Retrieve the bold version or the regular one?
	 * @param outlineThickness Thickness of outline (when != 0 the glyph will not be filled)
	 *
	 * @return The corresponding glyph
	 *
	*/
	public Glyph sfFont_getGlyph(Pointer/*(sfFont*)*/ font,  long codePoint,  /*unsigned*/ int characterSize,  int bold,  float outlineThickness);

	/**
	 * @brief Get the kerning value corresponding to a given pair of characters in a font
	 *
	 * @param font          Source font
	 * @param first         Unicode code point of the first character
	 * @param second        Unicode code point of the second character
	 * @param characterSize Character size, in pixels
	 *
	 * @return Kerning offset, in pixels
	 *
	*/
	public float sfFont_getKerning(Pointer/*(sfFont*)*/ font,  long first,  long second,  /*unsigned*/ int characterSize);

	/**
	 * @brief Get the line spacing value
	 *
	 * @param font          Source font
	 * @param characterSize Character size, in pixels
	 *
	 * @return Line spacing, in pixels
	 *
	*/
	public float sfFont_getLineSpacing(Pointer/*(sfFont*)*/ font,  /*unsigned*/ int characterSize);

	/**
	 * @brief Get the position of the underline
	 *
	 * Underline position is the vertical offset to apply between the
	 * baseline and the underline.
	 *
	 * @param font          Source font
	 * @param characterSize Reference character size
	 *
	 * @return Underline position, in pixels
	 *
	*/
	public float sfFont_getUnderlinePosition(Pointer/*(sfFont*)*/ font,  /*unsigned*/ int characterSize);

	/**
	 * @brief Get the thickness of the underline
	 *
	 * Underline thickness is the vertical size of the underline.
	 *
	 * @param font          Source font
	 * @param characterSize Reference character size
	 *
	 * @return Underline thickness, in pixels
	 *
	*/
	public float sfFont_getUnderlineThickness(Pointer/*(sfFont*)*/ font,  /*unsigned*/ int characterSize);

	/**
	 * @brief Get the texture containing the glyphs of a given size in a font
	 *
	 * @param font          Source font
	 * @param characterSize Character size, in pixels
	 *
	 * @return Read-only pointer to the texture
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfFont_getTexture(Pointer/*(sfFont*)*/ font,  /*unsigned*/ int characterSize);

	/**
	 * @brief Get the font information
	 *
	 * The returned structure will remain valid only if the font
	 * is still valid. If the font is invalid an invalid structure
	 * is returned.
	 *
	 * @param font Source font
	 *
	 * @return A structure that holds the font information
	 *
	*/
	public FontInfo sfFont_getInfo(Pointer/*(sfFont*)*/ font);

	// FontInfo.h

	/**
	 * Headers
	*/

	/**
	 * sfFontInfo holds various information about a font
	*/

	// Glsl.h

	/**
	 * Headers
	*/

	// Glyph.h

	/**
	 * Headers
	*/

	/**
	 * @brief sfGlyph describes a glyph (a visual character)
	 *
	*/

	// Image.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create an image
	 *
	 * This image is filled with black pixels.
	 *
	 * @param width  Width of the image
	 * @param height Height of the image
	 *
	 * @return A new sfImage object
	 *
	*/
	public Pointer/*(sfImage*)*/ sfImage_create(/*unsigned*/ int width,  /*unsigned*/ int height);

	/**
	 * @brief Create an image and fill it with a unique color
	 *
	 * @param width  Width of the image
	 * @param height Height of the image
	 * @param color  Fill color
	 *
	 * @return A new sfImage object
	 *
	*/
	public Pointer/*(sfImage*)*/ sfImage_createFromColor(/*unsigned*/ int width,  /*unsigned*/ int height,  Color color);

	/**
	 * @brief Create an image from an array of pixels
	 *
	 * The @a pixel array is assumed to contain 32-bits RGBA pixels,
	 * and have the given @a width and @a height. If not, this is
	 * an undefined behaviour.
	 * If @a pixels is null, an empty image is created.
	 *
	 * @param width  Width of the image
	 * @param height Height of the image
	 * @param pixels Array of pixels to copy to the image
	 *
	 * @return A new sfImage object
	 *
	*/
	public Pointer/*(sfImage*)*/ sfImage_createFromPixels(/*unsigned*/ int width,  /*unsigned*/ int height, Pointer/*(  sfUint8*)*/ pixels);

	/**
	 * @brief Create an image from a file on disk
	 *
	 * The supported image formats are bmp, png, tga, jpg, gif,
	 * psd, hdr and pic. Some format options are not supported,
	 * like progressive jpeg.
	 * If this function fails, the image is left unchanged.
	 *
	 * @param filename Path of the image file to load
	 *
	 * @return A new sfImage object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfImage*)*/ sfImage_createFromFile(String/*(char*)*/ filename);

	/**
	 * @brief Create an image from a file in memory
	 *
	 * The supported image formats are bmp, png, tga, jpg, gif,
	 * psd, hdr and pic. Some format options are not supported,
	 * like progressive jpeg.
	 * If this function fails, the image is left unchanged.
	 *
	 * @param data Pointer to the file data in memory
	 * @param size Size of the data to load, in bytes
	 *
	 * @return A new sfImage object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfImage*)*/ sfImage_createFromMemory(Pointer/*(void*)*/ data,  int size);

	/**
	 * @brief Create an image from a custom stream
	 *
	 * The supported image formats are bmp, png, tga, jpg, gif,
	 * psd, hdr and pic. Some format options are not supported,
	 * like progressive jpeg.
	 * If this function fails, the image is left unchanged.
	 *
	 * @param stream Source stream to read from
	 *
	 * @return A new sfImage object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfImage*)*/ sfImage_createFromStream(Pointer/*(sfInputStream*)*/ stream);

	/**
	 * @brief Copy an existing image
	 *
	 * @param image Image to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfImage*)*/ sfImage_copy(Pointer/*(sfImage*)*/ image);

	/**
	 * @brief Destroy an existing image
	 *
	 * @param image Image to delete
	 *
	*/
	public void sfImage_destroy(Pointer/*(sfImage*)*/ image);

	/**
	 * @brief Save an image to a file on disk
	 *
	 * The format of the image is automatically deduced from
	 * the extension. The supported image formats are bmp, png,
	 * tga and jpg. The destination file is overwritten
	 * if it already exists. This function fails if the image is empty.
	 *
	 * @param image    Image object
	 * @param filename Path of the file to save
	 *
	 * @return sfTrue if saving was successful
	 *
	*/
	public int sfImage_saveToFile(Pointer/*(sfImage*)*/ image, String/*(  char*)*/ filename);

	/**
	 * @brief Return the size of an image
	 *
	 * @param image Image object
	 *
	 * @return Size in pixels
	 *
	*/
	public Vector2u sfImage_getSize(Pointer/*(sfImage*)*/ image);

	/**
	 * @brief Create a transparency mask from a specified color-key
	 *
	 * This function sets the alpha value of every pixel matching
	 * the given color to @a alpha (0 by default), so that they
	 * become transparent.
	 *
	 * @param image Image object
	 * @param color Color to make transparent
	 * @param alpha Alpha value to assign to transparent pixels
	 *
	*/
	public void sfImage_createMaskFromColor(Pointer/*(sfImage*)*/ image,  Color color,  int alpha);

	/**
	 * @brief Copy pixels from an image onto another
	 *
	 * This function does a slow pixel copy and should not be
	 * used intensively. It can be used to prepare a complex
	 * static image from several others, but if you need this
	 * kind of feature in real-time you'd better use sfRenderTexture.
	 *
	 * If @a sourceRect is empty, the whole image is copied.
	 * If @a applyAlpha is set to true, the transparency of
	 * source pixels is applied. If it is false, the pixels are
	 * copied unchanged with their alpha value.
	 *
	 * @param image      Image object
	 * @param source     Source image to copy
	 * @param destX      X coordinate of the destination position
	 * @param destY      Y coordinate of the destination position
	 * @param sourceRect Sub-rectangle of the source image to copy
	 * @param applyAlpha Should the copy take in account the source transparency?
	 *
	*/
	public void sfImage_copyImage(Pointer/*(sfImage*)*/ image, Pointer/*(  sfImage*)*/ source,  /*unsigned*/ int destX,  /*unsigned*/ int destY,  IntRect sourceRect,  int applyAlpha);

	/**
	 * @brief Change the color of a pixel in an image
	 *
	 * This function doesn't check the validity of the pixel
	 * coordinates, using out-of-range values will result in
	 * an undefined behaviour.
	 *
	 * @param image Image object
	 * @param x     X coordinate of pixel to change
	 * @param y     Y coordinate of pixel to change
	 * @param color New color of the pixel
	 *
	*/
	public void sfImage_setPixel(Pointer/*(sfImage*)*/ image,  /*unsigned*/ int x,  /*unsigned*/ int y,  Color color);

	/**
	 * @brief Get the color of a pixel in an image
	 *
	 * This function doesn't check the validity of the pixel
	 * coordinates, using out-of-range values will result in
	 * an undefined behaviour.
	 *
	 * @param image Image object
	 * @param x     X coordinate of pixel to get
	 * @param y     Y coordinate of pixel to get
	 *
	 * @return Color of the pixel at coordinates (x, y)
	 *
	*/
	public Color sfImage_getPixel(Pointer/*(sfImage*)*/ image,  /*unsigned*/ int x,  /*unsigned*/ int y);

	/**
	 * @brief Get a read-only pointer to the array of pixels of an image
	 *
	 * The returned value points to an array of RGBA pixels made of
	 * 8 bits integers components. The size of the array is
	 * getWidth() * getHeight() * 4.
	 * Warning: the returned pointer may become invalid if you
	 * modify the image, so you should never store it for too long.
	 * If the image is empty, a null pointer is returned.
	 *
	 * @param image Image object
	 *
	 * @return Read-only pointer to the array of pixels
	 *
	*/
	public Pointer/*(sfUint8*)*/ sfImage_getPixelsPtr(Pointer/*(sfImage*)*/ image);

	/**
	 * @brief Flip an image horizontally (left <-> right)
	 *
	 * @param image Image object
	 *
	*/
	public void sfImage_flipHorizontally(Pointer/*(sfImage*)*/ image);

	/**
	 * @brief Flip an image vertically (top <-> bottom)
	 *
	 * @param image Image object
	 *
	*/
	public void sfImage_flipVertically(Pointer/*(sfImage*)*/ image);

	// PrimitiveType.h

	/**
	 * Headers
	*/

	/**
	 * @brief Types of primitives that a sf::VertexArray can render
	 *
	 * Points and lines have no area, therefore their thickness
	 * will always be 1 pixel, regardless the current transform
	 * and view.
	 *
	*/

	// Rect.h

	/**
	 * Headers
	*/

	/**
	 * sfFloatRect and sfIntRect are utility classes for
	 * manipulating rectangles.
	*/

	/**
	 * @brief Check if a point is inside a rectangle's area
	 *
	 * @param rect Rectangle to test
	 * @param x    X coordinate of the point to test
	 * @param y    Y coordinate of the point to test
	 *
	 * @return sfTrue if the point is inside
	 *
	*/
	public int sfFloatRect_contains(Pointer/*(FloatRect*)*/ rect,  float x,  float y);
	public int sfIntRect_contains(Pointer/*(IntRect*)*/ rect,  int x,  int y);

	/**
	 * @brief Check intersection between two rectangles
	 *
	 * @param rect1        First rectangle to test
	 * @param rect2        Second rectangle to test
	 * @param intersection Rectangle to be filled with overlapping rect (can be NULL)
	 *
	 * @return sfTrue if rectangles overlap
	 *
	*/
	public int sfFloatRect_intersects(Pointer/*(FloatRect*)*/ rect1, Pointer/*(  FloatRect*)*/ rect2, Pointer/*( FloatRect*)*/ intersection);
	public int sfIntRect_intersects(Pointer/*(IntRect*)*/ rect1, Pointer/*(  IntRect*)*/ rect2, Pointer/*( IntRect*)*/ intersection);

	// RectangleShape.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a new rectangle shape
	 *
	 * @return A new sfRectangleShape object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfRectangleShape*)*/ sfRectangleShape_create();

	/**
	 * @brief Copy an existing rectangle shape
	 *
	 * @param shape Shape to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfRectangleShape*)*/ sfRectangleShape_copy(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Destroy an existing rectangle shape
	 *
	 * @param shape Shape to delete
	 *
	*/
	public void sfRectangleShape_destroy(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Set the position of a rectangle shape
	 *
	 * This function completely overwrites the previous position.
	 * See sfRectangleShape_move to apply an offset based on the previous position instead.
	 * The default position of a circle Shape object is (0, 0).
	 *
	 * @param shape    Shape object
	 * @param position New position
	 *
	*/
	public void sfRectangleShape_setPosition(Pointer/*(sfRectangleShape*)*/ shape,  Vector2f position);

	/**
	 * @brief Set the orientation of a rectangle shape
	 *
	 * This function completely overwrites the previous rotation.
	 * See sfRectangleShape_rotate to add an angle based on the previous rotation instead.
	 * The default rotation of a circle Shape object is 0.
	 *
	 * @param shape Shape object
	 * @param angle New rotation, in degrees
	 *
	*/
	public void sfRectangleShape_setRotation(Pointer/*(sfRectangleShape*)*/ shape,  float angle);

	/**
	 * @brief Set the scale factors of a rectangle shape
	 *
	 * This function completely overwrites the previous scale.
	 * See sfRectangleShape_scale to add a factor based on the previous scale instead.
	 * The default scale of a circle Shape object is (1, 1).
	 *
	 * @param shape Shape object
	 * @param scale New scale factors
	 *
	*/
	public void sfRectangleShape_setScale(Pointer/*(sfRectangleShape*)*/ shape,  Vector2f scale);

	/**
	 * @brief Set the local origin of a rectangle shape
	 *
	 * The origin of an object defines the center point for
	 * all transformations (position, scale, rotation).
	 * The coordinates of this point must be relative to the
	 * top-left corner of the object, and ignore all
	 * transformations (position, scale, rotation).
	 * The default origin of a circle Shape object is (0, 0).
	 *
	 * @param shape  Shape object
	 * @param origin New origin
	 *
	*/
	public void sfRectangleShape_setOrigin(Pointer/*(sfRectangleShape*)*/ shape,  Vector2f origin);

	/**
	 * @brief Get the position of a rectangle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current position
	 *
	*/
	public Vector2f sfRectangleShape_getPosition(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the orientation of a rectangle shape
	 *
	 * The rotation is always in the range [0, 360].
	 *
	 * @param shape Shape object
	 *
	 * @return Current rotation, in degrees
	 *
	*/
	public float sfRectangleShape_getRotation(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the current scale of a rectangle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current scale factors
	 *
	*/
	public Vector2f sfRectangleShape_getScale(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the local origin of a rectangle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current origin
	 *
	*/
	public Vector2f sfRectangleShape_getOrigin(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Move a rectangle shape by a given offset
	 *
	 * This function adds to the current position of the object,
	 * unlike sfRectangleShape_setPosition which overwrites it.
	 *
	 * @param shape  Shape object
	 * @param offset Offset
	 *
	*/
	public void sfRectangleShape_move(Pointer/*(sfRectangleShape*)*/ shape,  Vector2f offset);

	/**
	 * @brief Rotate a rectangle shape
	 *
	 * This function adds to the current rotation of the object,
	 * unlike sfRectangleShape_setRotation which overwrites it.
	 *
	 * @param shape Shape object
	 * @param angle Angle of rotation, in degrees
	 *
	*/
	public void sfRectangleShape_rotate(Pointer/*(sfRectangleShape*)*/ shape,  float angle);

	/**
	 * @brief Scale a rectangle shape
	 *
	 * This function multiplies the current scale of the object,
	 * unlike sfRectangleShape_setScale which overwrites it.
	 *
	 * @param shape   Shape object
	 * @param factors Scale factors
	 *
	*/
	public void sfRectangleShape_scale(Pointer/*(sfRectangleShape*)*/ shape,  Vector2f factors);

	/**
	 * @brief Get the combined transform of a rectangle shape
	 *
	 * @param shape shape object
	 *
	 * @return Transform combining the positionrotationscaleorigin of the object
	 *
	*/
	public Transform sfRectangleShape_getTransform(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the inverse of the combined transform of a rectangle shape
	 *
	 * @param shape shape object
	 *
	 * @return Inverse of the combined transformations applied to the object
	 *
	*/
	public Transform sfRectangleShape_getInverseTransform(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Change the source texture of a rectangle shape
	 *
	 * The @a texture argument refers to a texture that must
	 * exist as long as the shape uses it. Indeed, the shape
	 * doesn't store its own copy of the texture, but rather keeps
	 * a pointer to the one that you passed to this function.
	 * If the source texture is destroyed and the shape tries to
	 * use it, the behaviour is undefined.
	 * @a texture can be NULL to disable texturing.
	 * If @a resetRect is true, the TextureRect property of
	 * the shape is automatically adjusted to the size of the new
	 * texture. If it is false, the texture rect is left unchanged.
	 *
	 * @param shape     Shape object
	 * @param texture   New texture
	 * @param resetRect Should the texture rect be reset to the size of the new texture?
	 *
	*/
	public void sfRectangleShape_setTexture(Pointer/*(sfRectangleShape*)*/ shape, Pointer/*(  sfTexture*)*/ texture,  int resetRect);

	/**
	 * @brief Set the sub-rectangle of the texture that a rectangle shape will display
	 *
	 * The texture rect is useful when you don't want to display
	 * the whole texture, but rather a part of it.
	 * By default, the texture rect covers the entire texture.
	 *
	 * @param shape Shape object
	 * @param rect  Rectangle defining the region of the texture to display
	 *
	*/
	public void sfRectangleShape_setTextureRect(Pointer/*(sfRectangleShape*)*/ shape,  IntRect rect);

	/**
	 * @brief Set the fill color of a rectangle shape
	 *
	 * This color is modulated (multiplied) with the shape's
	 * texture if any. It can be used to colorize the shape,
	 * or change its global opacity.
	 * You can use sfTransparent to make the inside of
	 * the shape transparent, and have the outline alone.
	 * By default, the shape's fill color is opaque white.
	 *
	 * @param shape Shape object
	 * @param color New color of the shape
	 *
	*/
	public void sfRectangleShape_setFillColor(Pointer/*(sfRectangleShape*)*/ shape,  Color color);

	/**
	 * @brief Set the outline color of a rectangle shape
	 *
	 * You can use sfTransparent to disable the outline.
	 * By default, the shape's outline color is opaque white.
	 *
	 * @param shape Shape object
	 * @param color New outline color of the shape
	 *
	*/
	public void sfRectangleShape_setOutlineColor(Pointer/*(sfRectangleShape*)*/ shape,  Color color);

	/**
	 * @brief Set the thickness of a rectangle shape's outline
	 *
	 * This number cannot be negative. Using zero disables
	 * the outline.
	 * By default, the outline thickness is 0.
	 *
	 * @param shape     Shape object
	 * @param thickness New outline thickness
	 *
	*/
	public void sfRectangleShape_setOutlineThickness(Pointer/*(sfRectangleShape*)*/ shape,  float thickness);

	/**
	 * @brief Get the source texture of a rectangle shape
	 *
	 * If the shape has no source texture, a NULL pointer is returned.
	 * The returned pointer is const, which means that you can't
	 * modify the texture when you retrieve it with this function.
	 *
	 * @param shape Shape object
	 *
	 * @return Pointer to the shape's texture
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfRectangleShape_getTexture(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the sub-rectangle of the texture displayed by a rectangle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Texture rectangle of the shape
	 *
	*/
	public IntRect sfRectangleShape_getTextureRect(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the fill color of a rectangle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Fill color of the shape
	 *
	*/
	public Color sfRectangleShape_getFillColor(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the outline color of a rectangle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Outline color of the shape
	 *
	*/
	public Color sfRectangleShape_getOutlineColor(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the outline thickness of a rectangle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Outline thickness of the shape
	 *
	*/
	public float sfRectangleShape_getOutlineThickness(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the total number of points of a rectangle shape
	 *
	 * @param shape Shape object
	 *
	 * @return Number of points of the shape
	 *
	*/
	public int sfRectangleShape_getPointCount(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get a point of a rectangle shape
	 *
	 * The result is undefined if @a index is out of the valid range.
	 *
	 * @param shape Shape object
	 * @param index Index of the point to get, in range [0 .. getPointCount() - 1]
	 *
	 * @return Index-th point of the shape
	 *
	*/
	public Vector2f sfRectangleShape_getPoint(Pointer/*(sfRectangleShape*)*/ shape,  int index);

	/**
	 * @brief Set the size of a rectangle shape
	 *
	 * @param shape Shape object
	 * @param size  New size of the rectangle
	 *
	*/
	public void sfRectangleShape_setSize(Pointer/*(sfRectangleShape*)*/ shape,  Vector2f size);

	/**
	 * @brief Get the size of a rectangle shape
	 *
	 * @param shape Shape object
	 *
	 * @return height Size of the rectangle
	 *
	*/
	public Vector2f sfRectangleShape_getSize(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the local bounding rectangle of a rectangle shape
	 *
	 * The returned rectangle is in local coordinates, which means
	 * that it ignores the transformations (translation, rotation,
	 * scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * entity in the entity's coordinate system.
	 *
	 * @param shape Shape object
	 *
	 * @return Local bounding rectangle of the entity
	 *
	*/
	public FloatRect sfRectangleShape_getLocalBounds(Pointer/*(sfRectangleShape*)*/ shape);

	/**
	 * @brief Get the global bounding rectangle of a rectangle shape
	 *
	 * The returned rectangle is in global coordinates, which means
	 * that it takes in account the transformations (translation,
	 * rotation, scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * sprite in the global 2D world's coordinate system.
	 *
	 * @param shape Shape object
	 *
	 * @return Global bounding rectangle of the entity
	 *
	*/
	public FloatRect sfRectangleShape_getGlobalBounds(Pointer/*(sfRectangleShape*)*/ shape);

	// RenderStates.h

	/**
	 * Headers
	*/

	/**
	 * @brief Define the states used for drawing to a RenderTarget
	 *
	*/

	// RenderTexture.h

	/**
	 * Headers
	*/

	/**
	 * @brief Construct a new render texture
	 *
	 * @param width       Width of the render texture
	 * @param height      Height of the render texture
	 * @param depthBuffer Do you want a depth-buffer attached? (useful only if you're doing 3D OpenGL on the rendertexture)
	 *
	 * @return A new sfRenderTexture object, or NULL if it failed
	 *
	 * @deprecated
	 * Use sfRenderTexture_createWithSettings instead.
	 *
	*/
	public Pointer/*(sfRenderTexture*)*/ sfRenderTexture_create(/*unsigned*/ int width,  /*unsigned*/ int height,  int depthBuffer);

	/**
	 * @brief Construct a new render texture
	 *
	 * @param width    Width of the render texture
	 * @param height   Height of the render texture
	 * @param settings Settings of the render texture
	 *
	 * @return A new sfRenderTexture object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfRenderTexture*)*/ sfRenderTexture_createWithSettings(/*unsigned*/ int width,  /*unsigned*/ int height, Pointer/*(  sfContextSettings*)*/ settings);

	/**
	 * @brief Destroy an existing render texture
	 *
	 * @param renderTexture Render texture to destroy
	 *
	*/
	public void sfRenderTexture_destroy(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Get the size of the rendering region of a render texture
	 *
	 * @param renderTexture Render texture object
	 *
	 * @return Size in pixels
	 *
	*/
	public Vector2u sfRenderTexture_getSize(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Activate or deactivate a render texture as the current target for rendering
	 *
	 * @param renderTexture Render texture object
	 * @param active        sfTrue to activate, sfFalse to deactivate
	 *
	 * @return True if operation was successful, false otherwise
	 *
	*/
	public int sfRenderTexture_setActive(Pointer/*(sfRenderTexture*)*/ renderTexture,  int active);

	/**
	 * @brief Update the contents of the target texture
	 *
	 * @param renderTexture Render texture object
	 *
	*/
	public void sfRenderTexture_display(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Clear the rendertexture with the given color
	 *
	 * @param renderTexture Render texture object
	 * @param color         Fill color
	 *
	*/
	public void sfRenderTexture_clear(Pointer/*(sfRenderTexture*)*/ renderTexture,  Color color);

	/**
	 * @brief Change the current active view of a render texture
	 *
	 * @param renderTexture Render texture object
	 * @param view          Pointer to the new view
	 *
	*/
	public void sfRenderTexture_setView(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfView*)*/ view);

	/**
	 * @brief Get the current active view of a render texture
	 *
	 * @param renderTexture Render texture object
	 *
	 * @return Current active view
	 *
	*/
	public Pointer/*(sfView*)*/ sfRenderTexture_getView(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Get the default view of a render texture
	 *
	 * @param renderTexture Render texture object
	 *
	 * @return Default view of the rendertexture
	 *
	*/
	public Pointer/*(sfView*)*/ sfRenderTexture_getDefaultView(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Get the viewport of a view applied to this target
	 *
	 * @param renderTexture Render texture object
	 * @param view          Target view
	 *
	 * @return Viewport rectangle, expressed in pixels in the current target
	 *
	*/
	public IntRect sfRenderTexture_getViewport(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfView*)*/ view);

	/**
	 * @brief Convert a point from texture coordinates to world coordinates
	 *
	 * This function finds the 2D position that matches the
	 * given pixel of the render-texture. In other words, it does
	 * the inverse of what the graphics card does, to find the
	 * initial position of a rendered pixel.
	 *
	 * Initially, both coordinate systems (world units and target pixels)
	 * match perfectly. But if you define a custom view or resize your
	 * render-texture, this assertion is not true anymore, ie. a point
	 * located at (10, 50) in your render-texture may map to the point
	 * (150, 75) in your 2D world -- if the view is translated by (140, 25).
	 *
	 * This version uses a custom view for calculations, see the other
	 * overload of the function if you want to use the current view of the
	 * render-texture.
	 *
	 * @param renderTexture Render texture object
	 * @param point Pixel to convert
	 * @param view The view to use for converting the point
	 *
	 * @return The converted point, in "world" units
	 *
	*/
	public Vector2f sfRenderTexture_mapPixelToCoords(Pointer/*(sfRenderTexture*)*/ renderTexture,  Vector2i point, Pointer/*(  sfView*)*/ view);

	/**
	 * @brief Convert a point from world coordinates to texture coordinates
	 *
	 * This function finds the pixel of the render-texture that matches
	 * the given 2D point. In other words, it goes through the same process
	 * as the graphics card, to compute the final position of a rendered point.
	 *
	 * Initially, both coordinate systems (world units and target pixels)
	 * match perfectly. But if you define a custom view or resize your
	 * render-texture, this assertion is not true anymore, ie. a point
	 * located at (150, 75) in your 2D world may map to the pixel
	 * (10, 50) of your render-texture -- if the view is translated by (140, 25).
	 *
	 * This version uses a custom view for calculations, see the other
	 * overload of the function if you want to use the current view of the
	 * render-texture.
	 *
	 * @param renderTexture Render texture object
	 * @param point Point to convert
	 * @param view The view to use for converting the point
	 *
	 * @return The converted point, in target coordinates (pixels)
	 *
	*/
	public Vector2i sfRenderTexture_mapCoordsToPixel(Pointer/*(sfRenderTexture*)*/ renderTexture,  Vector2f point, Pointer/*(  sfView*)*/ view);

	/**
	 * @brief Draw a drawable object to the render-target
	 *
	 * @param renderTexture Render texture object
	 * @param object        Object to draw
	 * @param states        Render states to use for drawing (NULL to use the default states)
	 *
	*/
	public void sfRenderTexture_drawSprite(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfSprite*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderTexture_drawText(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfText*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderTexture_drawShape(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfShape*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderTexture_drawCircleShape(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfCircleShape*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderTexture_drawConvexShape(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfConvexShape*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderTexture_drawRectangleShape(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfRectangleShape*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderTexture_drawVertexArray(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfVertexArray*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderTexture_drawVertexBuffer(Pointer/*(sfRenderTexture*)*/ renderTexture, Pointer/*(  sfVertexBuffer*)*/ object, Pointer/*(  sfRenderStates*)*/ states);

	/**
	 * @brief Draw primitives defined by an array of vertices to a render texture
	 *
	 * @param renderTexture Render texture object
	 * @param vertices      Pointer to the vertices
	 * @param vertexCount   Number of vertices in the array
	 * @param type          Type of primitives to draw
	 * @param states        Render states to use for drawing (NULL to use the default states)
	 *
	*/

	/**
	 * @brief Save the current OpenGL render states and matrices
	 *
	 * This function can be used when you mix SFML drawing
	 * and direct OpenGL rendering. Combined with popGLStates,
	 * it ensures that:
	 * @li SFML's internal states are not messed up by your OpenGL code
	 * @li your OpenGL states are not modified by a call to a SFML function
	 *
	 * Note that this function is quite expensive: it saves all the
	 * possible OpenGL states and matrices, even the ones you
	 * don't care about. Therefore it should be used wisely.
	 * It is provided for convenience, but the best results will
	 * be achieved if you handle OpenGL states yourself (because
	 * you know which states have really changed, and need to be
	 * saved and restored). Take a look at the resetGLStates
	 * function if you do so.
	 *
	 * @param renderTexture Render texture object
	 *
	*/
	public void sfRenderTexture_pushGLStates(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Restore the previously saved OpenGL render states and matrices
	 *
	 * See the description of pushGLStates to get a detailed
	 * description of these functions.
	 *
	 * @param renderTexture Render texture object
	 *
	*/
	public void sfRenderTexture_popGLStates(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Reset the internal OpenGL states so that the target is ready for drawing
	 *
	 * This function can be used when you mix SFML drawing
	 * and direct OpenGL rendering, if you choose not to use
	 * pushGLStatespopGLStates. It makes sure that all OpenGL
	 * states needed by SFML are set, so that subsequent sfRenderTexture_draw*()
	 * calls will work as expected.
	 *
	 * @param renderTexture Render texture object
	 *
	*/
	public void sfRenderTexture_resetGLStates(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Get the target texture of a render texture
	 *
	 * @param renderTexture Render texture object
	 *
	 * @return Pointer to the target texture
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfRenderTexture_getTexture(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Get the maximum anti-aliasing level supported by the system
	 *
	 * @return The maximum anti-aliasing level supported by the system
	 *
	*/
	public /*unsigned*/ int sfRenderTexture_getMaximumAntialiasingLevel();

	/**
	 * @brief Enable or disable the smooth filter on a render texture
	 *
	 * @param renderTexture Render texture object
	 * @param smooth        sfTrue to enable smoothing, sfFalse to disable it
	 *
	*/
	public void sfRenderTexture_setSmooth(Pointer/*(sfRenderTexture*)*/ renderTexture,  int smooth);

	/**
	 * @brief Tell whether the smooth filter is enabled or not for a render texture
	 *
	 * @param renderTexture Render texture object
	 *
	 * @return sfTrue if smoothing is enabled, sfFalse if it is disabled
	 *
	*/
	public int sfRenderTexture_isSmooth(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Enable or disable texture repeating
	 *
	 * @param renderTexture Render texture object
	 * @param repeated      sfTrue to enable repeating, sfFalse to disable it
	 *
	*/
	public void sfRenderTexture_setRepeated(Pointer/*(sfRenderTexture*)*/ renderTexture,  int repeated);

	/**
	 * @brief Tell whether the texture is repeated or not
	 *
	 * @param renderTexture Render texture object
	 *
	 * @return sfTrue if repeat mode is enabled, sfFalse if it is disabled
	 *
	*/
	public int sfRenderTexture_isRepeated(Pointer/*(sfRenderTexture*)*/ renderTexture);

	/**
	 * @brief Generate a mipmap using the current texture data
	 *
	 * This function is similar to sfTexture_generateMipmap and operates
	 * on the texture used as the target for drawing.
	 * Be aware that any draw operation may modify the base level image data.
	 * For this reason, calling this function only makes sense after all
	 * drawing is completed and display has been called. Not calling display
	 * after subsequent drawing will lead to undefined behavior if a mipmap
	 * had been previously generated.
	 *
	 * @return sfTrue if mipmap generation was successful, sfFalse if unsuccessful
	 *
	*/
	public int sfRenderTexture_generateMipmap(Pointer/*(sfRenderTexture*)*/ renderTexture);

	// RenderWindow.h

	/**
	 * Headers
	*/

	/**
	 * @brief Construct a new render window
	 *
	 * @param mode     Video mode to use
	 * @param title    Title of the window
	 * @param style    Window style
	 * @param settings Creation settings (pass NULL to use default values)
	 *
	*/
	public Pointer/*(sfRenderWindow*)*/ sfRenderWindow_create(VideoMode mode, String/*(  char*)*/ title,  int style, Pointer/*(  sfContextSettings*)*/ settings);

	/**
	 * @brief Construct a new render window (with a UTF-32 title)
	 *
	 * @param mode     Video mode to use
	 * @param title    Title of the window (UTF-32)
	 * @param style    Window style
	 * @param settings Creation settings (pass NULL to use default values)
	 *
	*/
	public Pointer/*(sfRenderWindow*)*/ sfRenderWindow_createUnicode(VideoMode mode, Pointer/*(  sfUint32*)*/ title,  long style, Pointer/*(  sfContextSettings*)*/ settings);

	// /**
	//  * @brief Construct a render window from an existing control
	//  *
	//  * @param handle   Platform-specific handle of the control
	//  * @param settings Creation settings (pass NULL to use default values)
	//  *
	// */
	// public Pointer/*(sfRenderWindow*)*/ sfRenderWindow_createFromHandle(WindowHandle handle, Pointer/*(  sfContextSettings*)*/ settings);

	/**
	 * @brief Destroy an existing render window
	 *
	 * @param renderWindow Render window to destroy
	 *
	*/
	public void sfRenderWindow_destroy(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Close a render window (but doesn't destroy the internal data)
	 *
	 * @param renderWindow Render window to close
	 *
	*/
	public void sfRenderWindow_close(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Tell whether or not a render window is opened
	 *
	 * @param renderWindow Render window object
	 *
	*/
	public int sfRenderWindow_isOpen(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Get the creation settings of a render window
	 *
	 * @param renderWindow Render window object
	 *
	 * @return Settings used to create the window
	 *
	*/
	public ContextSettings sfRenderWindow_getSettings(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Get the event on top of event queue of a render window, if any, and pop it
	 *
	 * @param renderWindow Render window object
	 * @param event        Event to fill, if any
	 *
	 * @return sfTrue if an event was returned, sfFalse if event queue was empty
	 *
	*/
	public int sfRenderWindow_pollEvent(Pointer/*(sfRenderWindow*)*/ renderWindow, Buffer eventBuffer);

	/**
	 * @brief Wait for an event and return it
	 *
	 * @param renderWindow Render window object
	 * @param event        Event to fill
	 *
	 * @return sfFalse if an error occured
	 *
	*/
	public int sfRenderWindow_waitEvent(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*( sfEvent*)*/ event);

	/**
	 * @brief Get the position of a render window
	 *
	 * @param renderWindow Render window object
	 *
	 * @return Position in pixels
	 *
	*/
	public Vector2i sfRenderWindow_getPosition(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Change the position of a render window on screen
	 *
	 * Only works for top-level windows
	 *
	 * @param renderWindow Render window object
	 * @param position     New position, in pixels
	 *
	*/
	public void sfRenderWindow_setPosition(Pointer/*(sfRenderWindow*)*/ renderWindow,  Vector2i position);

	/**
	 * @brief Get the size of the rendering region of a render window
	 *
	 * @param renderWindow Render window object
	 *
	 * @return Size in pixels
	 *
	*/
	public Vector2u sfRenderWindow_getSize(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Change the size of the rendering region of a render window
	 *
	 * @param renderWindow Render window object
	 * @param size         New size, in pixels
	 *
	*/
	public void sfRenderWindow_setSize(Pointer/*(sfRenderWindow*)*/ renderWindow,  Vector2u size);

	/**
	 * @brief Change the title of a render window
	 *
	 * @param renderWindow Render window object
	 * @param title        New title
	 *
	*/
	public void sfRenderWindow_setTitle(Pointer/*(sfRenderWindow*)*/ renderWindow, String/*(  char*)*/ title);

	/**
	 * @brief Change the title of a render window (with a UTF-32 string)
	 *
	 * @param renderWindow Render window object
	 * @param title        New title
	 *
	*/
	public void sfRenderWindow_setUnicodeTitle(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfUint32*)*/ title);

	/**
	 * @brief Change a render window's icon
	 *
	 * @param renderWindow Render window object
	 * @param width        Icon's width, in pixels
	 * @param height       Icon's height, in pixels
	 * @param pixels       Pointer to the pixels in memory, format must be RGBA 32 bits
	 *
	*/
	public void sfRenderWindow_setIcon(Pointer/*(sfRenderWindow*)*/ renderWindow,  /*unsigned*/ int width,  /*unsigned*/ int height, Pointer/*(  sfUint8*)*/ pixels);

	/**
	 * @brief Show or hide a render window
	 *
	 * @param renderWindow Render window object
	 * @param visible      sfTrue to show the window, sfFalse to hide it
	 *
	*/
	public void sfRenderWindow_setVisible(Pointer/*(sfRenderWindow*)*/ renderWindow,  int visible);

	/**
	 * @brief Enable  disable vertical synchronization on a render window
	 *
	 * @param renderWindow Render window object
	 * @param enabled      sfTrue to enable v-sync, sfFalse to deactivate
	 *
	*/
	public void sfRenderWindow_setVerticalSyncEnabled(Pointer/*(sfRenderWindow*)*/ renderWindow,  int enabled);

	/**
	 * @brief Show or hide the mouse cursor on a render window
	 *
	 * @param renderWindow Render window object
	 * @param show         sfTrue to show, sfFalse to hide
	 *
	*/
	public void sfRenderWindow_setMouseCursorVisible(Pointer/*(sfRenderWindow*)*/ renderWindow,  int show);

	/**
	 * @brief Grab or release the mouse cursor
	 *
	 * If set, grabs the mouse cursor inside this window's client
	 * area so it may no longer be moved outside its bounds.
	 * Note that grabbing is only active while the window has
	 * focus and calling this function for fullscreen windows
	 * won't have any effect (fullscreen windows always grab the
	 * cursor).
	 *
	 * @param grabbed sfTrue to enable, sfFalse to disable
	 *
	*/
	public void sfRenderWindow_setMouseCursorGrabbed(Pointer/*(sfRenderWindow*)*/ renderWindow,  int grabbed);

	/**
	 * @brief Set the displayed cursor to a native system cursor
	 *
	 * Upon window creation, the arrow cursor is used by default.
	 *
	 * @warning The cursor must not be destroyed while in use by
	 *          the window.
	 *
	 * @warning Features related to Cursor are not supported on
	 *          iOS and Android.
	 *
	 * @param cursor Native system cursor type to display
	 *
	 * @see sfCursor_createFromSystem
	 * @see sfCursor_createFromPixels
	 *
	*/
	public void sfRenderWindow_setMouseCursor(Pointer/*(sfRenderWindow*)*/ window, Pointer/*(  sfCursor*)*/ cursor);

	/**
	 * @brief Enable or disable automatic key-repeat for keydown events
	 *
	 * Automatic key-repeat is enabled by default
	 *
	 * @param renderWindow Render window object
	 * @param enabled      sfTrue to enable, sfFalse to disable
	 *
	*/
	public void sfRenderWindow_setKeyRepeatEnabled(Pointer/*(sfRenderWindow*)*/ renderWindow,  int enabled);

	/**
	 * @brief Limit the framerate to a maximum fixed frequency for a render window
	 *
	 * @param renderWindow Render window object
	 * @param limit        Framerate limit, in frames per seconds (use 0 to disable limit)
	 *
	*/
	public void sfRenderWindow_setFramerateLimit(Pointer/*(sfRenderWindow*)*/ renderWindow,  /*unsigned*/ int limit);

	/**
	 * @brief Change the joystick threshold, ie. the value below which no move event will be generated
	 *
	 * @param renderWindow Render window object
	 * @param threshold    New threshold, in range [0, 100]
	 *
	*/
	public void sfRenderWindow_setJoystickThreshold(Pointer/*(sfRenderWindow*)*/ renderWindow,  float threshold);

	/**
	 * @brief Activate or deactivate a render window as the current target for rendering
	 *
	 * @param renderWindow Render window object
	 * @param active       sfTrue to activate, sfFalse to deactivate
	 *
	 * @return True if operation was successful, false otherwise
	 *
	*/
	public int sfRenderWindow_setActive(Pointer/*(sfRenderWindow*)*/ renderWindow,  int active);
	public void sfRenderWindow_requestFocus(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Check whether the render window has the input focus
	 *
	 * At any given time, only one window may have the input focus
	 * to receive input events such as keystrokes or most mouse
	 * events.
	 *
	 * @return True if window has focus, false otherwise
	 *
	*/
	public int sfRenderWindow_hasFocus(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Display a render window on screen
	 *
	 * @param renderWindow Render window object
	 *
	*/
	public void sfRenderWindow_display(Pointer/*(sfRenderWindow*)*/ renderWindow);

	// /**
	//  * @brief Retrieve the OS-specific handle of a render window
	//  *
	//  * @param renderWindow Render window object
	//  *
	//  * @return Window handle
	//  *
	// */
	// public sfWindowHandle sfRenderWindow_getSystemHandle(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Clear a render window with the given color
	 *
	 * @param renderWindow Render window object
	 * @param color        Fill color
	 *
	*/
	public void sfRenderWindow_clear(Pointer/*(sfRenderWindow*)*/ renderWindow,  Color color);

	/**
	 * @brief Change the current active view of a render window
	 *
	 * @param renderWindow Render window object
	 * @param view         Pointer to the new view
	 *
	*/
	public void sfRenderWindow_setView(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfView*)*/ view);

	/**
	 * @brief Get the current active view of a render window
	 *
	 * @param renderWindow Render window object
	 *
	 * @return Current active view
	 *
	*/
	public Pointer/*(sfView*)*/ sfRenderWindow_getView(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Get the default view of a render window
	 *
	 * @param renderWindow Render window object
	 *
	 * @return Default view of the render window
	 *
	*/
	public Pointer/*(sfView*)*/ sfRenderWindow_getDefaultView(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Get the viewport of a view applied to this target
	 *
	 * @param renderWindow Render window object
	 * @param view         Target view
	 *
	 * @return Viewport rectangle, expressed in pixels in the current target
	 *
	*/
	public IntRect sfRenderWindow_getViewport(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfView*)*/ view);

	/**
	 * @brief Convert a point from window coordinates to world coordinates
	 *
	 * This function finds the 2D position that matches the
	 * given pixel of the render-window. In other words, it does
	 * the inverse of what the graphics card does, to find the
	 * initial position of a rendered pixel.
	 *
	 * Initially, both coordinate systems (world units and target pixels)
	 * match perfectly. But if you define a custom view or resize your
	 * render-window, this assertion is not true anymore, ie. a point
	 * located at (10, 50) in your render-window may map to the point
	 * (150, 75) in your 2D world -- if the view is translated by (140, 25).
	 *
	 * This function is typically used to find which point (or object) is
	 * located below the mouse cursor.
	 *
	 * This version uses a custom view for calculations, see the other
	 * overload of the function if you want to use the current view of the
	 * render-window.
	 *
	 * @param renderWindow Render window object
	 * @param point Pixel to convert
	 * @param view The view to use for converting the point
	 *
	 * @return The converted point, in "world" units
	 *
	*/
	public Vector2f sfRenderWindow_mapPixelToCoords(Pointer/*(sfRenderWindow*)*/ renderWindow,  Vector2i point, Pointer/*(  sfView*)*/ view);

	/**
	 * @brief Convert a point from world coordinates to window coordinates
	 *
	 * This function finds the pixel of the render-window that matches
	 * the given 2D point. In other words, it goes through the same process
	 * as the graphics card, to compute the final position of a rendered point.
	 *
	 * Initially, both coordinate systems (world units and target pixels)
	 * match perfectly. But if you define a custom view or resize your
	 * render-window, this assertion is not true anymore, ie. a point
	 * located at (150, 75) in your 2D world may map to the pixel
	 * (10, 50) of your render-window -- if the view is translated by (140, 25).
	 *
	 * This version uses a custom view for calculations, see the other
	 * overload of the function if you want to use the current view of the
	 * render-window.
	 *
	 * @param renderWindow Render window object
	 * @param point Point to convert
	 * @param view The view to use for converting the point
	 *
	 * @return The converted point, in target coordinates (pixels)
	 *
	*/
	public Vector2i sfRenderWindow_mapCoordsToPixel(Pointer/*(sfRenderWindow*)*/ renderWindow,  Vector2f point, Pointer/*(  sfView*)*/ view);

	/**
	 * @brief Draw a drawable object to the render-target
	 *
	 * @param renderWindow render window object
	 * @param object       Object to draw
	 * @param states       Render states to use for drawing (NULL to use the default states)
	 *
	*/
	public void sfRenderWindow_drawSprite(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfSprite*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderWindow_drawText(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfText*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderWindow_drawShape(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfShape*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderWindow_drawCircleShape(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfCircleShape*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderWindow_drawConvexShape(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfConvexShape*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderWindow_drawRectangleShape(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfRectangleShape*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderWindow_drawVertexArray(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfVertexArray*)*/ object, Pointer/*(  sfRenderStates*)*/ states);
	public void sfRenderWindow_drawVertexBuffer(Pointer/*(sfRenderWindow*)*/ renderWindow, Pointer/*(  sfVertexBuffer*)*/ object, Pointer/*(  sfRenderStates*)*/ states);

	/**
	 * @brief Draw primitives defined by an array of vertices to a render window
	 *
	 * @param renderWindow render window object
	 * @param vertices     Pointer to the vertices
	 * @param vertexCount  Number of vertices in the array
	 * @param type         Type of primitives to draw
	 * @param states       Render states to use for drawing (NULL to use the default states)
	 *
	*/

	/**
	 * @brief Save the current OpenGL render states and matrices
	 *
	 * This function can be used when you mix SFML drawing
	 * and direct OpenGL rendering. Combined with popGLStates,
	 * it ensures that:
	 * @li SFML's internal states are not messed up by your OpenGL code
	 * @li your OpenGL states are not modified by a call to a SFML function
	 *
	 * Note that this function is quite expensive: it saves all the
	 * possible OpenGL states and matrices, even the ones you
	 * don't care about. Therefore it should be used wisely.
	 * It is provided for convenience, but the best results will
	 * be achieved if you handle OpenGL states yourself (because
	 * you know which states have really changed, and need to be
	 * saved and restored). Take a look at the resetGLStates
	 * function if you do so.
	 *
	 * @param renderWindow render window object
	 *
	*/
	public void sfRenderWindow_pushGLStates(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Restore the previously saved OpenGL render states and matrices
	 *
	 * See the description of pushGLStates to get a detailed
	 * description of these functions.
	 *
	 * @param renderWindow render window object
	 *
	*/
	public void sfRenderWindow_popGLStates(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Reset the internal OpenGL states so that the target is ready for drawing
	 *
	 * This function can be used when you mix SFML drawing
	 * and direct OpenGL rendering, if you choose not to use
	 * pushGLStatespopGLStates. It makes sure that all OpenGL
	 * states needed by SFML are set, so that subsequent sfRenderWindow_draw*()
	 * calls will work as expected.
	 *
	 * @param renderWindow render window object
	 *
	*/
	public void sfRenderWindow_resetGLStates(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Copy the current contents of the window to an image
	 *
	 * @deprecated
	 * Use a sfTexture and its
	 * sfTexture_updateFromRenderWindow(sfTexture*, const sfRenderWindow*, unsigned int, unsigned int)
	 * function and copy its contents into an sfImage instead.
	 * @code
	 * sfVector2u windowSize = sfRenderWindow_getSize(window);
	 * sfTexture* texture = sfTexture_create(windowSize.x, windowSize.y);
	 * sfTexture_updateFromRenderWindow(texture, window, windowSize.x, windowSize.y);
	 * sfImage* screenshot = sfTexture_copyToImage(texture);
	 * @endcode
	 *
	 * This is a slow operation, whose main purpose is to make
	 * screenshots of the application. If you want to update an
	 * image with the contents of the window and then use it for
	 * drawing, you should rather use a sfTexture and the
	 * sfTexture_updateFromWindow(sfTexture*, const sfWindow*, unsigned int, unsigned int) function.
	 * You can also draw things directly to a texture with the
	 * sfRenderTexture class.
	 *
	 * @return sfImage containing the captured contents.
	 *
	*/
	public Pointer/*(sfImage*)*/ sfRenderWindow_capture(Pointer/*(sfRenderWindow*)*/ renderWindow);

	/**
	 * @brief Get the current position of the mouse relative to a render-window
	 *
	 * This function returns the current position of the mouse
	 * cursor relative to the given render-window, or desktop if NULL is passed.
	 *
	 * @param relativeTo Reference window
	 *
	 * @return Position of the mouse cursor, relative to the given render window
	 *
	*/
	public Vector2i sfMouse_getPositionRenderWindow(Pointer/*(sfRenderWindow*)*/ relativeTo);

	/**
	 * @brief Set the current position of the mouse relative to a render window
	 *
	 * This function sets the current position of the mouse
	 * cursor relative to the given render-window, or desktop if NULL is passed.
	 *
	 * @param position   New position of the mouse
	 * @param relativeTo Reference window
	 *
	*/
	public void sfMouse_setPositionRenderWindow(Vector2i position, Pointer/*(  sfRenderWindow*)*/ relativeTo);

	/**
	 * @brief Get the current position of a touch in window coordinates
	 *
	 * This function returns the current touch position
	 * relative to the given render window, or desktop if NULL is passed.
	 *
	 * @param finger Finger index
	 * @param relativeTo Reference window
	 *
	 * @return Current position of @a finger, or undefined if it's not down
	 *
	*/
	public Vector2i sfTouch_getPositionRenderWindow(/*unsigned*/ int finger, Pointer/*(  sfRenderWindow*)*/ relativeTo);

	// Shader.h

	/**
	 * Headers
	*/

	/**
	 * @brief Load the vertex, geometry and fragment shaders from files
	 *
	 * This function loads the vertex, geometry and fragment
	 * shaders. Pass NULL if you don't want to load
	 * a specific shader.
	 * The sources must be text files containing valid shaders
	 * in GLSL language. GLSL is a C-like language dedicated to
	 * OpenGL shaders; you'll probably need to read a good documentation
	 * for it before writing your own shaders.
	 *
	 * @param vertexShaderFilename   Path of the vertex shader file to load, or NULL to skip this shader
	 * @param geometryShaderFilename Path of the geometry shader file to load, or NULL to skip this shader
	 * @param fragmentShaderFilename Path of the fragment shader file to load, or NULL to skip this shader
	 *
	 * @return A new sfShader object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfShader*)*/ sfShader_createFromFile(String/*(char*)*/ vertexShaderFilename, String/*(  char*)*/ geometryShaderFilename, String/*(  char*)*/ fragmentShaderFilename);

	/**
	 * @brief Load the vertex, geometry and fragment shaders from source code in memory
	 *
	 * This function loads the vertex, geometry and fragment
	 * shaders. Pass NULL if you don't want to load
	 * a specific shader.
	 * The sources must be valid shaders in GLSL language. GLSL is
	 * a C-like language dedicated to OpenGL shaders; you'll
	 * probably need to read a good documentation for it before
	 * writing your own shaders.
	 *
	 * @param vertexShader   String containing the source code of the vertex shader, or NULL to skip this shader
	 * @param geometryShader String containing the source code of the geometry shader, or NULL to skip this shader
	 * @param fragmentShader String containing the source code of the fragment shader, or NULL to skip this shader
	 *
	 * @return A new sfShader object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfShader*)*/ sfShader_createFromMemory(String/*(char*)*/ vertexShader, String/*(  char*)*/ geometryShader, String/*(  char*)*/ fragmentShader);

	/**
	 * @brief Load the vertex, geometry and fragment shaders from custom streams
	 *
	 * This function loads the vertex, geometry and fragment
	 * shaders. Pass NULL if you don't want to load
	 * a specific shader.
	 * The source codes must be valid shaders in GLSL language.
	 * GLSL is a C-like language dedicated to OpenGL shaders;
	 * you'll probably need to read a good documentation for
	 * it before writing your own shaders.
	 *
	 * @param vertexShaderStream   Source stream to read the vertex shader from, or NULL to skip this shader
	 * @param geometryShaderStream Source stream to read the geometry shader from, or NULL to skip this shader
	 * @param fragmentShaderStream Source stream to read the fragment shader from, or NULL to skip this shader
	 *
	 * @return A new sfShader object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfShader*)*/ sfShader_createFromStream(Pointer/*(sfInputStream*)*/ vertexShaderStream, Pointer/*( sfInputStream*)*/ geometryShaderStream, Pointer/*( sfInputStream*)*/ fragmentShaderStream);

	/**
	 * @brief Destroy an existing shader
	 *
	 * @param shader Shader to delete
	 *
	*/
	public void sfShader_destroy(Pointer/*(sfShader*)*/ shader);

	/**
	 * @brief Specify value for @p float uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param x      Value of the float scalar
	 *
	*/
	public void sfShader_setFloatUniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  float x);

	/**
	 * @brief Specify value for @p vec2 uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param vector Value of the vec2 vector
	 *
	*/
	public void sfShader_setVec2Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  Vector2f vector);

	/**
	 * @brief Specify value for @p vec3 uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param vector Value of the vec3 vector
	 *
	*/
	public void sfShader_setVec3Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  Vector3f vector);

	/**
	 * @brief Specify value for @p vec4 uniform
	 *
	 * sfColor objects can be passed to this function via
	 * the use of sfGlslVec4_fromsfColor(sfColor);
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param vector Value of the vec4 vector
	 *
	*/
	public void sfShader_setVec4Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  GlslVec4 vector);

	/**
	 * @brief Specify value for @p vec4 uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param color  Value of the vec4 vector
	 *
	*/
	public void sfShader_setColorUniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  Color color);

	/**
	 * @brief Specify value for @p int uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param x      Value of the integer scalar
	 *
	*/
	public void sfShader_setIntUniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  int x);

	/**
	 * @brief Specify value for @p ivec2 uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param vector Value of the ivec2 vector
	 *
	*/
	public void sfShader_setIvec2Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  Vector2i vector);

	/**
	 * @brief Specify value for @p ivec3 uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param vector Value of the ivec3 vector
	 *
	*/
	public void sfShader_setIvec3Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  GlslIvec3 vector);

	/**
	 * @brief Specify value for @p ivec4 uniform
	 *
	 * sfColor objects can be passed to this function via
	 * the use of sfGlslIvec4_fromsfColor(sfColor);
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param vector Value of the ivec4 vector
	 *
	*/
	public void sfShader_setIvec4Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  GlslIvec4 vector);

	/**
	 * @brief Specify value for @p ivec4 uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param color  Value of the ivec4 vector
	 *
	*/
	public void sfShader_setIntColorUniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  Color color);

	/**
	 * @brief Specify value for @p bool uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param x      Value of the bool scalar
	 *
	*/
	public void sfShader_setBoolUniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  int x);

	/**
	 * @brief Specify value for @p bvec2 uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param vector Value of the bvec2 vector
	 *
	*/
	public void sfShader_setBvec2Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  GlslBvec2 vector);

	/**
	 * @brief Specify value for @p Bvec3 uniform
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param vector Value of the Bvec3 vector
	 *
	*/
	public void sfShader_setBvec3Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  GlslBvec3 vector);

	/**
	 * @brief Specify value for @p bvec4 uniform
	 *
	 * sfColor objects can be passed to this function via
	 * the use of sfGlslIvec4_fromsfColor(sfColor);
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param vector Value of the bvec4 vector
	 *
	*/
	public void sfShader_setBvec4Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  GlslBvec4 vector);

	/**
	 * @brief Specify value for @p mat3 matrix
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param matrix Value of the mat3 matrix
	 *
	*/
	public void sfShader_setMat3Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  sfGlslMat3*)*/ matrix);

	/**
	 * @brief Specify value for @p mat4 matrix
	 *
	 * @param shader Shader object
	 * @param name   Name of the uniform variable in GLSL
	 * @param matrix Value of the mat4 matrix
	 *
	*/
	public void sfShader_setMat4Uniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  sfGlslMat4*)*/ matrix);

	/**
	 * @brief Specify a texture as @p sampler2D uniform
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a 2D texture
	 * (@p sampler2D GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform sampler2D the_texture;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfTexture texture;
	 * ...
	 * sfShader_setTextureUniform(shader, "the_texture", &texture);
	 * @endcode
	 * It is important to note that @a texture must remain alive as long
	 * as the shader uses it, no copy is made internally.
	 *
	 * To use the texture of the object being drawn, which cannot be
	 * known in advance, you can pass the special value
	 * sf::Shader::CurrentTexture:
	 * @code
	 * shader.setUniform("the_texture", sf::Shader::CurrentTexture).
	 * @endcode
	 *
	 * @param shader  Shader object
	 * @param name    Name of the texture in the shader
	 * @param texture Texture to assign
	 *
	*/
	public void sfShader_setTextureUniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  sfTexture*)*/ texture);

	/**
	 * @brief Specify current texture as @p sampler2D uniform
	 *
	 * This overload maps a shader texture variable to the
	 * texture of the object being drawn, which cannot be
	 * known in advance.
	 * The corresponding parameter in the shader must be a 2D texture
	 * (@p sampler2D GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform sampler2D current;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfShader_setCurrentTextureUniform(shader, "current");
	 * @endcode
	 *
	 * @param shader Shader object
	 * @param name   Name of the texture in the shader
	 *
	*/
	public void sfShader_setCurrentTextureUniform(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name);

	/**
	 * @brief Specify values for @p float[] array uniform
	 *
	 * @param shader      Shader object
	 * @param name        Name of the uniform variable in GLSL
	 * @param scalarArray pointer to array of @p float values
	 * @param length      Number of elements in the array
	 *
	*/
	public void sfShader_setFloatUniformArray(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  float*)*/ scalarArray,  int length);

	/**
	 * @brief Specify values for @p vec2[] array uniform
	 *
	 * @param shader      Shader object
	 * @param name        Name of the uniform variable in GLSL
	 * @param vectorArray pointer to array of @p vec2 values
	 * @param length      Number of elements in the array
	 *
	*/
	public void sfShader_setVec2UniformArray(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  sfGlslVec2*)*/ vectorArray,  int length);

	/**
	 * @brief Specify values for @p vec3[] array uniform
	 *
	 * @param shader      Shader object
	 * @param name        Name of the uniform variable in GLSL
	 * @param vectorArray pointer to array of @p vec3 values
	 * @param length      Number of elements in the array
	 *
	*/
	public void sfShader_setVec3UniformArray(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  sfGlslVec3*)*/ vectorArray,  int length);

	/**
	 * @brief Specify values for @p vec4[] array uniform
	 *
	 * @param shader      Shader object
	 * @param name        Name of the uniform variable in GLSL
	 * @param vectorArray pointer to array of @p vec4 values
	 * @param length      Number of elements in the array
	 *
	*/
	public void sfShader_setVec4UniformArray(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  sfGlslVec4*)*/ vectorArray,  int length);

	/**
	 * @brief Specify values for @p mat3[] array uniform
	 *
	 * @param shader      Shader object
	 * @param name        Name of the uniform variable in GLSL
	 * @param matrixArray pointer to array of @p mat3 values
	 * @param length      Number of elements in the array
	 *
	*/
	public void sfShader_setMat3UniformArray(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  sfGlslMat3*)*/ matrixArray,  int length);

	/**
	 * @brief Specify values for @p mat4[] array uniform
	 *
	 * @param shader      Shader object
	 * @param name        Name of the uniform variable in GLSL
	 * @param matrixArray pointer to array of @p mat4 values
	 * @param length      Number of elements in the array
	 *
	*/
	public void sfShader_setMat4UniformArray(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  sfGlslMat4*)*/ matrixArray,  int length);

	/**
	 * @brief Change a float parameter of a shader
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a float
	 * (float GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform float myparam;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfShader_setFloatParameter(shader, "myparam", 5.2f);
	 * @endcode
	 *
	 * @param shader Shader object
	 * @param name   Name of the parameter in the shader
	 * @param x      Value to assign
	 *
	*/
	public void sfShader_setFloatParameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  float x);

	/**
	 * @brief Change a 2-components vector parameter of a shader
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a 2x1 vector
	 * (vec2 GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform vec2 myparam;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfShader_setFloat2Parameter(shader, "myparam", 5.2f, 6.0f);
	 * @endcode
	 *
	 * @param shader Shader object
	 * @param name   Name of the parameter in the shader
	 * @param x      First component of the value to assign
	 * @param y      Second component of the value to assign
	 *
	*/
	public void sfShader_setFloat2Parameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  float x,  float y);

	/**
	 * @brief Change a 3-components vector parameter of a shader
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a 3x1 vector
	 * (vec3 GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform vec3 myparam;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfShader_setFloat3Parameter(shader, "myparam", 5.2f, 6.0f, -8.1f);
	 * @endcode
	 *
	 * @param shader Shader object
	 * @param name   Name of the parameter in the shader
	 * @param x      First component of the value to assign
	 * @param y      Second component of the value to assign
	 * @param z      Third component of the value to assign
	 *
	*/
	public void sfShader_setFloat3Parameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  float x,  float y,  float z);

	/**
	 * @brief Change a 4-components vector parameter of a shader
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a 4x1 vector
	 * (vec4 GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform vec4 myparam;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfShader_setFloat4Parameter(shader, "myparam", 5.2f, 6.0f, -8.1f, 0.4f);
	 * @endcode
	 *
	 * @param shader Shader object
	 * @param name   Name of the parameter in the shader
	 * @param x      First component of the value to assign
	 * @param y      Second component of the value to assign
	 * @param z      Third component of the value to assign
	 * @param w      Fourth component of the value to assign
	 *
	*/
	public void sfShader_setFloat4Parameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  float x,  float y,  float z,  float w);

	/**
	 * @brief Change a 2-components vector parameter of a shader
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a 2x1 vector
	 * (vec2 GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform vec2 myparam;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfVector2f vec = {5.2f, 6.0f};
	 * sfShader_setVector2Parameter(shader, "myparam", vec);
	 * @endcode
	 *
	 * @param shader Shader object
	 * @param name   Name of the parameter in the shader
	 * @param vector Vector to assign
	 *
	*/
	public void sfShader_setVector2Parameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  Vector2f vector);

	/**
	 * @brief Change a 3-components vector parameter of a shader
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a 3x1 vector
	 * (vec3 GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform vec3 myparam;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfVector3f vec = {5.2f, 6.0f, -8.1f};
	 * sfShader_setVector3Parameter(shader, "myparam", vec);
	 * @endcode
	 *
	 * @param shader Shader object
	 * @param name   Name of the parameter in the shader
	 * @param vector Vector to assign
	 *
	*/
	public void sfShader_setVector3Parameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  Vector3f vector);

	/**
	 * @brief Change a color parameter of a shader
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a 4x1 vector
	 * (vec4 GLSL type).
	 *
	 * It is important to note that the components of the color are
	 * normalized before being passed to the shader. Therefore,
	 * they are converted from range [0 .. 255] to range [0 .. 1].
	 * For example, a sf::Color(255, 125, 0, 255) will be transformed
	 * to a vec4(1.0, 0.5, 0.0, 1.0) in the shader.
	 *
	 * Example:
	 * @code
	 * uniform vec4 color;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfShader_setColorParameter(shader, "color", sfColor_fromRGB(255, 128, 0));
	 * @endcode
	 *
	 * @param shader Shader object
	 * @param name   Name of the parameter in the shader
	 * @param color  Color to assign
	 *
	*/
	public void sfShader_setColorParameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  Color color);

	/**
	 * @brief Change a matrix parameter of a shader
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a 4x4 matrix
	 * (mat4 GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform mat4 matrix;  this is the variable in the shader
	 * @endcode
	 * @code
	 * @todo
	 * sfShader_setTransformParameter(shader, "matrix", transform);
	 * @endcode
	 *
	 * @param shader    Shader object
	 * @param name      Name of the parameter in the shader
	 * @param transform Transform to assign
	 *
	*/
	public void sfShader_setTransformParameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name,  Transform transform);

	/**
	 * @brief Change a texture parameter of a shader
	 *
	 * @a name is the name of the variable to change in the shader.
	 * The corresponding parameter in the shader must be a 2D texture
	 * (sampler2D GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform sampler2D the_texture;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sf::Texture texture;
	 * ...
	 * sfShader_setTextureParameter(shader, "the_texture", texture);
	 * @endcode
	 * It is important to note that @a texture must remain alive as long
	 * as the shader uses it, no copy is made internally.
	 *
	 * To use the texture of the object being draw, which cannot be
	 * known in advance, you can use the special function
	 * sfShader_setCurrentTextureParameter:
	 * @code
	 * sfShader_setCurrentTextureParameter(shader, "the_texture").
	 * @endcode
	 *
	 * @param shader  Shader object
	 * @param name    Name of the texture in the shader
	 * @param texture Texture to assign
	 *
	*/
	public void sfShader_setTextureParameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name, Pointer/*(  sfTexture*)*/ texture);

	/**
	 * @brief Change a texture parameter of a shader
	 *
	 * This function maps a shader texture variable to the
	 * texture of the object being drawn, which cannot be
	 * known in advance.
	 * The corresponding parameter in the shader must be a 2D texture
	 * (sampler2D GLSL type).
	 *
	 * Example:
	 * @code
	 * uniform sampler2D current;  this is the variable in the shader
	 * @endcode
	 * @code
	 * sfShader_setCurrentTextureParameter(shader, "current");
	 * @endcode
	 *
	 * @param shader Shader object
	 * @param name   Name of the texture in the shader
	 *
	*/
	public void sfShader_setCurrentTextureParameter(Pointer/*(sfShader*)*/ shader, String/*(  char*)*/ name);

	/**
	 * @brief Get the underlying OpenGL handle of the shader.
	 *
	 * You shouldn't need to use this function, unless you have
	 * very specific stuff to implement that SFML doesn't support,
	 * or implement a temporary workaround until a bug is fixed.
	 *
	 * @param shader Shader object
	 *
	 * @return OpenGL handle of the shader or 0 if not yet loaded
	 *
	*/
	public /*unsigned*/ int sfShader_getNativeHandle(Pointer/*(sfShader*)*/ shader);

	/**
	 * @brief Bind a shader for rendering (activate it)
	 *
	 * This function is not part of the graphics API, it mustn't be
	 * used when drawing SFML entities. It must be used only if you
	 * mix sfShader with OpenGL code.
	 *
	 * @code
	 * sfShader *s1, *s2;
	 * ...
	 * sfShader_bind(s1);
	 *  draw OpenGL stuff that use s1...
	 * sfShader_bind(s2);
	 *  draw OpenGL stuff that use s2...
	 * sfShader_bind(0);
	 *  draw OpenGL stuff that use no shader...
	 * @endcode
	 *
	 * @param shader Shader to bind, can be null to use no shader
	 *
	*/
	public void sfShader_bind(Pointer/*(sfShader*)*/ shader);

	/**
	 * @brief Tell whether or not the system supports shaders
	 *
	 * This function should always be called before using
	 * the shader features. If it returns false, then
	 * any attempt to use sfShader will fail.
	 *
	 * @return sfTrue if the system can use shaders, sfFalse otherwise
	 *
	*/
	public int sfShader_isAvailable();

	/**
	 * @brief Tell whether or not the system supports geometry shaders
	 *
	 * This function should always be called before using
	 * the geometry shader features. If it returns false, then
	 * any attempt to use sfShader geometry shader features will fail.
	 *
	 * This function can only return true if isAvailable() would also
	 * return true, since shaders in general have to be supported in
	 * order for geometry shaders to be supported as well.
	 *
	 * Note: The first call to this function, whether by your
	 * code or SFML will result in a context switch.
	 *
	 * @return True if geometry shaders are supported, false otherwise
	 *
	*/
	public int sfShader_isGeometryAvailable();

	// Shape.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a new shape
	 *
	 * @param getPointCount Callback that provides the point count of the shape
	 * @param getPoint      Callback that provides the points of the shape
	 * @param userData      Data to pass to the callback functions
	 *
	 * @return A new sfShape object
	 *
	*/

	/**
	 * @brief Destroy an existing shape
	 *
	 * @param shape Shape to delete
	 *
	*/
	public void sfShape_destroy(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Set the position of a shape
	 *
	 * This function completely overwrites the previous position.
	 * See sfShape_move to apply an offset based on the previous position instead.
	 * The default position of a circle Shape object is (0, 0).
	 *
	 * @param shape    Shape object
	 * @param position New position
	 *
	*/
	public void sfShape_setPosition(Pointer/*(sfShape*)*/ shape,  Vector2f position);

	/**
	 * @brief Set the orientation of a shape
	 *
	 * This function completely overwrites the previous rotation.
	 * See sfShape_rotate to add an angle based on the previous rotation instead.
	 * The default rotation of a circle Shape object is 0.
	 *
	 * @param shape Shape object
	 * @param angle New rotation, in degrees
	 *
	*/
	public void sfShape_setRotation(Pointer/*(sfShape*)*/ shape,  float angle);

	/**
	 * @brief Set the scale factors of a shape
	 *
	 * This function completely overwrites the previous scale.
	 * See sfShape_scale to add a factor based on the previous scale instead.
	 * The default scale of a circle Shape object is (1, 1).
	 *
	 * @param shape Shape object
	 * @param scale New scale factors
	 *
	*/
	public void sfShape_setScale(Pointer/*(sfShape*)*/ shape,  Vector2f scale);

	/**
	 * @brief Set the local origin of a shape
	 *
	 * The origin of an object defines the center point for
	 * all transformations (position, scale, rotation).
	 * The coordinates of this point must be relative to the
	 * top-left corner of the object, and ignore all
	 * transformations (position, scale, rotation).
	 * The default origin of a circle Shape object is (0, 0).
	 *
	 * @param shape  Shape object
	 * @param origin New origin
	 *
	*/
	public void sfShape_setOrigin(Pointer/*(sfShape*)*/ shape,  Vector2f origin);

	/**
	 * @brief Get the position of a shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current position
	 *
	*/
	public Vector2f sfShape_getPosition(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the orientation of a shape
	 *
	 * The rotation is always in the range [0, 360].
	 *
	 * @param shape Shape object
	 *
	 * @return Current rotation, in degrees
	 *
	*/
	public float sfShape_getRotation(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the current scale of a shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current scale factors
	 *
	*/
	public Vector2f sfShape_getScale(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the local origin of a shape
	 *
	 * @param shape Shape object
	 *
	 * @return Current origin
	 *
	*/
	public Vector2f sfShape_getOrigin(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Move a shape by a given offset
	 *
	 * This function adds to the current position of the object,
	 * unlike sfShape_setPosition which overwrites it.
	 *
	 * @param shape  Shape object
	 * @param offset Offset
	 *
	*/
	public void sfShape_move(Pointer/*(sfShape*)*/ shape,  Vector2f offset);

	/**
	 * @brief Rotate a shape
	 *
	 * This function adds to the current rotation of the object,
	 * unlike sfShape_setRotation which overwrites it.
	 *
	 * @param shape Shape object
	 * @param angle Angle of rotation, in degrees
	 *
	*/
	public void sfShape_rotate(Pointer/*(sfShape*)*/ shape,  float angle);

	/**
	 * @brief Scale a shape
	 *
	 * This function multiplies the current scale of the object,
	 * unlike sfShape_setScale which overwrites it.
	 *
	 * @param shape   Shape object
	 * @param factors Scale factors
	 *
	*/
	public void sfShape_scale(Pointer/*(sfShape*)*/ shape,  Vector2f factors);

	/**
	 * @brief Get the combined transform of a shape
	 *
	 * @param shape shape object
	 *
	 * @return Transform combining the positionrotationscaleorigin of the object
	 *
	*/
	public Transform sfShape_getTransform(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the inverse of the combined transform of a shape
	 *
	 * @param shape shape object
	 *
	 * @return Inverse of the combined transformations applied to the object
	 *
	*/
	public Transform sfShape_getInverseTransform(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Change the source texture of a shape
	 *
	 * The @a texture argument refers to a texture that must
	 * exist as long as the shape uses it. Indeed, the shape
	 * doesn't store its own copy of the texture, but rather keeps
	 * a pointer to the one that you passed to this function.
	 * If the source texture is destroyed and the shape tries to
	 * use it, the behaviour is undefined.
	 * @a texture can be NULL to disable texturing.
	 * If @a resetRect is true, the TextureRect property of
	 * the shape is automatically adjusted to the size of the new
	 * texture. If it is false, the texture rect is left unchanged.
	 *
	 * @param shape     Shape object
	 * @param texture   New texture
	 * @param resetRect Should the texture rect be reset to the size of the new texture?
	 *
	*/
	public void sfShape_setTexture(Pointer/*(sfShape*)*/ shape, Pointer/*(  sfTexture*)*/ texture,  int resetRect);

	/**
	 * @brief Set the sub-rectangle of the texture that a shape will display
	 *
	 * The texture rect is useful when you don't want to display
	 * the whole texture, but rather a part of it.
	 * By default, the texture rect covers the entire texture.
	 *
	 * @param shape Shape object
	 * @param rect  Rectangle defining the region of the texture to display
	 *
	*/
	public void sfShape_setTextureRect(Pointer/*(sfShape*)*/ shape,  IntRect rect);

	/**
	 * @brief Set the fill color of a shape
	 *
	 * This color is modulated (multiplied) with the shape's
	 * texture if any. It can be used to colorize the shape,
	 * or change its global opacity.
	 * You can use sfTransparent to make the inside of
	 * the shape transparent, and have the outline alone.
	 * By default, the shape's fill color is opaque white.
	 *
	 * @param shape Shape object
	 * @param color New color of the shape
	 *
	*/
	public void sfShape_setFillColor(Pointer/*(sfShape*)*/ shape,  Color color);

	/**
	 * @brief Set the outline color of a shape
	 *
	 * You can use sfTransparent to disable the outline.
	 * By default, the shape's outline color is opaque white.
	 *
	 * @param shape Shape object
	 * @param color New outline color of the shape
	 *
	*/
	public void sfShape_setOutlineColor(Pointer/*(sfShape*)*/ shape,  Color color);

	/**
	 * @brief Set the thickness of a shape's outline
	 *
	 * This number cannot be negative. Using zero disables
	 * the outline.
	 * By default, the outline thickness is 0.
	 *
	 * @param shape     Shape object
	 * @param thickness New outline thickness
	 *
	*/
	public void sfShape_setOutlineThickness(Pointer/*(sfShape*)*/ shape,  float thickness);

	/**
	 * @brief Get the source texture of a shape
	 *
	 * If the shape has no source texture, a NULL pointer is returned.
	 * The returned pointer is const, which means that you can't
	 * modify the texture when you retrieve it with this function.
	 *
	 * @param shape Shape object
	 *
	 * @return Pointer to the shape's texture
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfShape_getTexture(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the sub-rectangle of the texture displayed by a shape
	 *
	 * @param shape Shape object
	 *
	 * @return Texture rectangle of the shape
	 *
	*/
	public IntRect sfShape_getTextureRect(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the fill color of a shape
	 *
	 * @param shape Shape object
	 *
	 * @return Fill color of the shape
	 *
	*/
	public Color sfShape_getFillColor(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the outline color of a shape
	 *
	 * @param shape Shape object
	 *
	 * @return Outline color of the shape
	 *
	*/
	public Color sfShape_getOutlineColor(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the outline thickness of a shape
	 *
	 * @param shape Shape object
	 *
	 * @return Outline thickness of the shape
	 *
	*/
	public float sfShape_getOutlineThickness(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the total number of points of a shape
	 *
	 * @param shape Shape object
	 *
	 * @return Number of points of the shape
	 *
	*/
	public int sfShape_getPointCount(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get a point of a shape
	 *
	 * The result is undefined if @a index is out of the valid range.
	 *
	 * @param shape Shape object
	 * @param index Index of the point to get, in range [0 .. getPointCount() - 1]
	 *
	 * @return Index-th point of the shape
	 *
	*/
	public Vector2f sfShape_getPoint(Pointer/*(sfShape*)*/ shape,  int index);

	/**
	 * @brief Get the local bounding rectangle of a shape
	 *
	 * The returned rectangle is in local coordinates, which means
	 * that it ignores the transformations (translation, rotation,
	 * scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * entity in the entity's coordinate system.
	 *
	 * @param shape Shape object
	 *
	 * @return Local bounding rectangle of the entity
	 *
	*/
	public FloatRect sfShape_getLocalBounds(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Get the global bounding rectangle of a shape
	 *
	 * The returned rectangle is in global coordinates, which means
	 * that it takes in account the transformations (translation,
	 * rotation, scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * sprite in the global 2D world's coordinate system.
	 *
	 * @param shape Shape object
	 *
	 * @return Global bounding rectangle of the entity
	 *
	*/
	public FloatRect sfShape_getGlobalBounds(Pointer/*(sfShape*)*/ shape);

	/**
	 * @brief Recompute the internal geometry of a shape
	 *
	 * This function must be called by specialized shape objects
	 * everytime their points change (ie. the result of either
	 * the getPointCount or getPoint callbacks is different).
	 *
	*/
	public void sfShape_update(Pointer/*(sfShape*)*/ shape);

	// Sprite.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a new sprite
	 *
	 * @return A new sfSprite object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfSprite*)*/ sfSprite_create();

	/**
	 * @brief Copy an existing sprite
	 *
	 * @param sprite Sprite to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfSprite*)*/ sfSprite_copy(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Destroy an existing sprite
	 *
	 * @param sprite Sprite to delete
	 *
	*/
	public void sfSprite_destroy(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Set the position of a sprite
	 *
	 * This function completely overwrites the previous position.
	 * See sfSprite_move to apply an offset based on the previous position instead.
	 * The default position of a sprite Sprite object is (0, 0).
	 *
	 * @param sprite   Sprite object
	 * @param position New position
	 *
	*/
	public void sfSprite_setPosition(Pointer/*(sfSprite*)*/ sprite,  Vector2f position);

	/**
	 * @brief Set the orientation of a sprite
	 *
	 * This function completely overwrites the previous rotation.
	 * See sfSprite_rotate to add an angle based on the previous rotation instead.
	 * The default rotation of a sprite Sprite object is 0.
	 *
	 * @param sprite Sprite object
	 * @param angle  New rotation, in degrees
	 *
	*/
	public void sfSprite_setRotation(Pointer/*(sfSprite*)*/ sprite,  float angle);

	/**
	 * @brief Set the scale factors of a sprite
	 *
	 * This function completely overwrites the previous scale.
	 * See sfSprite_scale to add a factor based on the previous scale instead.
	 * The default scale of a sprite Sprite object is (1, 1).
	 *
	 * @param sprite Sprite object
	 * @param scale  New scale factors
	 *
	*/
	public void sfSprite_setScale(Pointer/*(sfSprite*)*/ sprite,  Vector2f scale);

	/**
	 * @brief Set the local origin of a sprite
	 *
	 * The origin of an object defines the center point for
	 * all transformations (position, scale, rotation).
	 * The coordinates of this point must be relative to the
	 * top-left corner of the object, and ignore all
	 * transformations (position, scale, rotation).
	 * The default origin of a sprite Sprite object is (0, 0).
	 *
	 * @param sprite Sprite object
	 * @param origin New origin
	 *
	*/
	public void sfSprite_setOrigin(Pointer/*(sfSprite*)*/ sprite,  Vector2f origin);

	/**
	 * @brief Get the position of a sprite
	 *
	 * @param sprite Sprite object
	 *
	 * @return Current position
	 *
	*/
	public Vector2f sfSprite_getPosition(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Get the orientation of a sprite
	 *
	 * The rotation is always in the range [0, 360].
	 *
	 * @param sprite Sprite object
	 *
	 * @return Current rotation, in degrees
	 *
	*/
	public float sfSprite_getRotation(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Get the current scale of a sprite
	 *
	 * @param sprite Sprite object
	 *
	 * @return Current scale factors
	 *
	*/
	public Vector2f sfSprite_getScale(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Get the local origin of a sprite
	 *
	 * @param sprite Sprite object
	 *
	 * @return Current origin
	 *
	*/
	public Vector2f sfSprite_getOrigin(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Move a sprite by a given offset
	 *
	 * This function adds to the current position of the object,
	 * unlike sfSprite_setPosition which overwrites it.
	 *
	 * @param sprite Sprite object
	 * @param offset Offset
	 *
	*/
	public void sfSprite_move(Pointer/*(sfSprite*)*/ sprite,  Vector2f offset);

	/**
	 * @brief Rotate a sprite
	 *
	 * This function adds to the current rotation of the object,
	 * unlike sfSprite_setRotation which overwrites it.
	 *
	 * @param sprite Sprite object
	 * @param angle  Angle of rotation, in degrees
	 *
	*/
	public void sfSprite_rotate(Pointer/*(sfSprite*)*/ sprite,  float angle);

	/**
	 * @brief Scale a sprite
	 *
	 * This function multiplies the current scale of the object,
	 * unlike sfSprite_setScale which overwrites it.
	 *
	 * @param sprite  Sprite object
	 * @param factors Scale factors
	 *
	*/
	public void sfSprite_scale(Pointer/*(sfSprite*)*/ sprite,  Vector2f factors);

	/**
	 * @brief Get the combined transform of a sprite
	 *
	 * @param sprite Sprite object
	 *
	 * @return Transform combining the positionrotationscaleorigin of the object
	 *
	*/
	public Transform sfSprite_getTransform(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Get the inverse of the combined transform of a sprite
	 *
	 * @param sprite Sprite object
	 *
	 * @return Inverse of the combined transformations applied to the object
	 *
	*/
	public Transform sfSprite_getInverseTransform(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Change the source texture of a sprite
	 *
	 * The @a texture argument refers to a texture that must
	 * exist as long as the sprite uses it. Indeed, the sprite
	 * doesn't store its own copy of the texture, but rather keeps
	 * a pointer to the one that you passed to this function.
	 * If the source texture is destroyed and the sprite tries to
	 * use it, the behaviour is undefined.
	 * If @a resetRect is true, the TextureRect property of
	 * the sprite is automatically adjusted to the size of the new
	 * texture. If it is false, the texture rect is left unchanged.
	 *
	 * @param sprite    Sprite object
	 * @param texture   New texture
	 * @param resetRect Should the texture rect be reset to the size of the new texture?
	 *
	*/
	public void sfSprite_setTexture(Pointer/*(sfSprite*)*/ sprite, Pointer/*(  sfTexture*)*/ texture,  int resetRect);

	/**
	 * @brief Set the sub-rectangle of the texture that a sprite will display
	 *
	 * The texture rect is useful when you don't want to display
	 * the whole texture, but rather a part of it.
	 * By default, the texture rect covers the entire texture.
	 *
	 * @param sprite    Sprite object
	 * @param rectangle Rectangle defining the region of the texture to display
	 *
	*/
	public void sfSprite_setTextureRect(Pointer/*(sfSprite*)*/ sprite,  IntRect rectangle);

	/**
	 * @brief Set the global color of a sprite
	 *
	 * This color is modulated (multiplied) with the sprite's
	 * texture. It can be used to colorize the sprite, or change
	 * its global opacity.
	 * By default, the sprite's color is opaque white.
	 *
	 * @param sprite Sprite object
	 * @param color  New color of the sprite
	 *
	*/
	public void sfSprite_setColor(Pointer/*(sfSprite*)*/ sprite,  Color color);

	/**
	 * @brief Get the source texture of a sprite
	 *
	 * If the sprite has no source texture, a NULL pointer is returned.
	 * The returned pointer is const, which means that you can't
	 * modify the texture when you retrieve it with this function.
	 *
	 * @param sprite Sprite object
	 *
	 * @return Pointer to the sprite's texture
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfSprite_getTexture(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Get the sub-rectangle of the texture displayed by a sprite
	 *
	 * @param sprite Sprite object
	 *
	 * @return Texture rectangle of the sprite
	 *
	*/
	public IntRect sfSprite_getTextureRect(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Get the global color of a sprite
	 *
	 * @param sprite Sprite object
	 *
	 * @return Global color of the sprite
	 *
	*/
	public Color sfSprite_getColor(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Get the local bounding rectangle of a sprite
	 *
	 * The returned rectangle is in local coordinates, which means
	 * that it ignores the transformations (translation, rotation,
	 * scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * entity in the entity's coordinate system.
	 *
	 * @param sprite Sprite object
	 *
	 * @return Local bounding rectangle of the entity
	 *
	*/
	public FloatRect sfSprite_getLocalBounds(Pointer/*(sfSprite*)*/ sprite);

	/**
	 * @brief Get the global bounding rectangle of a sprite
	 *
	 * The returned rectangle is in global coordinates, which means
	 * that it takes in account the transformations (translation,
	 * rotation, scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * sprite in the global 2D world's coordinate system.
	 *
	 * @param sprite Sprite object
	 *
	 * @return Global bounding rectangle of the entity
	 *
	*/
	public FloatRect sfSprite_getGlobalBounds(Pointer/*(sfSprite*)*/ sprite);

	// Text.h

	/**
	 * Headers
	*/

	/**
	 * sfText styles
	*/

	/**
	 * @brief Create a new text
	 *
	 * @return A new sfText object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfText*)*/ sfText_create();

	/**
	 * @brief Copy an existing text
	 *
	 * @param text Text to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfText*)*/ sfText_copy(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Destroy an existing text
	 *
	 * @param text Text to delete
	 *
	*/
	public void sfText_destroy(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Set the position of a text
	 *
	 * This function completely overwrites the previous position.
	 * See sfText_move to apply an offset based on the previous position instead.
	 * The default position of a text Text object is (0, 0).
	 *
	 * @param text     Text object
	 * @param position New position
	 *
	*/
	public void sfText_setPosition(Pointer/*(sfText*)*/ text,  Vector2f position);

	/**
	 * @brief Set the orientation of a text
	 *
	 * This function completely overwrites the previous rotation.
	 * See sfText_rotate to add an angle based on the previous rotation instead.
	 * The default rotation of a text Text object is 0.
	 *
	 * @param text  Text object
	 * @param angle New rotation, in degrees
	 *
	*/
	public void sfText_setRotation(Pointer/*(sfText*)*/ text,  float angle);

	/**
	 * @brief Set the scale factors of a text
	 *
	 * This function completely overwrites the previous scale.
	 * See sfText_scale to add a factor based on the previous scale instead.
	 * The default scale of a text Text object is (1, 1).
	 *
	 * @param text  Text object
	 * @param scale New scale factors
	 *
	*/
	public void sfText_setScale(Pointer/*(sfText*)*/ text,  Vector2f scale);

	/**
	 * @brief Set the local origin of a text
	 *
	 * The origin of an object defines the center point for
	 * all transformations (position, scale, rotation).
	 * The coordinates of this point must be relative to the
	 * top-left corner of the object, and ignore all
	 * transformations (position, scale, rotation).
	 * The default origin of a text object is (0, 0).
	 *
	 * @param text   Text object
	 * @param origin New origin
	 *
	*/
	public void sfText_setOrigin(Pointer/*(sfText*)*/ text,  Vector2f origin);

	/**
	 * @brief Get the position of a text
	 *
	 * @param text Text object
	 *
	 * @return Current position
	 *
	*/
	public Vector2f sfText_getPosition(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the orientation of a text
	 *
	 * The rotation is always in the range [0, 360].
	 *
	 * @param text Text object
	 *
	 * @return Current rotation, in degrees
	 *
	*/
	public float sfText_getRotation(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the current scale of a text
	 *
	 * @param text Text object
	 *
	 * @return Current scale factors
	 *
	*/
	public Vector2f sfText_getScale(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the local origin of a text
	 *
	 * @param text Text object
	 *
	 * @return Current origin
	 *
	*/
	public Vector2f sfText_getOrigin(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Move a text by a given offset
	 *
	 * This function adds to the current position of the object,
	 * unlike sfText_setPosition which overwrites it.
	 *
	 * @param text   Text object
	 * @param offset Offset
	 *
	*/
	public void sfText_move(Pointer/*(sfText*)*/ text,  Vector2f offset);

	/**
	 * @brief Rotate a text
	 *
	 * This function adds to the current rotation of the object,
	 * unlike sfText_setRotation which overwrites it.
	 *
	 * @param text  Text object
	 * @param angle Angle of rotation, in degrees
	 *
	*/
	public void sfText_rotate(Pointer/*(sfText*)*/ text,  float angle);

	/**
	 * @brief Scale a text
	 *
	 * This function multiplies the current scale of the object,
	 * unlike sfText_setScale which overwrites it.
	 *
	 * @param text    Text object
	 * @param factors Scale factors
	 *
	*/
	public void sfText_scale(Pointer/*(sfText*)*/ text,  Vector2f factors);

	/**
	 * @brief Get the combined transform of a text
	 *
	 * @param text Text object
	 *
	 * @return Transform combining the positionrotationscaleorigin of the object
	 *
	*/
	public Transform sfText_getTransform(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the inverse of the combined transform of a text
	 *
	 * @param text Text object
	 *
	 * @return Inverse of the combined transformations applied to the object
	 *
	*/
	public Transform sfText_getInverseTransform(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Set the string of a text (from an ANSI string)
	 *
	 * A text's string is empty by default.
	 *
	 * @param text   Text object
	 * @param string New string
	 *
	*/
	public void sfText_setString(Pointer/*(sfText*)*/ text, String/*(  char*)*/ string);

	/**
	 * @brief Set the string of a text (from a unicode string)
	 *
	 * @param text   Text object
	 * @param string New string
	 *
	*/
	public void sfText_setUnicodeString(Pointer/*(sfText*)*/ text, Pointer/*(  sfUint32*)*/ string);

	/**
	 * @brief Set the font of a text
	 *
	 * The @a font argument refers to a texture that must
	 * exist as long as the text uses it. Indeed, the text
	 * doesn't store its own copy of the font, but rather keeps
	 * a pointer to the one that you passed to this function.
	 * If the font is destroyed and the text tries to
	 * use it, the behaviour is undefined.
	 *
	 * @param text Text object
	 * @param font New font
	 *
	*/
	public void sfText_setFont(Pointer/*(sfText*)*/ text, Pointer/*(  sfFont*)*/ font);

	/**
	 * @brief Set the character size of a text
	 *
	 * The default size is 30.
	 *
	 * @param text Text object
	 * @param size New character size, in pixels
	 *
	*/
	public void sfText_setCharacterSize(Pointer/*(sfText*)*/ text,  /*unsigned*/ int size);

	/**
	 *CSFML_GRAPHICS_API void sfText_setLineSpacing(sfText* text, float spacingFactor);
	*/

	/**
	 * @brief Set the letter spacing factor
	 *
	 * The default spacing between letters is defined by the font.
	 * This factor doesn't directly apply to the existing
	 * spacing between each character, it rather adds a fixed
	 * space between them which is calculated from the font
	 * metrics and the character size.
	 * Note that factors below 1 (including negative numbers) bring
	 * characters closer to each other.
	 * By default the letter spacing factor is 1.
	 *
	 * @param text Text object
	 * @param spacingFactor New letter spacing factor
	 *
	 * @see sfText_getLetterSpacing
	 *
	*/
	public void sfText_setLetterSpacing(Pointer/*(sfText*)*/ text,  float spacingFactor);

	/**
	 * @brief Set the style of a text
	 *
	 * You can pass a combination of one or more styles, for
	 * example sfTextBold | sfTextItalic.
	 * The default style is sfTextRegular.
	 *
	 * @param text  Text object
	 * @param style New style
	 *
	*/
	public void sfText_setStyle(Pointer/*(sfText*)*/ text,  long style);

	/**
	 * @brief Set the fill color of a text
	 *
	 * By default, the text's fill color is opaque white.
	 * Setting the fill color to a transparent color with an outline
	 * will cause the outline to be displayed in the fill area of the text.
	 *
	 * @param text  Text object
	 * @param color New fill color of the text
	 *
	 * @deprecated This function is deprecated and may be removed in future releases.
	 * Use sfText_setFillColor instead.
	 *
	*/
	public void sfText_setColor(Pointer/*(sfText*)*/ text,  Color color);

	/**
	 * @brief Set the fill color of a text
	 *
	 * By default, the text's fill color is opaque white.
	 * Setting the fill color to a transparent color with an outline
	 * will cause the outline to be displayed in the fill area of the text.
	 *
	 * @param text  Text object
	 * @param color New fill color of the text
	 *
	*/
	public void sfText_setFillColor(Pointer/*(sfText*)*/ text,  Color color);

	/**
	 * @brief Set the outline color of the text
	 *
	 * By default, the text's outline color is opaque black.
	 *
	 * @param text  Text object
	 * @param color New outline color of the text
	 *
	*/
	public void sfText_setOutlineColor(Pointer/*(sfText*)*/ text,  Color color);

	/**
	 * @brief Set the thickness of the text's outline
	 *
	 * By default, the outline thickness is 0.
	 *
	 * Be aware that using a negative value for the outline
	 * thickness will cause distorted rendering.
	 *
	 * @param thickness New outline thickness, in pixels
	 *
	 * @see getOutlineThickness
	 *
	*/
	public void sfText_setOutlineThickness(Pointer/*(sfText*)*/ text,  float thickness);

	/**
	 * @brief Get the string of a text (returns an ANSI string)
	 *
	 * @param text Text object
	 *
	 * @return String as a locale-dependant ANSI string
	 *
	*/
	public String/*(char*)*/ sfText_getString(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the string of a text (returns a unicode string)
	 *
	 * @param text Text object
	 *
	 * @return String as UTF-32
	 *
	*/
	public Pointer/*(sfUint32*)*/ sfText_getUnicodeString(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the font used by a text
	 *
	 * If the text has no font attached, a NULL pointer is returned.
	 * The returned pointer is const, which means that you can't
	 * modify the font when you retrieve it with this function.
	 *
	 * @param text Text object
	 *
	 * @return Pointer to the font
	 *
	*/
	public Pointer/*(sfFont*)*/ sfText_getFont(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the size of the characters of a text
	 *
	 * @param text Text object
	 *
	 * @return Size of the characters
	 *
	*/
	public /*unsigned*/ int sfText_getCharacterSize(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the size of the letter spacing factor
	 *
	 * @param text Text object
	 *
	 * @return Size of the letter spacing factor
	 *
	 * @see sfText_setLetterSpacing
	 *
	*/
	public float sfText_getLetterSpacing(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the size of the line spacing factor
	 *
	 * @param text Text object
	 *
	 * @return Size of the line spacing factor
	 *
	 * @see sfText_setLineSpacing
	 *
	*/
	public float sfText_getLineSpacing(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the style of a text
	 *
	 * @param text Text object
	 *
	 * @return Current string style (see sfTextStyle enum)
	 *
	*/
	public long sfText_getStyle(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the fill color of a text
	 *
	 * @param text Text object
	 *
	 * @return Fill color of the text
	 *
	 * @deprecated This function is deprecated and may be removed in future releases.
	 * Use sfText_getFillColor instead.
	 *
	*/
	public Color sfText_getColor(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the fill color of a text
	 *
	 * @param text Text object
	 *
	 * @return Fill color of the text
	 *
	*/
	public Color sfText_getFillColor(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the outline color of a text
	 *
	 * @param text Text object
	 *
	 * @return Outline color of the text
	 *
	*/
	public Color sfText_getOutlineColor(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the outline thickness of a text
	 *
	 * @param text Text object
	 *
	 * @return Outline thickness of a text, in pixels
	 *
	*/
	public float sfText_getOutlineThickness(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Return the position of the @a index-th character in a text
	 *
	 * This function computes the visual position of a character
	 * from its index in the string. The returned position is
	 * in global coordinates (translation, rotation, scale and
	 * origin are applied).
	 * If @a index is out of range, the position of the end of
	 * the string is returned.
	 *
	 * @param text  Text object
	 * @param index Index of the character
	 *
	 * @return Position of the character
	 *
	*/
	public Vector2f sfText_findCharacterPos(Pointer/*(sfText*)*/ text,  int index);

	/**
	 * @brief Get the local bounding rectangle of a text
	 *
	 * The returned rectangle is in local coordinates, which means
	 * that it ignores the transformations (translation, rotation,
	 * scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * entity in the entity's coordinate system.
	 *
	 * @param text Text object
	 *
	 * @return Local bounding rectangle of the entity
	 *
	*/
	public FloatRect sfText_getLocalBounds(Pointer/*(sfText*)*/ text);

	/**
	 * @brief Get the global bounding rectangle of a text
	 *
	 * The returned rectangle is in global coordinates, which means
	 * that it takes in account the transformations (translation,
	 * rotation, scale, ...) that are applied to the entity.
	 * In other words, this function returns the bounds of the
	 * text in the global 2D world's coordinate system.
	 *
	 * @param text Text object
	 *
	 * @return Global bounding rectangle of the entity
	 *
	*/
	public FloatRect sfText_getGlobalBounds(Pointer/*(sfText*)*/ text);

	// Texture.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a new texture
	 *
	 * @param width  Texture width
	 * @param height Texture height
	 *
	 * @return A new sfTexture object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfTexture_create(/*unsigned*/ int width,  /*unsigned*/ int height);

	/**
	 * @brief Create a new texture from a file
	 *
	 * @param filename Path of the image file to load
	 * @param area     Area of the source image to load (NULL to load the entire image)
	 *
	 * @return A new sfTexture object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfTexture_createFromFile(String/*(char*)*/ filename, Pointer/*(  IntRect*)*/ area);

	/**
	 * @brief Create a new texture from a file in memory
	 *
	 * @param data        Pointer to the file data in memory
	 * @param sizeInBytes Size of the data to load, in bytes
	 * @param area        Area of the source image to load (NULL to load the entire image)
	 *
	 * @return A new sfTexture object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfTexture_createFromMemory(Pointer/*(void*)*/ data,  int sizeInBytes, Pointer/*(  IntRect*)*/ area);

	/**
	 * @brief Create a new texture from a custom stream
	 *
	 * @param stream Source stream to read from
	 * @param area   Area of the source image to load (NULL to load the entire image)
	 *
	 * @return A new sfTexture object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfTexture_createFromStream(Pointer/*(sfInputStream*)*/ stream, Pointer/*(  IntRect*)*/ area);

	/**
	 * @brief Create a new texture from an image
	 *
	 * @param image Image to upload to the texture
	 * @param area  Area of the source image to load (NULL to load the entire image)
	 *
	 * @return A new sfTexture object, or NULL if it failed
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfTexture_createFromImage(Pointer/*(sfImage*)*/ image, Pointer/*(  IntRect*)*/ area);

	/**
	 * @brief Copy an existing texture
	 *
	 * @param texture Texture to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfTexture*)*/ sfTexture_copy(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Destroy an existing texture
	 *
	 * @param texture Texture to delete
	 *
	*/
	public void sfTexture_destroy(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Return the size of the texture
	 *
	 * @param texture Texture to read
	 *
	 * @return Size in pixels
	 *
	*/
	public Vector2u sfTexture_getSize(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Copy a texture's pixels to an image
	 *
	 * @param texture Texture to copy
	 *
	 * @return Image containing the texture's pixels
	 *
	*/
	public Pointer/*(sfImage*)*/ sfTexture_copyToImage(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Update a texture from an array of pixels
	 *
	 * @param texture Texture to update
	 * @param pixels  Array of pixels to copy to the texture
	 * @param width   Width of the pixel region contained in @a pixels
	 * @param height  Height of the pixel region contained in @a pixels
	 * @param x       X offset in the texture where to copy the source pixels
	 * @param y       Y offset in the texture where to copy the source pixels
	 *
	*/
	public void sfTexture_updateFromPixels(Pointer/*(sfTexture*)*/ texture, Pointer/*(  sfUint8*)*/ pixels,  /*unsigned*/ int width,  /*unsigned*/ int height,  /*unsigned*/ int x,  /*unsigned*/ int y);

	/**
	 * @brief Update a part of this texture from another texture
	 *
	 * No additional check is performed on the size of the texture,
	 * passing an invalid combination of texture size and offset
	 * will lead to an undefined behavior.
	 *
	 * This function does nothing if either texture was not
	 * previously created.
	 *
	 * @param destination Destination texture to copy source texture to
	 * @param source      Source texture to copy to destination texture
	 * @param x           X offset in this texture where to copy the source texture
	 * @param y           Y offset in this texture where to copy the source texture
	 *
	*/
	public void sfTexture_updateFromTexture(Pointer/*(sfTexture*)*/ destination, Pointer/*(  sfTexture*)*/ source,  /*unsigned*/ int x,  /*unsigned*/ int y);

	/**
	 * @brief Update a texture from an image
	 *
	 * @param texture Texture to update
	 * @param image   Image to copy to the texture
	 * @param x       X offset in the texture where to copy the source pixels
	 * @param y       Y offset in the texture where to copy the source pixels
	 *
	*/
	public void sfTexture_updateFromImage(Pointer/*(sfTexture*)*/ texture, Pointer/*(  sfImage*)*/ image,  /*unsigned*/ int x,  /*unsigned*/ int y);

	/**
	 * @brief Update a texture from the contents of a window
	 *
	 * @param texture Texture to update
	 * @param window  Window to copy to the texture
	 * @param x       X offset in the texture where to copy the source pixels
	 * @param y       Y offset in the texture where to copy the source pixels
	 *
	*/
	public void sfTexture_updateFromWindow(Pointer/*(sfTexture*)*/ texture, Pointer/*(  sfWindow*)*/ window,  /*unsigned*/ int x,  /*unsigned*/ int y);

	/**
	 * @brief Update a texture from the contents of a render-window
	 *
	 * @param texture      Texture to update
	 * @param renderWindow Render-window to copy to the texture
	 * @param x            X offset in the texture where to copy the source pixels
	 * @param y            Y offset in the texture where to copy the source pixels
	 *
	*/
	public void sfTexture_updateFromRenderWindow(Pointer/*(sfTexture*)*/ texture, Pointer/*(  sfRenderWindow*)*/ renderWindow,  /*unsigned*/ int x,  /*unsigned*/ int y);

	/**
	 * @brief Enable or disable the smooth filter on a texture
	 *
	 * @param texture The texture object
	 * @param smooth  sfTrue to enable smoothing, sfFalse to disable it
	 *
	*/
	public void sfTexture_setSmooth(Pointer/*(sfTexture*)*/ texture,  int smooth);

	/**
	 * @brief Tell whether the smooth filter is enabled or not for a texture
	 *
	 * @param texture The texture object
	 *
	 * @return sfTrue if smoothing is enabled, sfFalse if it is disabled
	 *
	*/
	public int sfTexture_isSmooth(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Enable or disable conversion from sRGB
	 *
	 * When providing texture data from an image file or memory, it can
	 * either be stored in a linear color space or an sRGB color space.
	 * Most digital images account for gamma correction already, so they
	 * would need to be "uncorrected" back to linear color space before
	 * being processed by the hardware. The hardware can automatically
	 * convert it from the sRGB color space to a linear color space when
	 * it gets sampled. When the rendered image gets output to the final
	 * framebuffer, it gets converted back to sRGB.
	 *
	 * After enabling or disabling sRGB conversion, make sure to reload
	 * the texture data in order for the setting to take effect.
	 *
	 * This option is only useful in conjunction with an sRGB capable
	 * framebuffer. This can be requested during window creation.
	 *
	 * @param sRgb True to enable sRGB conversion, false to disable it
	 *
	 * @see sfTexture_isSrgb
	 *
	*/
	public void sfTexture_setSrgb(Pointer/*(sfTexture*)*/ texture,  int sRgb);

	/**
	 * @brief Tell whether the texture source is converted from sRGB or not
	 *
	 * @return True if the texture source is converted from sRGB, false if not
	 *
	 * @see sfTexture_setSrgb
	 *
	*/
	public int sfTexture_isSrgb(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Enable or disable repeating for a texture
	 *
	 * Repeating is involved when using texture coordinates
	 * outside the texture rectangle [0, 0, width, height].
	 * In this case, if repeat mode is enabled, the whole texture
	 * will be repeated as many times as needed to reach the
	 * coordinate (for example, if the X texture coordinate is
	 * 3 * width, the texture will be repeated 3 times).
	 * If repeat mode is disabled, the "extra space" will instead
	 * be filled with border pixels.
	 * Warning: on very old graphics cards, white pixels may appear
	 * when the texture is repeated. With such cards, repeat mode
	 * can be used reliably only if the texture has power-of-two
	 * dimensions (such as 256x128).
	 * Repeating is disabled by default.
	 *
	 * @param texture  The texture object
	 * @param repeated True to repeat the texture, false to disable repeating
	 *
	*/
	public void sfTexture_setRepeated(Pointer/*(sfTexture*)*/ texture,  int repeated);

	/**
	 * @brief Tell whether a texture is repeated or not
	 *
	 * @param texture The texture object
	 *
	 * @return sfTrue if repeat mode is enabled, sfFalse if it is disabled
	 *
	*/
	public int sfTexture_isRepeated(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Generate a mipmap using the current texture data
	 *
	 * Mipmaps are pre-computed chains of optimized textures. Each
	 * level of texture in a mipmap is generated by halving each of
	 * the previous level's dimensions. This is done until the final
	 * level has the size of 1x1. The textures generated in this process may
	 * make use of more advanced filters which might improve the visual quality
	 * of textures when they are applied to objects much smaller than they are.
	 * This is known as minification. Because fewer texels (texture elements)
	 * have to be sampled from when heavily minified, usage of mipmaps
	 * can also improve rendering performance in certain scenarios.
	 *
	 * Mipmap generation relies on the necessary OpenGL extension being
	 * available. If it is unavailable or generation fails due to another
	 * reason, this function will return false. Mipmap data is only valid from
	 * the time it is generated until the next time the base level image is
	 * modified, at which point this function will have to be called again to
	 * regenerate it.
	 *
	 * @return sfTrue if mipmap generation was successful, sfFalse if unsuccessful
	 *
	*/
	public int sfTexture_generateMipmap(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Swap the contents of a texture with those of another
	 *
	 * @param left  Instance to swap from
	 * @param right Instance to swap with
	 *
	*/
	public void sfTexture_swap(Pointer/*(sfTexture*)*/ left, Pointer/*( sfTexture*)*/ right);

	/**
	 * @brief Get the underlying OpenGL handle of the texture.
	 *
	 * You shouldn't need to use this function, unless you have
	 * very specific stuff to implement that SFML doesn't support,
	 * or implement a temporary workaround until a bug is fixed.
	 *
	 * @param texture The texture object
	 *
	 * @return OpenGL handle of the texture or 0 if not yet created
	 *
	*/
	public /*unsigned*/ int sfTexture_getNativeHandle(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Bind a texture for rendering
	 *
	 * This function is not part of the graphics API, it mustn't be
	 * used when drawing SFML entities. It must be used only if you
	 * mix sfTexture with OpenGL code.
	 *
	 * @code
	 * sfTexture *t1, *t2;
	 * ...
	 * sfTexture_bind(t1);
	 *  draw OpenGL stuff that use t1...
	 * sfTexture_bind(t2);
	 *  draw OpenGL stuff that use t2...
	 * sfTexture_bind(NULL);
	 *  draw OpenGL stuff that use no texture...
	 * @endcode
	 *
	 * @param texture Pointer to the texture to bind, can be null to use no texture
	 *
	*/
	public void sfTexture_bind(Pointer/*(sfTexture*)*/ texture);

	/**
	 * @brief Get the maximum texture size allowed
	 *
	 * @return Maximum size allowed for textures, in pixels
	 *
	*/
	public /*unsigned*/ int sfTexture_getMaximumSize();

	// Transform.h

	/**
	 * Headers
	*/

	/**
	 * @brief Encapsulate a 3x3 transform matrix
	 *
	*/

	/**
	 * @brief Identity transform (does nothing)
	 *
	*/

	/**
	 * @brief Create a new transform from a matrix
	 *
	 * @param a00 Element (0, 0) of the matrix
	 * @param a01 Element (0, 1) of the matrix
	 * @param a02 Element (0, 2) of the matrix
	 * @param a10 Element (1, 0) of the matrix
	 * @param a11 Element (1, 1) of the matrix
	 * @param a12 Element (1, 2) of the matrix
	 * @param a20 Element (2, 0) of the matrix
	 * @param a21 Element (2, 1) of the matrix
	 * @param a22 Element (2, 2) of the matrix
	 *
	 * @return A new sfTransform object
	 *
	*/

	/**
	 * @brief Return the 4x4 matrix of a transform
	 *
	 * This function fills an array of 16 floats with the transform
	 * converted as a 4x4 matrix, which is directly compatible with
	 * OpenGL functions.
	 *
	 * @code
	 * sfTransform transform = ...;
	 * float matrix[16];
	 * sfTransform_getMatrix(&transform, matrix)
	 * glLoadMatrixf(matrix);
	 * @endcode
	 *
	 * @param transform Transform object
	 * @param matrix Pointer to the 16-element array to fill with the matrix
	 *
	*/
	public void sfTransform_getMatrix(Pointer/*(Transform*)*/ transform, Pointer/*( float*)*/ matrix);

	/**
	 * @brief Return the inverse of a transform
	 *
	 * If the inverse cannot be computed, a new identity transform
	 * is returned.
	 *
	 * @param transform Transform object
	 * @return The inverse matrix
	 *
	*/
	public Transform sfTransform_getInverse(Pointer/*(Transform*)*/ transform);

	/**
	 * @brief Apply a transform to a 2D point
	 *
	 * @param transform Transform object
	 * @param point     Point to transform
	 *
	 * @return Transformed point
	 *
	*/
	public Vector2f sfTransform_transformPoint(Pointer/*(Transform*)*/ transform,  Vector2f point);

	/**
	 * @brief Apply a transform to a rectangle
	 *
	 * Since SFML doesn't provide support for oriented rectangles,
	 * the result of this function is always an axis-aligned
	 * rectangle. Which means that if the transform contains a
	 * rotation, the bounding rectangle of the transformed rectangle
	 * is returned.
	 *
	 * @param transform Transform object
	 * @param rectangle Rectangle to transform
	 *
	 * @return Transformed rectangle
	 *
	*/
	public FloatRect sfTransform_transformRect(Pointer/*(Transform*)*/ transform,  FloatRect rectangle);

	/**
	 * @brief Combine two transforms
	 *
	 * The result is a transform that is equivalent to applying
	 * @a transform followed by @a other. Mathematically, it is
	 * equivalent to a matrix multiplication.
	 *
	 * @param transform Transform object
	 * @param other     Transform to combine to @a transform
	 *
	*/
	public void sfTransform_combine(Pointer/*(Transform*)*/ transform, Pointer/*(  Transform*)*/ other);

	/**
	 * @brief Combine a transform with a translation
	 *
	 * @param transform Transform object
	 * @param x         Offset to apply on X axis
	 * @param y         Offset to apply on Y axis
	 *
	*/
	public void sfTransform_translate(Pointer/*(Transform*)*/ transform,  float x,  float y);

	/**
	 * @brief Combine the current transform with a rotation
	 *
	 * @param transform Transform object
	 * @param angle     Rotation angle, in degrees
	 *
	*/
	public void sfTransform_rotate(Pointer/*(Transform*)*/ transform,  float angle);

	/**
	 * @brief Combine the current transform with a rotation
	 *
	 * The center of rotation is provided for convenience as a second
	 * argument, so that you can build rotations around arbitrary points
	 * more easily (and efficiently) than the usual
	 * [translate(-center), rotate(angle), translate(center)].
	 *
	 * @param transform Transform object
	 * @param angle     Rotation angle, in degrees
	 * @param centerX   X coordinate of the center of rotation
	 * @param centerY   Y coordinate of the center of rotation
	 *
	*/
	public void sfTransform_rotateWithCenter(Pointer/*(Transform*)*/ transform,  float angle,  float centerX,  float centerY);

	/**
	 * @brief Combine the current transform with a scaling
	 *
	 * @param transform Transform object
	 * @param scaleX    Scaling factor on the X axis
	 * @param scaleY    Scaling factor on the Y axis
	 *
	*/
	public void sfTransform_scale(Pointer/*(Transform*)*/ transform,  float scaleX,  float scaleY);

	/**
	 * @brief Combine the current transform with a scaling
	 *
	 * The center of scaling is provided for convenience as a second
	 * argument, so that you can build scaling around arbitrary points
	 * more easily (and efficiently) than the usual
	 * [translate(-center), scale(factors), translate(center)]
	 *
	 * @param transform Transform object
	 * @param scaleX    Scaling factor on X axis
	 * @param scaleY    Scaling factor on Y axis
	 * @param centerX   X coordinate of the center of scaling
	 * @param centerY   Y coordinate of the center of scaling
	 *
	*/
	public void sfTransform_scaleWithCenter(Pointer/*(Transform*)*/ transform,  float scaleX,  float scaleY,  float centerX,  float centerY);

	/**
	 * @brief Compare two transforms for equality
	 *
	 * Performs an element-wise comparison of the elements of the
	 * left transform with the elements of the right transform.
	 *
	 * @param left Left operand (the first transform)
	 * @param right Right operand (the second transform)
	 *
	 * @return true if the transforms are equal, false otherwise
	 *
	*/
	public int sfTransform_equal(Pointer/*(Transform*)*/ left, Pointer/*( Transform*)*/ right);

	// Transformable.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a new transformable
	 *
	 * @return A new sfTransformable object
	 *
	*/
	public Pointer/*(Transformable*)*/ sfTransformable_create();

	/**
	 * @brief Copy an existing transformable
	 *
	 * @param transformable Transformable to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(Transformable*)*/ sfTransformable_copy(Pointer/*(Transformable*)*/ transformable);

	/**
	 * @brief Destroy an existing transformable
	 *
	 * @param transformable Transformable to delete
	 *
	*/
	public void sfTransformable_destroy(Pointer/*(Transformable*)*/ transformable);

	/**
	 * @brief Set the position of a transformable
	 *
	 * This function completely overwrites the previous position.
	 * See sfTransformable_move to apply an offset based on the previous position instead.
	 * The default position of a transformable Transformable object is (0, 0).
	 *
	 * @param transformable Transformable object
	 * @param position      New position
	 *
	*/
	public void sfTransformable_setPosition(Pointer/*(Transformable*)*/ transformable,  Vector2f position);

	/**
	 * @brief Set the orientation of a transformable
	 *
	 * This function completely overwrites the previous rotation.
	 * See sfTransformable_rotate to add an angle based on the previous rotation instead.
	 * The default rotation of a transformable Transformable object is 0.
	 *
	 * @param transformable Transformable object
	 * @param angle         New rotation, in degrees
	 *
	*/
	public void sfTransformable_setRotation(Pointer/*(Transformable*)*/ transformable,  float angle);

	/**
	 * @brief Set the scale factors of a transformable
	 *
	 * This function completely overwrites the previous scale.
	 * See sfTransformable_scale to add a factor based on the previous scale instead.
	 * The default scale of a transformable Transformable object is (1, 1).
	 *
	 * @param transformable Transformable object
	 * @param scale         New scale factors
	 *
	*/
	public void sfTransformable_setScale(Pointer/*(Transformable*)*/ transformable,  Vector2f scale);

	/**
	 * @brief Set the local origin of a transformable
	 *
	 * The origin of an object defines the center point for
	 * all transformations (position, scale, rotation).
	 * The coordinates of this point must be relative to the
	 * top-left corner of the object, and ignore all
	 * transformations (position, scale, rotation).
	 * The default origin of a transformable Transformable object is (0, 0).
	 *
	 * @param transformable Transformable object
	 * @param origin        New origin
	 *
	*/
	public void sfTransformable_setOrigin(Pointer/*(Transformable*)*/ transformable,  Vector2f origin);

	/**
	 * @brief Get the position of a transformable
	 *
	 * @param transformable Transformable object
	 *
	 * @return Current position
	 *
	*/
	public Vector2f sfTransformable_getPosition(Pointer/*(Transformable*)*/ transformable);

	/**
	 * @brief Get the orientation of a transformable
	 *
	 * The rotation is always in the range [0, 360].
	 *
	 * @param transformable Transformable object
	 *
	 * @return Current rotation, in degrees
	 *
	*/
	public float sfTransformable_getRotation(Pointer/*(Transformable*)*/ transformable);

	/**
	 * @brief Get the current scale of a transformable
	 *
	 * @param transformable Transformable object
	 *
	 * @return Current scale factors
	 *
	*/
	public Vector2f sfTransformable_getScale(Pointer/*(Transformable*)*/ transformable);

	/**
	 * @brief Get the local origin of a transformable
	 *
	 * @param transformable Transformable object
	 *
	 * @return Current origin
	 *
	*/
	public Vector2f sfTransformable_getOrigin(Pointer/*(Transformable*)*/ transformable);

	/**
	 * @brief Move a transformable by a given offset
	 *
	 * This function adds to the current position of the object,
	 * unlike sfTransformable_setPosition which overwrites it.
	 *
	 * @param transformable Transformable object
	 * @param offset        Offset
	 *
	*/
	public void sfTransformable_move(Pointer/*(Transformable*)*/ transformable,  Vector2f offset);

	/**
	 * @brief Rotate a transformable
	 *
	 * This function adds to the current rotation of the object,
	 * unlike sfTransformable_setRotation which overwrites it.
	 *
	 * @param transformable Transformable object
	 * @param angle         Angle of rotation, in degrees
	 *
	*/
	public void sfTransformable_rotate(Pointer/*(Transformable*)*/ transformable,  float angle);

	/**
	 * @brief Scale a transformable
	 *
	 * This function multiplies the current scale of the object,
	 * unlike sfTransformable_setScale which overwrites it.
	 *
	 * @param transformable Transformable object
	 * @param factors       Scale factors
	 *
	*/
	public void sfTransformable_scale(Pointer/*(Transformable*)*/ transformable,  Vector2f factors);

	/**
	 * @brief Get the combined transform of a transformable
	 *
	 * @param transformable Transformable object
	 *
	 * @return Transform combining the positionrotationscaleorigin of the object
	 *
	*/
	public Transform sfTransformable_getTransform(Pointer/*(Transformable*)*/ transformable);

	/**
	 * @brief Get the inverse of the combined transform of a transformable
	 *
	 * @param transformable Transformable object
	 *
	 * @return Inverse of the combined transformations applied to the object
	 *
	*/
	public Transform sfTransformable_getInverseTransform(Pointer/*(Transformable*)*/ transformable);

	// Types.h

	// Vertex.h

	/**
	 * Headers
	*/

	/**
	 * Define a point with color and texture coordinates
	*/

	// VertexArray.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a new vertex array
	 *
	 * @return A new sfVertexArray object
	 *
	*/
	public Pointer/*(sfVertexArray*)*/ sfVertexArray_create();

	/**
	 * @brief Copy an existing vertex array
	 *
	 * @param vertexArray Vertex array to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfVertexArray*)*/ sfVertexArray_copy(Pointer/*(sfVertexArray*)*/ vertexArray);

	/**
	 * @brief Destroy an existing vertex array
	 *
	 * @param vertexArray Vertex array to delete
	 *
	*/
	public void sfVertexArray_destroy(Pointer/*(sfVertexArray*)*/ vertexArray);

	/**
	 * @brief Return the vertex count of a vertex array
	 *
	 * @param vertexArray Vertex array object
	 *
	 * @return Number of vertices in the array
	 *
	*/
	public int sfVertexArray_getVertexCount(Pointer/*(sfVertexArray*)*/ vertexArray);

	/**
	 * @brief Get access to a vertex by its index
	 *
	 * This function doesn't check @a index, it must be in range
	 * [0, vertex count - 1]. The behaviour is undefined
	 * otherwise.
	 *
	 * @param vertexArray Vertex array object
	 * @param index       Index of the vertex to get
	 *
	 * @return Pointer to the index-th vertex
	 *
	*/
	public Pointer/*(sfVertex*)*/ sfVertexArray_getVertex(Pointer/*(sfVertexArray*)*/ vertexArray,  int index);

	/**
	 * @brief Clear a vertex array
	 *
	 * This function removes all the vertices from the array.
	 * It doesn't deallocate the corresponding memory, so that
	 * adding new vertices after clearing doesn't involve
	 * reallocating all the memory.
	 *
	 * @param vertexArray Vertex array object
	 *
	*/
	public void sfVertexArray_clear(Pointer/*(sfVertexArray*)*/ vertexArray);

	/**
	 * @brief Resize the vertex array
	 *
	 * If @a vertexCount is greater than the current size, the previous
	 * vertices are kept and new (default-constructed) vertices are
	 * added.
	 * If @a vertexCount is less than the current size, existing vertices
	 * are removed from the array.
	 *
	 * @param vertexArray Vertex array objet
	 * @param vertexCount New size of the array (number of vertices)
	 *
	*/
	public void sfVertexArray_resize(Pointer/*(sfVertexArray*)*/ vertexArray,  int vertexCount);

	/**
	 * @brief Add a vertex to a vertex array array
	 *
	 * @param vertexArray Vertex array objet
	 * @param vertex      Vertex to add
	 *
	*/
	public void sfVertexArray_append(Pointer/*(sfVertexArray*)*/ vertexArray,  Vertex vertex);

	/**
	 * @brief Set the type of primitives of a vertex array
	 *
	 * This function defines how the vertices must be interpreted
	 * when it's time to draw them:
	 * @li As points
	 * @li As lines
	 * @li As triangles
	 * @li As quads
	 * The default primitive type is sfPoints.
	 *
	 * @param vertexArray Vertex array objet
	 * @param type        Type of primitive
	 *
	*/
	public void sfVertexArray_setPrimitiveType(Pointer/*(sfVertexArray*)*/ vertexArray,  PrimitiveType type);

	/**
	 * @brief Get the type of primitives drawn by a vertex array
	 *
	 * @param vertexArray Vertex array objet
	 *
	 * @return Primitive type
	 *
	*/
	public PrimitiveType sfVertexArray_getPrimitiveType(Pointer/*(sfVertexArray*)*/ vertexArray);

	/**
	 * @brief Compute the bounding rectangle of a vertex array
	 *
	 * This function returns the axis-aligned rectangle that
	 * contains all the vertices of the array.
	 *
	 * @param vertexArray Vertex array objet
	 *
	 * @return Bounding rectangle of the vertex array
	 *
	*/
	public FloatRect sfVertexArray_getBounds(Pointer/*(sfVertexArray*)*/ vertexArray);

	// VertexBuffer.h

	/**
	 * Headers
	*/

	/**
	 * @brief Usage specifiers
	 *
	 * If data is going to be updated once or more every frame,
	 * set the usage to sfVertexBufferStream. If data is going
	 * to be set once and used for a long time without being
	 * modified, set the usage to sfVertexBufferUsageStatic.
	 * For everything else sfVertexBufferUsageDynamic should
	 * be a good compromise.
	 *
	*/

	/**
	 * @brief Create a new vertex buffer with a specific
	 * sfPrimitiveType and usage specifier.
	 *
	 * Creates the vertex buffer, allocating enough graphcis
	 * memory to hold @p vertexCount vertices, and sets its
	 * primitive type to @p type and usage to @p usage.
	 *
	 * @param vertexCount Amount of vertices
	 * @param type Type of primitive
	 * @param usage Usage specifier
	 *
	 * @return A new sfVertexBuffer object
	 *
	*/
	public Pointer/*(sfVertexBuffer*)*/ sfVertexBuffer_create(/*unsigned*/ int vertexCount,  PrimitiveType type,  VertexBufferUsage usage);

	/**
	 * @brief Copy an existing vertex buffer
	 *
	 * @param vertexBuffer Vertex buffer to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfVertexBuffer*)*/ sfVertexBuffer_copy(Pointer/*(sfVertexBuffer*)*/ vertexBuffer);

	/**
	 * @brief Destroy an existing vertex buffer
	 *
	 * @param vertexBuffer Vertex buffer to delete
	 *
	*/
	public void sfVertexBuffer_destroy(Pointer/*(sfVertexBuffer*)*/ vertexBuffer);

	/**
	 * @brief Return the vertex count
	 *
	 * @param vertexBuffer Vertex buffer object
	 *
	 * @return Number of vertices in the vertex buffer
	 *
	*/
	public /*unsigned*/ int sfVertexBuffer_getVertexCount(Pointer/*(sfVertexBuffer*)*/ vertexBuffer);

	/**
	 * @brief Update a part of the buffer from an array of vertices
	 *
	 * @p offset is specified as the number of vertices to skip
	 * from the beginning of the buffer.
	 *
	 * If @p offset is 0 and @p vertexCount is equal to the size of
	 * the currently created buffer, its whole contents are replaced.
	 *
	 * If @p offset is 0 and @p vertexCount is greater than the
	 * size of the currently created buffer, a new buffer is created
	 * containing the vertex data.
	 *
	 * If @p offset is 0 and @p vertexCount is less than the size of
	 * the currently created buffer, only the corresponding region
	 * is updated.
	 *
	 * If @p offset is not 0 and @p offset + @p vertexCount is greater
	 * than the size of the currently created buffer, the update fails.
	 *
	 * No additional check is performed on the size of the vertex
	 * array, passing invalid arguments will lead to undefined
	 * behavior.
	 *
	 * @param vertices    Array of vertices to copy to the buffer
	 * @param vertexCount Number of vertices to copy
	 * @param offset      Offset in the buffer to copy to
	 *
	 * @return sfTrue if the update was successful
	 *
	*/
	public int sfVertexBuffer_update(Pointer/*(sfVertexBuffer*)*/ vertexBuffer, Pointer/*(  sfVertex*)*/ vertices,  /*unsigned*/ int vertexCount,  /*unsigned*/ int offset);

	/**
	 * @brief Copy the contents of another buffer into this buffer
	 *
	 * @param vertexBuffer Vertex buffer object
	 * @param other Vertex buffer whose contents to copy into first vertex buffer
	 *
	 * @return sfTrue if the copy was successful
	 *
	*/
	public int sfVertexBuffer_updateFromVertexBuffer(Pointer/*(sfVertexBuffer*)*/ vertexBuffer, Pointer/*(  sfVertexBuffer*)*/ other);

	/**
	 * @brief Swap the contents of this vertex buffer with those of another
	 *
	 * @param left Instance to swap
	 * @param right Instance to swap with
	 *
	*/
	public void sfVertexBuffer_swap(Pointer/*(sfVertexBuffer*)*/ left, Pointer/*( sfVertexBuffer*)*/ right);

	/**
	 * @brief Get the underlying OpenGL handle of the vertex buffer.
	 *
	 * You shouldn't need to use this function, unless you have
	 * very specific stuff to implement that SFML doesn't support,
	 * or implement a temporary workaround until a bug is fixed.
	 *
	 * @return OpenGL handle of the vertex buffer or 0 if not yet created
	 *
	*/
	public /*unsigned*/ int sfVertexBuffer_getNativeHandle(Pointer/*(sfVertexBuffer*)*/ vertexBuffer);

	/**
	 * @brief Set the type of primitives to draw
	 *
	 * This function defines how the vertices must be interpreted
	 * when it's time to draw them.
	 *
	 * The default primitive type is sf::Points.
	 *
	 * @param vertexBuffer Vertex buffer object
	 * @param type Type of primitive
	 *
	*/
	public void sfVertexBuffer_setPrimitiveType(Pointer/*(sfVertexBuffer*)*/ vertexBuffer,  PrimitiveType type);

	/**
	 * @brief Get the type of primitives drawn by the vertex buffer
	 *
	 * @param vertexBuffer Vertex buffer object
	 *
	 * @return Primitive type
	 *
	*/
	public PrimitiveType sfVertexBuffer_getPrimitiveType(Pointer/*(sfVertexBuffer*)*/ vertexBuffer);

	/**
	 * @brief Set the usage specifier of this vertex buffer
	 *
	 * This function provides a hint about how this vertex buffer is
	 * going to be used in terms of data update frequency.
	 *
	 * After changing the usage specifier, the vertex buffer has
	 * to be updated with new data for the usage specifier to
	 * take effect.
	 *
	 * The default primitive type is sfVertexBufferStream.
	 *
	 * @param vertexBuffer Vertex buffer object
	 * @param usage Usage specifier
	 *
	*/
	public void sfVertexBuffer_setUsage(Pointer/*(sfVertexBuffer*)*/ vertexBuffer,  VertexBufferUsage usage);

	/**
	 * @brief Get the usage specifier of this vertex buffer
	 *
	 * @param vertexBuffer Vertex buffer object
	 *
	 * @return Usage specifier
	 *
	*/
	public VertexBufferUsage sfVertexBuffer_getUsage(Pointer/*(sfVertexBuffer*)*/ vertexBuffer);

	/**
	 * @brief Bind a vertex buffer for rendering
	 *
	 * This function is not part of the graphics API, it mustn't be
	 * used when drawing SFML entities. It must be used only if you
	 * mix sfVertexBuffer with OpenGL code.
	 *
	 * @code
	 * sfVertexBuffer* vb1, vb2;
	 * ...
	 * sfVertexBuffer_bind(vb1);
	 *  draw OpenGL stuff that use vb1...
	 * sfVertexBuffer_bind(vb2);
	 *  draw OpenGL stuff that use vb2...
	 * sfVertexBuffer_bind(NULL);
	 *  draw OpenGL stuff that use no vertex buffer...
	 * @endcode
	 *
	 * @param vertexBuffer Pointer to the vertex buffer to bind, can be null to use no vertex buffer
	 *
	*/
	public void sfVertexBuffer_bind(Pointer/*(sfVertexBuffer*)*/ vertexBuffer);

	/**
	 * @brief Tell whether or not the system supports vertex buffers
	 *
	 * This function should always be called before using
	 * the vertex buffer features. If it returns false, then
	 * any attempt to use sf::VertexBuffer will fail.
	 *
	 * @return True if vertex buffers are supported, false otherwise
	 *
	*/
	public int sfVertexBuffer_isAvailable();

	// View.h

	/**
	 * Headers
	*/

	/**
	 * @brief Create a default view
	 *
	 * This function creates a default view of (0, 0, 1000, 1000)
	 *
	 * @return A new sfView object
	 *
	*/
	public Pointer/*(sfView*)*/ sfView_create();

	/**
	 * @brief Construct a view from a rectangle
	 *
	 * @param rectangle Rectangle defining the zone to display
	 *
	 * @return A new sfView object
	 *
	*/
	public Pointer/*(sfView*)*/ sfView_createFromRect(FloatRect rectangle);

	/**
	 * @brief Copy an existing view
	 *
	 * @param view View to copy
	 *
	 * @return Copied object
	 *
	*/
	public Pointer/*(sfView*)*/ sfView_copy(Pointer/*(sfView*)*/ view);

	/**
	 * @brief Destroy an existing view
	 *
	 * @param view View to destroy
	 *
	*/
	public void sfView_destroy(Pointer/*(sfView*)*/ view);

	/**
	 * @brief Set the center of a view
	 *
	 * @param view   View object
	 * @param center New center
	 *
	*/
	public void sfView_setCenter(Pointer/*(sfView*)*/ view,  Vector2f center);

	/**
	 * @brief Set the size of a view
	 *
	 * @param view View object
	 * @param size New size of the view
	 *
	*/
	public void sfView_setSize(Pointer/*(sfView*)*/ view,  Vector2f size);

	/**
	 * @brief Set the orientation of a view
	 *
	 * The default rotation of a view is 0 degree.
	 *
	 * @param view  View object
	 * @param angle New angle, in degrees
	 *
	*/
	public void sfView_setRotation(Pointer/*(sfView*)*/ view,  float angle);

	/**
	 * @brief Set the target viewport of a view
	 *
	 * The viewport is the rectangle into which the contents of the
	 * view are displayed, expressed as a factor (between 0 and 1)
	 * of the size of the render target to which the view is applied.
	 * For example, a view which takes the left side of the target would
	 * be defined by a rect of (0, 0, 0.5, 1).
	 * By default, a view has a viewport which covers the entire target.
	 *
	 * @param view     View object
	 * @param viewport New viewport rectangle
	 *
	*/
	public void sfView_setViewport(Pointer/*(sfView*)*/ view,  FloatRect viewport);

	/**
	 * @brief Reset a view to the given rectangle
	 *
	 * Note that this function resets the rotation angle to 0.
	 *
	 * @param view      View object
	 * @param rectangle Rectangle defining the zone to display
	 *
	*/
	public void sfView_reset(Pointer/*(sfView*)*/ view,  FloatRect rectangle);

	/**
	 * @brief Get the center of a view
	 *
	 * @param view View object
	 *
	 * @return Center of the view
	 *
	*/
	public Vector2f sfView_getCenter(Pointer/*(sfView*)*/ view);

	/**
	 * @brief Get the size of a view
	 *
	 * @param view View object
	 *
	 * @return Size of the view
	 *
	*/
	public Vector2f sfView_getSize(Pointer/*(sfView*)*/ view);

	/**
	 * @brief Get the current orientation of a view
	 *
	 * @param view View object
	 *
	 * @return Rotation angle of the view, in degrees
	 *
	*/
	public float sfView_getRotation(Pointer/*(sfView*)*/ view);

	/**
	 * @brief Get the target viewport rectangle of a view
	 *
	 * @param view View object
	 *
	 * @return Viewport rectangle, expressed as a factor of the target size
	 *
	*/
	public FloatRect sfView_getViewport(Pointer/*(sfView*)*/ view);

	/**
	 * @brief Move a view relatively to its current position
	 *
	 * @param view   View object
	 * @param offset Offset
	 *
	*/
	public void sfView_move(Pointer/*(sfView*)*/ view,  Vector2f offset);

	/**
	 * @brief Rotate a view relatively to its current orientation
	 *
	 * @param view  View object
	 * @param angle Angle to rotate, in degrees
	 *
	*/
	public void sfView_rotate(Pointer/*(sfView*)*/ view,  float angle);

	/**
	 * @brief Resize a view rectangle relatively to its current size
	 *
	 * Resizing the view simulates a zoom, as the zone displayed on
	 * screen grows or shrinks.
	 * @a factor is a multiplier:
	 * @li 1 keeps the size unchanged
	 * @li > 1 makes the view bigger (objects appear smaller)
	 * @li < 1 makes the view smaller (objects appear bigger)
	 *
	 * @param view   View object
	 * @param factor Zoom factor to apply
	 *
	*/
	public void sfView_zoom(Pointer/*(sfView*)*/ view,  float factor);

}