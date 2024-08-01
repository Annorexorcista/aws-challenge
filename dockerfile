FROM openjdk:17-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} mi-proyecto-1.0.0.jar
ENTRYPOINT ["java","-jar","/mi-proyecto-1.0.0.jar"]