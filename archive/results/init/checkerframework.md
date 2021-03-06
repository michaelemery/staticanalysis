# checker framework results (init)

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

* [init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

* [init/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/IntraProceduralTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/IntraProcedural.java
```

#### checker output

```
src/init/IntraProcedural.java:16: error: [dereference.of.nullable] dereference of possibly-null reference this.foo
        this.foo.toString();
            ^
src/init/IntraProcedural.java:31: error: [argument.type.incompatible] incompatible types in argument.
        new IntraProcedural(null).foo.toString();
                            ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16 | TP |
| 31 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 2 | 0 |
| - | 0 | 1 |

> accurate

<br>

## InterProcedural

* [init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

* [init/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InterProceduralTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/InterProcedural.java
```

#### checker output

```
src/init/InterProcedural.java:16: error: [dereference.of.nullable] dereference of possibly-null reference this.foo
        this.foo.toString();
            ^
src/init/InterProcedural.java:35: error: [argument.type.incompatible] incompatible types in argument.
        new InterProcedural(null).foo.toString();
                            ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16 | TP |
| 35 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 2 | 0 |
| - | 0 | 1 |

> accurate

<br>

## ReflectConstructor

* [init/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectConstructor.java)

* [test/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectConstructorTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/ReflectConstructor.java
```

#### checker output

```
src/init/ReflectConstructor.java:33: error: [argument.type.incompatible] incompatible types in argument.
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

* [init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

* [test/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/ReflectMethod.java
```

#### checker output

```
src/init/ReflectMethod.java:15: error: [assignment.type.incompatible] incompatible types in assignment.
        this.foo = getObject.invoke(null, object);
                                   ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/init/ReflectMethod.java:15: error: [argument.type.incompatible] incompatible types in argument.
        this.foo = getObject.invoke(null, object);
                                    ^
  found   : null
  required: @Initialized @NonNull Object
src/init/ReflectMethod.java:33: error: [argument.type.incompatible] incompatible types in argument.
        new ReflectMethod(null).foo.toString();
                          ^
  found   : null
  required: @Initialized @NonNull Object
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 15(i), 15(ii) | FP |
| 33 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 1 |

> imprecise

<br>

## ReflectField

* [init/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectField.java)

* [test/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/ReflectField.java
```

#### checker output

````
src/init/ReflectField.java:12: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
    ReflectField(Object object) throws NoSuchFieldException, IllegalAccessException {
    ^
src/init/ReflectField.java:29: error: [argument.type.incompatible] incompatible types in argument.
        new ReflectField(null).foo.toString();
                         ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
````

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12 | FP |
| 29 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 1 |

> imprecise

<br>

## InvokeDynamicConstructor

* [init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

* [test/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicConstructorTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/InvokeDynamicConstructor.java
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

* [test/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicMethodTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/InvokeDynamicMethod.java
```

#### checker output

```
src/init/InvokeDynamicMethod.java:37: error: [argument.type.incompatible] incompatible types in argument.
        new InvokeDynamicMethod(null).foo.toString();
                                ^
  found   : null
  required: @Initialized @NonNull Object
1 error
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

* [test/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicFieldTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/InvokeDynamicField.java
```

#### checker output

```
src/init/InvokeDynamicField.java:14: error: [argument.type.incompatible] incompatible types in argument.
        getSetterMethodHandle().invoke(this, object);
                                       ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull InvokeDynamicField
  required: @Initialized @NonNull InvokeDynamicField
src/init/InvokeDynamicField.java:15: error: [dereference.of.nullable] dereference of possibly-null reference this.foo
        this.foo.toString();
            ^
src/init/InvokeDynamicField.java:34: error: [argument.type.incompatible] incompatible types in argument.
        new InvokeDynamicField(null);
                               ^
  found   : null
  required: @Initialized @NonNull Object
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 14, 15 | FP |
| 24 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 1 |

> imprecise

<br>

## DynamicProxy

* [init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/DynamicProxy.java)

* [test/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/DynamicProxyTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/DynamicProxy.java
```

#### checker output

```
src/init/DynamicProxy.java:22: error: [argument.type.incompatible] incompatible types in argument.
                MyClass.class.getClassLoader(),
                                            ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
src/init/DynamicProxy.java:44: error: [argument.type.incompatible] incompatible types in argument.
        new DynamicProxy(getProxyInstance(), null).foo.toString();
                                             ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 22 | FN |
| 44 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 1 |

> imprecise
