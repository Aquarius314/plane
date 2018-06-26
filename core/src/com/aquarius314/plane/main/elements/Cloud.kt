package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Decoration
import com.aquarius314.plane.main.Resources
import java.util.*

class Cloud(x: Float, y: Float) : Decoration(x, y, "") {
    override var xSpeed = Random().nextInt()%4 + 4f
    override var ySpeed = 0f

    init {
        val randomCloudType = Math.abs(Random().nextInt()% Resources.numberOfClouds)
        imageFileName = "cloud$randomCloudType.png"
    }

}