val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false

dependencies {
    implementation("org.testcontainers:testcontainers:1.20.4")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
}