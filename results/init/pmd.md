# pmd results (init)

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

* [init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

* [init/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/IntraProceduralTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/init/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/init/IntraProcedural.java:8:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

## InterProcedural

* [init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

* [init/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InterProceduralTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/init/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/init/InterProcedural.java:8:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

* [init/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectConstructor.java)

* [init/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectConstructorTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/init/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/init/ReflectMethod.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

* [init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

* [init/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/init/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/init/ReflectMethod.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

* [init/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectField.java)

* [init/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/init/ReflectField.java -f text -R category/java/errorprone.xml
```

#### checker output

```
/Users/michaelemery/Developer/staticanalysis/src/init/ReflectField.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

## InvokeDynamicConstructor

* [init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

* [init/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicConstructorTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/init/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output

```
/Users/michaelemery/Developer/staticanalysis/src/init/InvokeDynamicConstructor.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

* [init/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicMethod.java)

* [init/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/init/InvokeDynamicMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/init/InvokeDynamicMethod.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

* [init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicField.java)

* [init/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/init/InvokeDynamicField.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/init/InvokeDynamicField.java:11:	Found non-transient, non-static member. Please mark as transient or provide accessors.
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

* [init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/DynamicProxy.java)

* [init/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/DynamicProxyTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/init/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/init/DynamicProxy.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
rc/init/DynamicProxy.java:22:	In J2EE, getClassLoader() might not work as expected.  Use Thread.currentThread().getContextClassLoader() instead. issues found.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | NA |
| 22 | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 1 |

> unsound
