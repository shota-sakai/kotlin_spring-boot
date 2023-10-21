# openapi

OpenAPI definition

- API version: v0

- Build date: 2023-10-21T13:00:09.908379746Z[UTC]

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*

## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.example</groupId>
  <artifactId>openapi</artifactId>
  <version>2.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.example:openapi:2.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/openapi-2.0.0.jar`
- `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.*;
import com.auth.*;
import org.openapitools.client.model.*;
import com.example.ApiControllerApi;

public class ApiControllerApiExample {

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

## Documentation for API Endpoints

All URIs are relative to *http://ec2-35-75-6-81.ap-northeast-1.compute.amazonaws.com:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApiControllerApi* | [**getApi**](docs/ApiControllerApi.md#getApi) | **GET** /entry/ | 
*ApiControllerApi* | [**getTestApi**](docs/ApiControllerApi.md#getTestApi) | **GET** /entry/test | 
*ApiControllerApi* | [**postApi**](docs/ApiControllerApi.md#postApi) | **POST** /entry/ | 


## Documentation for Models

 - [AddressDto](docs/AddressDto.md)
 - [CustomerDto](docs/CustomerDto.md)
 - [EntryRequestDto](docs/EntryRequestDto.md)
 - [EntryResponseDto](docs/EntryResponseDto.md)
 - [EntryResponseTestDto](docs/EntryResponseTestDto.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


