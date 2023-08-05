import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.kapt") apply false

    kotlin("jvm")
    kotlin("plugin.spring") apply false
    kotlin("plugin.jpa") apply false
}

group = "com.physicaltherapy"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

val projectGroup: String by project
val applicationVersion: String by project

allprojects {
    group = projectGroup
    version = applicationVersion

    repositories {
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.kapt")

//        plugin("jacoco") TODO: 정적분석 툴 추가하기
        plugin("idea")
    }

    dependencyManagement {
        val springCloudDependenciesVersion: String by project
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudDependenciesVersion}")
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.flywaydb:flyway-core")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        runtimeOnly("com.h2database:h2")
        runtimeOnly("org.postgresql:postgresql")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.security:spring-security-test")
        testImplementation("io.kotest:kotest-assertions-core-jvm:5.6.2")
    }

    // 모든 sub module들이 bootJar를 필요로하지 않음 (필요한 경우에는 해당 module만 따로 설정)
    tasks.getByName("bootJar") {
        enabled = false
    }

    tasks.getByName("jar") {
        enabled = true
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
