package com.aquarius314.engine.test

import com.aquarius314.engine.graphics.Decoration
import com.aquarius314.engine.logic.MeasurableProperty
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.mockito.Mockito.mock

class DecorationTests {

    private val filename = "decoration"
    private val x = 3f
    private val y = 4f

    private fun mockDecoration(x: Float, y: Float, filename: String) : Decoration {
        val dec = mock(Decoration::class.java)
        dec.x = x
        dec.y = y
        dec.imageFileName = filename
        dec.xSpeed = 3f
        dec.ySpeed = 0f
        return dec
    }

    @Test
    fun testDecorationCreation() {
        val decoration = mockDecoration(x, y, filename)
        assertTrue(decoration.x == x)
        assertTrue(decoration.y == y)
        assertTrue(decoration.imageFileName == filename)
        assertTrue(decoration.isVisible())
    }

    @Test
    fun testDecorationVisibility() {
        val decoration = mockDecoration(-500f, y, filename)
        assertFalse(decoration.isVisible())
    }

    @Test
    fun testDecorationMove() {
        val decoration = mockDecoration(x, y, filename)
        decoration.move()
        assertTrue(decoration.x == x + decoration.xSpeed)
        decoration.moveTo(-100f, -100f)
        assertTrue(decoration.x == -100f && decoration.y == -100f)
    }

}