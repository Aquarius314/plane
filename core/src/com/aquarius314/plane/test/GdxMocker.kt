package com.aquarius314.plane.test

import com.aquarius314.plane.main.GdxGame
import org.mockito.Mockito

class GdxMocker {

    fun mockGdxGame() = Mockito.mock(GdxGame::class.java)

}