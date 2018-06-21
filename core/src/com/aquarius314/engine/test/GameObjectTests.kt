package com.aquarius314.engine.test

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.engine.logic.GameObject
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test
import java.util.*
import org.mockito.Mockito.mock

class GameObjectTests {

    private fun mockGameObject(x: Float = 0f, y: Float = 0f) : GameObject {
        val obj = mock(GameObject::class.java)
        obj.x = x
        obj.y = y
        return obj
    }

    @Test
    fun testCollisions() {
        val obj1 = mockGameObject()
        val obj2 = mockGameObject(obj1.colliderR*2, 0f)
        assertTrue(obj1.collidesWith(obj2))
        obj2.x += 1f
        assertFalse(obj1.collidesWith(obj2))
    }

    @Test
    fun testInterchangeableCollisions() {
        val randomX1 = Random().nextInt()%200 - 100
        val randomY1 = Random().nextInt()%200 - 100
        val randomX2 = Random().nextInt()%200 - 100
        val randomY2 = Random().nextInt()%200 - 100
        val obj1 = mockGameObject(randomX1.toFloat(), randomY1.toFloat())
        val obj2 = mockGameObject(randomX2.toFloat(), randomY2.toFloat())
        assertTrue(obj1.collidesWith(obj2) == obj2.collidesWith(obj1))
    }

    @Test
    fun testCollidingWithItself() {
        val obj = mockGameObject()
        assertFalse(obj.collidesWith(obj))
    }

}