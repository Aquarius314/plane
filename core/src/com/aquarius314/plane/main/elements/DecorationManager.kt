package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Displayable
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.ElementGenerator
import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.Resources
import com.badlogic.gdx.Gdx
import java.util.*

class DecorationManager : Displayable, Active {

    private val clouds = arrayListOf<Cloud>()
    private val cloudGenerator: ElementGenerator
    private val mountains = arrayListOf<Mountain>()
    private val mountainGenerator: ElementGenerator

    init {
        val cloudFactory = {
            x: Float, y: Float -> clouds.add(Cloud(x, y, Math.abs(Random().nextInt()%Resources.numberOfClouds)))
        }
        val minX = Gdx.graphics.width + 400
        val minY = Gdx.graphics.height - 100
        val maxY = Gdx.graphics.height - 400
        cloudGenerator = ElementGenerator(cloudFactory, minX, minX + 100, minY, maxY, 2000)

        val mountainFactory = {
            x: Float, y: Float -> mountains.add(Mountain(x, y, Math.abs(Random().nextInt()% Resources.numberOfMountains)))
        }
        val minX2 = Gdx.graphics.width + 1000
        mountainGenerator = ElementGenerator(mountainFactory, minX2, minX2+100, 100, 101, 3000)
    }

    override fun actions(game: GdxGame) {
        cloudGenerator.actions(game)
        clouds.forEach { c -> c.actions(game) }
        removeOldClouds()
        mountainGenerator.actions(game)
        mountains.forEach { m -> m.actions(game) }
        removeOldMountains()
    }

    private fun removeOldClouds() {
        val oldClouds = clouds.filter { c -> !c.isVisible() }
        clouds.removeAll(oldClouds)
    }

    private fun removeOldMountains() {
        val oldMountains = mountains.filter { m -> !m.isVisible() }
        mountains.removeAll(oldMountains)
    }

    override fun display(renderer: Renderer) {
        clouds.forEach { c -> c.display(renderer) }
        mountains.forEach { m -> m.display(renderer) }
    }

}