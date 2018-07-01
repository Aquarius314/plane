package com.aquarius314.engine.ui

import com.aquarius314.engine.application.GameScreen
import com.aquarius314.plane.main.menu.MenuButton

open class SwitchButton constructor(
        x: Float, y: Float, width: Float, height: Float, parent: GameScreen,
        private var propertyGetter: () -> Boolean,
        private var propertySwitcher: () -> Unit,
        private var propertyName: String
) : MenuButton(x, y, width, height, "", parent) {

    init {
        updateText()
    }

    private fun updateText() {
        this.text = "$propertyName\n   " + if (propertyGetter()) "on" else "off"
    }

    override fun onClick(x: Float, y: Float) {
        propertySwitcher()
        updateText()
    }

    fun switch() {
        propertySwitcher()
        updateText()
    }
}