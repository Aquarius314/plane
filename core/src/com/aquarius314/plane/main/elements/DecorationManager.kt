package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Displayable
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.ElementGenerator
import com.aquarius314.plane.main.GdxGame
import com.badlogic.gdx.Gdx
import java.util.*

class DecorationManager : Displayable, Active {

    val clouds = arrayListOf<Cloud>()
    val cloudGenerator: ElementGenerator

    init {
        val cloudFactory = {
            x: Float, y: Float -> clouds.add(Cloud(x, y, Math.abs(Random().nextInt()%4)))
        }
        val minX = Gdx.graphics.width + 400
        val minY = Gdx.graphics.height - 100
        val maxY = Gdx.graphics.height - 400
        cloudGenerator = ElementGenerator(cloudFactory, minX, minX + 100, minY, maxY, 2000)
    }

    override fun actions(game: GdxGame) {
        cloudGenerator.actions(game)
        clouds.forEach { c -> c.actions(game) }
        removeOldClouds()
    }

    private fun removeOldClouds() {
        val oldClouds = clouds.filter { c -> !c.isVisible() }
        clouds.removeAll(oldClouds)
    }

    override fun display(renderer: Renderer) {
        clouds.forEach { c -> c.display(renderer) }
    }

}