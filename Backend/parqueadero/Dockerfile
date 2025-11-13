# Etapa 1: construir el proyecto
FROM eclipse-temurin:21-jdk AS build

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Crear el directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto
COPY pom.xml .
COPY src ./src

# Compilar la app (sin ejecutar tests)
RUN mvn clean package -DskipTests

# Etapa 2: crear imagen liviana para ejecutar el jar
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar el jar compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
