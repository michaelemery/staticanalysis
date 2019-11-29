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

* [nullnessCheckerFramework/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/IntraProceduralTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/IntraProcedural.java
```

#### checker output

```
src/main/java/nullnessCheckerFramework/IntraProcedural.java:24: error: [dereference.of.nullable] dereference of possibly-null reference foo
        foo.toString();
        ^
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 24 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## InterProcedural

* [nullnessCheckerFramework/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/InterProcedural.java)

* [nullness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/InterProceduralTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/InterProcedural.java
```

#### checker output

```
src/main/java/nullnessCheckerFramework/InterProcedural.java:23: error: [argument.type.incompatible] incompatible types in argument.
        Object foo = getObject(null);
                               ^
  found   : null
  required: @Initialized @NonNull Object
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 23 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## ReflectConstructor

* [nullnessCheckerFramework/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/ReflectConstructor.java)

* [nullness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectConstructorTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/ReflectConstructor.java
```

#### checker output

```
src/main/java/nullnessCheckerFramework/ReflectConstructor.java:25: error: [dereference.of.nullable] dereference of possibly-null reference ((ReflectConstructor)constructor.newInstance(new Object())).foo
        ((ReflectConstructor) constructor.newInstance(new Object())).foo.toString();
                                                                    ^
src/main/java/nullnessCheckerFramework/ReflectConstructor.java:33: error: [dereference.of.nullable] dereference of possibly-null reference ((ReflectConstructor)constructor.newInstance((Object)null)).foo
        ((ReflectConstructor) constructor.newInstance((Object) null)).foo.toString();
                                                                     ^
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 25 | FP |
| 33 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> imprecise

<br>

## ReflectMethod

* [nullnessCheckerFramework/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/ReflectMethod.java
```

#### checker output

```
src/main/java/nullnessCheckerFramework/ReflectMethod.java:22: error: [dereference.of.nullable] dereference of possibly-null reference foo
        foo.toString();
        ^
src/main/java/nullnessCheckerFramework/ReflectMethod.java:32: error: [argument.type.incompatible] incompatible types in argument.
        Object foo = getObjectMethod.invoke(i, (Object) null);
                                               ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
src/main/java/nullnessCheckerFramework/ReflectMethod.java:33: error: [dereference.of.nullable] dereference of possibly-null reference foo
        foo.toString();
        ^
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 22 | FP |
| 32, 33 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> imprecise

<br>

## ReflectField

* [nullnessCheckerFramework/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/ReflectField.java
```

#### checker output

````
src/main/java/nullnessCheckerFramework/ReflectField.java:17: error: [dereference.of.nullable] dereference of possibly-null reference i.foo
        i.foo.toString();
         ^
src/main/java/nullnessCheckerFramework/ReflectField.java:26: error: [dereference.of.nullable] dereference of possibly-null reference i.foo
        i.foo.toString();
         ^
2 errors
````

#### output analysis

| line(s) | event |
| :---: | :---: |
| 17 | FP |
| 26 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> imprecise

<br>

## MethodHandleConstructor

* [nullnessCheckerFramework/MethodHandleConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/MethodHandleConstructor.java)

* [nullness/MethodHandleConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleConstructorTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/MethodHandleConstructor.java
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

* [nullnessCheckerFramework/MethodHandleMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/MethodHandleMethod.java)

* [nullness/MethodHandleMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/MethodHandleMethod.java
```

#### checker output

```
src/main/java/nullnessCheckerFramework/MethodHandleMethod.java:36: error: [argument.type.incompatible] incompatible types in argument.
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

* [nullnessCheckerFramework/MethodHandleField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/MethodHandleField.java)

* [nullness/MethodHandleFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/MethodHandleField.java
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

* [nullnessCheckerFramework/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/InvokeDynamic.java)

* [nullness/InvokeDynamicTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/InvokeDynamicTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/InvokeDynamic.java
```

#### checker output

```
src/main/java/nullnessCheckerFramework/InvokeDynamic.java:18: error: [return.type.incompatible] incompatible types in return.
        java.util.function.Function<Object, Object> c = foo -> i.getFoo(foo);
                                                                       ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/main/java/nullnessCheckerFramework/InvokeDynamic.java:30: error: [return.type.incompatible] incompatible types in return.
        java.util.function.Function<Object, Object> c = foo -> i.getFoo(foo);
                                                                       ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/main/java/nullnessCheckerFramework/InvokeDynamic.java:31: error: [argument.type.incompatible] incompatible types in argument.
        Object foo = c.apply(null);
                             ^
  found   : null
  required: @Initialized @NonNull Object
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18 | FP |
| 30, 31 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise

<br>

## DynamicProxy

* [nullnessCheckerFramework/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/DynamicProxyTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/DynamicProxy.java
```

#### checker output

```
src/main/java/nullnessCheckerFramework/DynamicProxy.java:29: error: [return.type.incompatible] incompatible types in return.
            return method.invoke(new MyClass(), methodArgs);
                                ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/main/java/nullnessCheckerFramework/DynamicProxy.java:35: error: [argument.type.incompatible] incompatible types in argument.
                MyInterface.class.getClassLoader(),
                                                ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
src/main/java/nullnessCheckerFramework/DynamicProxy.java:46: error: [dereference.of.nullable] dereference of possibly-null reference foo
        foo.toString();
        ^
src/main/java/nullnessCheckerFramework/DynamicProxy.java:55: error: [argument.type.incompatible] incompatible types in argument.
        Object foo = i.getProxyInstance().getObject(null);
                                                    ^
  found   : null
  required: @Initialized @NonNull Object
src/main/java/nullnessCheckerFramework/DynamicProxy.java:56: error: [dereference.of.nullable] dereference of possibly-null reference foo
        foo.toString();
        ^
5 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 29 | FP |
| 35 | FP |
| 46 | FP |
| 55, 56 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 3 |
| - | 0 | 0 |

> imprecise

<br>

## UnsafeField

* [nullnessCheckerFramework/UnsafeField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/UnsafeField.java)

* [nullness/UnsafeFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/UnsafeField.java
```

#### checker output

```
src/main/java/nullnessCheckerFramework/UnsafeField.java:17: error: [return.type.incompatible] incompatible types in return.
        return (Unsafe) f.get(null);
               ^
  found   : @Initialized @Nullable Unsafe
  required: @Initialized @NonNull Unsafe
src/main/java/nullnessCheckerFramework/UnsafeField.java:39: error: [argument.type.incompatible] incompatible types in argument.
                        UnsafeField.class.getDeclaredField("foo")), null);
                                                                    ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
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

* [nullnessCheckerFramework/UnsafeInitialisation.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessCheckerFramework/UnsafeInitialisation.java)

* [nullness/UnsafeInitialisationTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeInitialisationTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -AresolveReflection -d out/ src/main/java/nullnessCheckerFramework/UnsafeInitialisation.java
```

#### checker output

```
src/main/java/nullnessCheckerFramework/UnsafeInitialisation.java:21: error: [return.type.incompatible] incompatible types in return.
        return (Unsafe) f.get(null);
               ^
  found   : @Initialized @Nullable Unsafe
  required: @Initialized @NonNull Unsafe
src/main/java/nullnessCheckerFramework/UnsafeInitialisation.java:28: error: [dereference.of.nullable] dereference of possibly-null reference new UnsafeInitialisation().foo
        new UnsafeInitialisation().foo.toString();
                                  ^
src/main/java/nullnessCheckerFramework/UnsafeInitialisation.java:39: error: [dereference.of.nullable] dereference of possibly-null reference i.foo
        i.foo.toString();
         ^
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 21, 29 | TP |
| 28 | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise
