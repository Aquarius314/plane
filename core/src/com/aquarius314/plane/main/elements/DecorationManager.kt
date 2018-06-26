package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Active
import com.aquarius314.engine.logic.CollectionManager
import com.aquarius314.engine.logic.ElementGenerator
import com.aquarius314.plane.main.GdxGame
import com.badlogic.gdx.Gdx
import kotlin.collections.ArrayList

class DecorationManager : Active {

    private val cloudsManager: CollectionManager<Cloud>
    private val mountainsManager: CollectionManager<Mountain>

    init {
        val cloudFactory = {
            x: Float, y: Float, collection: ArrayList<Cloud> -> collection.add(Cloud(x, y))
        }
//        val cloudFactory = Utils.elementFactory()
        // TODO replace with Utils element factory method
        val minX = Gdx.graphics.width + 400
        val minY = Gdx.graphics.height - 100
        val maxY = Gdx.graphics.height - 400
        cloudsManager = CollectionManager(ElementGenerator(
                cloudFactory, minX, minX + 100, minY, maxY, 2000
        ))

        val mountainFactory = {
            x: Float, y: Float, collection: ArrayList<Mountain> -> collection.add(Mountain(x, y))
        }
        val minX2 = Gdx.graphics.width + 1000
        mountainsManager = CollectionManager(ElementGenerator(
                mountainFactory, minX2, minX2+100, 100, 101, 3000
        ))
    }

    override fun actions(game: GdxGame) {
        cloudsManager.actions(game)
        mountainsManager.actions(game)
    }

    fun display(renderer: Renderer) {
        cloudsManager.display(renderer)
        mountainsManager.display(renderer)
    }

}