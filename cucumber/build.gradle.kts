plugins {
    java
    kotlin("jvm") version "1.9.23"
    jacoco
    id("com.github.nbaztec.coveralls-jacoco") version "1.2.20"
}


tasks.test {
    useJUnitPlatform()
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    finalizedBy(tasks.coverallsJacoco)
    reports {
        xml.required = true
    }
}

tasks.coverallsJacoco {
    dependsOn(tasks.jacocoTestReport)
}


group = "com.anarchyghost"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation(platform("io.cucumber:cucumber-bom:7.18.0"))

    testImplementation("io.cucumber:cucumber-java")
    testImplementation("io.cucumber:cucumber-junit-platform-engine")
    testImplementation("org.junit.platform:junit-platform-suite")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.cucumber:cucumber-java")

    testImplementation("io.kotest:kotest-assertions-core:5.9.0")

}

kotlin {
    jvmToolchain(17)
}