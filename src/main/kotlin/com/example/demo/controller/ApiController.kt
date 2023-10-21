package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import com.example.ApiControllerApi


import com.example.demo.dto.EntryRequestDto
import com.example.demo.dto.EntryResponseDto


@RestController
@RequestMapping("entry")
class ApiController {

    @GetMapping("/")
    fun getApi(): String {
        return "test";
    }

    @PostMapping("/")
    fun postApi(@RequestBody @Validated request: EntryRequestDto, bindingResult: BindingResult): EntryResponseDto {

        if(bindingResult.hasErrors()){
            return EntryResponseDto(request.id, request.customer.name, request.date, bindingResult.getSuppressedFields()[0])
        }
        return EntryResponseDto(request.id, request.customer.name, request.date, "success");
    }

    @GetMapping("/test")
    fun getTestApi(): String {
        val client = ApiControllerApi();
        println("APIクライアント開始")
        val str = client.getApi();
        println("APIクライアント終了")
        return str;
    }    
}