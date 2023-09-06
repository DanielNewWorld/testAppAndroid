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
}

tasks.test {
    useJUnitPlatform()
}