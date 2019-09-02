# findbugs results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: findbugs-3.0.1

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

* [alias/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/IntraProceduralTest.java)

#### checker command

```shell script
javac -d out/ src/alias/IntraProcedural.java
findbugs out/alias/IntraProcedural.class
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
| - | 1 | 1 |

> unsound

<br>

## InterProcedural

* [alias/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InterProcedural.java)

* [alias/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InterProcedural.java)

#### checker command

```shell script
javac -d out/ src/alias/InterProcedural.java
findbugs out/alias/InterProcedural.class
```

#### checker output

```
M D DLS: Dead store to $L1 in alias.InterProcedural.setFooWithAlias()  At InterProcedural.java:[line 33]
Warnings generated: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 33 | NA |

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
javac -d out/ src/alias/ReflectConstructor.java
findbugs out/alias/ReflectConstructor.class
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
javac -d out/ src/alias/ReflectMethod.java
findbugs out/alias/ReflectMethod.class
```

#### checker output

```
M D DLS: Dead store to $L2 in alias.ReflectMethod.setFooWithAlias()  At ReflectMethod.java:[line 38]
Warnings generated: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 38 | NA |

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
javac -d out/ src/alias/ReflectField.java
findbugs out/alias/ReflectField.class
```

#### checker output

```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |
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

[//]: [alias/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicConstructor.java)

Dynamic language feature not applicable for this checker. 
<!--
#### checker command

```shell script
javac -d out/ src/alias/InvokeDynamicConstructor.java
findbugs out/alias/InvokeDynamicConstructor.class
```

#### checker output

```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |
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
javac -d out/ src/alias/InvokeDynamicMethod.java
findbugs out/alias/InvokeDynamicMethod.class
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
javac -d out/ src/alias/InvokeDynamicField.java
findbugs out/alias/InvokeDynamicField.class
```

#### checker output

```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |
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
javac -d out/ src/alias/DynamicProxy.java
findbugs out/alias/DynamicProxy.class
```

#### checker output

```
The following classes needed for analysis were missing:
  alias.DynamicProxy$MyClass
Missing classes: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| Missing classes | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound
