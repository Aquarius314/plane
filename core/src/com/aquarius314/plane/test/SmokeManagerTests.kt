package com.aquarius314.plane.test

import com.aquarius314.plane.main.effects.SmokeManager
import junit.framework.Assert.assertTrue
import org.junit.Test

class SmokeManagerTests {

    val x = 100f
    val y = 100f

    @Test
    fun testSmokeManagerActions() {
        val smokeManager = SmokeManager(GdxMocker().mockPlane())
        val game = GdxMocker().mockGdxGame()
        assertTrue(smokeManager.smokes.size == 0)
        repeat(smokeManager.smokesPeriod, { smokeManager.actions(game) })
        assertTrue(smokeManager.smokes.size == 1)
        val firstSmokeX = smokeManager.smokes[0].x
        smokeManager.actions(game)
        assertTrue(firstSmokeX != smokeManager.smokes[0].x)
    }

    @Test
    fun testMaxSmokes() {
        val smokeManager = SmokeManager(GdxMocker().mockPlane())
        val game = GdxMocker().mockGdxGame()
        assertTrue(smokeManager.smokes.size == 0)
        repeat(smokeManager.smokesPeriod * (smokeManager.maxNumberOfSmokes + 1),
                { smokeManager.actions(game) })
        assertTrue(smokeManager.smokes.size == smokeManager.maxNumberOfSmokes)
    }

}