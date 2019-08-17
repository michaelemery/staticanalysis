javac -d out/ -sourcepath src/ -cp lib/junit-platform-console-standalone-1.5.1.jar test/$1/$2Test.java
java -jar lib/junit-platform-console-standalone-1.5.1.jar --class-path out/ -c $1.$2Test
