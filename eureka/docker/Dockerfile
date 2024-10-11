FROM amazoncorretto:17

WORKDIR /app

COPY app.jar /app/eureka-service.jar

EXPOSE 8761

ENV SPRING_APPLICATION_NAME=eureka \
    SERVER_PORT=8761 \
    EUREKA_INSTANCE_HOSTNAME=localhost \
    EUREKA_CLIENT_REGISTER_WITH_EUREKA=false \
    EUREKA_CLIENT_FETCH_REGISTRY=false \
    EUREKA_SERVICEURL_DEFAULTZONE=http://localhost:8761/eureka/

ENTRYPOINT ["java", "-jar", "/app/eureka-service.jar"]

CMD ["--server.port=8761"]
