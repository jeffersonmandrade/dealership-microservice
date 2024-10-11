FROM amazoncorretto:17

WORKDIR /app

COPY app.jar /app/auth-service.jar

EXPOSE 9997

ENV SPRING_DATASOURCE_URL=jdbc:mariadb://localhost:3306/usuarios \
    SPRING_DATASOURCE_USERNAME=user-service \
    SPRING_DATASOURCE_PASSWORD=123456 \
    SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.mariadb.jdbc.Driver \
    SPRING_JPA_HIBERNATE_DDL_AUTO=update \
    SPRING_JPA_SHOW_SQL=true \
    SPRING_JPA_DEFER_DATASOURCE_INITIALIZATION=true \
    JWT_SECRET=secret \
    EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8761/eureka

ENTRYPOINT ["java", "-jar", "/app/auth-service.jar"]

CMD ["--server.port=9997"]
