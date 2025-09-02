FROM maven:3.8-amazoncorretto-21-debian AS BUILD
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTest


FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=BUILD /app/target/*.jar app.jar

EXPOSE 8083

CMD ["java", "-jar", "/app/bff-agendador-tarefas.jar"]