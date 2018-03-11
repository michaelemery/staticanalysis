# pmd

Version: pmd-bin-6.0.1

## usage

* PMD checkers belonging to the "error prone" category are the only ones required for these tests.
* The `$PMD_HOME` variable must be configured to use these commands.
* JDK must be set to 1.8 or lower.
* Outputs have been simplified for brevity.

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| Vanilla | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanilla) |
| Interprocedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#interprocedural) |
| IntraproceduralMethodInvocation | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#intraproceduralmethodinvocation) |
| InterproceduralMethodInvocation | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#interproceduralmethodinvocation) |
| InterproceduralOverloadInvocation | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#interproceduraloverloadinvocation) |
| IntraproceduralReflectiveFieldAccess | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#intraproceduralreflectivefieldaccess) |
| InterproceduralReflectiveFieldAccess | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#interproceduralreflectivefieldaccess) |
| InvokeDynamic | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#invokedynamic) |
| Proxy | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#proxy) |

> Select results for detail.

### Vanilla

[nullness/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/Vanilla.java -f text -R category/java/errorprone.xml
```

#### output

```
nullness/Vanilla.java:16:   
Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### Interprocedural

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


### IntraproceduralReflectiveFieldAccess

[nullness/IntraproceduralReflectiveFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralReflectiveFieldAccess.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/IntraproceduralReflectiveFieldAccess.java -f text -R category/java/errorprone.xml
```

#### output

````
nullness/IntraproceduralReflectiveFieldAccess.java:9:   
Found non-transient, non-static member. Please mark as transient or provide accessors.
````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### InvokeDynamic

[nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamic.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/InvokeDynamic.java -f text -R category/java/errorprone.xml
```

#### output

````

````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| TBC | TBC | TBC |

### Proxy

[nullness/Proxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Proxy.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/Proxy.java -f text -R category/java/errorprone.xml
```

#### output

````

````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| TBC | TBC | TBC |

## redundant tests

Tests are considered redundant when prerequisite tests are unsound.

### IntraproceduralMethodInvocation

[nullness/IntraproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralMethodInvocation.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/IntraproceduralMethodInvocation.java -f text -R category/java/errorprone.xml
```

### InterproceduralMethodInvocation

[nullness/InterproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralMethodInvocation.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/InterproceduralMethodInvocation.java -f text -R category/java/errorprone.xml
```

### InterproceduralOverloadInvocation

[nullness/InterproceduralOverloadInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralOverloadInvocation.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/InterproceduralOverloadInvocation.java -f text -R category/java/errorprone.xml
```

### InterproceduralMethodInvocation

[nullness/InterproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralMethodInvocation.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/InterproceduralMethodInvocation.java -f text -R category/java/errorprone.xml
```

### InterproceduralReflectiveFieldAccess

[nullness/InterproceduralReflectiveFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralReflectiveFieldAccess.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/InterproceduralReflectiveFieldAccess.java -f text -R category/java/errorprone.xml
```
