package com.aquarius314.plane.main

import com.aquarius314.engine.ui.GameInputProcessor

class MainInputProcessor constructor(var game: GdxGame) : GameInputProcessor() {

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        game.plane.jump(game)
//        GraphicalEffects.shake = 10
        return super.touchDown(screenX, screenY, pointer, button)
    }

}