# checker framework results (init)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

#### checker

Version: checker-framework-2.1.11

Init checking is part of the Nullness Checker. To run the Nullness Checker, supply the `-processor org.checkerframework.checker.nullness.NullnessChecker` command-line option to javac.

#### run checker from docker

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

If you have Docker installed on your system, you may pull/update and run the Docker instance for this project with;

```
docker pull michaelemery/staticanalysis
docker run -it --rm michaelemery/staticanalysis
```

#### run junit tests from docker

```
sh test.sh [ [ package-name ] | [ package-name class-name ] ]
```

* `sh test.sh` will run all tests
* do not include `.class` suffix for class name

<br>

## IntraProcedural

[src/init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

[test/init/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/IntraProceduralTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/IntraProcedural.java
```

#### checker output

```
src/init/IntraProcedural.java:18: error: [dereference.of.nullable] dereference of possibly-null reference this.object
        this.object.toString();
            ^
src/init/IntraProcedural.java:23: error: [dereference.of.nullable] dereference of possibly-null reference this.object
        this.object.toString();
            ^
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18 | TP |
| 23 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 2 | 0 |
| - | 0 | 1 |

&nbsp; ⟶ &nbsp; accurate

<br>

## InterProcedural

[src/init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

[test/init/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InterProceduralTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/InterProcedural.java
```

#### checker output

```
src/init/InterProcedural.java:18: error: [argument.type.incompatible] incompatible types in argument.
        this.object = returnObject(null);
                                   ^
  found   : null
  required: @Initialized @NonNull Object
src/init/InterProcedural.java:24: error: [dereference.of.nullable] dereference of possibly-null reference this.object
        this.object.toString();
            ^
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18 | TP |
| 24 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 2 | 0 |
| - | 0 | 1 |

&nbsp; ⟶ &nbsp; accurate

<br>

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

[test/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectMethodTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/ReflectMethod.java
```

#### checker output

```
src/init/ReflectMethod.java:15: error: [assignment.type.incompatible] incompatible types in assignment.
        this.object = method.invoke(null, new Object());
                                   ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/init/ReflectMethod.java:15: error: [argument.type.incompatible] incompatible types in argument.
        this.object = method.invoke(null, new Object());
                                    ^
  found   : null
  required: @Initialized @NonNull Object
src/init/ReflectMethod.java:22: error: [assignment.type.incompatible] incompatible types in assignment.
        this.object = method.invoke(null, (Object) null);
                                   ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/init/ReflectMethod.java:22: error: [argument.type.incompatible] incompatible types in argument.
        this.object = method.invoke(null, (Object) null);
                                    ^
  found   : null
  required: @Initialized @NonNull Object
src/init/ReflectMethod.java:22: error: [argument.type.incompatible] incompatible types in argument.
        this.object = method.invoke(null, (Object) null);
                                          ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
5 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 15(i), 15(ii) | FP |
| 22(i), 22(ii), 22(iii) | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

&nbsp; ⟶ &nbsp; imprecise

<br>

## ReflectConstructor

[init/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectConstructor.java)

[test/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectConstructorTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/ReflectConstructor.java
```

#### checker output

```
src/init/ReflectConstructor.java:30: error: [argument.type.incompatible] incompatible types in argument.
        constructor.newInstance((Object) null);
                                ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 30 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

&nbsp; ⟶ &nbsp; accurate

<br>

## ReflectField

[init/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectField.java)

[test/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectFieldTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/ReflectField.java
```

#### checker output

````
src/init/ReflectField.java:16: error: [dereference.of.nullable] dereference of possibly-null reference this.object
        this.object.toString();
            ^
src/init/ReflectField.java:23: error: [dereference.of.nullable] dereference of possibly-null reference this.object
        this.object.toString();
            ^
2 errors
````

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16 | FP |
| 23 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

&nbsp; ⟶ &nbsp; imprecise

<br>

## InvokeDynamicMethod

[init/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicMethod.java)

[test/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicMethodTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/InvokeDynamicMethod.java
```

#### checker output

```
No issues found.
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

&nbsp; ⟶ &nbsp; unsound

<br>

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

[test/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicConstructorTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/InvokeDynamicConstructor.java
```

#### checker output

```
No issues found.
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

&nbsp; ⟶ &nbsp; unsound

<br>

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicField.java)

[test/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicFieldTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/InvokeDynamicField.java
```

#### checker output

```
src/init/InvokeDynamicField.java:17: error: [argument.type.incompatible] incompatible types in argument.
        getSetterMethodHandle().invoke(this, new Object());
                                       ^
  found   : @UnderInitialization(init.InvokeDynamicField.class) @NonNull InvokeDynamicField
  required: @Initialized @NonNull InvokeDynamicField
src/init/InvokeDynamicField.java:24: error: [argument.type.incompatible] incompatible types in argument.
        getSetterMethodHandle().invoke(this, null);
                                       ^
  found   : @UnderInitialization(init.InvokeDynamicField.class) @NonNull InvokeDynamicField
  required: @Initialized @NonNull InvokeDynamicField
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 17 | FP |
| 24 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

&nbsp; ⟶ &nbsp; imprecise

<br>

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/DynamicProxy.java)

[test/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/DynamicProxyTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/init/DynamicProxy.java
```

#### checker output

```
src/init/DynamicProxy.java:18: error: [argument.type.incompatible] incompatible types in argument.
        this.o = proxyInstance.get(null);
                                   ^
  found   : null
  required: @Initialized @NonNull Object
src/init/DynamicProxy.java:28: error: [argument.type.incompatible] incompatible types in argument.
                Foo.class.getClassLoader(),
                                        ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18 | TP |
| 28 | FN |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

&nbsp; ⟶ &nbsp; imprecise
