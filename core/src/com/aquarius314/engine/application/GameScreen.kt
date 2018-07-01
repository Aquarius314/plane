package com.aquarius314.engine.application

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.GameMaster
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.Screen

abstract class GameScreen constructor(var gameMaster: GameMaster,
                                  var renderer: Renderer,
                                  var soundManager: SoundManager) : Screen {

    abstract val inputProcessor: InputProcessor

    open fun start() {
        gameMaster.screen = this
        Gdx.input.inputProcessor = inputProcessor
    }

    override fun hide() {}

    override fun show() {}

    override fun pause() {}

    override fun resume() {}

    override fun resize(width: Int, height: Int) {}

    override fun dispose () {}

}