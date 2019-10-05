# findbugs results (signedness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: findbugs-3.0.1

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
javac -d out/ src/signedness/IntraProcedural.java
findbugs out/signedness/IntraProcedural.class
```

#### checker output

```
M D UC: Method signedness.IntraProcedural.divisorSigned() seems to be useless  At IntraProcedural.java:[line 23]
M D UC: Method signedness.IntraProcedural.divisorUnsigned() seems to be useless  At IntraProcedural.java:[line 38]
M D UC: Method signedness.IntraProcedural.modulusSigned() seems to be useless  At IntraProcedural.java:[line 51]
Warnings generated: 3
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 23, 38, 51 | NA |

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
javac -d out/ src/signedness/InterProcedural.java
findbugs out/signedness/InterProcedural.class
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
javac -d out/ src/signedness/ReflectConstructor.java
findbugs out/signedness/ReflectConstructor.class
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
javac -d out/ src/signedness/ReflectMethod.java
findbugs out/signedness/ReflectMethod.class
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
javac -d out/ src/signedness/ReflectField.java
findbugs out/signedness/ReflectField.class
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
javac -d out/ src/signedness/InvokeDynamicConstructor.java
findbugs out/signedness/InvokeDynamicConstructor.class
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
javac -d out/ src/signedness/InvokeDynamicMethod.java
findbugs out/signedness/InvokeDynamicMethod.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicMethod.java:[line 30]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicMethod.java:[line 39]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 30, 39 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InvokeDynamicField

* [signedness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InvokeDynamicField.java)

* [signedness/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/InvokeDynamicFieldTest.java)

#### checker command

```shell script
javac -d out/ src/signedness/InvokeDynamicField.java
findbugs out/signedness/InvokeDynamicField.class
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
javac -d out/ src/signedness/DynamicProxy.java
findbugs out/signedness/DynamicProxy.class
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
