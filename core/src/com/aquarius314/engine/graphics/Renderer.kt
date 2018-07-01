package com.aquarius314.engine.graphics

import com.aquarius314.engine.effects.GraphicalEffects
import com.aquarius314.engine.resources.ImageManager
import com.aquarius314.plane.main.Resources
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2


class Renderer(protected var shapeRenderer: ShapeRenderer = ShapeRenderer(),
               protected var spriteBatch: SpriteBatch = SpriteBatch(),
               protected var specialImageManager: ImageManager? = null) {

    private val imageManager = ImageManager(Resources.textures)
    private val font = BitmapFont(Gdx.files.internal(Resources.font))

    companion object {
        var scaling = Gdx.graphics.width/400f
            get() = Gdx.graphics.width/400f
    }

    init {
        if (specialImageManager != null) {
            imageManager.assets.putAll(specialImageManager!!.assets)
        }
    }

    fun renderBackground() {
        spriteBatch.begin()
        Gdx.gl.glClearColor(0.2f, 0.49f, 0.96f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    fun finishRendering() {
        spriteBatch.end()
        // also do whatever needs to be done with each rendering cycle
        GraphicalEffects.shake--
    }

    fun circle(x: Float, y: Float, r: Float, color: Color) {
        renderShape {
            shapeRenderer.color = color
            shapeRenderer.circle(x, y, r)
        }
    }

    fun line(x1: Float, y1: Float, x2: Float, y2: Float, color: Color) {
        renderShape { shapeRenderer.rectLine(Vector2(x1, y1), Vector2(x2, y2), 4f) }
    }

    fun rectangle(x: Float, y: Float, width: Float, height: Float, color: Color) {
        renderShape {
            shapeRenderer.color = color
            shapeRenderer.rect(x, y, width, height)
        }
    }

    fun image(imageFile: String, x: Float, y: Float, scale: Boolean = true, rotation: Float = 0f) {
        val image = imageManager.get(imageFile)
        val sprite = Sprite(image)
        sprite.texture.setFilter(Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear)
        if (scale) {
            sprite.setSize(sprite.width/scaling, sprite.height/scaling)
        }
        sprite.rotation = rotation
        sprite.setOrigin(sprite.width/2f, sprite.height/2f)
        sprite.setPosition(coordinateWithEffects(x) - sprite.width/2f,
                coordinateWithEffects(y) - sprite.height/2f)
        sprite.draw(spriteBatch)
    }

    fun text(text: String, x: Float, y: Float) {
        font.draw(spriteBatch, text, x, y)
    }

    protected fun coordinateWithEffects(c: Float) : Float = c + getDistortion()

    protected fun getDistortion() : Int {
        var distortion = GraphicalEffects.shake
        if (distortion%2 == 0) {
            distortion = -distortion
        }
        return distortion
    }

    private fun renderShape(action: () -> Unit) {
        spriteBatch.end()
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        action()
        shapeRenderer.end()
        spriteBatch.begin()
    }

    fun dispose() {
        imageManager.dispose()
    }

}