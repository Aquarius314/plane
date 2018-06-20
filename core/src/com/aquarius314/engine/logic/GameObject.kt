package com.aquarius314.engine.logic

import com.aquarius314.engine.graphics.Displayable

abstract class GameObject constructor(x: Float = 0f, y: Float = 0f) : Displayable {

    var x = 0f
    var y = 0f
    var colliderR = 30f

    init {
        this.x = x
        this.y = y
    }

    fun collidesWith(other: GameObject) : Boolean {
        if (this === other) {
            return false
        }
        return distance(x, y, other.x, other.y) <= colliderR + other.colliderR
    }

    private fun distance(x1: Float, y1: Float, x2: Float, y2: Float) : Float{
        return Math.sqrt(Math.pow(x1.toDouble() - x2.toDouble(), 2.0) +
                        Math.pow(y1.toDouble() - y2.toDouble(), 2.0)).toFloat()
    }

}