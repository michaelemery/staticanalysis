# pmd results (nullness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: pmd-bin-6.1.0

* PMD checkers belonging to the "error prone" category are the only ones required for these tests.
* The `$PMD_HOME` variable must be configured to use these commands.
* JDK must be set to 1.8 or lower.
* Outputs have been simplified for brevity.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/IntraProcedural.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d nullness/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
nullness/IntraProcedural.java:23:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## InterProcedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InterProcedural.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d nullness/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethod

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethod.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethodOverload

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethodOverload.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectMethodOverload.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectFieldAccess.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d nullness/ReflectFieldAccess.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |


## InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicVirtual.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d nullness/InvokeDynamicVirtual.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicConstructor.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d nullness/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicField.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d nullness/InvokeDynamicField.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d nullness/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### checker output

```
nullness/DynamicProxy.java:18:	Found 'DU'-anomaly for variable 'proxyInstance' (lines '18'-'35').
hecker/nullness/DynamicProxy.java:19:	In J2EE, getClassLoader() might not work as expected.  Use Thread.currentThread().getContextClassLoader() instead.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |
