#!/bin/bash
if [ -d "out" ]
then
  rm -rf out/*
fi
if ! [ -z $2 ]
then
  javac -d out/ -sourcepath src/ -cp lib/junit-platform-console-standalone-1.5.1.jar test/$1/$2Test.java
  java -jar lib/junit-platform-console-standalone-1.5.1.jar --class-path out/ -c $1.$2Test
else
  if ! [ -z $1 ]
  then
    javac -d out/ -sourcepath src/ -cp lib/junit-platform-console-standalone-1.5.1.jar test/$1/*.java
    java -jar lib/junit-platform-console-standalone-1.5.1.jar --class-path out/ -p $1
  else
    javac -d out/ -sourcepath src/ -cp lib/junit-platform-console-standalone-1.5.1.jar test/*/*Test.java
    java -jar lib/junit-platform-console-standalone-1.5.1.jar --class-path out/ --scan-class-path
  fi
fi
