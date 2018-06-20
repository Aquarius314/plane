package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Decoration
import com.aquarius314.engine.logic.MeasurableProperty

class Mountain(x: Float, y: Float, counter: Int) : Decoration(x, y, "mountain$counter.png") {
    override var xSpeed = MeasurableProperty(3f, 3f)
    override var ySpeed = MeasurableProperty(0f, 0f)

}