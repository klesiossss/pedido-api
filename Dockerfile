FROM adoptopenjdk/openjdk8:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} desafio.jar
ENTRYPOINT ["java","-jar","desafio.jar"]