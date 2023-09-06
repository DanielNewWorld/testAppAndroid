plugins {
    id("java")
}

group = "org.nets"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.appium:java-client:7.5.1")
    testImplementation("com.github.romankh3:image-comparison:4.4.0")
    testImplementation("io.qameta.allure:allure-junit5:2.19.0")
            testImplementation("com.codeborne:selenide:5.25.0")
                    testImplementation("io.qameta.allure:allure-selenide:2.19.0")
                            testImplementation("io.appium:java-client:7.6.0")
                                    testImplementation("org.aeonbits.owner:owner:1.0.12")
                                            testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly(
            "org.slf4j:slf4j-simple:1.7.32",
            "org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.test {
    useJUnitPlatform()
}