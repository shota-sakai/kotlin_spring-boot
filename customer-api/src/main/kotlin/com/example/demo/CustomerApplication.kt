package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com/commons/demo", "com/example/demo"])
class CustomerApplication

fun main(args: Array<String>) {
	runApplication<CustomerApplication>(*args)
}
