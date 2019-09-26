#!/bin/bash
if [ -d "out" ]
then
  rm -rf out/*
fi
if [ -n "$2" ]
then
  javac -d out/ -sourcepath src/ -cp /opt/junit-platform-console-standalone-1.5.2.jar test/$1/$2Test.java
  java -jar /opt/junit-platform-console-standalone-1.5.2.jar --class-path out/ -c $1.$2Test
else
  if [ -n "$1" ]
  then
    javac -d out/ -sourcepath src/ -cp /opt/junit-platform-console-standalone-1.5.2.jar test/$1/*.java
    java -jar /opt/junit-platform-console-standalone-1.5.2.jar --class-path out/ -p $1
  else
    javac -d out/ -sourcepath src/ -cp /opt/junit-platform-console-standalone-1.5.2.jar test/*/*Test.java
    java -jar /opt/junit-platform-console-standalone-1.5.2.jar --class-path out/ --scan-class-path
  fi
fi
