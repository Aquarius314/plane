package com.aquarius314.engine.application

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.GameMaster
import com.aquarius314.plane.main.menu.MenuButton

abstract class MenuScreen constructor(
        gameMaster: GameMaster, renderer: Renderer, soundManager: SoundManager
) : GameScreen(gameMaster, renderer, soundManager) {

    val buttons = arrayListOf<MenuButton>()

    override val inputProcessor = MenuScreenInputProcessor(this)

    override fun render(delta: Float) {
        renderer.renderBackground()
        buttons.forEach { b -> b.display(renderer) }
        renderer.finishRendering()
    }

}