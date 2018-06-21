package com.aquarius314.engine.test

import com.aquarius314.engine.logic.MeasurableProperty
import junit.framework.Assert.assertTrue
import org.junit.Test

class MeasurablePropertyTest {

    private val min = -10f
    private val max = 20f

    @Test
    fun testMeasurablePropertyCreation() {
        val property = MeasurableProperty(min, max)
        assertTrue(property.min == min)
        assertTrue(property.max == max)
        assertTrue(property.value == min)
    }

    @Test
    fun testOverflowingProperty() {
        val property = MeasurableProperty(min, max)
        property.value += 1f
        assertTrue(property.value == min + 1f)
        property.value -= 1000
        assertTrue(property.value == min)
        property.value += 1000
        assertTrue(property.value == max)
    }

}