package com.aquarius314.engine.test

import com.aquarius314.engine.ui.RectangularButton
import com.aquarius314.engine.ui.RoundButton
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class ButtonsTests {

    val x = 100f
    val y = 100f

    @Test
    fun testRoundButton() {
        val radius = 50f
        val roundButton = object : RoundButton(x, y, radius, "") {
            var clicked = false
            override fun onClick(x: Float, y: Float) {
                clicked = !clicked
            }
        }
        assertFalse(roundButton.clicked)
        assertTrue(roundButton.checkClick(x + radius/10f, y + radius/10f))
        assertTrue(roundButton.clicked)
        assertFalse(roundButton.checkClick(x + radius, y + radius))
    }

    @Test
    fun testRectangularButton() {
        val width = 100f
        val height = 100f
        val rectButton = object : RectangularButton(x, y, width, height) {
            var clicked = false
            override fun onClick(x: Float, y: Float) {
                clicked = !clicked
            }
        }
        assertFalse(rectButton.clicked)
        assertTrue(rectButton.checkClick(x + width/2f, y + height/2f))
        assertTrue(rectButton.clicked)
        assertFalse(rectButton.checkClick(x + width + 1f, y + height))
    }
}