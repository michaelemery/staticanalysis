
# findbugs

Version: findbugs-3.0.1

## intra-procedurual

[nullness/NullIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullIntraProcedural.java)

**results:**

```
$ findbugs nullness/NullIntraProcedural.class 

H C NP: Null pointer dereference of ? in nullness.IntraProcedural.main(String[])  
Dereferenced at NullIntraProcedural.java:[line 22]
Warnings generated: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

## 

[nullness/NullAlias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullAlias.java)

**results:**

```
$ findbugs nullness/NullAlias.class 

H C NP: Null pointer dereference of ? in nullness.NullAlias.main(String[])  
Dereferenced at NullAlias.java:[line 24]
Warnings generated: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

## inter-procedural

[nullness/NullInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullInterProcedural.java)

**results:**

```
$ findbugs nullness/NullInterProcedural.class 

[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

## reflection

[nullness/NullReflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullReflection.java)

**results:**

```
$ findbugs nullness/NullReflection.class 

[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |
