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

* [nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/IntraProceduralTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/IntraProcedural.java
```

#### checker output

```
Found 2 issues

src/main/java/nullness/IntraProcedural.java:25: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `IntraProcedural.foo` can be null but is not declared `@Nullable`. (Origin: null constant at line 25)
  23.       public static void setFooToNull() {
  24.           IntraProcedural i = new IntraProcedural();
  25. >         i.foo = null;
  26.           i.foo.toString();
  27.       }

src/main/java/nullness/IntraProcedural.java:26: error: ERADICATE_NULL_METHOD_CALL
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
| 25, 26 | TP |

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
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/InterProcedural.java
```

#### checker output

```
Found 1 issue

src/main/java/nullness/InterProcedural.java:29: error: ERADICATE_PARAMETER_NOT_NULLABLE
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
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/ReflectConstructor.java
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

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectMethodTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/ReflectMethod.java
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

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/ReflectField.java
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
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/MethodHandleConstructor.java
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
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/MethodHandleMethod.java
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

## MethodHandleField

* [nullness/MethodHandleField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/MethodHandleField.java)

* [nullness/MethodHandleFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/MethodHandleField.java
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
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/InvokeDynamic.java
```

#### checker output

```
Found 1 issue

src/main/java/nullness/InvokeDynamic.java:31: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `setFoo(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 31)
  29.       public static void setFooToNull() {
  30.           InvokeDynamic i = new InvokeDynamic();
  31. >         java.util.function.Consumer<Object> c = foo -> i.setFoo(null);
  32.           c.accept(new Object());
  33.           i.foo.toString();
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
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/DynamicProxy.java
```

#### checker output

```
Found 1 issue

src/main/java/nullness/DynamicProxy.java:55: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `getObject(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 55)
  53.       public static void setFooToNull() {
  54.           DynamicProxy i = new DynamicProxy();
  55. >         i.foo = i.getProxyInstance().getObject(null);
  56.           i.foo.toString();
  57.       }
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

* [nullness/UnsafeField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/DynamicProxy.java)

* [nullness/UnsafeFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/UnsafeField.java
```

#### checker output

```
Found 1 issue

src/main/java/nullness/UnsafeField.java:10: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `UnsafeField.foo` is not initialized in the constructor and is not declared `@Nullable`
  8.    * Check nullness of field set via sun.misc.Unsafe.
  9.    */
  10. > public class UnsafeField {
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

<br>

## UnsafeInitialisation

* [nullness/UnsafeInitialisation.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullness/UnsafeInitialisation.java)

* [nullness/UnsafeInitialisationTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeInitialisationTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/main/java/nullness/UnsafeInitialisation.java
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
