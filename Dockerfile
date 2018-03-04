# --- BASE SETUP (OpenJDK)

# use openjdk runtime as a base image
FROM openjdk:8u121-jdk

# make app and set as working directory
RUN mkdir /app


# --- ANT SETUP

# create directory
RUN mkdir /app/ant
WORKDIR /app/ant

# copy install files
ADD ./apache-ant-1.10.1-bin.zip .
RUN unzip apache-ant-1.10.1-bin.zip

# add to path
ENV ANT_HOME /app/ant/apache-ant-1.10.1
ENV PATH ${PATH}:${ANT_HOME}/bin


# --- CHECKERFRAMEWORK SETUP

# create directory
RUN mkdir /app/checkerframework
WORKDIR /app/checkerframework

# copy install files
ADD ./checker-framework-2.1.11.zip .
RUN unzip checker-framework-2.1.11.zip

# add to path
ENV CHECKERFRAMEWORK_HOME /app/checkerframework/checker-framework-2.1.11
# note that ${CHECKERFRAMEWORK_HOME} must come first
ENV PATH ${CHECKERFRAMEWORK_HOME}/checker/bin:${PATH}


# --- COPY SOURCE FILES FOR CHECKER TESTS

#WORKDIR /checker
#ADD src ./src
#ADD build.xml .
#ADD readme.md .
