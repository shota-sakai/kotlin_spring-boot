package com.example.demo.utils

import kotlinx.coroutines.runBlocking
import aws.sdk.kotlin.services.eventbridge.model.PutEventsRequestEntry
import aws.sdk.kotlin.services.eventbridge.model.PutEventsRequest
import aws.sdk.kotlin.services.eventbridge.EventBridgeClient

class EventBridgeUtils(private val value: String) {
  fun triggerCustomRule() = runBlocking {
    val entry = PutEventsRequestEntry {
        source = "test"
        detail = "{}"
        // detail = "{\"c-count\": \"test\"}"
        detailType = "testDetail"
    }

    val eventsRequest = PutEventsRequest {
        this.entries = listOf(entry)
    }    

    EventBridgeClient { region = value }.use { eventBrClient ->
        val response = eventBrClient.putEvents(eventsRequest)
        println("結果=$response")
    }    
  }
}