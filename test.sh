#!/bin/bash
if [ -d "out" ]
then
  rm -rf out/*
fi
javac -d out/ -sourcepath src/main/java -cp /opt/junit-platform-console-standalone-1.5.2.jar src/test/java/*/*Test.java
java -jar /opt/junit-platform-console-standalone-1.5.2.jar --class-path out/ --scan-class-path
