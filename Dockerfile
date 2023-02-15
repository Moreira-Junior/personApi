FROM gradle:7.4.2-jdk17 as gradle
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN mkdir -p /data/log && chown -R gradle:gradle /data/log
RUN gradle build --no-daemon -x test
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/gradle/src/build/libs/PersonAPI-0.0.1-SNAPSHOT.jar"]