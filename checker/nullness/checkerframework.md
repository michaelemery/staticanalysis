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
| IntraproceduralMethodInvocation | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#IntraproceduralMethodInvocation) |
| IntraproceduralReflectiveFieldAccess | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#IntraproceduralReflectiveFieldAccess) |
| InterproceduralMethodInvocation | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InterproceduralMethodInvocation) |
| InterproceduralReflectiveFieldAccess | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InterproceduralReflectiveFieldAccess) |
| InterproceduralOverloadInvocation | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InterproceduralOverloadInvocation) |
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
nullness/Vanilla.java:17: 
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
nullness/Interprocedural.java:16: 
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

### IntraproceduralMethodInvocation

[nullness/IntraproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralMethodInvocation.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/IntraproceduralMethodInvocation.java
```

#### output

```
nullness/IntraproceduralMethodInvocation.java:18: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // "text"
                           ^

nullness/IntraproceduralMethodInvocation.java:23: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

nullness/IntraproceduralMethodInvocation.java:31: 
error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

3 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

### IntraproceduralReflectiveFieldAccess

[nullness/IntraproceduralReflectiveFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralReflectiveFieldAccess.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/IntraproceduralReflectiveFieldAccess.java
```

#### output

```
nullness/IntraproceduralReflectiveFieldAccess.java:8: 
error: [initialization.fields.uninitialized] the constructor does not initialize fields: bar
public class IntraproceduralReflectiveFieldAccess {
       ^

1 error

```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 0 |

### InterproceduralMethodInvocation

[nullness/InterproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralMethodInvocation.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InterproceduralMethodInvocation.java
```

#### output

```
nullness/InterproceduralMethodInvocation.java:26: 
error: [return.type.incompatible] incompatible types in return.
        return s;
               ^
  found   : @Initialized @Nullable String
  required: @Initialized @NonNull String

nullness/InterproceduralMethodInvocation.java:34: 
error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

2 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### InterproceduralReflectiveFieldAccess

[nullness/InterproceduralReflectiveFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralReflectiveFieldAccess.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InterproceduralReflectiveFieldAccess.java
```

#### output

```

```

### InterproceduralOverloadInvocation

[nullness/InterproceduralOverloadInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralOverloadInvocation.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InterproceduralOverloadInvocation.java
```

#### output

````
nullness/InterproceduralOverloadInvocation.java:18: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // "text"
                           ^

nullness/InterproceduralOverloadInvocation.java:23: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

nullness/InterproceduralOverloadInvocation.java:31: error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

3 errors
````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

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