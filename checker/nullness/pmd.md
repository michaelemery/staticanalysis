# pmd results (nullness)

Version: pmd-bin-6.1.0

* PMD checkers belonging to the "error prone" category are the only ones required for these tests.
* The `$PMD_HOME` variable must be configured to use these commands.
* JDK must be set to 1.8 or lower.
* Outputs have been simplified for brevity.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

### summary

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#IntraProcedural) |
| InterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#InterProcedural) |
| ReflectMethod | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#ReflectMethod) |
| ReflectMethodOverload | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#ReflectMethodOverload) |
| ReflectFieldAccess | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#InvokeDynamicField) |
| DynamicProxy | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#DynamicProxy) |

> Select results for detail.

## IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### output

```
checker/nullness/IntraProcedural.java:23:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| False Neg | False Pos | Result | 
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## InterProcedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethod

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethod.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethodOverload

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodOverload.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/ReflectMethodOverload.java -f text -R category/java/errorprone.xml
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccess.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/ReflectFieldAccess.java -f text -R category/java/errorprone.xml
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | unsound |


## InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicVirtual.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/InvokeDynamicVirtual.java -f text -R category/java/errorprone.xml
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicConstructor.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicField.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/InvokeDynamicField.java -f text -R category/java/errorprone.xml
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result | 
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/DynamicProxy.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d checker/nullness/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### output

```
checker/nullness/DynamicProxy.java:18:	Found 'DU'-anomaly for variable 'proxyInstance' (lines '18'-'35').
hecker/nullness/DynamicProxy.java:19:	In J2EE, getClassLoader() might not work as expected.  Use Thread.currentThread().getContextClassLoader() instead.
```

| False Neg | False Pos | Result | 
| :---: | :---: | :---: |
| 0 | 2 | aberrant |
