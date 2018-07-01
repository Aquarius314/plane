package com.aquarius314.engine.test

import com.aquarius314.engine.logic.Utils
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class UtilsTests {

    @Test
    fun testDistance() {
        val x1 = 0f
        val y1 = 0f
        val x2 = 100f
        val y2 = 100f
        assertTrue(Utils.distance(x1, y1, x2, y2) == 100f*Math.sqrt(2.0).toFloat())
        assertTrue(Utils.distance(x1, y1, x2, y2) == Utils.distance(x2, y2, x1, y1))
        assertTrue(Utils.distance(x1, y1, x1, y1) == 0f)
        assertTrue(Utils.distance(x1, y1, x2, y2) == Utils.distance(x1, y1, y2, x2))
    }

    @Test
    fun testPointInCircle() {
        val areaX = 100f
        val areaY = 100f
        val pointX = 150f
        val pointY = 150f
        val areaR = 51*Math.sqrt(2.0).toFloat()
        assertTrue(Utils.pointInCircle(pointX, pointY, areaX, areaY, areaR))
        assertFalse(Utils.pointInCircle(pointX, pointY, areaX, areaY, areaR - 3f))
    }

    @Test
    fun testPointInRectangle() {
        val x = 0f
        val y = 0f
        val width = 100f
        val height = 300f
        assertTrue(Utils.pointInRectangle(10f, 10f, x, y, width, height))
        assertFalse(Utils.pointInRectangle(-10f, 10f, x, y, width, height))
    }

    @Test
    fun testElementFactory() {

    }

}