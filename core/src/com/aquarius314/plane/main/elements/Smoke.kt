package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Decoration
import com.aquarius314.engine.logic.MeasurableProperty

class Smoke constructor(x: Float, y: Float, counter: Int) : Decoration(x, y, "smoke$counter.png") {

    override var xSpeed = MeasurableProperty(10f, 10f)
    override var ySpeed = MeasurableProperty(0f, 0f)

}