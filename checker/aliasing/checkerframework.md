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

### intra-procedural

[alias/IntraProcedural_CF.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/IntraProcedural_CF.java)

```

```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 0 |


### inter-procedural

[alias/InterProcedural_CF.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/InterProcedural_CF.java)


```

```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 0 |

### reflection

[alias/reflection_CF.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/reflection_CF.java)

```

```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 0 |
