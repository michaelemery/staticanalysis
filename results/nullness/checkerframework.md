# checker framework results (nullness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: checker-framework-2.1.11

To run the Nullness Checker, supply the `-processor org.checkerframework.checker.nullness.NullnessChecker` command-line option to javac.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

#### run checker from docker

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the checker command(s) provided with each test result, and paste them into your interactive Docker session. 

To download/update and run your project Docker container;

```
docker pull michaelemery/staticanalysis
docker run -it --rm michaelemery/staticanalysis
```

#### run junit tests from docker

```
sh test.sh [ [ nullness ] | [ nullness <class-name> ] ]
```

* `sh test.sh` will run all tests for all packages

<br>

## IntraProcedural

* [nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/IntraProcedural.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/IntraProcedural.java
```

#### checker output

```
src/nullness/IntraProcedural.java:8: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class IntraProcedural {
       ^
src/nullness/IntraProcedural.java:26: error: [assignment.type.incompatible] incompatible types in assignment.
        i.foo = null;
                ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | FP |
| 26 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise

<br>

## InterProcedural

* [nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InterProcedural.java)

* [nullness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InterProcedural.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/InterProcedural.java
```

#### checker output

```
src/nullness/InterProcedural.java:6: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class InterProcedural {
       ^
src/nullness/InterProcedural.java:28: error: [argument.type.incompatible] incompatible types in argument.
        i.foo = getObject(null);
                          ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 6 | FP |
| 27 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise

<br>

## ReflectConstructor

* [nullness/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectConstructor.java)

* [nullness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectConstructor.java)

#### checker command

```
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

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectMethod.java)

#### checker command

```
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
| 8 | FP |
| 23 | FP |
| 34(i) | TP |
| 34(ii) | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 3 |
| - | 0 | 0 |

> imprecise

<br>

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectField.java)

#### checker command

```
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
| 6 | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 0 |

> unsound

<br>

## InvokeDynamicConstructor

* [nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicConstructor.java)

* [nullness/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicConstructor.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/InvokeDynamicConstructor.java
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
| - | 1 | 0 |

> unsound

<br>

## InvokeDynamicMethod

* [nullness/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicMethod.java)

* [nullness/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicMethod.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/InvokeDynamicMethod.java
```

#### checker output

```
src/nullness/InvokeDynamicMethod.java:10: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class InvokeDynamicMethod {
       ^
src/nullness/InvokeDynamicMethod.java:38: error: [argument.type.incompatible] incompatible types in argument.
        getSetFooMethodHandle().invoke(i, (Object) null);
                                          ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | FP |
| 38 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise

<br>

## InvokeDynamicField

* [nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicField.java)

* [nullness/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicField.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/InvokeDynamicField.java
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
| - | 1 | 0 |

> imprecise

<br>

## DynamicProxy

* [nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/DynamicProxy.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/nullness/DynamicProxy.java
```

#### checker output

```
src/nullness/DynamicProxy.java:8: error: [initialization.fields.uninitialized] the constructor does not initialize fields: foo
public class DynamicProxy {
       ^
src/nullness/DynamicProxy.java:18: error: [argument.type.incompatible] incompatible types in argument.
                MyClass.class.getClassLoader(),
                                            ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
src/nullness/DynamicProxy.java:44: error: [argument.type.incompatible] incompatible types in argument.
        i.foo = getProxyInstance().getObject(null);
                                             ^
  found   : null
  required: @Initialized @NonNull Object
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | FP |
| 18 | FP |
| 44 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 2 |
| - | 0 | 0 |

> imprecise
