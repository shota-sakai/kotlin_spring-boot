package com.example.demo.dto

import jakarta.validation.constraints.*

data class AddressDto(
    @field:NotEmpty(message = "都道府県は必須です。")
    val prefectures: String?,
    @field:NotBlank(message = "市区町村は必須です。")
    val municipalities: String?
)