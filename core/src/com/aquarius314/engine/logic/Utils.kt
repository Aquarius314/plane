package com.aquarius314.engine.logic

object Utils {

    fun distance(x1: Float, y1: Float, x2: Float, y2: Float) : Float{
        return Math.sqrt(Math.pow(x1.toDouble() - x2.toDouble(), 2.0) +
                Math.pow(y1.toDouble() - y2.toDouble(), 2.0)).toFloat()
    }

    fun pointInCircle(pointX: Float, pointY: Float, circleX: Float, circleY: Float, circleR: Float) : Boolean {
        return distance(pointX, pointY, circleX, circleY) <= circleR
    }

    fun pointInRectangle(pointX: Float, pointY: Float, rectX: Float, rectY: Float, rectWidth: Float, rectHeight: Float) : Boolean {
        return pointX in rectX..(rectX + rectWidth)
                && pointY in rectY..(rectY + rectHeight)
    }
}