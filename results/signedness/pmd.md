# pmd results (signedness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

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

* [signedness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/IntraProcedural.java)

* [signedness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/IntraProceduralTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/signedness/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/signedness/IntraProcedural.java:20:	Avoid using Literals in Conditional Statements
src/signedness/IntraProcedural.java:35:	Avoid using Literals in Conditional Statements

```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 20, 35 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InterProcedural

* [signedness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InterProcedural.java)

* [signedness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/InterProceduralTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/signedness/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
NA
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |

> NA

<br>

## ReflectConstructor

* [signedness/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/ReflectConstructor.java)

* [signedness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/ReflectConstructorTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/signedness/ReflectConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output

```
NA
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |

> NA

<br>

## ReflectMethod

* [signedness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/ReflectMethod.java)

* [signedness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/ReflectMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/signedness/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
NA
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |

> NA

<br>

## ReflectField

* [signedness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/ReflectField.java)

* [signedness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/ReflectFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/signedness/ReflectField.java -f text -R category/java/errorprone.xml
```

#### checker output

```
NA
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |

> NA

<br>

## InvokeDynamicConstructor

* [signedness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InvokeDynamicConstructor.java)

* [signedness/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/InvokeDynamicConstructorTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/signedness/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output

```
NA
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |

> NA

<br>

## InvokeDynamicMethod

* [signedness/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InvokeDynamicMethod.java)

* [signedness/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/InvokeDynamicMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/signedness/InvokeDynamicMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
NA
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |

> NA

<br>

## InvokeDynamicField

* [signedness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InvokeDynamicField.java)

* [signedness/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/InvokeDynamicFieldTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/signedness/InvokeDynamicField.java -f text -R category/java/errorprone.xml
```

#### checker output

```
NA
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |

> NA

<br>

## DynamicProxy

* [signedness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/DynamicProxy.java)

* [signedness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/DynamicProxyTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/signedness/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### checker output

```
NA
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |

> NA
