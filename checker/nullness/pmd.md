# pmd

Version: pmd-bin-6.0.1

PMD checkers belonging to the "error prone" category are the only ones required for these tests.

> 1. The `pmd` command shown in all results is an alias; <br>
> `alias pmd='$PMD_HOME/bin/run.sh pmd'`
> 2. JDK must be set to 1.8 or lower.
> 3. Outputs have been simplified for brevity.

## results

PMD correctly identified nulness issues at the intra-procedural (vanilla) level only. Results were unsound when using interprocedural analysis or reflection.

| Vanilla | Interprocedural | Reflection | InvokeDynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#interprocedural) | - | - | - |

### vanilla

[nullness/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/Vanilla.java -f text -R category/java/errorprone.xml
```

#### output
```
nullness/Vanilla.java:17: 
Assigning an Object to null is a code smell. Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### interprocedural

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Interprocedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/Interprocedural.java -f text -R category/java/errorprone.xml
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
$PMD_HOME/bin/run.sh pmd -d nullness/Reflection.java -f text -R category/java/errorprone.xml
```

#### output
```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |
