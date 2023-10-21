# ApiControllerApi

All URIs are relative to *http://ec2-35-75-6-81.ap-northeast-1.compute.amazonaws.com:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getApi**](ApiControllerApi.md#getApi) | **GET** /entry/ |  |
| [**getTestApi**](ApiControllerApi.md#getTestApi) | **GET** /entry/test |  |
| [**postApi**](ApiControllerApi.md#postApi) | **POST** /entry/ |  |



## getApi

> EntryResponseTestDto getApi()



### Example

```java
// Import classes:
import com.ApiClient;
import com.ApiException;
import com.Configuration;
import com.models.*;
import com.example.ApiControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://ec2-35-75-6-81.ap-northeast-1.compute.amazonaws.com:8080");

        ApiControllerApi apiInstance = new ApiControllerApi(defaultClient);
        try {
            EntryResponseTestDto result = apiInstance.getApi();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiControllerApi#getApi");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**EntryResponseTestDto**](EntryResponseTestDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getTestApi

> EntryResponseTestDto getTestApi()



### Example

```java
// Import classes:
import com.ApiClient;
import com.ApiException;
import com.Configuration;
import com.models.*;
import com.example.ApiControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://ec2-35-75-6-81.ap-northeast-1.compute.amazonaws.com:8080");

        ApiControllerApi apiInstance = new ApiControllerApi(defaultClient);
        try {
            EntryResponseTestDto result = apiInstance.getTestApi();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiControllerApi#getTestApi");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**EntryResponseTestDto**](EntryResponseTestDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## postApi

> EntryResponseDto postApi(entryRequestDto)



### Example

```java
// Import classes:
import com.ApiClient;
import com.ApiException;
import com.Configuration;
import com.models.*;
import com.example.ApiControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://ec2-35-75-6-81.ap-northeast-1.compute.amazonaws.com:8080");

        ApiControllerApi apiInstance = new ApiControllerApi(defaultClient);
        EntryRequestDto entryRequestDto = new EntryRequestDto(); // EntryRequestDto | 
        try {
            EntryResponseDto result = apiInstance.postApi(entryRequestDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiControllerApi#postApi");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **entryRequestDto** | [**EntryRequestDto**](EntryRequestDto.md)|  | |

### Return type

[**EntryResponseDto**](EntryResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

