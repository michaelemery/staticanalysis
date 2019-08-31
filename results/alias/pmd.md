# pmd results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: pmd-bin-6.1.0

* PMD checkers belonging to the "error prone" category are the only ones required for these tests.
* The `$PMD_HOME` variable must be configured to use these commands.
* JDK must be set to 1.8 or lower.
* Outputs have been simplified for brevity.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[alias/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/IntraProcedural.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d alias/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
alias/IntraProcedural.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
alias/IntraProcedural.java:21:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InterProcedural

[alias/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InterProcedural.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d alias/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
alias/InterProcedural.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
alias/InterProcedural.java:21:	Assigning an Object to null is a code smell.  Consider refactoring.

```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethod

[alias/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectMethod.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d alias/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
alias/ReflectMethod.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
alias/ReflectMethod.java:25:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectConstructor

[alias/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectConstructor.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d alias/ReflectConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output

```
alias/ReflectConstructor.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
alias/ReflectConstructor.java:26:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectField

[//]: [alias/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectField.java)

This language feature is not applicable to the checker being tested. 

#### checker command

```
NA
```

#### checker output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## InvokeDynamicMethod

[alias/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicMethod.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d alias/InvokeDynamicMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
alias/InvokeDynamicMethod.java:14:	Found non-transient, non-static member. Please mark as transient or provide accessors.
alias/InvokeDynamicMethod.java:29:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[alias/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicConstructor.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d alias/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output

```
alias/InvokeDynamicConstructor.java:14:	Found non-transient, non-static member. Please mark as transient or provide accessors.
alias/InvokeDynamicConstructor.java:31:	Assigning an Object to null is a code smell.  Consider refactoring.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[//]: [alias/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicField.java)

This language feature is not applicable to the checker being tested. 

#### checker command

```
NA
```

#### checker output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## DynamicProxy

[//]: [alias/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/DynamicProxy.java)

This language feature is not applicable to the checker being tested. 

#### checker command

```
NA
```

#### checker output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |
