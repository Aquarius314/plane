package com.aquarius314.plane.main.menu

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.ui.RectangularClickable
import com.badlogic.gdx.graphics.Color

abstract class MenuButton constructor(
        x: Float, y: Float, width: Float, height: Float, var text: String
) : RectangularClickable(x, y, width, height) {

    override fun display(renderer: Renderer) {
        renderer.line(x, y, x + width, y, Color.CHARTREUSE)
        renderer.line(x, y + height, x + width, y + height, Color.CHARTREUSE)
        renderer.line(x, y, x, y + height, Color.CHARTREUSE)
        renderer.line(x + width, y, x + width, y + height, Color.CHARTREUSE)

        renderer.text(text, x + width/2, y + width/2)
    }

}