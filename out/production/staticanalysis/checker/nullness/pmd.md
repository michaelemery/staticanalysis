# pmd

Version: pmd-bin-6.1.0

## usage

* PMD checkers belonging to the "error prone" category are the only ones required for these tests.
* The `$PMD_HOME` variable must be configured to use these commands.
* JDK must be set to 1.8 or lower.
* Outputs have been simplified for brevity.

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| VanillaIntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanillaintraprocedural) |
| VanillaInterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanillainterprocedural) |
| ReflectMethodInvokeIntraProcedural | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectmethodinvokeintraprocedural) |
| ReflectMethodInvokeInterProcedural | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectmethodinvokeinterprocedural) |
| ReflectOverloadInvokeInterProcedural | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectoverloadinvokeinterprocedural) |
| ReflectMethodHandleIntraProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectmethodhandleintraprocedural) |
| ReflectFieldAccessIntraProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectfieldaccessintraprocedural) |
| ReflectFieldAccessInterProcedural | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectfieldaccessinterprocedural) |
| DynamicProxy | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#dynamicproxy) |
| InvokeDynamic | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#invokedynamic) |

> Select results for detail.

### VanillaIntraProcedural

[nullness/VanillaIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/VanillaIntraProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/VanillaIntraProcedural.java -f text -R category/java/errorprone.xml
```

#### output

```
nullness/VanillaIntraProcedural.java:16:   
Assigning an Object to null is a code smell.  
Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### VanillaInterProcedural

[nullness/VanillaInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/VanillaInterProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/VanillaInterProcedural.java -f text -R category/java/errorprone.xml
```

#### output

```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### ReflectMethodHandleIntraProcedural

[nullness/ReflectMethodHandleIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodHandleIntraProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectMethodHandleIntraProcedural.java -f text -R category/java/errorprone.xml
```

#### output

```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### ReflectFieldAccessIntraProcedural

[nullness/ReflectFieldAccessIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccessIntraProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectFieldAccessIntraProcedural.java -f text -R category/java/errorprone.xml
```

#### output

````
nullness/ReflectFieldAccessIntraProcedural.java:9:   
Found non-transient, non-static member. 
Please mark as transient or provide accessors.
````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/DynamicProxy.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### output

````
nullness/DynamicProxy.java:17:	
In J2EE, getClassLoader() might not work as expected.  
Use Thread.currentThread().getContextClassLoader() instead.

nullness/DynamicProxy.java:24:	
In J2EE, getClassLoader() might not work as expected.  
Use Thread.currentThread().getContextClassLoader() instead.

````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 1 | 1 |

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

## redundant tests

Tests are considered redundant when prerequisite tests are unsound.

### ReflectMethodInvokeIntraProcedural

[nullness/ReflectMethodInvokeIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvokeIntraProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectMethodInvokeIntraProcedural.java -f text -R category/java/errorprone.xml
```

### ReflectMethodInvokeInterProcedural

[nullness/ReflectMethodInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvokeInterProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectMethodInvokeInterProcedural.java -f text -R category/java/errorprone.xml
```

### ReflectOverloadInvokeInterProcedural

[nullness/ReflectOverloadInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvokeInterProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectOverloadInvokeInterProcedural.java -f text -R category/java/errorprone.xml
```

### ReflectMethodInvokeInterProcedural

[nullness/ReflectMethodInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvokeInterProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectMethodInvokeInterProcedural.java -f text -R category/java/errorprone.xml
```

### ReflectFieldAccessInterProcedural

[nullness/ReflectFieldAccessInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccessInterProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectFieldAccessInterProcedural.java -f text -R category/java/errorprone.xml
```
