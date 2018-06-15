package com.aquarius314.plane.main.elements

import com.aquarius314.engine.graphics.Decoration
import com.aquarius314.plane.main.GdxGame

class Mountain(x: Float, y: Float, counter: Int) : Decoration(x, y, "mountain$counter.png") {

    override val speed: Int = 3

    override fun actions(game: GdxGame) {
        super.actions(game)
        println("x $x y $y")
    }

}