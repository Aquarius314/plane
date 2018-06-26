package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.CollectionManager
import com.aquarius314.engine.logic.ElementGenerator
import com.aquarius314.plane.main.GdxGame
import com.badlogic.gdx.Gdx

class GameElementsManager : Active {

    private val bonusManager : CollectionManager<Bonus>
    val counts = arrayOf(0, 0, 0, 0)

    init {
        val bonusFactory = {
            x: Float, y: Float, collection: ArrayList<Bonus> -> collection.add(Bonus(x, y))
        }
        val minX = Gdx.graphics.width + 200
        val maxX = Gdx.graphics.width + 300
        val minY = Gdx.graphics.height
        val maxY = Gdx.graphics.height + 200
        bonusManager = CollectionManager(ElementGenerator(
                bonusFactory, minX, maxX, minY, maxY, 5000
        ))
    }

    override fun actions(game: GdxGame) {
        bonusManager.actions(game)
//        println("Elements: ${bonusManager.collection.size}")
    }

    fun display(renderer: Renderer) {
        bonusManager.display(renderer)
    }
}