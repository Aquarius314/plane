package com.aquarius314.plane.main.menu

import com.aquarius314.engine.application.GameScreen
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.GameMaster

class Menu constructor(gameMaster: GameMaster,
                       renderer: Renderer,
                       soundManager: SoundManager): GameScreen(gameMaster, renderer, soundManager) {

    val buttons = arrayListOf<MenuButton>()

    override val inputProcessor = MenuInputProcessor(this)

    init {
        buttons.add(
            object : MenuButton(100f, 100f, 200f, 100f, "Start") {
                override fun onClick(x: Float, y: Float) {
                    gameMaster.game.start()
                    println("Started!")
                }
            }
        )
    }

    override fun render(delta: Float) {
        renderer.renderBackground()
        buttons.forEach { b -> b.display(renderer) }
        renderer.finishRendering()
    }

}
