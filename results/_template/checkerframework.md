# checker framework results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

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

[alias/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/IntraProcedural.java)

#### checker framework

```
xxxCOMMANDxxx
```

#### output

```
xxxOUTPUTxxx
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| ? | ? | xxx |

## InterProcedural

[alias/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/InterProcedural.java)

#### checker framework

```
xxxCOMMANDxxx
```

#### output

```
xxxOUTPUTxxx
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| ? | ? | xxx |

## ReflectMethod

[alias/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/ReflectMethod.java)

#### checker framework

```
xxxCOMMANDxxx
```

#### output

```
xxxOUTPUTxxx
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| ? | ? | xxx |

## ReflectMethodOverload

[alias/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/ReflectMethodOverload.java)

#### checker framework

```
xxxCOMMANDxxx
```

#### output

```
xxxOUTPUTxxx
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| ? | ? | xxx |

## ReflectFieldAccess

[alias/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/ReflectFieldAccess.java)

#### checker framework

```
xxxCOMMANDxxx
```

#### output

```
xxxOUTPUTxxx
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| ? | ? | xxx |

## InvokeDynamicVirtual

[alias/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/InvokeDynamicVirtual.java)

#### checker framework

```
xxxCOMMANDxxx
```

#### output

```
xxxOUTPUTxxx
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| ? | ? | xxx |

## InvokeDynamicConstructor

[alias/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/InvokeDynamicConstructor.java)

#### checker framework

```
xxxCOMMANDxxx
```

#### output

```
xxxOUTPUTxxx
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| ? | ? | xxx |

## InvokeDynamicField

[alias/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/InvokeDynamicField.java)

#### checker framework

```
xxxCOMMANDxxx
```

#### output

```
xxxOUTPUTxxx
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| ? | ? | xxx |

## DynamicProxy

[alias/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/DynamicProxy.java)

#### checker framework

```
xxxCOMMANDxxx
```

#### output

```
xxxOUTPUTxxx
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| ? | ? | xxx |
