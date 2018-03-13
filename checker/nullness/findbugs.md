# findbugs

Version: findbugs-3.0.1

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| VanillaIntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanillaintraprocedural) |
| VanillaInterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanillainterprocedural) |
| ReflectMethodInvokeIntraProcedural | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodinvokeintraprocedural) |
| ReflectMethodInvokeInterProcedural | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodinvokeinterprocedural) |
| ReflectOverloadInvokeInterProcedural | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectoverloadinvokeinterprocedural) |
| ReflectMethodHandleIntraProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodhandleintraprocedural) |
| ReflectFieldAccessIntraProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectfieldaccessintraprocedural) |
| ReflectFieldAccessInterProcedural | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectfieldaccessinterprocedural) |
| InvokeDynamic | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#invokedynamic) |
| Proxy | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#proxy) |
> Select results for detail.

### VanillaIntraProcedural

[nullness/VanillaIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/VanillaIntraProcedural.java)

```
javac nullness/VanillaIntraProcedural.java
findbugs nullness/VanillaIntraProcedural.class
```

#### output

```
H C NP: Null pointer dereference of ? in nullness.VanillaIntraProcedural.main(String[])  
Dereferenced at VanillaIntraProcedural.java:[line 17]

Warnings generated: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### VanillaInterProcedural

[nullness/VanillaInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/VanillaInterProcedural.java)

```
javac nullness/VanillaInterProcedural.java
findbugs nullness/VanillaInterProcedural.class
```

#### output

```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### ReflectMethodHandleIntraProcedural

[nullness/ReflectMethodHandleIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodHandleIntraProcedural.java)

```
javac nullness/ReflectMethodHandleIntraProcedural.java
findbugs nullness/ReflectMethodHandleIntraProcedural.class nullness/Message.class
```

#### output

```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### ReflectFieldAccessIntraProcedural

[nullness/ReflectFieldAccessIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccessIntraProcedural.java)

```
javac nullness/ReflectFieldAccessIntraProcedural.java
findbugs nullness/ReflectFieldAccessIntraProcedural.class
```

#### output

```
M D UwF: Unwritten public or protected field: nullness.ReflectFieldAccessIntraProcedural.bar
At ReflectFieldAccessIntraProcedural.java:[line 18]

M D NP: Read of unwritten public or protected field bar in
nullness.ReflectFieldAccessIntraProcedural.main(String[])  
At ReflectFieldAccessIntraProcedural.java:[line 18]

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

### ReflectMethodInvokeIntraProcedural

[nullness/ReflectMethodInvokeIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvokeIntraProcedural.java)

```
javac nullness/ReflectMethodInvokeIntraProcedural.java
findbugs nullness/ReflectMethodInvokeIntraProcedural.class
```

### ReflectMethodInvokeInterProcedural

[nullness/ReflectMethodInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvokeInterProcedural.java)

```
javac nullness/ReflectMethodInvokeInterProcedural.java
findbugs nullness/ReflectMethodInvokeInterProcedural.class
```

### ReflectOverloadInvokeInterProcedural

[nullness/ReflectOverloadInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvokeInterProcedural.java)

```
javac nullness/ReflectOverloadInvokeInterProcedural.java
findbugs nullness/ReflectOverloadInvokeInterProcedural.class
```

### ReflectFieldAccessInterProcedural

[nullness/ReflectFieldAccessInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccessInterProcedural.java)

```
javac nullness/ReflectFieldAccessInterProcedural.java
findbugs nullness/ReflectFieldAccessInterProcedural.class
```
