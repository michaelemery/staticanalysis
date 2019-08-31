# findbugs results (nullness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

#### run checker from docker

```shell script
docker pull michaelemery/staticanalysis
docker run -it --rm michaelemery/staticanalysis
```

#### run junit tests from docker

```shell script
sh test.sh [ [ nullness ] | [ nullness <class-name> ] ]
```

* `sh test.sh` will run all tests for all packages

<br>

## IntraProcedural

* [nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/IntraProceduralTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/IntraProcedural.java
findbugs out/nullness/IntraProcedural.class
```

#### checker output

```
H C NP: Null pointer dereference of IntraProcedural.foo in nullness.IntraProcedural.setFooToNull()  Dereferenced at IntraProcedural.java:[line 27]
M D UC: Useless object stored in variable var$0 of method nullness.IntraProcedural.setFooToNonNull()  At IntraProcedural.java:[line 16]
M D UC: Useless object stored in variable var$0 of method nullness.IntraProcedural.setFooToNull()  At IntraProcedural.java:[line 25]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 18]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 27]
Warnings generated: 5
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 27(i) | TP |
| 16 | NA |
| 25 | NA |
| 18 | NA |
| 27(ii) | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 4 |
| - | 0 | 0 |

> imprecise

<br>

## InterProcedural

* [nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InterProcedural.java)

* [nullness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InterProceduralTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/InterProcedural.java
findbugs out/nullness/InterProcedural.class
```

#### checker output

```
M D UC: Useless object stored in variable var$0 of method nullness.InterProcedural.setFooToNull()  At InterProcedural.java:[line 27]
M D UC: Useless object stored in variable var$0 of method nullness.InterProcedural.setFooToNonNull()  At InterProcedural.java:[line 18]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 20]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 29]
Warnings generated: 4
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 27 | NA |
| 18 | NA |
| 20 | NA |
| 29 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## ReflectConstructor

* [nullness/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectConstructor.java)

* [nullness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectConstructorTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/ReflectConstructor.java
findbugs out/nullness/ReflectConstructor.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectConstructor.java:[line 25]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectConstructor.java:[line 33]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 25 | NA |
| 33 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## ReflectMethod

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectMethodTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/ReflectMethod.java
findbugs out/nullness/ReflectMethod.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectMethod.java:[line 24]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectMethod.java:[line 35]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 24 | NA |
| 35 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectFieldTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/ReflectField.java
findbugs out/nullness/ReflectField.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectField.java:[line 16]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectField.java:[line 25]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16 | NA |
| 25 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## InvokeDynamicConstructor

* [nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicConstructor.java)

* [nullness/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicConstructorTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/InvokeDynamicConstructor.java
findbugs out/nullness/InvokeDynamicConstructor.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicConstructor.java:[line 16]
Warnings generated: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## InvokeDynamicMethod

* [nullness/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicMethod.java)

* [nullness/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicMethodTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/InvokeDynamicMethod.java
findbugs out/nullness/InvokeDynamicMethod.class
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
| 30 | NA |
| 39 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## InvokeDynamicField

* [nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicField.java)

* [nullness/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicFieldTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/InvokeDynamicField.java
findbugs out/nullness/InvokeDynamicField.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicField.java:[line 28]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicField.java:[line 37]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 28 | NA |
| 37 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## DynamicProxy

* [nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/DynamicProxyTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/DynamicProxy.java
findbugs out/nullness/DynamicProxy.class
```

#### checker output

```
M D UC: Useless object stored in variable var$0 of method nullness.DynamicProxy.setFooToNull()  At DynamicProxy.java:[line 43]
M D UC: Useless object stored in variable var$0 of method nullness.DynamicProxy.setFooToNonNull()  At DynamicProxy.java:[line 34]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At DynamicProxy.java:[line 36]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At DynamicProxy.java:[line 45]
The following classes needed for analysis were missing:
  nullness.DynamicProxy$MyClass
Warnings generated: 4
Missing classes: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 43 | NA |
| 34 | NA |
| 36 | NA |
| 45 | NA |
| Missing Class | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 0 | 0 |

> unsound
