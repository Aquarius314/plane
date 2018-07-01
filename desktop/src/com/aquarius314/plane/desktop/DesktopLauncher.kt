package com.aquarius314.plane.desktop

import com.aquarius314.plane.main.GameMaster
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.aquarius314.plane.main.GdxGame

fun main(arg: Array<String>) {
    val config = LwjglApplicationConfiguration()
    LwjglApplication(GameMaster(), config)
}
