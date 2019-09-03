# infer results (init)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

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

* [init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

* [init/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/IntraProceduralTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac src/init/IntraProcedural.java
```

#### checker output

```
Found 1 issue

src/init/IntraProcedural.java:31: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `IntraProcedural(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 31)
  29.        */
  30.       public static void setFooToNull() {
  31. >         new IntraProcedural(null).foo.toString();
  32.       }
  33.   
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

## InterProcedural

* [init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

* [init/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InterProceduralTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac src/init/InterProcedural.java
```

#### checker output

```
Found 1 issue

src/init/InterProcedural.java:35: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `InterProcedural(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 35)
  33.        */
  34.       public static void setFooToNull() {
  35. >         new InterProcedural(null).foo.toString();
  36.       }
  37.   
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 35 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## ReflectConstructor

* [init/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectConstructor.java)

* [init/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectConstructorTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac src/init/ReflectConstructor.java
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

* [init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

* [init/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectMethodTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac src/init/ReflectMethod.java
```

#### checker output

```
Found 1 issue

src/init/ReflectMethod.java:33: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `ReflectMethod(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 33)
  31.        */
  32.       public static void setFooToNull() throws Exception {
  33. >         new ReflectMethod(null).foo.toString();
  34.       }
  35.   }
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

## ReflectField

* [init/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectField.java)

* [init/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac src/init/ReflectField.java
```

#### checker output

```
Found 2 issues

src/init/ReflectField.java:12: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectField.foo` is not initialized in the constructor and is not declared `@Nullable`
  10.       Object foo;
  11.   
  12. >     ReflectField(Object object) throws NoSuchFieldException, IllegalAccessException {
  13.           Class<?> C = this.getClass();
  14.           Field objectField = C.getDeclaredField("foo");

src/init/ReflectField.java:29: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `ReflectField(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 29)
  27.        */
  28.       public static void setFooToNull() throws Exception {
  29. >         new ReflectField(null).foo.toString();
  30.       }
  31.   }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12 | FP |
| 29 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise

<br>

## InvokeDynamicConstructor

* [init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

* [init/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicConstructorTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac src/init/InvokeDynamicConstructor.java
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

* [init/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicMethod.java)

* [init/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicMethodTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac src/init/InvokeDynamicMethod.java
```

#### checker output

```
Found 1 issue

src/init/InvokeDynamicMethod.java:37: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `InvokeDynamicMethod(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 37)
  35.        */
  36.       public static void setFooToNull() throws Throwable {
  37. >         new InvokeDynamicMethod(null).foo.toString();
  38.       }
  39.   }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 37 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## InvokeDynamicField

* [init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicField.java)

* [init/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac src/init/InvokeDynamicField.java
```

#### checker output

```
Found 2 issues

src/init/InvokeDynamicField.java:13: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `InvokeDynamicField.foo` is not initialized in the constructor and is not declared `@Nullable`
  11.       Object foo;
  12.   
  13. >     InvokeDynamicField(Object object) throws Throwable {
  14.           getSetterMethodHandle().invoke(null, object);
  15.           this.foo.toString();

src/init/InvokeDynamicField.java:34: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `InvokeDynamicField(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 34)
  32.        */
  33.       public static void setFooToNull() throws Throwable {
  34. >         new InvokeDynamicField(null);
  35.       }
  36.   }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 13 | FP |
| 34 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise

<br>

## DynamicProxy

* [init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/DynamicProxy.java)

* [init/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/DynamicProxyTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac src/init/DynamicProxy.java
```

#### checker output

```
Found 1 issue

src/init/DynamicProxy.java:44: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `DynamicProxy(...)` needs a non-null value in parameter 2 but argument `null` can be null. (Origin: null constant at line 44)
  42.        */
  43.       static void setFooToNull() {
  44. >         new DynamicProxy(getProxyInstance(), null).foo.toString();
  45.       }
  46.   }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 44 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate
