import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id ("org.springframework.boot") version "3.0.7"
	id ("io.spring.dependency-management") version "1.1.0"
	id ("org.jetbrains.kotlin.jvm") version "1.8.21"
	id ("org.jetbrains.kotlin.plugin.spring") version "1.8.21"
	id("org.openapi.generator") version "6.2.0"
	id("jacoco") // 追加
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom (configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

ext {
	set("springCloudVersion", "2022.0.3")
}

dependencies {
	implementation ("org.springframework.boot:spring-boot-starter-actuator")
	implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation ("org.springframework.boot:spring-boot-starter-validation:3.0.7")
	implementation("javax.validation:validation-api:1.1.0.Final")
	implementation("org.hibernate:hibernate-validator:8.0.0.Final")
	implementation ("org.springframework.boot:spring-boot-starter-web")
	implementation ("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation ("org.jetbrains.kotlin:kotlin-reflect")
	implementation ("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2")
	implementation ("org.springframework.cloud:spring-cloud-starter-openfeign")
	implementation ("org.springframework.security:spring-security-core:6.2.1")
	implementation ("org.springframework.boot:spring-boot-starter-security:3.2.1")
	developmentOnly ("org.springframework.boot:spring-boot-devtools")
	runtimeOnly ("com.h2database:h2")
	runtimeOnly ("io.micrometer:micrometer-registry-prometheus")
	runtimeOnly ("org.postgresql:postgresql")
	annotationProcessor  ("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	implementation("com.example:openapi:2.0.0")
	implementation(project(":commons")) 
	// https://mvnrepository.com/artifact/aws.sdk.kotlin/eventbridge-jvm
	implementation("aws.sdk.kotlin:eventbridge-jvm:1.0.53")
	// https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
	implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
	// https://mvnrepository.com/artifact/aws.sdk.kotlin/ssm
	implementation("aws.sdk.kotlin:ssm:1.0.73")
}

dependencyManagement {
	imports {
		mavenBom ("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<JacocoReport> {
    reports {
        csv.required.set(false)
        html.required.set(true)
        xml.required.set(true)
    }
}

openApiGenerate {
	generatorName.set("java")
	inputSpec.set("$rootDir/openapi.yaml")
	outputDir.set("$rootDir/client")
	apiPackage.set("org.openapi.example.api")
	configOptions.set(mapOf(
		"artifactId" to "openapi",
		"artifactVersion" to "2.0.0",
		"groupId" to "com.example",
		"apiPackage" to "com.example",
		"library" to "apache-httpclient"
	))
}

repositories {
	maven {
		url = uri("https://apiclient-domain-795090648644.d.codeartifact.ap-northeast-1.amazonaws.com/maven/test-repository/")
		credentials {
				username = "aws"
				password = System.getenv("CODEARTIFACT_AUTH_TOKEN")
		}
	}
}
