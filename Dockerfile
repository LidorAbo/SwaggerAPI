FROM openjdk:8
ENV jar_name="h2-db-persistence.jar"
EXPOSE 8080
ADD target/${jar_name} ${jar_name}
ENTRYPOINT java -jar ${jar_name}
