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
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanillaintraprocedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanillainterprocedural) |
| ReflectMethodInvoke | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectmethodinvokeintraprocedural) |
| ReflectOverloadInvoke | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectmethodinvokeinterprocedural) |
| ReflectFieldAccess | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectoverloadinvokeinterprocedural) |
| InvokeDynamicVirtual | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectmethodhandleintraprocedural) |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectfieldaccessintraprocedural) |
| InvokeDynamicField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#InvokeDynamicField) |
| DynamicProxy | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#dynamicproxy) |

> Select results for detail.

### IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### output

```
/checker/nullness/IntraProcedural.java:8:	Found non-transient, non-static member. Please mark as transient or provide accessors.
/checker/nullness/IntraProcedural.java:22:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | accurate |

### InterProcedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### output

```
/checker/nullness/InterProcedural.java:8:	Found non-transient, non-static member. Please mark as transient or provide accessors.
/checker/nullness/InterProcedural.java:27:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | accurate |

### ReflectMethodInvoke

[nullness/ReflectMethodInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvoke.java)

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/ReflectMethodInvoke.java -f text -R category/java/errorprone.xml
```

#### output

```
/checker/nullness/ReflectMethodInvoke.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
/checker/nullness/ReflectMethodInvoke.java:31:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | accurate |

### ReflectOverloadInvoke

[nullness/ReflectOverloadInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvoke.java)

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/ReflectOverloadInvoke.java -f text -R category/java/errorprone.xml
```

#### output

```
/checker/nullness/ReflectOverloadInvoke.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
/checker/nullness/ReflectOverloadInvoke.java:36:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | accurate |

### ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccess.java)

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/ReflectFieldAccess.java -f text -R category/java/errorprone.xml
```

#### output

```
/checker/nullness/ReflectFieldAccess.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| True Pos | False Pos | Result | 
| :---: | :---: | :---: |
| 0 | 0 | unsound |


### InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicVirtual.java)

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/InvokeDynamicVirtual.java -f text -R category/java/errorprone.xml
```

#### output

```
/checker/nullness/InvokeDynamicVirtual.java:11:	Found non-transient, non-static member. Please mark as transient or provide accessors.
/checker/nullness/InvokeDynamicVirtual.java:34:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | accurate |

### InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicConstructor.java)

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### output

```
/checker/nullness/InvokeDynamicConstructor.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| True Pos | False Pos | Result | 
| :---: | :---: | :---: |
| 0 | 0 | unsound |

### InvokeDynamicField

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicField.java)

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/InvokeDynamicField.java -f text -R category/java/errorprone.xml
```

#### output

```
/checker/nullness/InvokeDynamicField.java:11:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| True Pos | False Pos | Result | 
| :---: | :---: | :---: |
| 0 | 0 | unsound |

### DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/DynamicProxy.java)

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### output

```
/checker/nullness/DynamicProxy.java:19:	In J2EE, getClassLoader() might not work as expected.  Use Thread.currentThread().getContextClassLoader() instead.
/checker/nullness/DynamicProxy.java:23:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | accurate |
