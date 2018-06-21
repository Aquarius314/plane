package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Decoration
import java.util.*

class Cloud(x: Float, y: Float, counter: Int) : Decoration(x, y, "cloud$counter.png") {

    override var xSpeed = Random().nextInt()%4 + 4f
    override var ySpeed = 0f

}