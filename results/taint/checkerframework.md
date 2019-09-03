# checker framework results (taint)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: checker-framework-2.1.11

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
javac -processor org.checkerframework.checker.tainting.TaintingChecker -d out/ src/taint/IntraProcedural.java
```

#### checker output

```
src/taint/IntraProcedural.java:25: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = new Object();
                ^
  found   : @Tainted Object
  required: @Untainted Object
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 25 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## InterProcedural

* [taint/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InterProcedural.java)

* [taint/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InterProceduralTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.tainting.TaintingChecker -d out/ src/taint/InterProcedural.java
```

#### checker output

```
src/taint/InterProcedural.java:28: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = i.getObject();
                           ^
  found   : @Tainted Object
  required: @Untainted Object
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 28 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## ReflectConstructor

* [taint/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectConstructor.java)

* [taint/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectConstructorTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.tainting.TaintingChecker -d out/ src/taint/ReflectConstructor.java
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

## ReflectMethod

* [taint/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectMethod.java)

* [taint/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.tainting.TaintingChecker -d out/ src/taint/ReflectMethod.java
```

#### checker output

```
src/taint/ReflectMethod.java:29: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = getObjectMethod.invoke(i);
                                      ^
  found   : @Tainted Object
  required: @Untainted Object
src/taint/ReflectMethod.java:39: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = getObjectMethod.invoke(i);
                                      ^
  found   : @Tainted Object
  required: @Untainted Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 29 | FP |
| 39 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise

<br>

## ReflectField

* [taint/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectField.java)

* [taint/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.tainting.TaintingChecker -d out/ src/taint/ReflectField.java
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
javac -processor org.checkerframework.checker.tainting.TaintingChecker -d out/ src/taint/InvokeDynamicConstructor.java
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

## InvokeDynamicMethod

* [taint/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InvokeDynamicMethod.java)

* [taint/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InvokeDynamicMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.tainting.TaintingChecker -d out/ src/taint/InvokeDynamicMethod.java
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
javac -processor org.checkerframework.checker.tainting.TaintingChecker -d out/ src/taint/InvokeDynamicField.java
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
javac -processor org.checkerframework.checker.tainting.TaintingChecker -d out/ src/taint/DynamicProxy.java
```

#### checker output

```
src/taint/DynamicProxy.java:36: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = i.getProxyInstance().getObject(new @Untainted Object());
                                              ^
  found   : @Tainted Object
  required: @Untainted Object
src/taint/DynamicProxy.java:44: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = i.getProxyInstance().getObject(new Object());
                                              ^
  found   : @Tainted Object
  required: @Untainted Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 36 | FP |
| 44 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise
