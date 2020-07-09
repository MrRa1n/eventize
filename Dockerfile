FROM openjdk:11
VOLUME /tmp
COPY ./target/*.jar eventize.jar
ENTRYPOINT ["java", "-jar", "/eventize.jar"]