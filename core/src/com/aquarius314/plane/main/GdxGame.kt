package com.aquarius314.plane.main

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.resources.SoundManager
import com.aquarius314.plane.main.elements.DecorationManager
import com.aquarius314.plane.main.player.Plane
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx

class GdxGame : ApplicationAdapter() {

    var plane = Plane(200f, 250f)
    var renderer: Renderer? = null
    var soundManager: SoundManager? = null
    var decorationManager : DecorationManager? = null
    var ui: UIManager? = null
//    val gameObjects = arrayListOf<GameObject>()

	override fun create () {
        renderer = Renderer()
        ui = UIManager(this)
        soundManager = SoundManager(Resources.sounds)
        decorationManager = DecorationManager()
        Gdx.input.inputProcessor = MainInputProcessor(this)
        plane.game = this
	}

    fun openMenu() {
        plane.frozen = !plane.frozen
    }

	override fun render () {
        calculate()
        renderGame()
	}

    fun calculate() {
        plane.actions(this)
        decorationManager!!.actions(this)
    }

    fun renderGame() {
        renderer!!.renderBackground()
        decorationManager!!.display(renderer!!)
        plane.display(renderer!!)
        ui!!.display(renderer!!)
        renderer!!.finishRendering()
    }

	override fun dispose () {
        renderer!!.dispose()
        soundManager!!.dispose()
	}
}
