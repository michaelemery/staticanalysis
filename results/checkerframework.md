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
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessIntraProcedural.java
```

#### checker output

```
src/main/java/nullnessIntraProcedural.java:6: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class IntraProcedural {
       ^
src/main/java/nullnessIntraProcedural.java:25: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = null;
                ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 6 | NA |
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
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessInterProcedural.java
```

#### checker output

```
src/main/java/nullnessInterProcedural.java:6: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class InterProcedural {
       ^
src/main/java/nullnessInterProcedural.java:29: error: [argument.type.incompatible] incompatible types in argument.
        i.foo = i.getObject(null);
                            ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 6 | NA |
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
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessReflectConstructor.java
```

#### checker output

```
src/main/java/nullnessReflectConstructor.java:33: error: [argument.type.incompatible] incompatible types in argument.
        ((ReflectConstructor) constructor.newInstance((Object) null)).foo.toString();
                                                      ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 33 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## ReflectMethod

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessReflectMethod.java
```

#### checker output

```
src/main/java/nullnessReflectMethod.java:8: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class ReflectMethod {
       ^
src/main/java/nullnessReflectMethod.java:23: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = getObjectMethod.invoke(i, new Object());
                                      ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/main/java/nullnessReflectMethod.java:34: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = getObjectMethod.invoke(i, (Object) null);
                                      ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/main/java/nullnessReflectMethod.java:34: error: [argument.type.incompatible] incompatible types in argument.
        i.foo = getObjectMethod.invoke(i, (Object) null);
                                          ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
4 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | NA |
| 23 | FP |
| 34(i), 34(ii) | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 1 |

> imprecise

<br>

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessReflectField.java
```

#### checker output

````
src/main/java/nullnessReflectField.java:6: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class ReflectField {
       ^
1 error
````

#### output analysis

| line(s) | event |
| :---: | :---: |
| 6 | NA |

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
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessMethodHandleConstructor.java
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

## MethodHandleMethod

* [nullness/MethodHandleMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/MethodHandleMethod.java)

* [nullness/MethodHandleMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessMethodHandleMethod.java
```

#### checker output

```
src/main/java/nullnessMethodHandleMethod.java:9: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class MethodHandleMethod {
       ^
src/main/java/nullnessMethodHandleMethod.java:38: error: [argument.type.incompatible] incompatible types in argument.
        i.getSetFooMethodHandle().invoke(i, (Object) null);
                                            ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 9 | NA |
| 38 | TP |

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
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessMethodHandleField.java
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
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessInvokeDynamic.java
```

#### checker output

```
src/main/java/nullnessInvokeDynamic.java:6: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class InvokeDynamic {
       ^
src/main/java/nullnessInvokeDynamic.java:30: error: [argument.type.incompatible] incompatible types in argument.
        java.util.function.Consumer<Object> c = foo -> i.setFoo(null);
                                                                ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 6 | NA |
| 30 | TP |

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
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessDynamicProxy.java
```

#### checker output

```
src/main/java/nullnessDynamicProxy.java:10: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class DynamicProxy {
       ^
src/main/java/nullnessDynamicProxy.java:27: error: [return.type.incompatible] incompatible types in return.
            return method.invoke(new MyClass(), methodArgs);
                                ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/main/java/nullnessDynamicProxy.java:33: error: [argument.type.incompatible] incompatible types in argument.
                MyInterface.class.getClassLoader(),
                                                ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
src/main/java/nullnessDynamicProxy.java:53: error: [argument.type.incompatible] incompatible types in argument.
        i.foo = i.getProxyInstance().getObject(null);
                                               ^
  found   : null
  required: @Initialized @NonNull Object
4 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | NA |
| 27 | FP |
| 33 | FP |
| 53 | TP |

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
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessUnsafeField.java
```

#### checker output

```
src/main/java/nullnessUnsafeField.java:10: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class UnsafeField {
       ^
src/main/java/nullnessUnsafeField.java:17: error: [return.type.incompatible] incompatible types in return.
        return (Unsafe) f.get(null);
               ^
  found   : @Initialized @Nullable Unsafe
  required: @Initialized @NonNull Unsafe
src/main/java/nullnessUnsafeField.java:38: error: [argument.type.incompatible] incompatible types in argument.
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
| 38 | TP |


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
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/main/java/nullnessUnsafeInitialisation.java
```

#### checker output

```
src/main/java/nullnessUnsafeInitialisation.java:10: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class UnsafeInitialisation {
       ^
src/main/java/nullnessUnsafeInitialisation.java:17: error: [return.type.incompatible] incompatible types in return.
        return (Unsafe) f.get(null);
               ^
  found   : @Initialized @Nullable Unsafe
  required: @Initialized @NonNull Unsafe
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10,17 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound
