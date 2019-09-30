# findbugs results (taint)

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

* [taint/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/IntraProcedural.java)

* [taint/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/IntraProceduralTest.java)

#### checker command

```shell script
javac -d out/ src/taint/IntraProcedural.java
findbugs out/taint/IntraProcedural.class
```

#### checker output

```
M D UC: Useless object stored in variable var$0 of method taint.IntraProcedural.setFooToTainted()  At IntraProcedural.java:[line 24]
M D UC: Useless object stored in variable var$0 of method taint.IntraProcedural.setFooToUntainted()  At IntraProcedural.java:[line 16]
M D UC: Method taint.IntraProcedural.setFooToUntainted() seems to be useless  At IntraProcedural.java:[line 18]
M D UC: Method taint.IntraProcedural.setFooToTainted() seems to be useless  At IntraProcedural.java:[line 26]
M P UrF: Unread field: taint.IntraProcedural.foo  At IntraProcedural.java:[line 17]
Warnings generated: 5
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 24, 16, 18, 26, 17 | NA |

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
javac -d out/ src/taint/InterProcedural.java
findbugs out/taint/InterProcedural.class
```

#### checker output

```
M D UC: Useless object stored in variable var$0 of method taint.InterProcedural.setFooToTainted()  At InterProcedural.java:[line 32]
M D UC: Useless object stored in variable var$0 of method taint.InterProcedural.setFooToUntainted()  At InterProcedural.java:[line 24]
M D UC: Method taint.InterProcedural.setFooToUntainted() seems to be useless  At InterProcedural.java:[line 26]
M D UC: Method taint.InterProcedural.setFooToTainted() seems to be useless  At InterProcedural.java:[line 34]
M P UrF: Unread field: taint.InterProcedural.foo  At InterProcedural.java:[line 25]
Warnings generated: 5
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 32, 24, 26, 34, 25 | NA |

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
javac -d out/ src/taint/ReflectConstructor.java
findbugs out/taint/ReflectConstructor.class
```

#### checker output

```
M D DLS: Dead store to $L1 in taint.ReflectConstructor.setFooToUntainted()  At ReflectConstructor.java:[line 28]
M D DLS: Dead store to $L1 in taint.ReflectConstructor.setFooToTainted()  At ReflectConstructor.java:[line 37]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 28, 37 | NA |

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
javac -d out/ src/taint/ReflectMethod.java
findbugs out/taint/ReflectMethod.class
```

#### checker output

```
M P UrF: Unread field: taint.ReflectMethod.foo  At ReflectMethod.java:[line 29]
Warnings generated: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 29 | NA |

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
javac -d out/ src/taint/ReflectField.java
findbugs out/taint/ReflectField.class
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
javac -d out/ src/taint/InvokeDynamicConstructor.java
findbugs out/taint/InvokeDynamicConstructor.class
```

#### checker output

```
M D DLS: Dead store to $L0 in taint.InvokeDynamicConstructor.setFooToUntainted()  At InvokeDynamicConstructor.java:[line 31]
M D DLS: Dead store to $L0 in taint.InvokeDynamicConstructor.setFooToTainted()  At InvokeDynamicConstructor.java:[line 39]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 31, 39 | NA |

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
javac -d out/ src/taint/InvokeDynamicMethod.java
findbugs out/taint/InvokeDynamicMethod.class
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

## InvokeDynamicField

* [taint/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InvokeDynamicField.java)

* [taint/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InvokeDynamicFieldTest.java)

#### checker command

```shell script
javac -d out/ src/taint/InvokeDynamicField.java
findbugs out/taint/InvokeDynamicField.class
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

* [taint/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/DynamicProxy.java)

* [taint/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/DynamicProxyTest.java)

#### checker command

```shell script
javac -d out/ src/taint/DynamicProxy.java
findbugs out/taint/DynamicProxy.class
```

#### checker output

```
M P UrF: Unread field: taint.DynamicProxy.foo  At DynamicProxy.java:[line 36]
The following classes needed for analysis were missing:
  taint.DynamicProxy$MyClass
Warnings generated: 1
Missing classes: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 36 | NA |
| Missing classes | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 1 |

> unsound
