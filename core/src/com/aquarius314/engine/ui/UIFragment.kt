package com.aquarius314.engine.ui

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.plane.main.GdxGame

interface UIFragment {
    fun display(renderer: Renderer)
    fun actions(game: GdxGame)
}