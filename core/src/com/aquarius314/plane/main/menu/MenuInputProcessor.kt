package com.aquarius314.plane.main.menu

import com.aquarius314.engine.ui.GameInputProcessor
import com.badlogic.gdx.Gdx

class MenuInputProcessor constructor(var menu: Menu): GameInputProcessor() {

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val x = screenX.toFloat()
        val y = (Gdx.graphics.height - screenY).toFloat()
        menu.buttons.forEach { b -> b.checkClick(x, y) }
        return false
    }

}