# infer results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

Version: 0.13.1

Infer does not have a checker to detect an alias.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[//]: [alias/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/IntraProcedural.java)

Infer does not have a checker to detect an alias.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## InterProcedural

[//]: [alias/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InterProcedural.java)

Infer does not have a checker to detect an alias.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## ReflectMethod

[//]: [alias/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectMethod.java)

Infer does not have a checker to detect an alias.

#### docker

```
infer run -a checkers --eradicate -- javac alias/ReflectMethod.java
```

#### output

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## ReflectMethodOverload

[//]: [alias/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectMethodOverload.java)

Infer does not have a checker to detect an alias.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## ReflectFieldAccess

[//]: [alias/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectFieldAccess.java)

1) This language feature is not applicable to the checker being tested.
2) Infer does not have a checker to detect an alias.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## InvokeDynamicVirtual

[//]: [alias/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicVirtual.java)

Infer does not have a checker to detect an alias.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## InvokeDynamicConstructor

[//]: [alias/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicConstructor.java)

Infer does not have a checker to detect an alias.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## InvokeDynamicField

[//]: [alias/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicField.java)

1) This language feature is not applicable to the checker being tested.
2) Infer does not have a checker to detect an alias.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |

## DynamicProxy

[//]: [alias/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/DynamicProxy.java)

1) This language feature is not applicable to the checker being tested.
2) Infer does not have a checker to detect an alias.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | - |
