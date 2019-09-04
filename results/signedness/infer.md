# infer results (signedness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: infer-0.13.1

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
infer run -a checkers --eradicate -- javac -d out/ src/signedness/IntraProcedural.java
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

## InterProcedural

* [signedness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InterProcedural.java)

* [signedness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/signedness/InterProceduralTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/signedness/InterProcedural.java
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
infer run -a checkers --eradicate -- javac -d out/ src/signedness/ReflectConstructor.java
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
infer run -a checkers --eradicate -- javac -d out/ src/signedness/ReflectMethod.java
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
infer run -a checkers --eradicate -- javac -d out/ src/signedness/ReflectField.java
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
infer run -a checkers --eradicate -- javac -d out/ src/signedness/InvokeDynamicConstructor.java
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
infer run -a checkers --eradicate -- javac -d out/ src/signedness/InvokeDynamicMethod.java
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
infer run -a checkers --eradicate -- javac -d out/ src/signedness/InvokeDynamicField.java
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
infer run -a checkers --eradicate -- javac -d out/ src/signedness/DynamicProxy.java
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
