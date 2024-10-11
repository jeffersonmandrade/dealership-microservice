FROM amazoncorretto:17

WORKDIR /app

COPY app.jar /app/gateway.jar

EXPOSE 9999

ENV SPRING_APPLICATION_NAME=gateway \
    SERVER_PORT=9999 \
    EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8761/eureka

ENTRYPOINT ["java", "-jar", "/app/gateway.jar"]

CMD ["--spring.config.location=/app/application.yml"]
