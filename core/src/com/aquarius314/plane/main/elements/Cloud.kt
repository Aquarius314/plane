package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Decoration
import com.aquarius314.engine.logic.MeasurableProperty
import java.util.*

class Cloud(x: Float, y: Float, counter: Int) : Decoration(x, y, "cloud$counter.png") {

    val vx = Random().nextInt()%4 + 4f
    override var xSpeed = MeasurableProperty(vx, vx)
    override var ySpeed = MeasurableProperty(0f, 0f)

}