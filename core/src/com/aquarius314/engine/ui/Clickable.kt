package com.aquarius314.engine.ui

import com.aquarius314.engine.graphics.Displayable

interface Clickable : Displayable{
    fun onClick(x: Float, y: Float)
}