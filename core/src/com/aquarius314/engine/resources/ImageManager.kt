package com.aquarius314.engine.resources

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

open class ImageManager(files: List<String>) : ResourceManager<Texture>(files) {

    override fun loadAssets() {
        for(imageFileName in files) {
            loadImage(imageFileName)
        }
    }

    protected open fun loadImage(fileName: String) {
        val image = Texture(Gdx.files.internal(fileName))
        assets[fileName] = image
    }

}