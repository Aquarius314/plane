package com.aquarius314.engine.ui

import com.aquarius314.engine.application.GameScreen
import com.aquarius314.engine.application.Settings
import com.aquarius314.plane.main.menu.MenuButton

class ButtonFactory {

    fun createReturnButton(
            x: Float, y: Float, width: Float, height: Float, parent: GameScreen, previousScreen: GameScreen
    ) : MenuButton {
        return object : MenuButton(x, y, width, height, "Return", parent) {
            override fun onClick(x: Float, y: Float) {
                previousScreen.start()
            }
        }
    }

    fun createMusicButton(x: Float, y: Float, width: Float, height: Float, parent: GameScreen) : SwitchButton {
        val musicGetter = { getMusic() }
        val musicSwitcher = { invertMusic() }
        return SwitchButton(x, y, width, height, parent, musicGetter, musicSwitcher, "Music")
    }

    private fun invertMusic() {
        Settings.musicOn = !Settings.musicOn
    }

    private fun getMusic() : Boolean = Settings.musicOn

    fun createSoundButton(x: Float, y: Float, width: Float, height: Float, parent: GameScreen) : SwitchButton {
        val soundGetter = { getSound() }
        val soundSwitcher = { invertSound() }
        return SwitchButton(x, y, width, height, parent, soundGetter, soundSwitcher, "Sound")
    }

    private fun invertSound() {
        Settings.soundOn = !Settings.soundOn
    }

    private fun getSound() : Boolean = Settings.soundOn

}