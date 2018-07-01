package com.aquarius314.engine.ui

import com.aquarius314.engine.graphics.Renderer

abstract class RectangularButton constructor(
        x: Float, y: Float, width: Float, height: Float, var imgFile: String = ""
) : RectangularClickable(x, y, width, height) {

    override fun display(renderer: Renderer) {
        if (!imgFile.isEmpty()) {
            renderer.image(imgFile, x, y, scale = false)
        } else {
            println("Empty image file for rectangular button!")
        }
    }

}
