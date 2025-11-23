#this is for backend_ci test!!!

# 1️⃣ Build stage
#FROM gradle:7.6.4-jdk11 AS builder
#WORKDIR /app

# Gradle 캐시를 활용하기 위해 설정 파일만 먼저 복사
#COPY build.gradle settings.gradle ./
#COPY gradle gradle

# 의존성 미리 다운로드
#RUN gradle dependencies --no-daemon || return 0

# 애플리케이션 소스 복사 및 빌드
#COPY . .
#RUN gradle clean bootJar --no-daemon

# 2️⃣ Run stage
FROM openjdk:11.0.11-jdk-slim
WORKDIR /app

# 빌드된 jar 파일 복사
COPY  app.jar  app.jar

# 포트 설정 (Spring Boot 기본 포트)
EXPOSE 8888

# 컨테이너 시작 시 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]

