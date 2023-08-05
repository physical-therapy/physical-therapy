dependencies {
    // domain 모듈이 스프링에 의존하는 것이 아닌지? --> trade-off (취향따라 제거할 수도 있음) 대신 빈 구성을 app-api에서 다 해줘야한다.
    compileOnly("org.springframework:spring-context")
}