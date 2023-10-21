package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import com.example.ApiControllerApi
import org.openapitools.client.model.EntryResponseTestDto


import com.example.demo.dto.EntryRequestDto


@RestController
@RequestMapping("search")
class ApiController {

    @GetMapping("/")
    fun getApi(): String {
        return "test";
    }

    // @PostMapping("/")
    // fun postApi(@RequestBody @Validated request: EntryRequestDto, bindingResult: BindingResult): EntryResponseDto {

    //     if(bindingResult.hasErrors()){
    //         return EntryResponseDto(request.id, request.customer.name, request.date, bindingResult.getSuppressedFields()[0])
    //     }
    //     return EntryResponseDto(request.id, request.customer.name, request.date, "success");
    // }

    @GetMapping("/test")
    fun getTestApi(): EntryResponseTestDto {
        val client = ApiControllerApi();
        println("APIクライアント開始")
        val result: EntryResponseTestDto = client.getTestApi();
        println("APIクライアント終了")
        return result;
    }    
}