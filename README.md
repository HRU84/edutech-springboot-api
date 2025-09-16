# EduTech - Proyecto Final FullStack I

Este es un proyecto educativo desarrollado como parte del ramo Desarrollo FullStack I. Se trata de una plataforma para la gestión de cursos, donde se pueden registrar cursos, instructores y realizar operaciones básicas como crear, editar, eliminar y listar registros.

El proyecto está hecho con Spring Boot usando arquitectura de microservicios. Cada microservicio tiene su propia lógica, base de datos y endpoints REST.

## Tecnologías usadas

- Java 17
- Spring Boot
- Maven
- JPA / Hibernate
- MySQL (o H2 para pruebas)
- Postman
- Swagger
- JUnit / Mockito

## Estructura del proyecto

Cada microservicio tiene su propia carpeta y está organizado en capas:

- `controller`: endpoints REST
- `service`: lógica de negocio
- `repository`: acceso a datos
- `entity`: modelo
- `dto`: transferencia de datos

## Cómo ejecutar

1. Clonar este repositorio:
   ```
   git clone https://github.com/tu-usuario/edutech-microservicios.git
   ```
2. Abrir en tu IDE como proyecto Maven.
3. Configurar base de datos en `application.properties`.
4. Ejecutar desde la clase principal (`@SpringBootApplication`).
5. Acceder a Swagger en:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

## Pruebas

Se usó Postman para probar los endpoints (GET, POST, PUT, DELETE) y JUnit para probar algunos métodos de servicio. También se usó Mockito para simular respuestas en algunos casos.

## Autores

- Valentina Pino  
- Belén Toloza  
- Wilfred Vinet

Proyecto académico – 2025
