package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Decoration

class Smoke constructor(x: Float, y: Float, counter: Int) : Decoration(x, y, "smoke$counter.png") {

    override val speed = 10

}