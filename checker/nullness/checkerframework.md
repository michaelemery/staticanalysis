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
| VanillaIntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanillaintraprocedural) |
| VanillaInterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanillainterprocedural) |
| ReflectMethodInvokeIntraProcedural | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectmethodinvokeintraprocedural) |
| ReflectMethodInvokeInterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectmethodinvokeinterprocedural) |
| ReflectOverloadInvokeInterProcedural | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectoverloadinvokeinterprocedural) |
| ReflectMethodHandleIntraProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectmethodhandleintraprocedural) |
| ReflectFieldAccessIntraProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectfieldaccessintraprocedural) |
| ReflectFieldAccessInterProcedural | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectfieldaccessinterprocedural) |
| InvokeDynamic | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#invokedynamic) |
| Proxy | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#proxy) |

> Select results for detail.

### VanillaIntraProcedural

[nullness/VanillaIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/VanillaIntraProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/VanillaIntraProcedural.java
```

#### output

```
nullness/VanillaIntraProcedural.java:17: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### VanillaInterProcedural

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/VanillaInterProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/VanillaInterProcedural.java
```

#### output

```
nullness/VanillaInterProcedural.java:16: 
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

### ReflectMethodInvokeIntraProcedural

[nullness/ReflectMethodInvokeIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvokeIntraProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectMethodInvokeIntraProcedural.java
```

#### output

```
nullness/ReflectMethodInvokeIntraProcedural.java:18: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // "text"
                           ^

nullness/ReflectMethodInvokeIntraProcedural.java:23: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

nullness/ReflectMethodInvokeIntraProcedural.java:31: 
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

### ReflectMethodInvokeInterProcedural

[nullness/ReflectMethodInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvokeInterProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectMethodInvokeInterProcedural.java
```

#### output

```
nullness/ReflectMethodInvokeInterProcedural.java:26: 
error: [return.type.incompatible] incompatible types in return.
        return s;
               ^
  found   : @Initialized @Nullable String
  required: @Initialized @NonNull String

nullness/ReflectMethodInvokeInterProcedural.java:34: 
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

### ReflectOverloadInvokeInterProcedural

[nullness/ReflectOverloadInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvokeInterProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectOverloadInvokeInterProcedural.java
```

#### output

````
nullness/ReflectOverloadInvokeInterProcedural.java:18: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // "text"
                           ^

nullness/ReflectOverloadInvokeInterProcedural.java:23: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

nullness/ReflectOverloadInvokeInterProcedural.java:31: error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

3 errors
````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

### ReflectFieldAccessIntraProcedural

[nullness/ReflectFieldAccessIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccessIntraProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectFieldAccessIntraProcedural.java
```

#### output

```
nullness/ReflectFieldAccessIntraProcedural.java:4: 
error: [initialization.fields.uninitialized] the constructor does not initialize fields: s
class Message {
^

1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### InvokeDynamic

[nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamic.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InvokeDynamic.java
```

#### output

```
TBC
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| TBC | TBC | TBC |

### Proxy

[nullness/Proxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Proxy.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/Proxy.java
```

#### output

```
TBC
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| TBC | TBC | TBC |

## redundant tests

Tests are considered redundant when prerequisite tests are unsound.

### ReflectFieldAccessInterProcedural

[nullness/ReflectFieldAccessInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccessInterProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectFieldAccessInterProcedural.java
```
