/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.model

class ColorPalette(val name: String, val colors: List<Color>) {
    val colorsCount get() = colors.size

    fun filterAndSort(predicate: ((Color) -> Boolean)?, comparator: Comparator<Color>?): ColorPalette {
        val filteredColors = if (predicate != null) colors.filter(predicate) else colors
        val sortedColors = if (comparator != null) filteredColors.sortedWith(comparator) else filteredColors
        return ColorPalette(name, sortedColors)
    }

    companion object {
        inline fun builder(name: String, block: ColorPaletteBuilder.() -> Unit): ColorPalette {
            val builder = ColorPaletteBuilder(name)
            builder.block()
            return builder.build()
        }
    }
}
