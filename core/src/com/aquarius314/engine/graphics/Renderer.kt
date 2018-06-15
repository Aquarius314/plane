package com.aquarius314.engine.graphics

import com.aquarius314.engine.resources.ImageManager
import com.aquarius314.plane.main.Resources
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2



class Renderer(var shapeRenderer: ShapeRenderer = ShapeRenderer(),
               var spriteBatch: SpriteBatch = SpriteBatch()) {

    val imageManager = ImageManager(Resources.textures)

    val scaling = Gdx.graphics.width/400f

    fun renderBackground() {
        Gdx.gl.glClearColor(0.2f, 0.49f, 0.96f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
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

    fun image(image: String, x: Float, y: Float, rotation: Float = 0f) {
        spriteBatch.begin()
        val image = imageManager.get(image)
        val sprite = Sprite(image)
        sprite.texture.setFilter(Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear)
        sprite.setSize(sprite.width/scaling, sprite.height/scaling)
        sprite.rotation = rotation
        sprite.setOrigin(sprite.width/2f, sprite.height/2f)
        sprite.setPosition(x - sprite.width/2f, y - sprite.height/2f)
        sprite.draw(spriteBatch)
        spriteBatch.end()
    }

    private fun renderShape(action: () -> Unit) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        action()
        shapeRenderer.end()
    }

    fun dispose() {
        imageManager.dispose()
    }

}