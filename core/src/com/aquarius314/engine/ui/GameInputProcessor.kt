package com.aquarius314.engine.ui

import com.badlogic.gdx.InputProcessor

open class GameInputProcessor : InputProcessor {

    protected val keyPressedMap: HashMap<Int, Boolean> = hashMapOf(
            Pair(KeyCodes.W.value, false),
            Pair(KeyCodes.A.value, false),
            Pair(KeyCodes.S.value, false),
            Pair(KeyCodes.D.value, false)
    )

    fun isKeyPressed(key: Int) : Boolean {
        return keyPressedMap[key] ?: false
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean = false

    override fun keyDown(keycode: Int): Boolean {
        if (keyPressedMap.containsKey(keycode)) {
            keyPressedMap[keycode] = true
        } else {
            keyPressedMap.plus(Pair(keycode, true))
        }
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean = false

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean = false

    override fun keyTyped(character: Char): Boolean = false

    override fun scrolled(amount: Int): Boolean = false

    override fun keyUp(keycode: Int): Boolean {
        keyPressedMap[keycode] = false
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean = false

}