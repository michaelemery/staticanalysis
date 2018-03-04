# --- BASE SETUP (OpenJDK)

# use openjdk runtime as a base image
FROM openjdk:8u121-jdk

# make app and set as working directory
RUN mkdir /app


# --- MAVEN SETUP

RUN apt-get update -y && apt-get install maven -y


# --- CHECKERFRAMEWORK SETUP

# create directory
#RUN mkdir /app/checkerframework
#WORKDIR /app/checkerframework

# copy install files
#ADD ./checker-framework-2.1.11.zip .
#RUN unzip checker-framework-2.1.11.zip

# add to path
#ENV CHECKERFRAMEWORK_HOME /app/checkerframework/checker-framework-2.1.11
# note that ${CHECKERFRAMEWORK_HOME} must come first
#ENV PATH ${CHECKERFRAMEWORK_HOME}/checker/bin:${PATH}


# --- COPY SOURCE FILES FOR CHECKER TESTS

RUN mkdir /checker
ADD pom.xml ./pom.xml
RUN mkdir /checker/bin
ADD /checker/src ./src
WORKDIR /checker

#ADD build.xml .
#ADD readme.md .
