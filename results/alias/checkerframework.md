# checker framework results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

Version: checker-framework-2.1.11

The Aliasing Checker identifies expressions that definitely have no aliases.

Two expressions are aliased when they have the same non-primitive value; that is, they are references to the identical Java object in the heap. Another way of saying this is that two expressions, exprA and exprB, are aliases of each other when exprA == exprB at the same program point.

Assigning to a variable or field typically creates an alias. For example, after the statement a = b;, the variables a and b are aliased.

Knowing that an expression is not aliased permits more accurate reasoning about how side effects modify the expression’s value.

To run the Aliasing Checker, supply the `-processor org.checkerframework.common.aliasing.AliasingChecker` command-line option to javac. However, a user rarely runs the Aliasing Checker directly. This type system is mainly intended to be used together with other type systems. For example, the SPARTA information flow type-checker (Section 24.8) uses the Aliasing Checker to improve its type refinement — if an expression has no aliases, a more refined type can often be inferred, otherwise the type-checker makes conservative assumptions.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.checker framework.com/u/michaelemery/repository/checker framework/michaelemery/staticanalysis) Docker repository. Copy the checker framework command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[alias/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/IntraProcedural.java)

#### docker

```
javac -processor org.checkerframework.common.aliasing.AliasingChecker alias/IntraProcedural.java
```

#### output

```
alias/IntraProcedural.java:13: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique IntraProcedural original = new IntraProcedural();
                                           ^
  found   : @MaybeAliased IntraProcedural
  required: @NonLeaked @Unique IntraProcedural
alias/IntraProcedural.java:20: error: [unique.leaked] Reference annotated as @Unique is leaked.
        IntraProcedural alias = original;
                                ^
2 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

## InterProcedural

[alias/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InterProcedural.java)

#### docker

```
javac -processor org.checkerframework.common.aliasing.AliasingChecker alias/InterProcedural.java
```

#### output

```
alias/InterProcedural.java:13: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique InterProcedural original = new InterProcedural();
                                           ^
  found   : @MaybeAliased InterProcedural
  required: @NonLeaked @Unique InterProcedural
alias/InterProcedural.java:20: error: [unique.leaked] Reference annotated as @Unique is leaked.
        InterProcedural alias = aliasOf(original);
                                        ^
2 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

## ReflectMethod

[alias/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectMethod.java)

#### docker

```
javac -processor org.checkerframework.common.aliasing.AliasingChecker alias/ReflectMethod.java
```

#### output

```
alias/ReflectMethod.java:15: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique ReflectMethod original = new ReflectMethod();
                                         ^
  found   : @MaybeAliased ReflectMethod
  required: @NonLeaked @Unique ReflectMethod
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 1 | aberrant |

## ReflectMethodOverload

[alias/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectMethodOverload.java)

#### docker

```
javac -processor org.checkerframework.common.aliasing.AliasingChecker alias/ReflectMethodOverload.java
```

#### output

```
alias/ReflectMethodOverload.java:15: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique ReflectMethodOverload original = new ReflectMethodOverload();
                                                 ^
  found   : @MaybeAliased ReflectMethodOverload
  required: @NonLeaked @Unique ReflectMethodOverload
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 1 | aberrant |

## ReflectFieldAccess

[//]: [alias/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectFieldAccess.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## InvokeDynamicVirtual

[alias/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicVirtual.java)

#### docker

```
javac -processor org.checkerframework.common.aliasing.AliasingChecker alias/InvokeDynamicVirtual.java
```

#### output

```
alias/InvokeDynamicVirtual.java:17: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique InvokeDynamicVirtual original = new InvokeDynamicVirtual();
                                                ^
  found   : @MaybeAliased InvokeDynamicVirtual
  required: @NonLeaked @Unique InvokeDynamicVirtual
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 1 | aberrant |

## InvokeDynamicConstructor

[alias/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicConstructor.java)

#### docker

```
javac -processor org.checkerframework.common.aliasing.AliasingChecker alias/InvokeDynamicConstructor.java
```

#### output

```
alias/InvokeDynamicConstructor.java:27: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique InvokeDynamicConstructor original = (InvokeDynamicConstructor) h.invoke("safe");
                                                    ^
  found   : @MaybeAliased InvokeDynamicConstructor
  required: @NonLeaked @Unique InvokeDynamicConstructor
alias/InvokeDynamicConstructor.java:30: error: [unique.leaked] Reference annotated as @Unique is leaked.
        InvokeDynamicConstructor alias = original;
                                         ^
2 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

## InvokeDynamicField

[//]: [alias/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicField.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## DynamicProxy

[//]: [alias/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/DynamicProxy.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |
