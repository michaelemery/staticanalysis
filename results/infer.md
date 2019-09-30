# infer results (nullness)

[results](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)

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

* [nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/IntraProceduralTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/IntraProcedural.java
```

#### checker output

```
Found 3 issues

src/nullness/IntraProcedural.java:6: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `IntraProcedural.foo` is not initialized in the constructor and is not declared `@Nullable`
  4.    * Check nullness of field set via direct value assignment.
  5.    */
  6. > public class IntraProcedural {
  7.   
  8.       Object foo;

src/nullness/IntraProcedural.java:25: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `IntraProcedural.foo` can be null but is not declared `@Nullable`. (Origin: null constant at line 25)
  23.       public static void setFooToNull() {
  24.           IntraProcedural i = new IntraProcedural();
  25. >         i.foo = null;
  26.           i.foo.toString();
  27.       }

src/nullness/IntraProcedural.java:26: error: ERADICATE_NULL_METHOD_CALL
  The value of `i.foo` in the call to `toString()` could be null. (Origin: null constant at line 25)
  24.           IntraProcedural i = new IntraProcedural();
  25.           i.foo = null;
  26. >         i.foo.toString();
  27.       }
  28.   }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 6 | NA |
| 25, 26 | TP |

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
infer run -a checkers --eradicate -- javac -d out/ src/nullness/InterProcedural.java
```

#### checker output

```
Found 2 issues

src/nullness/InterProcedural.java:6: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `InterProcedural.foo` is not initialized in the constructor and is not declared `@Nullable`
  4.    * Check nullness of field set via inter-procedural return.
  5.    */
  6. > public class InterProcedural {
  7.   
  8.       Object foo;

src/nullness/InterProcedural.java:29: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `getObject(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 29)
  27.       public static void setFooToNull() {
  28.           InterProcedural i = new InterProcedural();
  29. >         i.foo = i.getObject(null);
  30.           i.foo.toString();
  31.       }
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
infer run -a checkers --eradicate -- javac -d out/ src/nullness/ReflectConstructor.java
```

### checker output

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

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectMethodTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/ReflectMethod.java
```

#### checker output

```
Found 1 issue

src/nullness/ReflectMethod.java:8: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectMethod.foo` is not initialized in the constructor and is not declared `@Nullable`
  6.    * Check nullness of field set via reflection method invocation.
  7.    */
  8. > public class ReflectMethod {
  9.   
  10.       Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/ReflectField.java
```

#### checker output

````
Found 1 issue

src/nullness/ReflectField.java:6: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectField.foo` is not initialized in the constructor and is not declared `@Nullable`
  4.    * Check nullness of field set via reflective field access.
  5.    */
  6. > public class ReflectField {
  7.   
  8.       Object foo;
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
>
> * line 6 error occurs with or without setFooToNull() and is therefore FP
 
 <br>

## MethodHandleConstructor

* [nullness/MethodHandleConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleConstructor.java)

* [nullness/MethodHandleConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleConstructorTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/MethodHandleConstructor.java
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
infer run -a checkers --eradicate -- javac -d out/ src/nullness/MethodHandleMethod.java
```

#### checker output

```
Found 1 issue

src/nullness/MethodHandleMethod.java:9: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `MethodHandleMethod.foo` is not initialized in the constructor and is not declared `@Nullable`
  7.    * Check nullness of field set by invoking virtual (non-static) method handle.
  8.    */
  9. > public class MethodHandleMethod {
  10.   
  11.       Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 9 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## MethodHandleField

* [nullness/MethodHandleField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleField.java)

* [nullness/MethodHandleFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/MethodHandleField.java
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
infer run -a checkers --eradicate -- javac -d out/ src/nullness/InvokeDynamic.java
```

#### checker output

```
Found 2 issues

src/nullness/InvokeDynamic.java:6: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `InvokeDynamic.foo` is not initialized in the constructor and is not declared `@Nullable`
  4.    * Check nullness of field set via dynamic invocation of setter method.
  5.    */
  6. > public class InvokeDynamic {
  7.   
  8.       Object foo;

src/nullness/InvokeDynamic.java:30: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `setFoo(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 30)
  28.       public static void setFooToNull() {
  29.           InvokeDynamic i = new InvokeDynamic();
  30. >         java.util.function.Consumer<Object> c = foo -> i.setFoo(null);
  31.           c.accept(new Object());
  32.           i.foo.toString();
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
infer run -a checkers --eradicate -- javac -d out/ src/nullness/DynamicProxy.java
```

#### checker output

```
Found 2 issues

src/nullness/DynamicProxy.java:10: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `DynamicProxy.foo` is not initialized in the constructor and is not declared `@Nullable`
  8.    * Check nullness for field set via dynamic proxy invocation.
  9.    */
  10. > public class DynamicProxy {
  11.   
  12.       Object foo;

src/nullness/DynamicProxy.java:53: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `getObject(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 53)
  51.       public static void setFooToNull() {
  52.           DynamicProxy i = new DynamicProxy();
  53. >         i.foo = i.getProxyInstance().getObject(null);
  54.           i.foo.toString();
  55.       }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | NA |
| 44 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate
>
> * line 8 error occurs with or without setFooToNull() and is therefore FP

<br>

## UnsafeField

* [nullness/UnsafeField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

* [nullness/UnsafeFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/UnsafeFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/UnsafeField.java
```

#### checker output

```
Found 1 issue

src/nullness/UnsafeField.java:39: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `UnsafeField(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 39)
  37.        */
  38.       public static void setFooToNull() throws Exception {
  39. >         UnsafeField i = new UnsafeField(null);
  40.           getUnsafe().putObject(
  41.                   i, getUnsafe().objectFieldOffset(
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 39 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## UnsafeInitialisation

* [nullness/UnsafeInitialisation.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/UnsafeInitialisation.java)

* [nullness/UnsafeInitialisationTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/UnsafeInitialisationTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/UnsafeInitialisation.java
```

#### checker output

```
Found 1 issue

src/nullness/UnsafeInitialisation.java:10: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `UnsafeInitialisation.foo` is not initialized in the constructor and is not declared `@Nullable`
  8.    * Allocate an empty instance of a class directly on the heap via sun.misc.Unsafe.
  9.    */
  10. > public class UnsafeInitialisation {
  11.   
  12.       Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound
