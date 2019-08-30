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

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/IntraProcedural.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/IntraProcedural.java
```

#### checker output

```
nullness/IntraProcedural.java:23: error: [assignment.type.incompatible] incompatible types in assignment.
        i.o = null;
              ^
  found   : null
  required: @Initialized @NonNull Object
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## InterProcedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InterProcedural.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/InterProcedural.java
```

#### checker output

```
nullness/InterProcedural.java:22: error: [argument.type.incompatible] incompatible types in argument.
        i.set(null);
              ^
  found   : null
  required: @Initialized @NonNull Object
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## ReflectMethod

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethod.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/ReflectMethod.java
```

#### checker output

```
nullness/ReflectMethod.java:25: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(i, (Object) null);  // cast to suppress compiler warning
                    ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## ReflectMethodOverload

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethodOverload.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/ReflectMethodOverload.java
```

#### checker output

```
nullness/ReflectMethodOverload.java:27: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(i, (Object) null);  // cast to suppress compiler warning
                    ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectFieldAccess.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/ReflectFieldAccess.java
```

#### checker output

````
No reported issues.
````

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1| 0 | unsound |


## InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicVirtual.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/InvokeDynamicVirtual.java
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicConstructor.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/InvokeDynamicConstructor.java
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1| 0 | unsound |

## InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicField.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/InvokeDynamicField.java
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1| 0 | unsound |

## DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

#### checker command

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker -d out/ src/DynamicProxy.java
```

#### checker output

```
nullness/DynamicProxy.java:18: error: [argument.type.incompatible] incompatible types in argument.
                Foo.class.getClassLoader(),
                                        ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
nullness/DynamicProxy.java:33: error: [argument.type.incompatible] incompatible types in argument.
        System.out.println(proxyInstance.get(null).toString());
                                             ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |
