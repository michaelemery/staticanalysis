# checker framework

Version: checker-framework-2.3.0

> Outputs have been simplified for brevity.

**checkers used (fqn)**

1. org.checkerframework.checker.nullness.NullnessChecker

**qualifiers**

The nullness hierarchy contains these qualifiers:

| qualifier | description |
| --- | --- |
| **@Nullable** | Indicates a type that includes the null value. For example, the type Boolean is nullable: a variable of type Boolean always has one of the values TRUE, FALSE, or null. |
| **@NonNull** *(default)*| Indicates a type that does not include the null value. The type boolean is non-null; a variable of type boolean always has one of the values true or false. The type @NonNull Boolean is also non-null: a variable of type @NonNull Boolean always has one of the values TRUE or FALSE — never null. Dereferencing an expression of non-null type can never cause a null pointer exception. |

> **Important:** The default state of any object in Checker Framework is ***@NonNull***.

**annotations**

The Nullness Checker supports several annotations that specify method behavior. These are 
declaration annotations, not type annotations as they apply to the method itself rather than to 
some particular type:

| annotation | description |
| --- | --- |
| **@RequiresNonNull** | Indicates a method precondition: The annotated method expects the specified variables (typically field references) to be non-null when the method is invoked. |
| **@EnsuresNonNull** | |
| **@EnsuresNonNullIf** | Indicates a method postcondition. With @EnsuresNonNull, the given expressions are non-null after the method returns; this is useful for a method that initializes a field, for example. With @EnsuresNonNullIf, if the annotated method returns the given boolean value (true or false), then the given expressions are non-null. |

## results

### summary

| Vanilla | InterProcedural | Reflection | InvokeDynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanilla) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#inter-procedural) | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflection) |  |  |

### dynamic features

#### vanilla
[nullness/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java)

```
$ javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/Vanilla.java

nullness/Vanilla.java:22: 
error: [dereference.of.nullable] dereference of possibly-null reference foo
        System.out.println(foo.s.toString());  // NullPointerException
                           ^

1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |
<td colspan=3> accurate

#### inter-procedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
$ javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InterProcedural.java

nullness/InterProcedural.java:21: 
error: [argument.type.incompatible] incompatible types in argument.
        InterProcedural bar = new InterProcedural(returnReceivedString(null));
                                                 ^
  found   : null
  required: @Initialized @NonNull String

1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

#### alias
[nullness/Alias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Alias.java)

```
$ javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/IAlias.java

nullness/Alias.java:24: 
error: [dereference.of.nullable] dereference of possibly-null reference bar
        System.out.println(bar.s.toString());  // NullPointerException
                           ^

1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

#### reflection
[nullness/Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java)

```
$ javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/Reflection.java

nullness/Reflection.java:25: error: [argument.type.incompatible] incompatible types in argument.
            Reflection foo = new Reflection((String) m.invoke(null));
                                            ^
  found   : @Initialized @Nullable String
  required: @Initialized @NonNull String

nullness/Reflection.java:25: 
error: [argument.type.incompatible] incompatible types in argument.
            Reflection foo = new Reflection((String) m.invoke(null));
                                                              ^
  found   : null
  required: @Initialized @NonNull Object

nullness/Reflection.java:30: 
error: [argument.type.incompatible] incompatible types in argument.
            Reflection bar = new Reflection((String) m.invoke(null));
                                            ^
  found   : @Initialized @Nullable String
  required: @Initialized @NonNull String

nullness/Reflection.java:30: 
error: [argument.type.incompatible] incompatible types in argument.
            Reflection bar = new Reflection((String) m.invoke(null));
                                                              ^
  found   : null
  required: @Initialized @NonNull Object

nullness/Reflection.java:46: 
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
