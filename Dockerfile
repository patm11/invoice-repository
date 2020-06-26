FROM openjdk:11
ARG JAR_FILE
COPY ${JAR_FILE} /usr/src/app.jar
WORKDIR /usr/src
CMD ["java", "-jar", "app.jar"]