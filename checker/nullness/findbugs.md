
# findbugs

Version: findbugs-3.0.1

## results

FindBugs correctly identified nulness issues at the intra-procedural (vanilla) level only. Results were unsound when using interprocedural analysis or reflection.

| Vanilla | Interprocedural | Reflection | InvokeDynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interprocedural) | - | - | - |

### vanilla
[nullness/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java)

```
javac nullness/Vanilla.java
findbugs nullness/Vanilla.class
```

#### output
```
H C NP: Null pointer dereference of ? in nullness.Vanilla.main(String[])  
Dereferenced at nullness.Vanilla.java:[line 22]
Warnings generated: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### alias

[nullness/Alias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Alias.java)

```
javac nullness/Alias.java
findbugs nullness/Alias.class 
```

#### output
```
H C NP: Null pointer dereference of ? in nullness.NullAlias.main(String[])  
Dereferenced at NullAlias.java:[line 24]
Warnings generated: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### interprocedural

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

### reflection

[nullness/Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java)

```
javac nullness/Reflection.java
findbugs nullness/Reflection.class
```

#### output
```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |
