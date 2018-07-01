package com.aquarius314.engine.ui

import com.aquarius314.engine.logic.Utils

abstract class RoundClickable constructor(var x: Float, var y: Float, var radius: Float) : Clickable {

    fun checkClick(x: Float, y: Float) : Boolean {
        if (Utils.pointInCircle(x, y, this.x, this.y, this.radius)) {
            onClick(x, y)
            return true
        }
        return false
    }
}