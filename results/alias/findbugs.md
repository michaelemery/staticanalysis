# findbugs results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.checker framework.com/u/michaelemery/repository/checker framework/michaelemery/staticanalysis) Docker repository. Copy the checker framework command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[alias/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/IntraProcedural.java)

#### docker

```
javac alias/IntraProcedural.java
findbugs alias/IntraProcedural.class
```

#### output

```
H C NP: Null pointer dereference of IntraProcedural.o in alias.IntraProcedural.main(String[])  Dereferenced at IntraProcedural.java:[line 22]
Warnings generated: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

## InterProcedural

[alias/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/InterProcedural.java)

#### docker

```
javac alias/InterProcedural.java
findbugs alias/InterProcedural.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

## ReflectMethod

[alias/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/ReflectMethod.java)

#### docker

```
javac alias/ReflectMethod.java
findbugs alias/ReflectMethod.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

## ReflectMethodOverload

[alias/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/ReflectMethodOverload.java)

#### docker

```
javac alias/ReflectMethodOverload.java
findbugs alias/ReflectMethodOverload.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

## ReflectFieldAccess

[//]: [alias/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/ReflectFieldAccess.java)

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

[alias/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/InvokeDynamicVirtual.java)

#### docker

```
javac alias/InvokeDynamicVirtual.java
findbugs alias/InvokeDynamicVirtual.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

## InvokeDynamicConstructor

[alias/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/InvokeDynamicConstructor.java)

#### docker

```
javac alias/InvokeDynamicConstructor.java
findbugs alias/InvokeDynamicConstructor.class
```

#### output

```
H C NP: Null pointer dereference of InvokeDynamicConstructor.o in alias.InvokeDynamicConstructor.main(String[])  Dereferenced at InvokeDynamicConstructor.java:[line 32]
Warnings generated: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

## InvokeDynamicField

[//]: [alias/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/InvokeDynamicField.java)

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

[//]: [alias/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/alias/DynamicProxy.java)

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