/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.model

open class Color(red: Int, green: Int, blue: Int, val name: String = "") {
    val red: Int = red and 0xFF
    val green: Int = green and 0xFF
    val blue: Int = blue and 0xFF
    val hex by lazy { "#%02X%02X%02X".format(this.red, this.green, this.blue) }
    val rgb by lazy { "rgb(%d,%d,%d)".format(this.red, this.green, this.blue) }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Color

        if (red != other.red) return false
        if (green != other.green) return false
        if (blue != other.blue) return false

        return true
    }

    override fun hashCode(): Int {
        var result = red.toInt()
        result = 31 * result + green
        result = 31 * result + blue
        return result
    }

    override fun toString() = if (name.isEmpty()) "Color[$hex]" else "Color[$hex, \"$name\"]"


    companion object {
        val ascendingNameComparator: Comparator<Color> = Comparator.comparing(Color::name)
        val descendingNameComparator: Comparator<Color> = ascendingNameComparator.reversed()

        fun wholeNamePredicate(name: String) = { color: Color -> color.name.equals(name, true) }
        fun partialNamePredicate(name: String) = { color: Color -> color.name.contains(name, true) }
        fun initialNamePredicate(name: String) = { color: Color -> color.name.startsWith(name, true) }
        fun finalNamePredicate(name: String) = { color: Color -> color.name.endsWith(name, true) }

        fun of(name: String, rgbVal: Int) = Color(rgbVal shr 16, rgbVal shr 8, rgbVal, name)
    }
}
