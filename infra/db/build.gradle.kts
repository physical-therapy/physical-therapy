plugins {
    apply {
        id("org.jetbrains.kotlin.kapt")
        kotlin("plugin.jpa")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

dependencies {
    compileOnly(project(":core"))
    // JPA 의존성을 implementation로 설정해뒀기 때문에 이 모듈을 사용하는 곳에서는 JPA에 대한 정보를 모름
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")

    // querydsl 설정
    implementation("com.querydsl:querydsl-jpa")
    kapt("com.querydsl:querydsl-apt:${dependencyManagement.importedProperties["querydsl.version"]}:jakarta")
    kapt("jakarta.persistence:jakarta.persistence-api")
    // javax 어노테이션 에러로 인해 추가
    // https://blog.leocat.kr/notes/2021/03/19/gradle-fix-no-class-def-found-error-entity-generated
    kapt("jakarta.annotation:jakarta.annotation-api")
}