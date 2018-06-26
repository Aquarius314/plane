package com.aquarius314.engine.logic

import com.aquarius314.engine.graphics.Renderer
import com.aquarius314.plane.main.GdxGame

class CollectionManager<T : ActiveFragment>(var generator: ElementGenerator<T>) : Active {

    val collection = arrayListOf<T>()

    fun display(renderer: Renderer) {
        collection.forEach { element -> element.display(renderer) }
    }

    override fun actions(game: GdxGame) {
        collection.forEach { element -> element.actions(game) }
        maintainCollection()
    }

    protected fun maintainCollection() {
        removeOldElements()
        generator.generateInto(collection)
    }

    protected fun removeOldElements() {
        val oldElements = collection.filter { el -> el.isExpired() }
        collection.removeAll(oldElements)
    }

}