package com.aquarius314.plane.main

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.menu.MainMenu
import com.aquarius314.plane.main.menu.OptionsMenu
import com.badlogic.gdx.Game



class GameMaster : Game() {

    var state = 1   // 1-menu 2-game

    lateinit var renderer: Renderer
    lateinit var soundManager: SoundManager
    lateinit var mainMenu: MainMenu
    lateinit var optionsMenu: OptionsMenu
    lateinit var game: GdxGame

    override fun create() {
        renderer = Renderer(specialImageManager = LevelTexturesManager())
        soundManager = SoundManager(Resources.sounds)
        mainMenu = MainMenu(this, renderer, soundManager)
        optionsMenu = OptionsMenu(this, renderer, soundManager)
        game = GdxGame(this, renderer, soundManager)
        mainMenu.start()
    }

    override fun render() {
        renderer.renderBackground()
        renderer.finishRendering()
        super.render()
    }

    override fun dispose() {
        super.dispose()
        renderer.dispose()
        soundManager.dispose()
    }

}