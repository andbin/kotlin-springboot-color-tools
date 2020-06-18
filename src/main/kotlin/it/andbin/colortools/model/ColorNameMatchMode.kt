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

enum class ColorNameMatchMode(override val code: String, val desc: String) : Coded {
    WHOLE("whole", "Whole"),
    PARTIAL("partial", "Partial"),
    INITIAL("initial", "Initial"),
    FINAL("final", "Final");

    companion object {
        val lookup = CodedEnumLookup(ColorNameMatchMode::class, values())
    }
}
