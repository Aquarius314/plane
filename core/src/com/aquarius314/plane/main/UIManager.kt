package com.aquarius314.plane.main

import com.aquarius314.engine.graphics.Displayable
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.ui.Button

class UIManager constructor(var game: GdxGame) : Displayable{

    val buttons = arrayListOf<Button>()

    init {
        buttons.add(
            object : Button(100f, 100f, 50f, "buttonshoot.png") {
                override fun onClick(x: Float, y: Float) {
                    println("Hehe $imgFile was clicked")
                }
            }
        )
    }

    override fun display(renderer: Renderer) {
        buttons.forEach { b -> b.display(renderer) }
    }

    fun anyButtonClicked(x: Float, y: Float) : Boolean {
        var anyButtonClicked: Boolean = false
        for (b in buttons) {
            anyButtonClicked = anyButtonClicked || b.checkClick(x, y)
        }
        return anyButtonClicked
    }

}