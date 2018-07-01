package com.aquarius314.plane.main.menu

import com.aquarius314.engine.application.GameScreen
import com.aquarius314.engine.application.MenuScreen
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.GameMaster
import com.badlogic.gdx.Gdx

class MainMenu constructor(
        gameMaster: GameMaster, renderer: Renderer, soundManager: SoundManager
): MenuScreen(gameMaster, renderer, soundManager) {

    init {
        addStartButton()
        addOptionsButton()
    }

    private fun addStartButton() {
        val x = Gdx.graphics.width/3f
        val y = Gdx.graphics.height/5f * 3
        val width = Gdx.graphics.width/3f
        val height = Gdx.graphics.height/5f
        buttons.add(
                object : MenuButton(x, y, width, height, "Start", this) {
                    override fun onClick(x: Float, y: Float) {
                        gameMaster.game.start()
                        println("Starting game!")
                    }
                }
        )
    }

    private fun addOptionsButton() {
        val x = Gdx.graphics.width/3f
        val y = Gdx.graphics.height/5f * 1
        val width = Gdx.graphics.width/3f
        val height = Gdx.graphics.height/5f
        buttons.add(
                object : MenuButton(x, y, width, height, "Options", this) {
                    override fun onClick(x: Float, y: Float) {
                        gameMaster.optionsMenu.start()
                        println("Starting options menu!")
                    }
                }
        )
    }

}
