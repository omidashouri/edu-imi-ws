# Runtime image only: JRE + pre-built Boot jar.
# Build the jar first (host Maven or edu-imi-ws-maven:25), then:
#   docker compose build
FROM eclipse-temurin:25-jre

WORKDIR /app

COPY edu-imi-web/target/edu-imi-web.jar /app/app.jar

EXPOSE 8443

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
