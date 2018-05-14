FROM debian:stretch-slim

LABEL maintainer "Michael Emery"

# Multi-tool Static Analysis Template


# --- MANIFEST
# openjdk-8-jdk-headless
# VIM, Nano
# Infer, Checker Framework, FindBugs, Infer, PMD

# use openjdk runtime as a base image if infer dependencies are not required
# FROM openjdk:8u121-jdk


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


# --- CREATE usr/local FOLDER

RUN mkdir -p /usr/local


# --- MAVEN SETUP



# --- CHECKERFRAMEWORK SETUP

WORKDIR /usr/local

# copy install files
ADD ./archive/checker-framework-2.1.11.zip .
RUN unzip checker-framework-2.1.11.zip && \
    rm checker-framework-2.1.11.zip

# add to path
ENV CHECKERFRAMEWORK_HOME /usr/local/checker-framework-2.1.11
# note that ${CHECKERFRAMEWORK_HOME} must come first
ENV PATH ${CHECKERFRAMEWORK_HOME}/checker/bin:${PATH}


# --- PMD SETUP

WORKDIR /usr/local

# copy install files
ADD ./archive/pmd-bin-6.1.0.zip .
RUN unzip pmd-bin-6.1.0.zip && \
    rm pmd-bin-6.1.0.zip

# ccnfigure pmd home
ENV PMD_HOME /usr/local/pmd-bin-6.1.0


# --- FINDBUGS SETUP

WORKDIR /usr/local

# copy install files
ADD ./archive/findbugs-3.0.1.zip .
RUN unzip findbugs-3.0.1.zip && \
    rm findbugs-3.0.1.zip

# add to path
ENV FINDBUGS_HOME /usr/local/findbugs-3.0.1
ENV PATH ${FINDBUGS_HOME}/bin:${PATH}


# --- COPY SOURCE FILES FOR CHECKER TESTS

RUN mkdir /checker
WORKDIR /checker
ADD /checker /checker
