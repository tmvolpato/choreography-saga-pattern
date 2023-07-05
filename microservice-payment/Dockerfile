FROM openjdk:17-jdk-slim as builder

MAINTAINER Thiago M. Volpato

ENV JAR_FILE=target/*.jar
ADD ${JAR_FILE} application.jar

RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:17-jdk-slim

COPY --from=builder dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder internal-dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder application/ ./

EXPOSE 8083

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
