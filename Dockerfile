# --- BASE SETUP (OpenJDK)

# use openjdk runtime as a base image
FROM openjdk:8u121-jdk

# make app and set as working directory
RUN mkdir /app


# --- ANT SETUP

# create directory
#RUN mkdir /app/ant
#WORKDIR /app/ant

# copy install files
#ADD ./archive/apache-ant-1.10.1-bin.zip .
#RUN unzip apache-ant-1.10.1-bin.zip

# add to path
#ENV ANT_HOME /app/ant/apache-ant-1.10.1
#ENV PATH ${PATH}:${ANT_HOME}/bin


# --- CHECKERFRAMEWORK SETUP

# create directory
RUN mkdir /app/checkerframework
WORKDIR /app/checkerframework

# copy install files
ADD ./archive/checker-framework-2.1.11.zip .
RUN unzip checker-framework-2.1.11.zip

# add to path
ENV CHECKERFRAMEWORK_HOME /app/checkerframework/checker-framework-2.1.11
# note that ${CHECKERFRAMEWORK_HOME} must come first
ENV PATH ${CHECKERFRAMEWORK_HOME}/checker/bin:${PATH}


# --- PMD SETUP

# create directory
RUN mkdir /app/pmd
WORKDIR /app/pmd

# copy install files
ADD ./archive/pmd-bin-6.1.0.zip .
RUN unzip pmd-bin-6.1.0.zip

# ccnfigure pmd home
ENV PMD_HOME /app/pmd/pmd-bin-6.1.0

# configure alias
RUN alias pmd="${PMD_HOME}/bin/run.sh pmd"

# configure default parameters
# -d = source root, -R = ruleset, -f output format
RUN pmd -d /checker -R java-basic -f text


# --- COPY SOURCE FILES FOR CHECKER TESTS

RUN mkdir /checker
WORKDIR /checker
ADD /checker /checker
