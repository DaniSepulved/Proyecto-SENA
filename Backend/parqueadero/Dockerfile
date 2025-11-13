# Imagen base con Java 21 (Spring Boot 3.4.5 usa Java 21)
FROM eclipse-temurin:21-jdk AS build

# Directorio de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY pom.xml .
COPY src ./src

# Compilar el proyecto
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# Imagen final
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar el jar desde la imagen anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
