# pmd results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: pmd-bin-6.1.0

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

#### pull docker container and run interactive instance

```shell script
docker pull michaelemery/staticanalysis
docker run -it --rm michaelemery/staticanalysis
```

#### run junit tests from docker

```shell script
sh test.sh [ [ <package-name> ] | [ <package-name> <class-name> ] ]
```

<br>

## IntraProcedural

* [alias/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/IntraProcedural.java)

* [alias/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/IntraProcedural.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/alias/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/alias/IntraProcedural.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/alias/IntraProcedural.java:17:	Avoid using Literals in Conditional Statements
src/alias/IntraProcedural.java:29:	Avoid using Literals in Conditional Statements
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10, 17, 29 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InterProcedural

* [alias/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InterProcedural.java)

* [alias/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/InterProceduralTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/alias/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/alias/InterProcedural.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/alias/InterProcedural.java:23:	Avoid using Literals in Conditional Statements
src/alias/InterProcedural.java:33:	Found 'DU'-anomaly for variable 'alias' (lines '33'-'37').
src/alias/InterProcedural.java:34:	Avoid using Literals in Conditional Statements
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10, 23, 33, 34 | NA |


#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectConstructor

[//]: [alias/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectConstructor.java)

[//]: [alias/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/ReflectConstructorTest.java)

Dynamic language feature not applicable for this checker. 
<!--
#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/alias/ReflectConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |
-->
> NA
> * Alias can not be assigned via constructor.

<br>

## ReflectMethod

* [alias/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectMethod.java)

* [alias/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/ReflectMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/alias/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/alias/ReflectMethod.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/alias/ReflectMethod.java:25:	Avoid using Literals in Conditional Statements
src/alias/ReflectMethod.java:38:	Found 'DU'-anomaly for variable 'alias' (lines '38'-'42').
src/alias/ReflectMethod.java:39:	Avoid using Literals in Conditional Statements
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12, 35, 28, 39 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectField

[//]: [alias/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectField.java)

[//]: [alias/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/ReflectFieldTest.java)

Dynamic language feature not applicable for this checker. 
<!--
#### checker command

```
$PMD_HOME/bin/run.sh pmd -d src/alias/ReflectField.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |
-->
> NA
> * Alias can not be assigned via fields.

<br>

## InvokeDynamicConstructor

[//]: [alias/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicConstructor.java)

[//]: [alias/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/InvokeDynamicConstructorTest.java)

Dynamic language feature not applicable for this checker. 
<!--
#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/alias/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |
-->
> NA 
> * Alias can not be assigned via constructor.

<br>

## InvokeDynamicMethod

* [alias/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicMethod.java)

* [alias/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/InvokeDynamicMethodTest.java)

#### checker command

```shell script
$PMD_HOME/bin/run.sh pmd -d src/alias/InvokeDynamicMethod.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/alias/InvokeDynamicMethod.java:14:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/alias/InvokeDynamicMethod.java:31:	Avoid using Literals in Conditional Statements
src/alias/InvokeDynamicMethod.java:44:	Avoid using Literals in Conditional Statements
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 14, 31, 44 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InvokeDynamicField

[//]: [alias/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicField.java)

[//]: [alias/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/InvokeDynamicFieldTest.java)

Dynamic language feature not applicable for this checker. 
<!--
#### checker command

```
$PMD_HOME/bin/run.sh pmd -d src/alias/InvokeDynamicField.java -f text -R category/java/errorprone.xml
```

#### checker output

```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 0 |
-->
> NA
> * Alias can not be assigned via fields.

<br>

## DynamicProxy

* [alias/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/DynamicProxy.java)

* [alias/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/DynamicProxyTest.java)

#### checker command

```
$PMD_HOME/bin/run.sh pmd -d src/alias/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### checker output

```
src/alias/DynamicProxy.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
src/alias/DynamicProxy.java:20:	In J2EE, getClassLoader() might not work as expected.  Use Thread.currentThread().getContextClassLoader() instead.
src/alias/DynamicProxy.java:37:	Avoid using Literals in Conditional Statements
src/alias/DynamicProxy.java:50:	Avoid using Literals in Conditional Statements
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12, 20, 37, 50 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound
