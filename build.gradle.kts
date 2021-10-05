import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.5" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.jetbrains.kotlin.jvm") version "1.5.31" apply false
    id("org.jetbrains.kotlin.plugin.spring") version "1.5.31" apply false
}

allprojects {
    group = "com.example"
    version = "0.0.1"

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_16.majorVersion
            freeCompilerArgs = listOf(
                "-Xjsr305=strict",
                "-Xemit-jvm-type-annotations"
            )
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        val implementation by configurations
        val testImplementation by configurations

        // Kotlin Full Reflection Library.
        implementation(kotlin("reflect"))

        // Kotlin Standard Library JDK 8 extension.
        implementation(kotlin("stdlib-jdk8"))

        // Lightweight logging framework for Kotlin.
        implementation("io.github.microutils:kotlin-logging:2.0.11")

        // Kotlin Test Support for junit5.
        testImplementation(kotlin("test-junit5"))
    }

    tasks.withType<Jar> {
        archiveBaseName.set(rootProject.name)
        archiveAppendix.set(project.name)
    }
}
