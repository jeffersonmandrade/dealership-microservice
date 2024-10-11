FROM amazoncorretto:17

WORKDIR /app

COPY app.jar /app/nota-service.jar

EXPOSE 8085

ENV SPRING_APPLICATION_NAME=nota-service \
    SERVER_PORT=8085 \
    SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres \
    SPRING_DATASOURCE_USERNAME=postgres \
    SPRING_DATASOURCE_PASSWORD=123456 \
    SPRING_JPA_HIBERNATE_DDL_AUTO=update \
    SPRING_JPA_SHOW_SQL=true \
    SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect \
    SPRING_MAIN_ALLOW_BEAN_DEFINITION_OVERRIDING=true \
    EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8761/eureka

ENTRYPOINT ["java", "-jar", "/app/nota-service.jar"]

CMD ["--server.port=8085"]
