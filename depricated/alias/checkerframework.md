# checker framework

Version: checker-framework-2.3.0

> Outputs have been simplified for brevity.

**checkers used (fqn)**

1. org.checkerframework.common.alias.AliasingChecker

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

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| Vanilla | Interprocedural | Reflect | InvokeDynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#vanilla) | [imprecise & unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#interprocedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#reflect) |  |  |

### vanilla

[alias/Vanilla_CF.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Vanilla_CF.java)

```
javac -processor org.checkerframework.common.alias.AliasingChecker alias/Vanilla_CF.java 
```

#### output
```
alias/Vanilla_CF.java:21: 
error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique Vanilla_CF foo = new Vanilla_CF("text");
                                         ^
  found   : @MaybeAliased Vanilla_CF
  required: @NonLeaked @Unique Vanilla_CF

alias/Vanilla_CF.java:25: 
error: [unique.leaked] Reference annotated as @Unique is leaked.
        bar = new Vanilla_CF(foo);
                                     ^

alias/Vanilla_CF.java:30: 
error: [unique.leaked] Reference annotated as @Unique is leaked.
        bar = foo;
              ^

3 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |


### interprocedural

[alias/Interprocedural_CF.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Interprocedural_CF.java)

```
javac -processor org.checkerframework.common.alias.AliasingChecker alias/Interprocedural_CF.java 
```

#### output
```
alias/Interprocedural_CF.java:17: 
error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique Interprocedural_CF foo = new Interprocedural_CF("text");
                                         ^
  found   : @MaybeAliased Interprocedural_CF
  required: @NonLeaked @Unique Interprocedural_CF

1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 1 |

### reflect

[alias/Reflect_CF.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Reflect_CF.java)

```
javac -processor org.checkerframework.common.alias.AliasingChecker alias/Reflect_CF.java 
```

#### output
```
alias/Reflect_CF.java:19: 
error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique Reflect_CF foo = new Reflect_CF("text");
                                    ^
  found   : @MaybeAliased Reflect_CF
  required: @NonLeaked @Unique Reflect_CF

alias/Reflect_CF.java:27: 
error: [unique.leaked] Reference annotated as @Unique is leaked.
            bar = (Reflect_CF) m.invoke(foo);
                                           ^

alias/Reflect_CF.java:33: 
error: [unique.leaked] Reference annotated as @Unique is leaked.
            bar = (Reflect_CF) m.invoke(foo);
                                           ^

3 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 1 | 1 |
