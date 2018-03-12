# findbugs

Version: findbugs-3.0.1

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| Vanilla | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanilla) |
| Interprocedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interprocedural) |
| IntraproceduralMethodInvocation | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#intraproceduralmethodinvocation) |
| InterproceduralMethodInvocation | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interproceduralmethodinvocation) |
| InterproceduralOverloadInvocation | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interproceduraloverloadinvocation) |
| IntraproceduralMethodHandle | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#intraproceduralmethodhandle) |
| IntraproceduralReflectiveFieldAccess | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#intraproceduralreflectivefieldaccess) |
| InterproceduralReflectiveFieldAccess | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interproceduralreflectivefieldaccess) |
| InvokeDynamic | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#invokedynamic) |
| Proxy | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#proxy) |
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
Dereferenced at Vanilla.java:[line 17]

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


### IntraproceduralMethodHandle

[nullness/IntraproceduralMethodHandle.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralMethodHandle.java)

```
javac nullness/IntraproceduralMethodHandle.java
findbugs nullness/IntraproceduralMethodHandle.class nullness/Message.class
```

#### output

```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### IntraproceduralReflectiveFieldAccess

[nullness/IntraproceduralReflectiveFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralReflectiveFieldAccess.java)

```
javac nullness/IntraproceduralReflectiveFieldAccess.java
findbugs nullness/IntraproceduralReflectiveFieldAccess.class
```

#### output

```
M D UwF: Unwritten public or protected field: nullness.IntraproceduralReflectiveFieldAccess.bar
At IntraproceduralReflectiveFieldAccess.java:[line 18]

M D NP: Read of unwritten public or protected field bar in
nullness.IntraproceduralReflectiveFieldAccess.main(String[])  
At IntraproceduralReflectiveFieldAccess.java:[line 18]

Warnings generated: 2
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### InvokeDynamic

[nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamic.java)

```
javac nullness/InvokeDynamic.java
findbugs nullness/InvokeDynamic.class
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
javac nullness/Proxy.java
findbugs nullness/Proxy.class
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

### IntraproceduralMethodInvocation

[nullness/IntraproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralMethodInvocation.java)

```
javac nullness/IntraproceduralMethodInvocation.java
findbugs nullness/IntraproceduralMethodInvocation.class
```

### InterproceduralMethodInvocation

[nullness/InterproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralMethodInvocation.java)

```
javac nullness/InterproceduralMethodInvocation.java
findbugs nullness/InterproceduralMethodInvocation.class
```

### InterproceduralOverloadInvocation

[nullness/InterproceduralOverloadInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralOverloadInvocation.java)

```
javac nullness/InterproceduralOverloadInvocation.java
findbugs nullness/InterproceduralOverloadInvocation.class
```

### InterproceduralReflectiveFieldAccess

[nullness/InterproceduralReflectiveFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralReflectiveFieldAccess.java)

```
javac nullness/InterproceduralReflectiveFieldAccess.java
findbugs nullness/InterproceduralReflectiveFieldAccess.class
```
