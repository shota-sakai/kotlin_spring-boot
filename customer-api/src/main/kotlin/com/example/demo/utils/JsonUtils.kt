package com.example.demo.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode

class JsonUtils() {

  private val mapper = ObjectMapper()

  enum class Kind {
    ENUM1,
    ENUM2,
    ENUM3,
  }

  data class dto(
    val data1: String,
    val data2: String,
  ) 

  fun main( kind: Kind ): String {
    val l = listOf(
      dto("data1_1", "data2_1"),
      dto("data1_2", "data2_2"),
      dto("data3_2", "data3_2"),
      dto("data4_2", "data4_2"),
    )
    return method(kind, l)
  }

  private fun method( kind: Kind, list: List<dto> ): String {

    return when (kind) {
      Kind.ENUM1 -> { 
        Kind.ENUM1.name
      }
      Kind.ENUM2 -> {
        Kind.ENUM2.name
      }
      Kind.ENUM3 -> {
        println("list=$list")
        val m = mapOf(Kind.ENUM3.name to list.map { it.data2 })
        println("m=$m")
        m.get(Kind.ENUM3.name)!!.first()
      }
    }
  }
}