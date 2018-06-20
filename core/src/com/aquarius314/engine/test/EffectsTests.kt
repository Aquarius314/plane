package com.aquarius314.engine.test

import com.aquarius314.engine.effects.GraphicalEffects
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class EffectsTests {

    private val shake = 13

    @Before
    fun setup() {
        GraphicalEffects.clear()
    }

    @Test
    fun testClearingValueOfShake() {
        assertTrue(GraphicalEffects.shake == 0)
    }

    @Test
    fun testSettingValueOfShake() {
        GraphicalEffects.shake = shake
        assertTrue(GraphicalEffects.shake == shake)
    }

    @Test
    fun testOnlyPositiveValuesOfShake() {
        GraphicalEffects.shake = -shake
        assertTrue(GraphicalEffects.shake == 0)
    }

}