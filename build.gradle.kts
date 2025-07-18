plugins {
    kotlin("jvm") version "2.0.21"
    id("com.typewritermc.module-plugin") version "1.1.2"
}

group = "btc.renaud.dualtextdisplayextension"
version = "0.9.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://maven.typewritermc.com/beta/")
    maven("https://repo.codemc.io/repository/maven-releases/")
}

dependencies {
    implementation("com.typewritermc:QuestExtension:0.9.0")
    implementation("com.typewritermc:BasicExtension:0.9.0")
    implementation("com.typewritermc:EntityExtension:0.9.0")
}

typewriter {
    namespace = "renaud"

    extension {
        name = "dualtextdisplay"
        shortDescription = "Typewriter extension Dual text display for more interaction."
        description =
            "This extension adds dual text display for NPC or other thing in TypewriterMC. " +
            "It allows you to create a main text display with a secondary interaction point, " +
            "enabling more complex and engaging interactions."
        engineVersion = "0.9.0-beta-162"
        channel = com.typewritermc.moduleplugin.ReleaseChannel.BETA
        dependencies {
            dependency("typewritermc", "Quest")
            dependency("typewritermc", "Entity")
        }

        paper()
    }

}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}
