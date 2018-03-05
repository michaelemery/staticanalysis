# checker framework

Version: checker-framework-2.3.0

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
| Vanilla | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanilla) |
| Interprocedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#interprocedural) |
| Reflect | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflect) |
| ReflectInterprocedural | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectinterprocedural) |
| ReflectOverload | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectoverload) |
| InvokeDynamic |  |
| Proxy |  |

> Select results for detail.

### Vanilla

[nullness/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/Vanilla.java
```

#### output

```
nullness/Vanilla.java:18: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### Interprocedural

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Interprocedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/Interprocedural.java
```

#### output

```
nullness/Interprocedural.java:17: 
error: [argument.type.incompatible] incompatible types in argument.
        s = returnReceivedString(null);
                                 ^
  found   : null
  required: @Initialized @NonNull String
  
1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### Reflect

[nullness/Reflect.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflect.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/Reflect.java
```

#### output

```
nullness/Reflect.java:17: 
error: [argument.type.incompatible] incompatible types in argument.
        s = (String) m.invoke(null);
                              ^
  found   : null
  required: @Initialized @NonNull Object

nullness/Reflect.java:18: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // "text"
                           ^

nullness/Reflect.java:22: 
error: [argument.type.incompatible] incompatible types in argument.
        s = (String) m.invoke(null);
                              ^
  found   : null
  required: @Initialized @NonNull Object

nullness/Reflect.java:23: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

nullness/Reflect.java:32: 
error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

5 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 3 | 0 |

### ReflectInterprocedural

[nullness/ReflectInterprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectInterprocedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectInterprocedural.java
```

#### output

```
nullness/ReflectInterprocedural.java:26: 
error: [argument.type.incompatible] incompatible types in argument.
        String s = (String) m.invoke(null);
                                     ^
  found   : null
  required: @Initialized @NonNull Object

nullness/ReflectInterprocedural.java:27: 
error: [return.type.incompatible] incompatible types in return.
        return s;
               ^
  found   : @Initialized @Nullable String
  required: @Initialized @NonNull String

nullness/ReflectInterprocedural.java:35: 
error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

3 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 2 | 0 |

### ReflectOverload

[nullness/ReflectOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverload.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectOverload.java
```

#### output

````
nullness/ReflectOverload.java:17: 
error: [argument.type.incompatible] incompatible types in argument.
        s = (String) m.invoke(null, 42);
                              ^
  found   : null
  required: @Initialized @NonNull Object

nullness/ReflectOverload.java:18: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // "text"
                           ^

nullness/ReflectOverload.java:22: 
error: [argument.type.incompatible] incompatible types in argument.
        s = (String) m.invoke(null, true);
                              ^
  found   : null
  required: @Initialized @NonNull Object

nullness/ReflectOverload.java:23: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

nullness/ReflectOverload.java:32: 
error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

5 errors
````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 3 | 0 |


## redundant tests

Tests are considered redundant when the results of previous tests at lower dynamic levels were unsound.

### InvokeDynamic

[nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamic.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InvokeDynamic.java
```

### Proxy

[nullness/Proxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Proxy.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/Proxy.java
```