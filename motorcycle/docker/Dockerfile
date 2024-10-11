FROM amazoncorretto:17

WORKDIR /app

COPY app.jar /app/motorcycle-service.jar

EXPOSE 8082

ENV SPRING_APPLICATION_NAME=motorcycle-service \
    SERVER_PORT=8082 \
    SPRING_DATASOURCE_URL=jdbc:h2:mem:motorcycle \
    SPRING_DATASOURCE_USERNAME=admin \
    SPRING_DATASOURCE_PASSWORD=pass \
    SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.h2.Driver \
    SPRING_H2_CONSOLE_ENABLED=true \
    SPRING_JPA_SHOW_SQL=false \
    SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect \
    SPRING_JPA_DEFER_DATASOURCE_INITIALIZATION=true \
    EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8761/eureka

ENTRYPOINT ["java", "-jar", "/app/motorcycle-service.jar"]

CMD ["--server.port=8082"]
