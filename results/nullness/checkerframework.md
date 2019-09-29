# checker framework results (nullness)

[results summary](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md)

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

* [nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/IntraProceduralTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/IntraProcedural.java
```

#### checker output

```
src/nullness/IntraProcedural.java:6: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class IntraProcedural {
       ^
src/nullness/IntraProcedural.java:25: error: [assignment.type.incompatible] incompatible types in assignment.
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

* [nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InterProcedural.java)

* [nullness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InterProceduralTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/InterProcedural.java
```

#### checker output

```
src/nullness/InterProcedural.java:6: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class InterProcedural {
       ^
src/nullness/InterProcedural.java:29: error: [argument.type.incompatible] incompatible types in argument.
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

* [nullness/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectConstructor.java)

* [nullness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectConstructorTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/ReflectConstructor.java
```

#### checker output

```
src/nullness/ReflectConstructor.java:33: error: [argument.type.incompatible] incompatible types in argument.
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

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/ReflectMethod.java
```

#### checker output

```
src/nullness/ReflectMethod.java:8: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class ReflectMethod {
       ^
src/nullness/ReflectMethod.java:23: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = getObjectMethod.invoke(i, new Object());
                                      ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/nullness/ReflectMethod.java:34: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = getObjectMethod.invoke(i, (Object) null);
                                      ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/nullness/ReflectMethod.java:34: error: [argument.type.incompatible] incompatible types in argument.
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

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/ReflectField.java
```

#### checker output

````
src/nullness/ReflectField.java:6: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
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

* [nullness/MethodHandleConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleConstructor.java)

* [nullness/MethodHandleConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleConstructorTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/MethodHandleConstructor.java
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

* [nullness/MethodHandleMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleMethod.java)

* [nullness/MethodHandleMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/MethodHandleMethod.java
```

#### checker output

```
src/nullness/MethodHandleMethod.java:9: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class MethodHandleMethod {
       ^
src/nullness/MethodHandleMethod.java:38: error: [argument.type.incompatible] incompatible types in argument.
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

* [nullness/MethodHandleField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleField.java)

* [nullness/MethodHandleFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/MethodHandleField.java
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

* [nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamic.java)

* [nullness/InvokeDynamicTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/InvokeDynamic.java
```

#### checker output

```
src/nullness/InvokeDynamic.java:6: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class InvokeDynamic {
       ^
src/nullness/InvokeDynamic.java:30: error: [argument.type.incompatible] incompatible types in argument.
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

* [nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/DynamicProxyTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/DynamicProxy.java
```

#### checker output

```
src/nullness/DynamicProxy.java:10: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class DynamicProxy {
       ^
src/nullness/DynamicProxy.java:27: error: [return.type.incompatible] incompatible types in return.
            return method.invoke(new MyClass(), methodArgs);
                                ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/nullness/DynamicProxy.java:33: error: [argument.type.incompatible] incompatible types in argument.
                MyInterface.class.getClassLoader(),
                                                ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
src/nullness/DynamicProxy.java:53: error: [argument.type.incompatible] incompatible types in argument.
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

* [nullness/UnsafeField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/UnsafeField.java)

* [nullness/UnsafeFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/UnsafeFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/UnsafeField.java
```

#### checker output

```
src/nullness/UnsafeField.java:10: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class UnsafeField {
       ^
src/nullness/UnsafeField.java:17: error: [return.type.incompatible] incompatible types in return.
        return (Unsafe) f.get(null);
               ^
  found   : @Initialized @Nullable Unsafe
  required: @Initialized @NonNull Unsafe
src/nullness/UnsafeField.java:38: error: [argument.type.incompatible] incompatible types in argument.
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

* [nullness/UnsafeInitialisation.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/UnsafeInitialisation.java)

* [nullness/UnsafeInitialisationTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/UnsafeInitialisationTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/UnsafeInitialisation.java
```

#### checker output

```
src/nullness/UnsafeInitialisation.java:10: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class UnsafeInitialisation {
       ^
src/nullness/UnsafeInitialisation.java:17: error: [return.type.incompatible] incompatible types in return.
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
