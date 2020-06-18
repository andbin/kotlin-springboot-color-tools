/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.model

class ColorPaletteBuilder(private val name: String) {
    private val colorsList = mutableListOf<Color>()

    fun build() = ColorPalette(name, colorsList.toList())

    operator fun Color.unaryPlus() {
        colorsList.add(this)
    }

    operator fun ColorPalette.unaryPlus() {
        colorsList.addAll(this.colors)
    }
}
