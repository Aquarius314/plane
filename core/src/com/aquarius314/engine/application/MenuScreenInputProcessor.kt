package com.aquarius314.engine.application

import com.aquarius314.engine.ui.GameInputProcessor
import com.badlogic.gdx.Gdx

open class MenuScreenInputProcessor constructor(var menu: MenuScreen): GameInputProcessor() {

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val x = screenX.toFloat()
        val y = (Gdx.graphics.height - screenY).toFloat()
        menu.buttons.forEach { b -> b.checkClick(x, y) }
        return false
    }

}