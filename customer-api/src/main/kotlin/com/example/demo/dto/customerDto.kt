package com.example.demo.dto

import jakarta.validation.constraints.*
import jakarta.validation.Valid
import com.example.demo.dto.AddressDto

data class CustomerDto(
    @field:NotEmpty(message = "ユーザー名は必須です。")
    val name: String?, 

    @field:Valid
    val address: AddressDto?
)