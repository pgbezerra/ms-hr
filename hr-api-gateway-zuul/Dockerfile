FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-api-gateway-zuul-0.0.1.jar hr-api-gateway-zuul.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "hr-api-gateway-zuul.jar"]

