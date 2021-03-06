/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.controller.model

import it.andbin.colortools.model.ColorNameMatchMode
import it.andbin.colortools.model.ColorSortMode

open class ColorsBrowserForm {
    var nameFilter: String = ""
        set(value) { field = value.trim() }
    var nameMatchMode: ColorNameMatchMode = ColorNameMatchMode.PARTIAL
    var sortMode: ColorSortMode = ColorSortMode.NAME_ASCENDING
}
