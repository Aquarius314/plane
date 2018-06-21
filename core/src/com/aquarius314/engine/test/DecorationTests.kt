package com.aquarius314.engine.test

import com.aquarius314.engine.graphics.Decoration
import com.aquarius314.engine.logic.MeasurableProperty
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DecorationTests {

    private val filename = "decoration"
    private val x = 3f
    private val y = 4f

    class DecorationImplementation(
            x: Float,
            y: Float,
            img: String,
            override var xSpeed: MeasurableProperty = MeasurableProperty(3f, 3f),
            override var ySpeed: MeasurableProperty = MeasurableProperty(0f, 0f))
        : Decoration(x, y, img)

    @Test
    fun testDecorationCreation() {
        val decoration = DecorationImplementation(x, y, filename)
        assertTrue(decoration.x == x)
        assertTrue(decoration.y == y)
        assertTrue(decoration.imageFileName == filename)
        assertTrue(decoration.isVisible())
    }

    @Test
    fun testDecorationVisibility() {
        val decoration = DecorationImplementation(-500f, y, filename)
        assertFalse(decoration.isVisible())
    }

    @Test
    fun testDecorationMove() {
        val decoration = DecorationImplementation(x, y, filename)
        decoration.move(-decoration.xSpeed.value, 0f)
        assertTrue(decoration.x == x - decoration.xSpeed.value)
        decoration.moveTo(-100f, -100f)
        assertTrue(decoration.x == -100f && decoration.y == -100f)
    }

}