FROM openjdk:8-slim

ARG GATLING_VERSION="3.4.1"
ENV GATLING_PROMETHEUS_HOME="/usr/gatling"
ENV GATLING_BUNDLE="gatling-charts-highcharts-bundle-${GATLING_VERSION}"
ENV GATLING_HOME="${GATLING_PROMETHEUS_HOME}/${GATLING_BUNDLE}"

RUN apt-get update && \
    apt-get -y install curl unzip

RUN mkdir "${GATLING_PROMETHEUS_HOME}" && \
    curl "https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/${GATLING_VERSION}/${GATLING_BUNDLE}-bundle.zip" \
    -o "${GATLING_HOME}.zip" && \
    unzip -o "${GATLING_HOME}.zip" -d "${GATLING_PROMETHEUS_HOME}" && \
    rm "${GATLING_HOME}.zip" && \
    rm -rf "${GATLING_HOME}/user-files"

COPY ./plugins "${GATLING_HOME}/plugins"
COPY ./bin/* "${GATLING_HOME}/bin/"
COPY ./conf/* "${GATLING_HOME}/conf/"
COPY ./user-files "${GATLING_HOME}/user-files"
COPY run.sh /run.sh

WORKDIR "${GATLING_HOME}"

ENTRYPOINT ["bash","-x","/run.sh"]