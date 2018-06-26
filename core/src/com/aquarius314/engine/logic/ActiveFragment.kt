package com.aquarius314.engine.logic

import com.aquarius314.engine.graphics.Displayable

interface ActiveFragment : Displayable, Active {
    fun isExpired(): Boolean
}