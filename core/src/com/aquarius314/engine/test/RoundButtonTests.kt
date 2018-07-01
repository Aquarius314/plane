package com.aquarius314.engine.test

import com.aquarius314.engine.ui.RoundButton
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class RoundButtonTests {

    private var clicked = false
    private val x = 100f
    private val y = 100f
    private val r = 20f
    private val imgFile = "_"

    val button = object : RoundButton(x, y, r, imgFile) {
        override fun onClick(x: Float, y: Float) {
            clicked = !clicked
        }
    }

    @Test
    fun testButtonCreation() {
        assertTrue(button.x == x)
        assertTrue(button.y == y)
        assertTrue(button.radius == r)
        assertTrue(button.imgFile == imgFile)
    }

    @Test
    fun testButtonClick() {
        clicked = false
        assertFalse(clicked)
        assertTrue(button.checkClick(x, y))
        assertTrue(clicked)
        assertFalse(button.checkClick(x + r + 5, y))
        assertTrue(clicked)
    }

}