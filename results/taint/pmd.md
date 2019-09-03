# pmd results (taint)

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

* [taint/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/IntraProcedural.java)

* [taint/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/IntraProceduralTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/taint/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/taint/IntraProcedural.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

## InterProcedural

* [taint/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InterProcedural.java)

* [taint/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InterProceduralTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/taint/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/taint/InterProcedural.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

## ReflectConstructor

* [taint/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectConstructor.java)

* [taint/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectConstructorTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/taint/ReflectConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/taint/ReflectConstructor.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/taint/ReflectConstructor.java:27:	Found 'DU'-anomaly for variable 'i' (lines '27'-'29').
src/taint/ReflectConstructor.java:36:	Found 'DU'-anomaly for variable 'i' (lines '36'-'38').
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12, 27, 36 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectMethod

* [taint/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectMethod.java)

* [taint/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/taint/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/taint/ReflectMethod.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12 | NA1 |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectField

* [taint/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectField.java)

* [taint/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/taint/ReflectField.java -f text -R category/java/errorprone.xml
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

## InvokeDynamicConstructor

* [taint/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InvokeDynamicConstructor.java)

* [taint/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InvokeDynamicConstructorTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/taint/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/taint/InvokeDynamicConstructor.java:14:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/taint/InvokeDynamicConstructor.java:30:	Found 'DU'-anomaly for variable 'i' (lines '30'-'32').
src/taint/InvokeDynamicConstructor.java:38:	Found 'DU'-anomaly for variable 'i' (lines '38'-'40').
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 14, 30, 38 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InvokeDynamicMethod

* [taint/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InvokeDynamicMethod.java)

* [taint/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InvokeDynamicMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/taint/InvokeDynamicMethod.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/taint/InvokeDynamicMethod.java:14:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 14 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InvokeDynamicField

* [taint/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InvokeDynamicField.java)

* [taint/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InvokeDynamicFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/taint/InvokeDynamicField.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/taint/InvokeDynamicField.java:13:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 13 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## DynamicProxy

* [taint/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/DynamicProxy.java)

* [taint/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/DynamicProxyTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/taint/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### checker output
```
src/taint/DynamicProxy.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/taint/DynamicProxy.java:20:	In J2EE, getClassLoader() might not work as expected.  Use Thread.currentThread().getContextClassLoader() instead.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12 | NA |
| 20 | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 1 |

> unsound
