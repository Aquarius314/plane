package com.aquarius314.plane.main

import com.aquarius314.engine.application.GameScreen
import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.elements.DecorationManager
import com.aquarius314.plane.main.elements.GameElementsManager
import com.aquarius314.plane.main.player.Plane

open class GdxGame constructor(gameMaster: GameMaster,
                          renderer: Renderer,
                          soundManager: SoundManager) : GameScreen(gameMaster, renderer, soundManager) {

    companion object Level {
        @JvmStatic
        val levelNumber = 2
    }

    override val inputProcessor = MainInputProcessor(this)
    var plane = Plane(200f, 250f)
    var decorationManager : DecorationManager? = null
    var ui: UIManager? = null
    var elementsManager : GameElementsManager? = null

    init {
        ui = UIManager(this)
        decorationManager = DecorationManager()
        elementsManager = GameElementsManager()
        plane.game = this
    }

    fun openMenu() {
        // TODO temporary
        plane.frozen = !plane.frozen
    }

	override fun render (delta: Float) {
        calculate()
        renderGame()
	}

    private fun calculate() {
        plane.actions(this)
        decorationManager!!.actions(this)
        elementsManager!!.actions(this)
    }

    private fun renderGame() {
        renderer.renderBackground()
        decorationManager!!.display(renderer)
        elementsManager!!.display(renderer)
        plane.display(renderer)
        ui!!.display(renderer)
        renderer.finishRendering()
    }
}
