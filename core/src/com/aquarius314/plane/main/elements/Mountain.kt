package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Decoration

class Mountain(x: Float, y: Float, counter: Int) : Decoration(x, y, "mountain$counter.png") {
    override var xSpeed = 3f
    override var ySpeed = 0f

}