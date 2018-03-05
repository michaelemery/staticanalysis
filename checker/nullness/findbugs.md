# findbugs

Version: findbugs-3.0.1

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| Vanilla | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanilla) |
| Interprocedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interprocedural) |
| Reflect | - |
| ReflectInterprocedural | - |
| ReflectOverload | - |
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

### Reflect

[nullness/Reflect.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflect.java)

```
javac nullness/Reflect.java
findbugs nullness/Reflect.class
```

### ReflectInterprocedural

[nullness/ReflectInterprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectInterprocedural.java)

```
javac nullness/ReflectInterprocedural.java
findbugs nullness/ReflectInterprocedural.class
```

### ReflectOverload

[nullness/ReflectOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverload.java)

```
javac nullness/ReflectOverload.java
findbugs nullness/ReflectOverload.class
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
