# DSY1103-EV2-PERFULANDIA

Repositorio de la API para la evaluación de **Desarrollo Fullstack 1**.

## Puertos asignados por microservicio

| Servicio         | Puerto |
|------------------|--------|
| API Gateway      | 8080   |
| Autenticación    | 8081   |
| Clientes         | 8082   |
| Soporte          | 8083   |
| Vendedores       | 8084   |
| Inventario       | 8085   |
| Envíos           | 8086   |
| Productos        | 8087   |
| Ventas           | 8088   |

## Dependencias adicionales (no disponibles en Spring Initializr)

Agrega las siguientes dependencias manualmente en tu archivo `pom.xml`:

```xml
<!-- SpringDoc OpenAPI con Swagger UI -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>

<!-- JWT (Java JSON Web Token) - API -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>

<!-- JWT - Implementación (runtime) -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>

<!-- JWT - Integración con Jackson (runtime) -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
