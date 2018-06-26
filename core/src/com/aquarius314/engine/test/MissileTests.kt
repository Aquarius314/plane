package com.aquarius314.engine.test

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.Missile
import com.aquarius314.plane.main.GdxGame
import junit.framework.Assert.assertTrue
import org.junit.Test
import java.util.*

class MissileTests {

    private class MissileImpl constructor(x: Float, y: Float, r: Float): Missile(x, y, r) {
        override fun actions(game: GdxGame) {}
        override fun display(renderer: Renderer) {}
    }

    @Test
    fun testMissileCreation() {
        val missile = MissileImpl(1f, 2f, 3f)
        assertTrue(missile.x == 1f)
        assertTrue(missile.y == 2f)
        assertTrue(missile.rotation == 3f)
    }

    @Test
    fun testMissileSpeeds() {
        val x = (Random().nextInt()%1000).toFloat()
        val y = (Random().nextInt()%1000).toFloat()
        val r = (Random().nextInt()%720 - 360).toFloat()
        val missile = MissileImpl(x, y, r)
        val expectedXSpeed = (Math.cos(Math.toRadians(r.toDouble())) * missile.unitSpeed).toFloat()
        val expectedYSpeed = (Math.sin(Math.toRadians(r.toDouble())) * missile.unitSpeed).toFloat()
        assertTrue(missile.xSpeed == expectedXSpeed)
        assertTrue(missile.ySpeed == expectedYSpeed)
        missile.move()
        assertTrue(missile.x == x + missile.xSpeed)
        assertTrue(missile.y == y + missile.ySpeed)
    }

}