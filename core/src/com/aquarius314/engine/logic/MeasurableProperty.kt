package com.aquarius314.engine.logic

open class MeasurableProperty constructor(var min: Float, var max: Float, initialValue: Float = min) {

    var value: Float = min
        set(value) {
            field = when {
                value > max -> max
                value < min -> min
                else -> value
            }
        }

    init {
        this.value = initialValue
    }

}