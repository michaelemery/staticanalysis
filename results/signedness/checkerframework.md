# checker framework results (signedness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

Version: checker-framework-2.1.11

To run the Signedness Checker; 

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[signedness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/IntraProcedural.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker signedness/InterProcedural.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## InterProcedural

[//]: [signedness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InterProcedural.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
NA
```

#### output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## ReflectMethod

[//]: [signedness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/ReflectMethod.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
NA
```

#### output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## ReflectMethodOverload

[//]: [signedness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/ReflectMethodOverload.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
NA
```

#### output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## ReflectFieldAccess

[//]: [signedness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/ReflectFieldAccess.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
NA
```

#### output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |


## InvokeDynamicVirtual

[//]: [signedness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InvokeDynamicVirtual.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
NA
```

#### output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## InvokeDynamicConstructor

[//]: [signedness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InvokeDynamicConstructor.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
NA
```

#### output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## InvokeDynamicField

[//]: [signedness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/InvokeDynamicField.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
NA
```

#### output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## DynamicProxy

[//]: [signedness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/signedness/DynamicProxy.java)

This language feature is not applicable to the checker being tested. 

#### docker

```
NA
```

#### output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |
