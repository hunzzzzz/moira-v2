dependencies {
    // core
    implementation(project(":core"))
    // kafka
    implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka")
    // spring boot
    implementation("org.springframework.boot:spring-boot-starter-web")
}