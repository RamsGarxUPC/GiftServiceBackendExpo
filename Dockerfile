FROM amazoncorretto:17-alpine-jdk
MAINTAINER RAMIRO
COPY target/GIFT_SERVICE-0.0.1-SNAPSHOT.jar GiftServiceBackendExpo.jar
ENTRYPOINT ["java", "-jar", "/GiftServiceBackendExpo.jar"]