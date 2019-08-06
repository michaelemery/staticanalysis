# findbugs results (init)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

#### docker

```
javac init/IntraProcedural.java
findbugs init/IntraProcedural.class
```

#### output

```
M C UR: Uninitialized read of o in new init.IntraProcedural(int)  At IntraProcedural.java:[line 16]
Warnings generated: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## InterProcedural

[init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

#### docker

```
javac init/InterProcedural.java
findbugs init/InterProcedural.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 2 | 0 | unsound |

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

#### docker

```
javac init/ReflectMethod.java
findbugs init/ReflectMethod.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

## ReflectMethodOverload

[init/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethodOverload.java)

#### docker

```
javac init/ReflectMethodOverload.java
findbugs init/ReflectMethodOverload.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | o | unsound |

## ReflectFieldAccess

[init/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectFieldAccess.java)

#### docker

```
javac init/ReflectFieldAccess.java
findbugs init/ReflectFieldAccess.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | unsound |

## InvokeDynamicVirtual

[init/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicVirtual.java)

#### docker

```
javac init/InvokeDynamicVirtual.java
findbugs init/InvokeDynamicVirtual.class init/InvokeDynamicVirtual.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | o | unsound |

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

#### docker

```
javac init/InvokeDynamicConstructor.java
findbugs init/InvokeDynamicConstructor.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | o | unsound |

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicField.java)

#### docker

```
javac init/InvokeDynamicField.java
findbugs init/InvokeDynamicField.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/DynamicProxy.java)

#### docker

```
javac init/DynamicProxy.java
findbugs init/DynamicProxy.class init/DynamicProxy.class
```

#### output

```
The following classes needed for analysis were missing:
  init.DynamicProxy$Foo
Missing classes: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |
