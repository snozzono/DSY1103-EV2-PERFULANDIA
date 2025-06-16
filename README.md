# DSY1103-EV2-PERFULANDIA
repo de la api para desarrollo fullstack 1

## Puertos
Api Gateway 8080
Auth 8081
Clientes  8082
Soporte 8083
Vendedores 8084
Inventario 8085
Envios 8086
Productos 8087
Ventas 8088

## Dependencias no disponbles en initializr

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
