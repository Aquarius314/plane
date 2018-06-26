package com.aquarius314.engine.logic

import java.util.*

class ElementGenerator<T>(
        private var factoryFunction : (x: Float, y: Float, collection: ArrayList<T>) -> Boolean,
        var minX: Int, var maxX: Int,
        var minY: Int, var maxY: Int,
        var generationTime: Int) {

    var lastGeneration = 0L

    fun generateInto(collection: ArrayList<T>) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastGeneration > generationTime) {
            lastGeneration = currentTime + Random().nextInt()%(generationTime/3)
            factoryFunction(randX().toFloat(), randY().toFloat(), collection)
        }
    }

    private fun randX() : Int = Random().nextInt()%(maxX - minX) + minX

    private fun randY() : Int = Random().nextInt()%(maxY - minY) + minY

}