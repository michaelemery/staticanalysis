# findbugs results (nullness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/IntraProcedural.java)

#### docker

```
javac nullness/IntraProcedural.java
findbugs nullness/IntraProcedural.class
```

#### output

```
H C NP: Null pointer dereference of IntraProcedural.o in checker.nullness.IntraProcedural.main(String[])  Dereferenced at IntraProcedural.java:[line 24]
Warnings generated: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## InterProcedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InterProcedural.java)

#### docker

```
javac nullness/InterProcedural.java
findbugs nullness/InterProcedural.class
```

#### output

```
master/src/src/
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethod

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethod.java)

#### docker

```
javac nullness/ReflectMethod.java
findbugs nullness/ReflectMethod.class
```

#### output

```
master/src/src/
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethodOverload

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethodOverload.java)

#### docker

```
javac nullness/ReflectMethodOverload.java
findbugs nullness/ReflectMethodOverload.class
```

#### output

```
master/src/src/
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectFieldAccess.java)

#### docker

```
javac nullness/ReflectFieldAccess.java
findbugs nullness/ReflectFieldAccess.class
```

#### output

```
master/src/src/
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicVirtual.java)

#### docker

```
javac nullness/InvokeDynamicVirtual.java
findbugs nullness/InvokeDynamicVirtual.class
```

#### output

```
master/src/src/
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicConstructor.java)

#### docker

```
javac nullness/InvokeDynamicConstructor.java
findbugs nullness/InvokeDynamicConstructor.class
```

#### output

```
master/src/src/
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicField.java)

#### docker

```
javac nullness/InvokeDynamicField.java
findbugs nullness/InvokeDynamicField.class
```

#### output

```
master/src/src/
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

#### docker

```
javac nullness/DynamicProxy.java
findbugs nullness/DynamicProxy.class
```

#### output

```
root@de7f4557a7e1:/# findbugs nullness/DynamicProxy.class nullness/DynamicProxy.class
The following classes needed for analysis were missing:
  checker.nullness.DynamicProxy$Foo
Missing classes: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1| 1 | aberrant |
