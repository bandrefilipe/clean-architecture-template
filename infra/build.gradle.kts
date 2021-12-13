plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation(project(":application"))

    // Starter for building web, including RESTful, applications using Spring MVC.
    // Uses Tomcat as the default embedded container.
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Add-on module for Jackson to support Kotlin language, specifically introspection of method/constructor parameter
    // names, without having to add explicit property name annotation.
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Starter for using Log4j2 for logging. An alternative to spring-boot-starter-logging.
    implementation("org.springframework.boot:spring-boot-starter-log4j2")

    // Starter for testing Spring Boot applications with libraries including JUnit Jupiter, Hamcrest and Mockito.
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configurations {
    all {
        // Exclude the default logging implementations used by Spring Boot.
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")

        resolutionStrategy.eachDependency {
            if (requested.group == "org.apache.logging.log4j") {
                useVersion("2.15.0")
                because("[CVE-2021-44228] https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2021-44228")
            }
        }
    }
}
