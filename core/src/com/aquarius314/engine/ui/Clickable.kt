package com.aquarius314.engine.ui

import com.aquarius314.engine.graphics.Displayable
import com.aquarius314.engine.logic.Utils
import com.aquarius314.plane.main.GdxGame

abstract class Clickable constructor(var x: Float, var y: Float, var radius: Float) : Displayable {

    fun checkClick(x: Float, y: Float) : Boolean {
        if (Utils.pointInArea(x, y, this.x, this.y, this.radius)) {
            onClick(x, y)
            return true
        }
        return false
    }

    abstract fun onClick(x: Float, y: Float)

}