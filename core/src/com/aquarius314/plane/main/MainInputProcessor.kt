package com.aquarius314.plane.main

import com.aquarius314.engine.ui.GameInputProcessor
import com.badlogic.gdx.Gdx

class MainInputProcessor constructor(var game: GdxGame) : GameInputProcessor() {

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val x = screenX.toFloat()
        val y = (Gdx.graphics.height - screenY).toFloat()
        game.ui!!.anyButtonClicked(x, y)
        return super.touchDown(screenX, screenY, pointer, button)
    }

}