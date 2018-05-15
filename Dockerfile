FROM openjdk:8-jre-slim

ADD ./build/libs/parcelSizeComponent.jar /jarFile/parcelSizeComponent.jar

CMD java -jar /jarFile/parcelSizeComponent.jar
