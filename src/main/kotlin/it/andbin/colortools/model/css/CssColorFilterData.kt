/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.model.css

import it.andbin.colortools.model.ColorFilterData

class CssColorFilterData : ColorFilterData() {
    var spec: CssSpecification = CssSpecification.COLOR_MODULE_LEVEL_4
}
