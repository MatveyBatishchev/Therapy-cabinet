import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.20"
    kotlin("plugin.spring") version "1.5.20"
}

group = "ru.mospolytech.therapy-cabinet"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    //  JodaTime
    implementation("joda-time:joda-time:2.10.10")

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda")

    // DB tools
    implementation("org.postgresql:postgresql:42.2.22")
    implementation("org.liquibase:liquibase-core:3.8.0")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")

    // Joda-Time
    implementation("joda-time:joda-time:2.10.10")

    // API tools
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.4")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
