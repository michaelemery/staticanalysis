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
| Reflect | - |
| ReflectInterprocedural | - |
| ReflectOverload | - |
| InvokeDynamic | - |
| Proxy | - |

> Select results for detail.

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

## redundant tests

Tests are considered redundant when the results of previous tests at lower dynamic levels were unsound.

### Reflect

[nullness/Reflect.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflect.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/Reflect.java -f text -R category/java/errorprone.xml
```

### ReflectInterprocedural

[nullness/ReflectInterprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectInterprocedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectInterprocedural.java -f text -R category/java/errorprone.xml
```

### ReflectOverload

[nullness/ReflectOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverload.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectOverload.java -f text -R category/java/errorprone.xml
```

### InvokeDynamic

[nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamic.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/InvokeDynamic.java -f text -R category/java/errorprone.xml
```

### Proxy

[nullness/Proxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Proxy.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/Proxy.java -f text -R category/java/errorprone.xml
```
