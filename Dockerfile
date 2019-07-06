FROM openjdk:11-slim

#todo: add RUN with copying logs to /devstdout and stderr

ADD build/libs/server-0.0.1.jar cinema-reservations-server.jar

ENTRYPOINT ["java", "-jar", "cinema-reservations-server.jar"]