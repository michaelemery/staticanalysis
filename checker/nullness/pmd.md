
# pmd

Version: pmd-bin-6.0.1

PMD checkers belonging to the "error prone" category are the only ones required for these tests.

> 1. The `pmd` command shown in all results is an alias; <br>
> `alias pmd='$PMD_HOME/bin/run.sh pmd'`
> 2. JDK must be set to 1.8 or lower.
> 3. Outputs have been simplified for brevity.

## results

PMD correctly identified nulness issues at the intra-procedural (vanilla) level only. Results were unsound when using inter-procedural analysis or reflection.

| Vanilla | InterProcedural | Reflection | InvokeDynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#inter-procedural) | - | - | - |

### vanilla

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

```
$ pmd -d nullness/IntraProcedural.java -f text -R category/java/errorprone.xml

nullness/IntraProcedural.java:8:
Found non-transient, non-static member. Please mark as transient or provide accessors.
nullness/IntraProcedural.java:21:
Assigning an Object to null is a code smell. Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### alias

[nullness/Alias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Alias.java)

```
$ pmd -d NullAlias.java -f text -R category/java/errorprone.xml

nullness/Alias.java:8: 
Found non-transient, non-static member. Please mark as transient or provide accessors.
nullness/Alias.java:22:    
Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

## inter-procedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
$ pmd -d NullInterProcedural.java -f text -R category/java/errorprone.xml

nullness/InterProcedural.java:8:  
Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

## reflection

[nullness/Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java)

```
$ pmd -d NullReflection.java -f text -R category/java/errorprone.xml

nullness/Reflection.java:11:   
Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |
