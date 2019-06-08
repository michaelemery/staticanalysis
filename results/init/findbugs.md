# findbugs

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

### summary

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#IntraProcedural) |
| InterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#InterProcedural) |
| ReflectMethod | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectmethodinvoke) |
| ReflectMethodOverload | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectmethodinvoke) |
| ReflectFieldAccess | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectoverloadinvoke) |
| InvokeDynamicVirtual | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectmethodhandle) |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectfieldaccess) |
| InvokeDynamicField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectfieldaccess) |
| DynamicProxy | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#dynamicproxy) |

> Select results for detail.

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/init/IntraProcedural.java)

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

[init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InterProcedural.java)

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

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectMethod.java)

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
| 1 | o | unsound |

## ReflectMethodOverload

[init/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectMethodOverload.java)

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

[init/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectFieldAccess.java)

#### docker

```
javac init/ReflectFieldAccess.java
findbugs init/ReflectFieldAccess.class
```

#### output

```
M C UR: Uninitialized read of o in new init.ReflectFieldAccess()  At ReflectFieldAccess.java:[line 16]
M C UR: Uninitialized read of o in new init.ReflectFieldAccess(int)  At ReflectFieldAccess.java:[line 23]
M C UwF: Unwritten field: init.ReflectFieldAccess.o  At ReflectFieldAccess.java:[line 16]
M C NP: Read of unwritten field o in new init.ReflectFieldAccess()  At ReflectFieldAccess.java:[line 16]
M C NP: Read of unwritten field o in new init.ReflectFieldAccess(int)  At ReflectFieldAccess.java:[line 23]
Warnings generated: 5
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 1 | aberrant |

## InvokeDynamicVirtual

[init/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicVirtual.java)

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

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicConstructor.java)

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

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicField.java)

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
| 1 | o | unsound |

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/init/DynamicProxy.java)

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
| 1 | 1 | aberrant |