package com.aquarius314.plane.main

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.menu.Menu
import com.badlogic.gdx.Game



class GameMaster : Game() {

    var state = 1   // 1-menu 2-game

    lateinit var renderer: Renderer
    lateinit var soundManager: SoundManager
    lateinit var menu: Menu
    lateinit var game: GdxGame

    override fun create() {
        renderer = Renderer(specialImageManager = LevelTexturesManager())
        soundManager = SoundManager(Resources.sounds)
        menu = Menu(this, renderer, soundManager)
        game = GdxGame(this, renderer, soundManager)
        menu.start()
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