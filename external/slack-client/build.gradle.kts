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
