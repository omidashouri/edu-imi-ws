FROM eclipse-temurin:25-jdk AS build
ARG MAVEN_VERSION=3.9.11
RUN apt-get update \
    && apt-get install -y --no-install-recommends curl ca-certificates tar \
    && curl -fsSL "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/${MAVEN_VERSION}/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
        | tar -xz -C /opt \
    && ln -s "/opt/apache-maven-${MAVEN_VERSION}/bin/mvn" /usr/local/bin/mvn \
    && rm -rf /var/lib/apt/lists/*
WORKDIR /build
COPY . .
RUN mvn -B -DskipTests package

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /build/edu-imi-web/target/edu-imi-web.jar /app/app.jar
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
