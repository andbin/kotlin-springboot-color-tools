/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.util

import kotlin.reflect.KClass

class CodedEnumLookup<T>(kclass: KClass<T>, values: Array<T>) : EnumLookup<T>(kclass, values) where T : Enum<T>, T : Coded {
    fun findByCodeOrNull(code: String) = findBy { it.code == code }
    fun findByCodeOrFail(code: String) = findBy { it.code == code } ?: throw codeNotFoundException(code)
    fun findByCodeOrElse(code: String, defaultValue: T) = findBy { it.code == code } ?: defaultValue

    private fun codeNotFoundException(code: String) = EnumValueNotFoundException("Enum value not found for code $code in $className")
}
