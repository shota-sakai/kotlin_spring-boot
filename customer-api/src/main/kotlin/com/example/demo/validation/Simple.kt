package com.example.demo.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass
 
@MustBeDocumented
@Constraint(validatedBy = [SimpleValidator::class])
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Simple(
    val message: String = "{hoge.message}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val value1: String,
    val value2: String,
)