/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.model

import it.andbin.colortools.util.Coded
import it.andbin.colortools.util.CodedEnumLookup

enum class ColorSortMode(override val code: String, val desc: String) : Coded {
    NAME_ASCENDING("name-asc", "Name (ascending)"),
    NAME_DESCENDING("name-desc", "Name (descending)");

    companion object {
        val lookup = CodedEnumLookup(ColorSortMode::class, values())
    }
}
