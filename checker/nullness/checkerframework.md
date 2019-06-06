# checker framework

Version: checker-framework-2.1.11

org.checkerframework.checker.nullness.NullnessChecker

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InterProcedural) |
| ReflectMethod | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectMethod) |
| ReflectMethodOverload | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectMethodOverload) |
| ReflectFieldAccess | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicField) |
| DynamicProxy | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#DynamicProxy) |

> Select results for detail.

### IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/IntraProcedural.java
```

#### output

```
checker/nullness/IntraProcedural.java:23: error: [assignment.type.incompatible] incompatible types in assignment.
        i.o = null;
              ^
  found   : null
  required: @Initialized @NonNull Object
1 error
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

### InterProcedural

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/InterProcedural.java
```

#### output

```
checker/nullness/InterProcedural.java:22: error: [argument.type.incompatible] incompatible types in argument.
        i.set(null);
              ^
  found   : null
  required: @Initialized @NonNull Object
1 error
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

### ReflectMethod

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethod.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/ReflectMethod.java
```

#### output

```
checker/nullness/ReflectMethod.java:25: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(i, (Object) null);  // cast to suppress compiler warning
                    ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
1 error
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

### ReflectMethodOverload

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodOverload.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/ReflectMethodOverload.java
```

#### output

```
checker/nullness/ReflectMethodOverload.java:27: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(i, (Object) null);  // cast to suppress compiler warning
                    ^
  found   : @FBCBottom @Nullable Object
  required: @Initialized @NonNull Object
1 error
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

### ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccess.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/ReflectFieldAccess.java
```

#### output

````
No reported issues.
````

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1| 0 | unsound |


### InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicVirtual.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/InvokeDynamicVirtual.java
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

### InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicConstructor.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/InvokeDynamicConstructor.java
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1| 0 | unsound |

### InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicField.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/InvokeDynamicField.java
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1| 0 | unsound |

### DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/DynamicProxy.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/DynamicProxy.java
```

#### output

```
checker/nullness/DynamicProxy.java:19: error: [argument.type.incompatible] incompatible types in argument.
                Foo.class.getClassLoader(),
                                        ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
checker/nullness/DynamicProxy.java:34: error: [argument.type.incompatible] incompatible types in argument.
        System.out.println(proxyInstance.get(null).toString());
                                             ^
  found   : null
  required: @Initialized @NonNull Object
2 errors
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |
