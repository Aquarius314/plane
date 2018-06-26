package com.aquarius314.engine.logic

import com.aquarius314.engine.graphics.Displayable

abstract class GameObject constructor(x: Float = 0f, y: Float = 0f) : Displayable {

    var x = 0f
    var y = 0f
    open var colliderR = 80f

    init {
        this.x = x
        this.y = y
    }

    fun collidesWith(other: GameObject, radiusScale: Float = 1f) : Boolean {
        if (this === other) {
            return false
        }
        return Utils.distance(x, y, other.x, other.y) <=
                colliderR * radiusScale + other.colliderR * radiusScale
    }

}