package com.aquarius314.plane.main.menu

import com.aquarius314.engine.application.MenuScreen
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.GameMaster
import com.aquarius314.plane.main.Settings
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
                object : MenuButton(x, y, width, height, "Return", this) {
                    override fun onClick(x: Float, y: Float) {
                        gameMaster.mainMenu.start()
                        println("Returning to Main Menu")
                    }
                }
        )
    }

    private fun addSoundButton() {
        fun getSoundText() : String = if (Settings.soundOn) "Sound\n   on" else "Sound\n   off"
        val x = unitW
        val y = unitH * 4
        buttons.add(
                object : MenuButton(x, y, width, height, getSoundText(), this) {
                    override fun onClick(x: Float, y: Float) {
                        Settings.soundOn = !Settings.soundOn
                        this.text = getSoundText()
                        println("Switching sound")
                    }
                }
        )
    }

    private fun addMusicButton() {

    }
}