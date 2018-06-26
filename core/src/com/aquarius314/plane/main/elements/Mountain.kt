package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Decoration
import com.aquarius314.plane.main.Resources
import java.util.*

class Mountain(x: Float, y: Float) : Decoration(x, y, "") {

    override var xSpeed = 3f
    override var ySpeed = 0f

    init {
        val randomType = Math.abs(Random().nextInt()% Resources.numberOfMountains)
        imageFileName = "mountain$randomType.png"
    }

}