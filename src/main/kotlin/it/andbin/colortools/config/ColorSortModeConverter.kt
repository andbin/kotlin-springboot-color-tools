/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.config

import it.andbin.colortools.model.ColorSortMode
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class ColorSortModeConverter : Converter<String, ColorSortMode> {
    override fun convert(source: String): ColorSortMode? = ColorSortMode.lookup.findByCodeOrFail(source)
}
