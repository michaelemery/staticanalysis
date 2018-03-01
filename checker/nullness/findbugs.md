
# findbugs

Version: findbugs-3.0.1

## results

FindBugs tested as "accurate" using intra-procedural (vanilla) anlysis, but failed to identify nullness using any form of inter-procedural anaylsis. 

| Vanilla | InterProcedural | Reflection | InvokeDynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#inter-procedural) | - | - | - |

### vanilla
[nullness/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java)

```
$ findbugs nullness/Vanilla.class 

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
$ findbugs nullness/Alias.class 

H C NP: Null pointer dereference of ? in nullness.NullAlias.main(String[])  
Dereferenced at NullAlias.java:[line 24]
Warnings generated: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### inter-procedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
$ findbugs nullness/InterProcedural.class 

[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### reflection

[nullness/Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java)

```
$ findbugs nullness/Reflection.class 

[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |
