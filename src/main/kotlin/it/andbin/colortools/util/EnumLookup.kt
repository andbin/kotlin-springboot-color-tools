/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools.util

import kotlin.reflect.KClass

open class EnumLookup<T : Enum<T>>(private val kclass: KClass<T>, private val values: Array<T>) {
    protected val className get() = kclass.qualifiedName

    fun findByNameOrNull(name: String) = findBy { it.name == name }
    fun findByNameOrFail(name: String) = findBy { it.name == name } ?: throw nameNotFoundException(name)
    fun findByNameOrElse(name: String, defaultValue: T) = findBy { it.name == name } ?: defaultValue

    protected fun findBy(predicate: (T) -> Boolean): T? = values.firstOrNull(predicate)

    private fun nameNotFoundException(name: String) = EnumValueNotFoundException("Enum value not found for name $name in $className")
}
