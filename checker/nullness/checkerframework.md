# checker framework

Version: checker-framework-2.1.11

## usage

### checkers used (fqn)

1. org.checkerframework.checker.nullness.NullnessChecker

### qualifiers

The nullness hierarchy contains these qualifiers:

| qualifier | description |
| --- | --- |
| @Nullable | Indicates a type that includes the null value. For example, the type Boolean is nullable: a variable of type Boolean always has one of the values TRUE, FALSE, or null. |
| @NonNull *(default)*| Indicates a type that does not include the null value. The type boolean is non-null; a variable of type boolean always has one of the values true or false. The type @NonNull Boolean is also non-null: a variable of type @NonNull Boolean always has one of the values TRUE or FALSE — never null. Dereferencing an expression of non-null type can never cause a null pointer exception. |

> The default state of any object in Checker Framework is *@NonNull*.

### annotations

The Nullness Checker supports several annotations that specify method behavior. These are 
declaration annotations, not type annotations as they apply to the method itself rather than to 
some particular type:

| annotation | description |
| --- | --- |
| @RequiresNonNull | Indicates a method precondition: The annotated method expects the specified variables (typically field references) to be non-null when the method is invoked. |
| @EnsuresNonNull | |
| @EnsuresNonNullIf | Indicates a method postcondition. With @EnsuresNonNull, the given expressions are non-null after the method returns; this is useful for a method that initializes a field, for example. With @EnsuresNonNullIf, if the annotated method returns the given boolean value (true or false), then the given expressions are non-null. |

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InterProcedural) |
| ReflectMethodInvoke | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectMethodInvoke) |
| ReflectOverloadInvoke | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectOverloadInvoke) |
| ReflectFieldAccess | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicVirtual) |
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
nullness/IntraProcedural.java:22: error: [assignment.type.incompatible] incompatible types in assignment.
        i.o = null;
              ^
  found   : null
  required: @Initialized @NonNull Object
1 error
```

| True Pos | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | accurate |

### InterProcedural

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/InterProcedural.java
```

#### output

```
nullness/InterProcedural.java:27: error: [assignment.type.incompatible] incompatible types in assignment.
        this.o = safe ? "safe" : null;
                      ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
1 error
```

| True Pos | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | accurate |

### ReflectMethodInvoke

[nullness/ReflectMethodInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvoke.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/ReflectMethodInvoke.java
```

#### output

```
checker/nullness/ReflectMethodInvoke.java:22: error: [dereference.of.nullable] dereference of possibly-null reference m.invoke(i, true)
        i.o = m.invoke(i, true).toString();
                      ^
checker/nullness/ReflectMethodInvoke.java:26: error: [dereference.of.nullable] dereference of possibly-null reference m.invoke(i, false)
        i.o = m.invoke(i, false).toString();
                      ^
checker/nullness/ReflectMethodInvoke.java:31: error: [assignment.type.incompatible] incompatible types in assignment.
        this.o = safe ? "safe" : null;
                      ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
3 errors
```

| True Pos | False Pos | Result |
| :---: | :---: | :---: |
| 2 | 1 | imprecise |

### ReflectOverloadInvoke

[nullness/ReflectOverloadInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvoke.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/ReflectOverloadInvoke.java
```

#### output

```
checker/nullness/ReflectOverloadInvoke.java:36: error: [assignment.type.incompatible] incompatible types in assignment.
        this.o = null;
                 ^
  found   : null
  required: @Initialized @NonNull Object
1 error
```

| True Pos | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | accurate |

### ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccess.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/ReflectFieldAccess.java
```

#### output

````
No reported issues.
````

| True Pos | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |


### InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicVirtual.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/InvokeDynamicVirtual.java
```

#### output

```
checker/nullness/InvokeDynamicVirtual.java:34: error: [assignment.type.incompatible] incompatible types in assignment.
        this.o = safe ? "safe" : null;
                      ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
1 error
```

| True Pos | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | accurate |

### InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicConstructor.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/InvokeDynamicConstructor.java
```

#### output

```
No reported issues.
```

| True Pos | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

### InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicField.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/nullness/InvokeDynamicField.java
```

#### output

```
No reported issues.
```

| True Pos | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

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
checker/nullness/DynamicProxy.java:23: error: [return.type.incompatible] incompatible types in return.
                        return (Boolean) methodArgs[0] ? "safe" : null;
                                                       ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
2 errors
```

| True Pos | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 1 | imprecise |
