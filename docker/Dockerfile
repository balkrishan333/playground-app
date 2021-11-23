#docker build --progress=plain --no-cache . -f docker/Dockerfile -t odxbootstrapacr94a636d0.azurecr.io/odx/bala_app:v9
#docker push odxbootstrapacr94a636d0.azurecr.io/odx/bala_app:v9

FROM openjdk:11.0.12-jre
ARG app_name=playground-app
ARG app_version=0.0.1-SNAPSHOT
ARG WORK_DIR=/home/bala
RUN mkdir ${WORK_DIR}
RUN mkdir ${WORK_DIR}/config
WORKDIR ${WORK_DIR}
COPY build/libs/${app_name}-${app_version}.jar app.jar
COPY lib/opentelemetry-javaagent-all-1.7.2.jar opentelemetry-javaagent-all.jar
RUN pwd
RUN ls -l
#"-Dotel.javaagent.debug=true"
ENTRYPOINT ["java","-Dotel.traces.exporter=jaeger","-Dotel.exporter.jaeger.endpoint=http://jaeger:14250","-Dotel.service.name=playground-app","-javaagent:/home/bala/opentelemetry-javaagent-all.jar","-jar","/home/bala/app.jar"]