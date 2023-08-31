plugins {
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    //
    implementation ("com.fasterxml.jackson.core:jackson-core:2.14.2")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    implementation ("com.fasterxml.jackson.core:jackson-annotations:2.14.2")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.14.2")
    implementation ("com.fasterxml.woodstox:woodstox-core:6.5.0")
    implementation ("javax.xml.stream:stax-api:1.0-2")
    //
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}