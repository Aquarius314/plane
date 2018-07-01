package com.aquarius314.engine.ui

import com.aquarius314.engine.logic.Utils

abstract class RectangularClickable constructor(
        var x: Float, var y: Float, var width: Float, var height: Float
): Clickable {

    fun checkClick(x: Float, y: Float) : Boolean {
        if (Utils.pointInRectangle(x, y, this.x, this.y, this.width, this.height)) {
            onClick(x, y)
            playClickSound()
            return true
        }
        return false
    }

    open fun playClickSound() {
        // no sound by default
    }

}