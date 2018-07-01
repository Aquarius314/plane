package com.aquarius314.plane.test

import com.aquarius314.plane.main.GdxGame
import com.aquarius314.plane.main.player.Plane
import org.mockito.Mockito

class GdxMocker {

    fun mockGdxGame() : GdxGame = Mockito.mock(GdxGame::class.java)

    fun mockPlane() : Plane = Mockito.mock(Plane::class.java)

}