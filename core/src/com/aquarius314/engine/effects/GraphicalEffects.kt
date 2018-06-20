package com.aquarius314.engine.effects

object GraphicalEffects {

    fun clear() {
        shake = 0
    }

    var shake = 0
        set(value) {
            field = if (value < 0) {
                0
            } else {
                value
            }
        }
}