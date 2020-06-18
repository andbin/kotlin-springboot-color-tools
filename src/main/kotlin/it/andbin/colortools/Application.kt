/*
 * Copyright (C) 2020 Andrea Binello ("andbin")
 *
 * This file is part of the "Kotlin+SpringBoot Color Tools" project
 * and is released under the MIT License. See one of the license files
 * included in the root of the project for the full text of the license.
 */

package it.andbin.colortools

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootApplication

fun main(args: Array<String>) {
    runApplication<BootApplication>(*args)
}
