# checker framework results (nullness)

[results](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)

<br>

Version: checker-framework-2.11.0

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

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/IntraProcedural.java
```

#### checker output

```
src/main/java/nullness/IntraProcedural.java:25: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = null;
                ^
  found   : null
  required: @Initialized @NonNull Object
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

* [nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/InterProcedural.java)

* [nullness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/InterProceduralTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/InterProcedural.java
```

#### checker output

```
src/main/java/nullness/InterProcedural.java:29: error: [argument.type.incompatible] incompatible types in argument.
        i.foo = i.getObject(null);
                            ^
  found   : null
  required: @Initialized @NonNull Object
1 error
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

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/ReflectConstructor.java
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

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/ReflectMethod.java
```

#### checker output

```
src/main/java/nullness/ReflectMethod.java:34: error: [argument.type.incompatible] incompatible types in argument.
        Object foo = getObjectMethod.invoke(i, (Object) null);
                                               ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 34 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/ReflectField.java
```

#### checker output

````
No reported issues.
````

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

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/MethodHandleConstructor.java
```

#### checker output

```
error: ClassValAnnotatedTypeFactory.getClassname: did not expect VOID; invoke the compiler with -AprintErrorStack to see the stack trace.
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| error | NA |

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

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/MethodHandleMethod.java
```

#### checker output

```
src/main/java/nullness/MethodHandleMethod.java:36: error: [argument.type.incompatible] incompatible types in argument.
        Object foo = i.getMethodHandle("getObject").invoke(i, (Object) null);
                                                              ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
1 error

```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 36 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## MethodHandleField

* [nullness/MethodHandleField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/MethodHandleField.java)

* [nullness/MethodHandleFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/MethodHandleField.java
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

## InvokeDynamic

* [nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/InvokeDynamic.java)

* [nullness/InvokeDynamicTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/InvokeDynamicTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/InvokeDynamic.java
```

#### checker output

```
src/main/java/nullness/InvokeDynamic.java:31: error: [argument.type.incompatible] incompatible types in argument.
        java.util.function.Consumer<Object> c = foo -> i.setFoo(null);
                                                                ^
  found   : null
  required: @Initialized @NonNull Object
1 error
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

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/DynamicProxy.java
```

#### checker output

```
src/main/java/nullness/DynamicProxy.java:29: error: [return.type.incompatible] incompatible types in return.
            return method.invoke(new MyClass(), methodArgs);
                                ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/main/java/nullness/DynamicProxy.java:35: error: [argument.type.incompatible] incompatible types in argument.
                MyInterface.class.getClassLoader(),
                                                ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
src/main/java/nullness/DynamicProxy.java:55: error: [argument.type.incompatible] incompatible types in argument.
        i.foo = i.getProxyInstance().getObject(null);
                                               ^
  found   : null
  required: @Initialized @NonNull Object
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 29 | FP |
| 35 | FP |
| 55 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 2 |
| - | 0 | 1 |

> imprecise

<br>

## UnsafeField

* [nullness/UnsafeField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/UnsafeField.java)

* [nullness/UnsafeFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/UnsafeField.java
```

#### checker output

```
src/main/java/nullness/UnsafeField.java:10: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class UnsafeField {
       ^
src/main/java/nullness/UnsafeField.java:17: error: [return.type.incompatible] incompatible types in return.
        return (Unsafe) f.get(null);
               ^
  found   : @Initialized @Nullable Unsafe
  required: @Initialized @NonNull Unsafe
src/main/java/nullness/UnsafeField.java:39: error: [argument.type.incompatible] incompatible types in argument.
                        UnsafeField.class.getDeclaredField("foo")), null);
                                                                    ^
  found   : null
  required: @Initialized @NonNull Object
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10, 17 | NA |
| 39 | TP |


#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## UnsafeInitialisation

* [nullness/UnsafeInitialisation.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/UnsafeInitialisation.java)

* [nullness/UnsafeInitialisationTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeInitialisationTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullness/UnsafeInitialisation.java
```

#### checker output

```
src/main/java/nullness/UnsafeInitialisation.java:21: error: [return.type.incompatible] incompatible types in return.
        return (Unsafe) f.get(null);
               ^
  found   : @Initialized @Nullable Unsafe
  required: @Initialized @NonNull Unsafe
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 21 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate
