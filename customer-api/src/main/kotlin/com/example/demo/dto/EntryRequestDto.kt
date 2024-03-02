package com.example.demo.dto

import com.example.demo.dto.CustomerDto

// import javax.validation.constraints.NotNull
// import org.hibernate.validator.constraints.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.NotBlank
import jakarta.validation.Valid
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.example.demo.validation.Simple


@JsonInclude(Include.NON_NULL)
// @Simple(value1="id", value2="idtest", message="相関チェックエラー")
data class EntryRequestDto (
    val id: String = "",
    val idtest: String?,
    val num: Int = 10000,
    // @field:Valid
    // val customer: CustomerDto,
    // @field:Pattern(regexp = "^([MTSH]\\d{1,2}|\\d{2,4})-?(0?[1-9]|1[0-2])-?(0?[1-9]|[1-2][0-9]|3[0-1])$", message = "日付形式ではありません。")
    // @field:DateTimeFormat(pattern = "yyyy-MM-dd") 
    // val date: Date
) 