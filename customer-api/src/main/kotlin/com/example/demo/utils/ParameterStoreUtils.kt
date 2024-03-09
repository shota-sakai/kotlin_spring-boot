package com.example.demo.utils

import kotlinx.coroutines.runBlocking
import aws.sdk.kotlin.services.ssm.SsmClient
import aws.sdk.kotlin.services.ssm.model.GetParameterRequest

class ParameterStoreUtils() {

    fun getParameter() = runBlocking {

      val param = GetParameterRequest {
        name = "/integration-app/test2"
      }

      SsmClient { region = "ap-northeast-1" }.use { client ->
        val response = client.getParameter(param)
        println("parameter=${response.parameter}")
        val value = response.parameter?.value
        println("value=${response?.parameter?.value}")
      }
    }
}