# checker framework results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: checker-framework-2.1.11

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
javac -processor org.checkerframework.common.aliasing.AliasingChecker src/alias/IntraProcedural.java
```

#### checker output

```
src/alias/IntraProcedural.java:16: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique IntraProcedural original = new IntraProcedural();
                                           ^
  found   : @MaybeAliased IntraProcedural
  required: @NonLeaked @Unique IntraProcedural
src/alias/IntraProcedural.java:26: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique IntraProcedural original = new IntraProcedural();
                                           ^
  found   : @MaybeAliased IntraProcedural
  required: @NonLeaked @Unique IntraProcedural
src/alias/IntraProcedural.java:27: error: [unique.leaked] Reference annotated as @Unique is leaked.
        IntraProcedural alias = original;
                                ^
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16, 26 | NA |
| 27 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## InterProcedural

* [alias/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InterProcedural.java)

* [alias/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/InterProceduralTest.java)

#### checker command

```shell script
javac -processor org.checkerframework.common.aliasing.AliasingChecker src/alias/InterProcedural.java
```

#### checker output

```
src/alias/InterProcedural.java:22: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique InterProcedural original = new InterProcedural();
                                           ^
  found   : @MaybeAliased InterProcedural
  required: @NonLeaked @Unique InterProcedural
src/alias/InterProcedural.java:32: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique InterProcedural original = new InterProcedural();
                                           ^
  found   : @MaybeAliased InterProcedural
  required: @NonLeaked @Unique InterProcedural
src/alias/InterProcedural.java:33: error: [unique.leaked] Reference annotated as @Unique is leaked.
        InterProcedural alias = getAlias(original);
                                         ^
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 22,32 | NA |
| 33 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## ReflectConstructor

[//]: [alias/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectConstructor.java)

[//]: [alias/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/ReflectConstructorTest.java)

Dynamic language feature not applicable for this checker. 
<!--
#### checker command

```shell script
javac -processor org.checkerframework.common.aliasing.AliasingChecker src/alias/ReflectConstructor.java
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
javac -processor org.checkerframework.common.aliasing.AliasingChecker src/alias/ReflectMethod.java
```

#### checker output

```
src/alias/ReflectMethod.java:24: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique ReflectMethod original = new ReflectMethod();
                                         ^
  found   : @MaybeAliased ReflectMethod
  required: @NonLeaked @Unique ReflectMethod
src/alias/ReflectMethod.java:35: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique ReflectMethod original = new ReflectMethod();
                                         ^
  found   : @MaybeAliased ReflectMethod
  required: @NonLeaked @Unique ReflectMethod
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 24, 25 | NA |

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

```shell script
javac -processor org.checkerframework.common.aliasing.AliasingChecker src/alias/ReflectConstructor.java
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

* [alias/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicConstructor.java)

* [alias/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/InvokeDynamicConstructorTest.java)

Dynamic language feature not applicable for this checker. 
<!--
#### checker command

```shell script
javac -processor org.checkerframework.common.aliasing.AliasingChecker src/alias/ReflectConstructor.java
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
javac -processor org.checkerframework.common.aliasing.AliasingChecker src/alias/InvokeDynamicMethod.java
```

#### checker output

```
src/alias/InvokeDynamicMethod.java:30: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique InvokeDynamicMethod original = new InvokeDynamicMethod();
                                               ^
  found   : @MaybeAliased InvokeDynamicMethod
  required: @NonLeaked @Unique InvokeDynamicMethod
src/alias/InvokeDynamicMethod.java:40: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique InvokeDynamicMethod original = new InvokeDynamicMethod();
                                               ^
  found   : @MaybeAliased InvokeDynamicMethod
  required: @NonLeaked @Unique InvokeDynamicMethod
src/alias/InvokeDynamicMethod.java:42: error: [unique.leaked] Reference annotated as @Unique is leaked.
                (InvokeDynamicMethod) getGetObjectMethodHandle().invoke(original);
                                                                        ^
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 30, 40 | NA |
| 42 | TP

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## InvokeDynamicField

[//]: [alias/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicField.java)

[//]: [alias/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/alias/InvokeDynamicFieldTest.java)

Dynamic language feature not applicable for this checker. 
<!--
#### checker command

```shell script
javac -processor org.checkerframework.common.aliasing.AliasingChecker src/alias/InvokeDynamicField.java
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

```shell script
javac -processor org.checkerframework.common.aliasing.AliasingChecker src/alias/DynamicProxy.java
```

#### checker output

```
src/alias/DynamicProxy.java:36: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique DynamicProxy original = new DynamicProxy();
                                        ^
  found   : @MaybeAliased DynamicProxy
  required: @NonLeaked @Unique DynamicProxy
src/alias/DynamicProxy.java:46: error: [assignment.type.incompatible] incompatible types in assignment.
        @Unique DynamicProxy original = new DynamicProxy();
                                        ^
  found   : @MaybeAliased DynamicProxy
  required: @NonLeaked @Unique DynamicProxy
src/alias/DynamicProxy.java:48: error: [unique.leaked] Reference annotated as @Unique is leaked.
                (DynamicProxy) getProxyInstance().getObject(original);
                                                            ^
3 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 26, 46 | NA |
| 48 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate
