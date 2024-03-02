package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.context.annotation.Bean
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.HttpStatus
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.example.ApiControllerApi


import com.example.demo.dto.EntryRequestDto
import com.example.demo.dto.EntryResponseDto
import com.example.demo.dto.EntryResponseTestDto

import com.commons.demo.service.CommonsService
import kotlin.io.println
import org.springframework.security.core.context.SecurityContextHolder


@RestController
@RequestMapping("entry")
class ApiController(
    private val commonsService: CommonsService
) {

    @GetMapping("/")
    fun getApi(@Validated request: EntryRequestDto, result: BindingResult): ResponseEntity<Any> {

        // if (result.hasErrors()) {
        //     println(result.toString())
        //     // return ResponseEntity(EntryResponseTestDto("error"), HttpStatus.BAD_REQUEST);
        //     val error = result.getGlobalErrors()[0]
        //     val param = error.getArguments()
        //     if ( param is Object ){
        //         val e = param[1]
        //         return ResponseEntity.ok("")
        //     }
        //     return ResponseEntity.ok(param)
        // }

        println("test：${SecurityContextHolder.getContext().getAuthentication()}")
        println("commonservice呼び出し：${commonsService.execute()}")

        return ResponseEntity.ok(EntryResponseTestDto("entry"));
    }

    @PostMapping("/")
    fun postApi(@RequestBody @Validated request: EntryRequestDto, bindingResult: BindingResult): ResponseEntity<EntryResponseDto> {
        
        if(bindingResult.hasErrors()){
            return ResponseEntity.ok(EntryResponseDto(bindingResult.allErrors.toString(), 1))
        }

        println("test：${SecurityContextHolder.getContext().getAuthentication()}")
        return ResponseEntity.ok(EntryResponseDto(request.id, request.num));
    }

    @GetMapping("/test")
    fun getTestApi(): ResponseEntity<EntryResponseTestDto> {
        return ResponseEntity.ok(EntryResponseTestDto("entry/test"));
    }
    // @Bean
    // open fun objectMapperBuilder(): Jackson2ObjectMapperBuilder {
    //     return Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())    
    // }
        
}