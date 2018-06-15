package com.aquarius314.engine.resources

import com.badlogic.gdx.utils.Disposable


abstract class ResourceManager<T : Disposable>(var files: List<String>) {

    protected val assets: HashMap<String, T> = HashMap()

    init {
        loadAssets()
    }

    abstract fun loadAssets()

    fun get(filePath: String): T {
        return if (assets.containsKey(filePath)) {
            assets[filePath]!!
        } else {
            throw ResourceNotFoundException("Could not load resource: $filePath")
        }
    }

    fun dispose() {
        for (d in assets.values) {
            d.dispose()
        }
    }

}