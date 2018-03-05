# --- BASE SETUP (OpenJDK)

# use openjdk runtime as a base image
FROM openjdk:8u121-jdk


# --- CREATE APP FOLDER

RUN mkdir /app


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

# <<manually>> configure pmd alias and parameters
# pmd='$PMD_HOME/bin/run.sh pmd'
# RUN pmd -d <path/source_file> -f text -R category/java/errorprone.xml
# (-d = source root, -R = ruleset, -f output format)


# --- FINDBUGS SETUP

# create directory
RUN mkdir /app/findbugs
WORKDIR /app/findbugs

# copy install files
ADD ./archive/findbugs-3.0.1.zip .
RUN unzip findbugs-3.0.1.zip

# add to path
ENV FINDBUGS_HOME /app/findbugs/findbugs-3.0.1
# note that ${FINDBUGS_HOME}
ENV PATH ${FINDBUGS_HOME}/bin:${PATH}


# --- COPY SOURCE FILES FOR CHECKER TESTS

RUN mkdir /checker
WORKDIR /checker
ADD /checker /checker


# --- DISPLAY DOCKER INFO FILE

WORKDIR /checker
RUN cat Docker_Info.txt
