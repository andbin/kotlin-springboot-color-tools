/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.model.css

import it.andbin.colortools.util.Coded
import it.andbin.colortools.util.CodedEnumLookup

enum class CssSpecification(override val code: String, val desc: String) : Coded {
    LEVEL_1("level-1", "CSS Level 1"),
    LEVEL_2_REV_1("level-2-rev-1", "CSS Level 2 (Revision 1)"),
    COLOR_MODULE_LEVEL_3("module-level-3", "CSS Color Module Level 3"),
    COLOR_MODULE_LEVEL_4("module-level-4", "CSS Color Module Level 4");

    companion object {
        val lookup = CodedEnumLookup(CssSpecification::class, values())
    }
}
