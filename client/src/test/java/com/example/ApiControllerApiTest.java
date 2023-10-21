/*
 * OpenAPI definition
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.example;

import com.ApiException;
import org.openapitools.client.model.EntryRequestDto;
import org.openapitools.client.model.EntryResponseDto;
import org.openapitools.client.model.EntryResponseTestDto;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ApiControllerApi
 */
@Ignore
public class ApiControllerApiTest {

    private final ApiControllerApi api = new ApiControllerApi();

    /**
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getApiTest() throws ApiException {
        EntryResponseTestDto response = api.getApi();

        // TODO: test validations
    }
    /**
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getTestApiTest() throws ApiException {
        EntryResponseTestDto response = api.getTestApi();

        // TODO: test validations
    }
    /**
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postApiTest() throws ApiException {
        EntryRequestDto entryRequestDto = null;
        EntryResponseDto response = api.postApi(entryRequestDto);

        // TODO: test validations
    }
}