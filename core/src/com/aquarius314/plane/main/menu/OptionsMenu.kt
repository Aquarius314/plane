package com.aquarius314.plane.main.menu

import com.aquarius314.engine.application.MenuScreen
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.GameMaster
import com.aquarius314.engine.ui.ButtonFactory
import com.badlogic.gdx.Gdx

class OptionsMenu constructor(
        gameMaster: GameMaster, renderer: Renderer, soundManager: SoundManager
): MenuScreen(gameMaster, renderer, soundManager) {

    private val widthUnits = 16f
    private val heightUnits = 10f
    private val unitW = Gdx.graphics.width/widthUnits
    private val unitH = Gdx.graphics.height/heightUnits
    private val width = unitW * 3
    private val height = unitH * 2

    init {
        addReturnButton()
        addSoundButton()
        addMusicButton()
    }

    private fun addReturnButton() {
        val x = unitW
        val y = unitH
        buttons.add(
            ButtonFactory().createReturnButton(x, y, width, height, this, gameMaster.mainMenu)
        )
    }

    private fun addSoundButton() {
        val x = unitW
        val y = unitH * 4
        buttons.add(
            ButtonFactory().createSoundButton(x, y, width, height, this)
        )
    }

    private fun addMusicButton() {
        val x = unitW
        val y = unitH * 7
        buttons.add(
            ButtonFactory().createMusicButton(x, y, width, height, this)
        )
    }
}