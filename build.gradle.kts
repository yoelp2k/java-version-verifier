plugins {
    kotlin("jvm") version "1.9.20"
    id("java")
    application
}

group = "utils.java.version.verifier"
version = "1.0"

repositories {
    mavenCentral()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "utils.java.version.verifier.Main"
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("utils.java.version.verifier.Main")
}
