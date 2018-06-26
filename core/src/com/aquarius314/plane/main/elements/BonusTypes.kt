package com.aquarius314.plane.main.elements

import com.aquarius314.plane.main.player.Plane
import java.util.*

enum class BonusType(val code: Int, val image: String, val affectPlayer : (plane: Plane) -> Unit) {

    WEAPON(1, "boxweapon.png", {
        plane -> plane.weaponManager.ammunition.value += 20
    }),
    HEALTH(2, "boxhealth.png", {
        plane -> plane.health.value += 50
    }),
    ROCKET(3, "boxrocket.png", {
        plane -> plane.points += 10
    }),
    POINTS(4, "boxpoints.png", {
        plane -> plane.weaponManager.rockets.value += 3
    });

    companion object {
        @JvmStatic
        fun random() : BonusType = when (Math.abs(Random().nextInt()%1000)) {
            in 0..100 -> ROCKET
            in 101..300 -> POINTS
            in 301..600 -> HEALTH
            else -> WEAPON
        }
    }
}