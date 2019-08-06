FROM openjdk:8-jre-alpine
ARG microservice
ARG port
ARG artifactid
ARG version
ENV artifact ${artifactid}-${version}.jar
WORKDIR /app
COPY  com/sofrecom/sofid/${artifactid}/${version}/${artifact} /app
EXPOSE ${port}
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar ${artifact}"]
