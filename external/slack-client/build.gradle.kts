dependencies {
    api(project(":external:common-client"))

    // Slack API
    api("com.slack.api:slack-api-model-kotlin-extension:1.24.0")

    api ("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.3")

    api ("com.squareup.okhttp3:okhttp:4.10.0")
    api ("com.squareup.okhttp3:logging-interceptor:4.8.0")
    api ("com.squareup.retrofit2:retrofit:2.9.0")
    api ("com.squareup.retrofit2:converter-jackson:2.9.0")
}

// 참고: https://github.com/woowacourse-teams/2021-tyf/blob/develop/server/build.gradle
val processResources = tasks.findByName("processResources")?.let {
    println("processResources 실행")
    it.dependsOn("copySecret")
}

task("copySecret", Copy::class) {
    from("physical-therapy-secret/")
    include("*.yml")
//    into("src/main/resources") TODO: public으로 커밋될 수 있음.
    into("build/resources/main")
}
