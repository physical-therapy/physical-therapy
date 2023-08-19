FROM eclipse-temurin:17
ENV PROFILE=local
ENV TZ Asia/Seoul
WORKDIR /app
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone #Set TimeZone
COPY build/libs/app-api.jar app-api.jar
ARG DD_VERSION=default
ENV DD_VERSION=$DD_VERSION
CMD [ \
  "java", \
  "-Dserver.port=8080", \
  "-Dspring.profiles.active=${PROFILE}",\
  "-XX:+UseZGC", \
  "-XX:+DisableExplicitGC", \
  "-verbose:gc", \
  "-XX:+PrintGCDetails", \
  "-jar", \
  "-server", \
  "-Xmx2560M", \
  "-Xms2560M", \
  "app-api.jar" \
]
