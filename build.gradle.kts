import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id ("org.springframework.boot") version "3.0.7"
	id ("io.spring.dependency-management") version "1.1.0"
	id ("org.jetbrains.kotlin.jvm") version "1.8.21"
	id ("org.jetbrains.kotlin.plugin.spring") version "1.8.21"
	id("org.openapi.generator") version "6.2.0"
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
	// implementation ("org.springframework.boot:spring-boot-starter-security")
	implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation ("org.springframework.boot:spring-boot-starter-validation:3.0.7")
	// implementation ("org.springframework.boot:spring-boot-starter-validation")
	// implementation ("javax.validation:validation-api:2.0.1.Final")
	implementation("javax.validation:validation-api:1.1.0.Final")
	implementation("org.hibernate:hibernate-validator:8.0.0.Final")
	implementation ("org.springframework.boot:spring-boot-starter-web")
	implementation ("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation ("org.jetbrains.kotlin:kotlin-reflect")
	implementation ("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2")
	implementation ("org.springframework.cloud:spring-cloud-starter-openfeign")
	// implementation ("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	developmentOnly ("org.springframework.boot:spring-boot-devtools")
	runtimeOnly ("com.h2database:h2")
	runtimeOnly ("io.micrometer:micrometer-registry-prometheus")
	runtimeOnly ("org.postgresql:postgresql")
	annotationProcessor  ("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	// testImplementation  ("org.springframework.security:spring-security-test")
	// https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
	implementation("com.example:openapi:8.0.0")
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

openApiGenerate {
	generatorName.set("java")
	inputSpec.set("$rootDir/openapi.yaml")
	outputDir.set("$rootDir/client")
	apiPackage.set("org.openapi.example.api")
	configOptions.set(mapOf(
		"artifactId" to "openapi",
		"artifactVersion" to "3.0.0",
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
