/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.service

import it.andbin.colortools.model.Color
import it.andbin.colortools.model.ColorFilterData
import it.andbin.colortools.model.ColorNameMatchMode
import it.andbin.colortools.model.ColorPalette
import it.andbin.colortools.model.ColorSortMode
import org.springframework.stereotype.Service

@Service
class ColorService {
    fun filterColorPalette(colorPalette: ColorPalette, filterData: ColorFilterData): ColorPalette {
        val nameFilter = filterData.nameFilter

        val predicate = if (nameFilter.isEmpty()) null else
            when (filterData.nameMatchMode) {
                ColorNameMatchMode.WHOLE -> Color.wholeNamePredicate(nameFilter)
                ColorNameMatchMode.PARTIAL -> Color.partialNamePredicate(nameFilter)
                ColorNameMatchMode.INITIAL -> Color.initialNamePredicate(nameFilter)
                ColorNameMatchMode.FINAL -> Color.finalNamePredicate(nameFilter)
            }

        val comparator = when (filterData.sortMode) {
            ColorSortMode.NAME_ASCENDING -> Color.ascendingNameComparator
            ColorSortMode.NAME_DESCENDING -> Color.descendingNameComparator
        }

        return colorPalette.filterAndSort(predicate, comparator)
    }
}
