plugins {
	java
	id ("jacoco")
	id("org.springframework.boot") version "4.0.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "es.meeknot"
version = "0.0.5-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(26)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-h2console")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }

    classDirectories.setFrom(
        files(classDirectories.files.map {
            fileTree(it) {
                exclude(
                    "**/config/**",
                    "**/dto/**",
                    "**/model/**",
                    "**/exception/**",
                    "**/*Application*",
                )
            }
        })
    )
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport)

    violationRules {
        // Overall project minimum
        rule {
            limit {
                counter = "LINE"
                minimum = "0.60".toBigDecimal()  // 60% line coverage
            }
            limit {
                counter = "BRANCH"
                minimum = "0.70".toBigDecimal()  // 70% branch coverage
            }
        }

        // Per-class minimum — catches classes with zero coverage
        rule {
            element = "CLASS"
            limit {
                counter = "LINE"
                minimum = "0.60".toBigDecimal()  // 60% per class
            }

            // Exclude the same packages as the report
            excludes = listOf(
                "*.config.*",
                "*.dto.*",
                "*.model.*",
                "*.exception.*",
                "*Application*",
            )
        }
    }
}

tasks.check {
    dependsOn(tasks.jacocoTestCoverageVerification)
}
