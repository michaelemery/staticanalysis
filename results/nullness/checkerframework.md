# checker framework results (nullness)

Version: checker-framework-2.1.11

To run the Nullness Checker, supply the `-processor org.checkerframework.checker.nullness.NullnessChecker` command-line option to javac.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

### summary

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/nullness/checkerframework.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/nullness/checkerframework.md#InterProcedural) |
| ReflectMethod | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/nullness/checkerframework.md#ReflectMethod) |
| ReflectMethodOverload | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/nullness/checkerframework.md#ReflectMethodOverload) |
| ReflectFieldAccess | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/nullness/checkerframework.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/nullness/checkerframework.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/nullness/checkerframework.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/nullness/checkerframework.md#InvokeDynamicField) |
| DynamicProxy | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/nullness/checkerframework.md#DynamicProxy) |

> Select results for detail.

## IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/IntraProcedural.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/IntraProcedural.java
```

#### output

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

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/InterProcedural.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InterProcedural.java
```

#### output

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

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/ReflectMethod.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectMethod.java
```

#### output

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

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/ReflectMethodOverload.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectMethodOverload.java
```

#### output

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

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/ReflectFieldAccess.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectFieldAccess.java
```

#### output

````
No reported issues.
````

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1| 0 | unsound |


## InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/InvokeDynamicVirtual.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InvokeDynamicVirtual.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/InvokeDynamicConstructor.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InvokeDynamicConstructor.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1| 0 | unsound |

## InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/InvokeDynamicField.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InvokeDynamicField.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1| 0 | unsound |

## DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/DynamicProxy.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/DynamicProxy.java
```

#### output

```
nullness/DynamicProxy.java:19: error: [argument.type.incompatible] incompatible types in argument.
                Foo.class.getClassLoader(),
                                        ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
nullness/DynamicProxy.java:34: error: [argument.type.incompatible] incompatible types in argument.
        System.out.println(proxyInstance.get(null).toString());
                                             ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |