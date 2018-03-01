
# findbugs

Version: findbugs-3.0.1

## results

### summary

| Vanilla | Inter<br />Procedural | Reflection | Invoke<br />Dynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| accurate | unsound | - | - | - |

### dynamic features

#### vanilla
[nullness/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java)

**results:**

```
$ findbugs nullness/Vanilla.class 

H C NP: Null pointer dereference of ? in nullness.Vanilla.main(String[])  
Dereferenced at nullness.Vanilla.java:[line 22]
Warnings generated: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

## 

[nullness/Alias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Alias.java)

**results:**

```
$ findbugs nullness/Alias.class 

H C NP: Null pointer dereference of ? in nullness.NullAlias.main(String[])  
Dereferenced at NullAlias.java:[line 24]
Warnings generated: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

## inter-procedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

**results:**

```
$ findbugs nullness/InterProcedural.class 

[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

## reflection

[nullness/Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java)

**results:**

```
$ findbugs nullness/Reflection.class 

[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |
