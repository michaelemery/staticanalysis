# findbugs

Version: findbugs-3.0.1

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| Vanilla | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanilla) |
| Interprocedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interprocedural) |
| Reflect | - |
| InterproceduralMethodInvocation | - |
| InterproceduralOverloadInvocation | - |
| InvokeDynamic | - |
| Proxy | - |

> Select results for detail.

### Vanilla

[nullness/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java)

```
javac nullness/Vanilla.java
findbugs nullness/Vanilla.class
```

#### output

```
H C NP: Null pointer dereference of ? in nullness.Vanilla.main(String[])  
Dereferenced at Vanilla.java:[line 18]

Warnings generated: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### Interprocedural

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Interprocedural.java)

```
javac nullness/Interprocedural.java
findbugs nullness/Interprocedural.class
```

#### output

```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

## redundant tests

Tests are considered redundant when the results of previous tests at lower dynamic levels were unsound.

### IntraproceduralMethodInvocation

[nullness/IntraproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralMethodInvocation.java)

```
javac nullness/IntraproceduralMethodInvocation.java
findbugs nullness/IntraproceduralMethodInvocation.class
```

### IntraproceduralFieldAccess

[nullness/IntraproceduralFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralFieldAccess.java)

```
javac nullness/IntraproceduralFieldAccess.java
findbugs nullness/IntraproceduralFieldAccess.class
```

#### output

```

```


### InterproceduralMethodInvocation

[nullness/InterproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralMethodInvocation.java)

```
javac nullness/InterproceduralMethodInvocation.java
findbugs nullness/InterproceduralMethodInvocation.class
```

### InterproceduralFieldAccess

[nullness/InterproceduralFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralFieldAccess.java)

```
javac nullness/InterproceduralFieldAccess.java
findbugs nullness/InterproceduralFieldAccess.class
```

#### output

```

```

### InterproceduralOverloadInvocation

[nullness/InterproceduralOverloadInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralOverloadInvocation.java)

```
javac nullness/InterproceduralOverloadInvocation.java
findbugs nullness/InterproceduralOverloadInvocation.class
```

### InvokeDynamic

[nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamic.java)

```
javac nullness/InvokeDynamic.java
findbugs nullness/InvokeDynamic.class
```

### Proxy

[nullness/Proxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Proxy.java)

```
javac nullness/Proxy.java
findbugs nullness/Proxy.class
```
