# checker framework

Version: checker-framework-2.3.0

> Outputs have been simplified for brevity.

**checkers used (fqn)**

1. org.checkerframework.common.aliasing.AliasingChecker

**annotations**

There are two possible types for an expression:

| annotation | description |
| --- | --- |
| **@MaybeAliased** *(default)*| Indicates the type of an expression that might have an alias. This is the default, so every unannotated type is @MaybeAliased. Includes the type of null. |
| **@Unique** | is the type of an expression that has no aliases. The @Unique annotation is only allowed at local variables, method parameters, constructor results, and method returns. It is not allowed on fields, array elements, and type parameters. A constructor’s result should be annotated with @Unique only if the constructor’s body does not create an alias to the constructed object. |

> **Important:** The default state of any object in Checker Framework is ***@MaybeAliased***.

There are also two annotations, which are currently trusted instead of verified, that can be used on formal parameters (including the receiver parameter, this):

| annotation | description |
| --- | --- |
| **@NonLeaked** | Identifies a formal parameter that is not leaked nor returned by the method body. For example, the formal parameter of the String copy constructor, String(String s), is @NonLeaked because the body of the method only makes a copy of the parameter. |
| **@LeakedToResult** | Indicates when the parameter may be returned, but it is not otherwise leaked. For example, the receiver parameter of StringBuffer.append(StringBuffer this, String s) is @LeakedToResult, because the method returns the updated receiver. |

## results

Word picture of results.

| Vanilla | InterProcedural | Reflection | InvokeDynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/checkerframework.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/checkerframework.md#inter-procedural) | [imprecise & unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/checkerframework.md#reflection) |  |  |

### vanilla

[aliasing/Vanilla_CF.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Vanilla_CF.java)

```
$ javac -processor org.checkerframework.common.aliasing.AliasingChecker aliasing/Vanilla_CF.java 

aliasing/Vanilla_CF.java:21: 
error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique Vanilla_CF foo = new Vanilla_CF("text");
                                         ^
  found   : @MaybeAliased Vanilla_CF
  required: @NonLeaked @Unique Vanilla_CF

aliasing/Vanilla_CF.java:25: 
error: [unique.leaked] Reference annotated as @Unique is leaked.
        bar = new Vanilla_CF(foo);
                                     ^

aliasing/Vanilla_CF.java:30: 
error: [unique.leaked] Reference annotated as @Unique is leaked.
        bar = foo;
              ^

3 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |


### inter-procedural

[aliasing/InterProcedural_CF.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/InterProcedural_CF.java)

```
$ javac -processor org.checkerframework.common.aliasing.AliasingChecker aliasing/InterProcedural_CF.java 

aliasing/InterProcedural_CF.java:17: 
error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique InterProcedural_CF foo = new InterProcedural_CF("text");
                                         ^
  found   : @MaybeAliased InterProcedural_CF
  required: @NonLeaked @Unique InterProcedural_CF

1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 1 | 1 |

### reflection

[aliasing/reflection_CF.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/Vanilla_CF_old.javaaliasing/reflection_CF.java)

```
$ javac -processor org.checkerframework.common.aliasing.AliasingChecker aliasing/Reflection_CF.java 

aliasing/Reflection_CF.java:19: 
error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique Reflection_CF foo = new Reflection_CF("text");
                                    ^
  found   : @MaybeAliased Reflection_CF
  required: @NonLeaked @Unique Reflection_CF

aliasing/Reflection_CF.java:27: 
error: [unique.leaked] Reference annotated as @Unique is leaked.
            bar = (Reflection_CF) m.invoke(foo);
                                           ^

aliasing/Reflection_CF.java:33: 
error: [unique.leaked] Reference annotated as @Unique is leaked.
            bar = (Reflection_CF) m.invoke(foo);
                                           ^

3 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 1 |
