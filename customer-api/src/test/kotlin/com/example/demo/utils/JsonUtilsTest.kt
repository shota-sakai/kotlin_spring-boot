package com.example.demo.utils

import org.junit.jupiter.api.Test
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.example.demo.utils.JsonUtils.Kind

class JsonUtilsTest() {

  @Test
  fun test001() {
    JsonUtils().main(Kind.ENUM1)
    JsonUtils().main(Kind.ENUM2)
    JsonUtils().main(Kind.ENUM3)
  }
}