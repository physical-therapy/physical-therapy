//tasks.getByName("bootJar") {
//    enabled = true
//}

tasks.bootJar {
    enabled = true
    archiveFileName = "app-api.jar"
    mainClass.set("physicaltherapy.AppApiSpringApplicationKt")
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":core"))
    implementation(project(":common:logging"))
    implementation(project(":external:slack-client"))
    runtimeOnly(project(":infra:db"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}
