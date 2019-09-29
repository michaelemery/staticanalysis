# pmd results (nullness)

[results](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)

<br>

Version: pmd-6.1.0

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

#### pull docker container and run interactive instance

```shell script
docker pull michaelemery/staticanalysis
docker run -it --rm michaelemery/staticanalysis
```

#### run junit tests from docker

```shell script
sh test.sh [ [ <package-name> ] | [ <package-name> <class-name> ] ]
```

<br>

## IntraProcedural

* [nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/IntraProceduralTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/IntraProcedural.java:8:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/nullness/IntraProcedural.java:24:	Assigning an Object to null is a code smell.  Consider refactoring.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | NA |
| 24 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> accurate

<br>

## InterProcedural

* [nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InterProcedural.java)

* [nullness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InterProceduralTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/InterProcedural.java:8:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectConstructor

* [nullness/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectConstructor.java)

* [nullness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectConstructorTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/ReflectConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/ReflectConstructor.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectMethod

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/ReflectMethod.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/ReflectField.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/ReflectField.java:8:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## MethodHandleConstructor

* [nullness/MethodHandleConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleConstructor.java)

* [nullness/MethodHandleConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleConstructorTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/MethodHandleConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/MethodHandleConstructor.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## MethodHandleMethod

* [nullness/MethodHandleMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleMethod.java)

* [nullness/MethodHandleMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/MethodHandleMethod.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/MethodHandleMethod.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## MethodHandleField

* [nullness/MethodHandleField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleField.java)

* [nullness/MethodHandleFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/MethodHandleField.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/MethodHandleField.java:11:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 11 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InvokeDynamic

* [nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamic.java)

* [nullness/InvokeDynamicTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/InvokeDynamic.java -f text -R category/java/errorprone.xml
```

#### checker output
```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## DynamicProxy

* [nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/DynamicProxyTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/DynamicProxy.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/nullness/DynamicProxy.java:33:	In J2EE, getClassLoader() might not work as expected.  Use Thread.currentThread().getContextClassLoader() instead.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12 | NA |
| 33 | na |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 1 |

> unsound

<br>

## UnsafeField

* [nullness/UnsafeField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/UnsafeField.java)

* [nullness/UnsafeFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/UnsafeFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/UnsafeField.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/UnsafeField.java:3:	Avoid importing anything from the sun.* packages
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 3 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## UnsafeInitialisation

* [nullness/UnsafeInitialisation.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/UnsafeInitialisation.java)

* [nullness/UnsafeInitialisationTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/UnsafeInitialisationTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/UnsafeInitialisation.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/UnsafeInitialisation.java:3:	Avoid importing anything from the sun.* packages
src/nullness/UnsafeInitialisation.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 3,12 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound
