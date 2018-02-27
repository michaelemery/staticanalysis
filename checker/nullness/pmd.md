
# pmd

Version: pmd-bin-6.0.1

PMD checkers belonging to the "error prone" category are the only ones required for these tests.

> 1. The `pmd` command shown in all results is an alias; <br>
> `alias pmd='$PMD_HOME/bin/run.sh pmd'`
> 2. JDK must be set to 1.8 or lower.
> 3. Outputs have been simplified for brevity.

## intra-procedural

[nullness/NullIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullIntraProcedural.java)

**results:**

```
$ pmd -d nullness/NullIntraProcedural.java -f text -R category/java/errorprone.xml

nullness/NullIntraProcedural.java:8:
Found non-transient, non-static member. Please mark as transient or provide accessors.
nullness/NullIntraProcedural.java:21:
Assigning an Object to null is a code smell. Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

## alias

[nullness/NullAlias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullAlias.java)

**results:**

```
$ pmd -d NullAlias.java -f text -R category/java/errorprone.xml

nullness/NullAlias.java:8: 
Found non-transient, non-static member. Please mark as transient or provide accessors.
nullness/NullAlias.java:22:    
Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

## inter-procedural

[nullness/NullInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullInterProcedural.java)

**results:**

```
$ pmd -d NullInterProcedural.java -f text -R category/java/errorprone.xml

nullness/NullInterProcedural.java:8:  
Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

## reflection

[nullness/NullReflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullReflection.java)

**results:**

```
$ pmd -d NullReflection.java -f text -R category/java/errorprone.xml

nullness/NullReflection.java:11:   
Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |
