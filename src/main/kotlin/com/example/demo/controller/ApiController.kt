package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("entry")
class ApiController {

    @GetMapping("/")
    fun getApi(): String {
        return "test";
    }

    // fun postApi() {

    // }
}