/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.controller

import it.andbin.colortools.controller.model.CssColorsBrowserForm
import it.andbin.colortools.model.ColorFilterData
import it.andbin.colortools.model.ColorNameMatchMode
import it.andbin.colortools.model.ColorSortMode
import it.andbin.colortools.model.css.CssSpecification
import it.andbin.colortools.model.css.cssColorModuleLevel3Colors
import it.andbin.colortools.model.css.cssColorModuleLevel4Colors
import it.andbin.colortools.model.css.cssLevel1Colors
import it.andbin.colortools.model.css.cssLevel2Rev1Colors
import it.andbin.colortools.service.ColorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.servlet.ModelAndView

@Controller
class ColorBrowserController {

    @Autowired
    private lateinit var colorService: ColorService

    @GetMapping("/css-colors.html")
    fun getCssColorsBrowser(@ModelAttribute("form") formData: CssColorsBrowserForm): ModelAndView {
        val colorPalette = when (formData.spec) {
            CssSpecification.LEVEL_1 -> cssLevel1Colors
            CssSpecification.LEVEL_2_REV_1 -> cssLevel2Rev1Colors
            CssSpecification.COLOR_MODULE_LEVEL_3 -> cssColorModuleLevel3Colors
            CssSpecification.COLOR_MODULE_LEVEL_4 -> cssColorModuleLevel4Colors
        }

        val colorFilterData = ColorFilterData(formData.nameFilter, formData.nameMatchMode, formData.sortMode)
        val colorPaletteOut = colorService.filterColorPalette(colorPalette, colorFilterData)

        return ModelAndView("colors-browser").apply {
            addObject("title", "CSS Colors")
            addObject("specs", CssSpecification.values())
            addObject("colorPalette", colorPaletteOut)
            addObject("totalColors", colorPalette.colorsCount)
        }
    }

    @ModelAttribute("colorNameMatchModes")
    fun getColorNameMatchModes() = ColorNameMatchMode.values()

    @ModelAttribute("colorSortModes")
    fun getColorSortModes() = ColorSortMode.values()
}
