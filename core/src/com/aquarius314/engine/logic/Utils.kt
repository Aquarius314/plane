package com.aquarius314.engine.logic

object Utils {

    fun distance(x1: Float, y1: Float, x2: Float, y2: Float) : Float{
        return Math.sqrt(Math.pow(x1.toDouble() - x2.toDouble(), 2.0) +
                Math.pow(y1.toDouble() - y2.toDouble(), 2.0)).toFloat()
    }

    fun pointInArea(pointX: Float, pointY: Float, areaX: Float, areaY: Float, areaR: Float) : Boolean {
        return distance(pointX, pointY, areaX, areaY) <= areaR
    }

    fun <T> elementFactory(collection: ArrayList<T>, fn: (Float, Float) -> T)
            : (Float, Float) -> Boolean = { x, y -> collection.add(fn(x, y)) }
}