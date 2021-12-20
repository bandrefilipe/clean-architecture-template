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
                useVersion("2.17.0")
                because(
                    """
                    |[CVE-2021-45105] https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2021-45105
                    |Apache Log4j2 versions 2.0-alpha1 through 2.16.0 (excluding 2.12.3) did not protect from uncontrolled recursion from self-referential lookups.
                    |This allows an attacker with control over Thread Context Map data to cause a denial of service when a crafted string is interpreted.
                    |This issue was fixed in Log4j 2.17.0 and 2.12.3.
                    |""".trimMargin())
            }
        }
    }
}
