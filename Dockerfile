FROM debian:stretch-slim

LABEL maintainer = "Michael Emery"

# Multi-tool Static Analysis Template with code checking examples
#
# os: debain (slim)
# utilities: vim, nano, maven
# checker frameworks: infer, checkerframework, pmd, findbugs
#
# project source: https://github.com/michaelemery/staticanalysis


# --- INSTALL VIM & NANO

# mkdir man/man1 due to Debian bug #863199
RUN mkdir -p /usr/share/man/man1 && \
    apt-get update && \
    apt-get -y install vim && \
    apt-get -y install nano


# --- SETUP INFER DEPENDENCIES (INCLUDES OPENJDK)

RUN apt-get install --yes --no-install-recommends \
      autoconf \
      automake \
      cmake \
      curl \
      git \
      libc6-dev \
      libsqlite3-dev \
      opam \
      openjdk-8-jdk-headless \
      pkg-config \
      python2.7 \
      zlib1g-dev && \
    rm -rf /var/lib/apt/lists/*


# --- SETUP INFER

# Download the latest Infer release
RUN INFER_VERSION=v0.13.1; \
    cd /opt && \
    curl -sL \
      https://github.com/facebook/infer/releases/download/${INFER_VERSION}/infer-linux64-${INFER_VERSION}.tar.xz | \
    tar xJ && \
    rm -f /infer && \
    ln -s ${PWD}/infer-linux64-$INFER_VERSION /infer

# Compile Infer
RUN OCAML_VERSION=4.05.0+flambda; \
    cd /infer && ./build-infer.sh --opam-switch $OCAML_VERSION && rm -rf /root/.opam

# Install Infer
ENV INFER_HOME /infer/infer
ENV PATH ${INFER_HOME}/bin:${PATH}


# --- MAVEN SETUP

# create directory
RUN mkdir -p /opt/maven
WORKDIR /opt/maven

# copy install files
ADD lib .
RUN unzip apache-maven-3.5.3-bin.zip && \
    rm apache-maven-3.5.3-bin.zip

# add to path
ENV MAVEN_HOME /opt/maven/apache-maven-3.5.3
ENV PATH ${MAVEN_HOME}/bin:${PATH}


# --- CHECKERFRAMEWORK SETUP

# create directory
RUN mkdir -p /opt/checkerframework
WORKDIR /opt/checkerframework

# copy install files
ADD lib .
RUN unzip checker-framework-2.1.11.zip && \
    rm checker-framework-2.1.11.zip

# add to path
ENV CHECKERFRAMEWORK_HOME /opt/checkerframework/checker-framework-2.1.11
# note that ${CHECKERFRAMEWORK_HOME} must come first
ENV PATH ${CHECKERFRAMEWORK_HOME}/checker/bin:${PATH}


# --- PMD SETUP

# create directory
RUN mkdir -p /opt/pmd
WORKDIR /opt/pmd

# copy install files
ADD lib .
RUN unzip pmd-bin-6.1.0.zip && \
    rm pmd-bin-6.1.0.zip

# ccnfigure pmd home
ENV PMD_HOME /opt/pmd/pmd-bin-6.1.0


# --- SPOTBUGS SETUP

# create directory
RUN mkdir -p /opt/spotbugs
WORKDIR /opt/spotbugs

# copy install files
ADD lib .
RUN unzip spotbugs-3.1.12.zip && \
    rm spotbugs-3.1.12.zip

# add to path
ENV FINDBUGS_HOME /opt/findbugs/findbugs-3.0.1
ENV PATH ${FINDBUGS_HOME}/bin:${PATH}


# --- JUNIT STANDALONE APP AND TEST SCRIPT

ADD lib /opt
ADD test.sh /


# --- COPY SOURCE AND TEST FILES FOR CHECKER TESTS

RUN mkdir /src
ADD src /src
RUN mkdir /test
ADD test /test
RUN mkdir /out
WORKDIR /
