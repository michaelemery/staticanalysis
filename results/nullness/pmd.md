# pmd results (nullness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

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

> unsound

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

## InvokeDynamicConstructor

* [nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicConstructor.java)

* [nullness/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicConstructorTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/InvokeDynamicConstructor.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

## InvokeDynamicMethod

* [nullness/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicMethod.java)

* [nullness/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/InvokeDynamicMethod.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/InvokeDynamicMethod.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

## InvokeDynamicField

* [nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicField.java)

* [nullness/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/InvokeDynamicField.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/InvokeDynamicField.java:11:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

## DynamicProxy

* [nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/DynamicProxyTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/nullness/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/nullness/DynamicProxy.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/nullness/DynamicProxy.java:18:	In J2EE, getClassLoader() might not work as expected.  Use Thread.currentThread().getContextClassLoader() instead.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | NA |
| 18 | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 1 |

> unsound
