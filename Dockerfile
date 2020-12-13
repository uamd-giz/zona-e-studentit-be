FROM ubuntu

WORKDIR /opt

RUN apt-get -y update
RUN apt-get -y install software-properties-common
RUN apt-add-repository -y universe
RUN apt-get -y update
RUN apt-get -y install maven

COPY . /opt

RUN mvn clean install

ENTRYPOINT ["java","-jar", "/opt/target/zona-e-studentit-0.0.1-SNAPSHOT.jar"]
