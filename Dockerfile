FROM openjdk:17-alpine AS build
WORKDIR /app
COPY . /app
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]