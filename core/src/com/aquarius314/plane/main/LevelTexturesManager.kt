package com.aquarius314.plane.main

import com.aquarius314.engine.application.Settings
import com.aquarius314.engine.resources.ImageManager
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

class LevelTexturesManager(files: List<String> = Resources.levelTextures) : ImageManager(files) {

    override fun loadImage(fileName: String) {
        val level = Settings.levelNumber
        val image = Texture(Gdx.files.internal("levels/$level/$fileName"))
        assets[fileName] = image
    }

}