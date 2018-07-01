package com.aquarius314.engine.ui

import com.aquarius314.engine.graphics.Renderer

abstract class RoundButton constructor(x: Float, y: Float, radius: Float,
                                       var imgFile: String) : RoundClickable(x, y, radius) {

    override fun display(renderer: Renderer) {
        renderer.image(imgFile, x, y, scale = false)
    }

}