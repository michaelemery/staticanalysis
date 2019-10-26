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

* [nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/IntraProceduralTest.java)

#### checker output
```
src/main/java/nullness/IntraProcedural.java:25: warning: [NullAway] assigning @Nullable expression to @NonNull field
        i.foo = null;
              ^
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

* [nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/InterProcedural.java)

* [nullness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/InterProceduralTest.java)

#### checker output
```
src/main/java/nullness/InterProcedural.java:29: warning: [NullAway] passing @Nullable parameter 'null' where @NonNull is required
        i.foo = i.getObject(null);
                            ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 29 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## ReflectConstructor

* [nullness/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/ReflectConstructor.java)

* [nullness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectConstructorTest.java)

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

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectMethodTest.java)

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

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectFieldTest.java)

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

## MethodHandleConstructor

* [nullness/MethodHandleConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/MethodHandleConstructor.java)

* [nullness/MethodHandleConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleConstructorTest.java)

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

## MethodHandleMethod

* [nullness/MethodHandleMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/MethodHandleMethod.java)

* [nullness/MethodHandleMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleMethodTest.java)

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

## MethodHandleField

* [nullness/MethodHandleField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/MethodHandleField.java)

* [nullness/MethodHandleFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleFieldTest.java)

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

## InvokeDynamic

* [nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/InvokeDynamic.java)

* [nullness/InvokeDynamicTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/InvokeDynamicTest.java)

#### checker output
```
src/main/java/nullness/InvokeDynamic.java:31: warning: [NullAway] passing @Nullable parameter 'null' where @NonNull is required
        java.util.function.Consumer<Object> c = foo -> i.setFoo(null);
                                                                ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 31 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## DynamicProxy

* [nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/DynamicProxyTest.java)

#### checker output
```
src/main/java/nullness/DynamicProxy.java:55: warning: [NullAway] passing @Nullable parameter 'null' where @NonNull is required
        i.foo = i.getProxyInstance().getObject(null);
                                               ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 55 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## UnsafeField

* [nullness/UnsafeField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/UnsafeField.java)

* [nullness/UnsafeFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeFieldTest.java)

#### checker output
```
src/main/java/nullness/UnsafeField.java:12: warning: [NullAway] @NonNull field foo not initialized
    Object foo;
           ^
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

## UnsafeInitialisation

* [nullness/UnsafeInitialisation.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/UnsafeInitialisation.java)

* [nullness/UnsafeInitialisationTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeInitialisationTest.java)

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
