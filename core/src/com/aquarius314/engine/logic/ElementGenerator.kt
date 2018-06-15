package com.aquarius314.engine.logic

import com.aquarius314.plane.main.GdxGame
import java.util.*

class ElementGenerator(private var factoryFunction : (x: Float, y: Float) -> Boolean,
                       var minX: Int, var maxX: Int, var minY: Int, var maxY: Int,
                       var generationTime: Int) : Active {

    var lastGeneration = 0L

    override fun actions(game: GdxGame) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastGeneration > generationTime) {
            lastGeneration = currentTime + Random().nextInt()%(generationTime/3)
            factoryFunction(randX().toFloat(), randY().toFloat())
        }
    }

    private fun randX() : Int = Random().nextInt()%(maxX - minX) + minX

    private fun randY() : Int = Random().nextInt()%(maxY - minY) + minY

}