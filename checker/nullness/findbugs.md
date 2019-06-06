# findbugs results (nullness)

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

### summary

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#IntraProcedural) |
| InterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#InterProcedural) |
| ReflectMethod | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodinvoke) |
| ReflectMethodOverload | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodinvoke) |
| ReflectFieldAccess | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectoverloadinvoke) |
| InvokeDynamicVirtual | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodhandle) |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectfieldaccess) |
| InvokeDynamicField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectfieldaccess) |
| DynamicProxy | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#dynamicproxy) |

> Select results for detail.

## IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

#### docker

```
javac checker/nullness/IntraProcedural.java
findbugs checker/nullness/IntraProcedural.class
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

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

#### docker

```
javac checker/nullness/InterProcedural.java
findbugs checker/nullness/InterProcedural.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethod

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethod.java)

#### docker

```
javac checker/nullness/ReflectMethod.java
findbugs checker/nullness/ReflectMethod.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethodOverload

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodOverload.java)

#### docker

```
javac checker/nullness/ReflectMethodOverload.java
findbugs checker/nullness/ReflectMethodOverload.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccess.java)

#### docker

```
javac checker/nullness/ReflectFieldAccess.java
findbugs checker/nullness/ReflectFieldAccess.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicVirtual.java)

#### docker

```
javac checker/nullness/InvokeDynamicVirtual.java
findbugs checker/nullness/InvokeDynamicVirtual.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicConstructor.java)

#### docker

```
javac checker/nullness/InvokeDynamicConstructor.java
findbugs checker/nullness/InvokeDynamicConstructor.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicField.java)

#### docker

```
javac checker/nullness/InvokeDynamicField.java
findbugs checker/nullness/InvokeDynamicField.class
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/DynamicProxy.java)

#### docker

```
javac checker/nullness/DynamicProxy.java
findbugs checker/nullness/DynamicProxy.class
```

#### output

```
root@de7f4557a7e1:/# findbugs checker/nullness/DynamicProxy.class checker/nullness/DynamicProxy.class
The following classes needed for analysis were missing:
  checker.nullness.DynamicProxy$Foo
Missing classes: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1| 1 | aberrant |
