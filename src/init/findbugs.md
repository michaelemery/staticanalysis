# findbugs

Version: findbugs-3.0.1

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example.

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#IntraProcedural) |
| InterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#InterProcedural) |
| ReflectMethod | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectmethodinvoke) |
| ReflectMethodOverload | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectmethodinvoke) |
| ReflectFieldAccess | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectoverloadinvoke) |
| InvokeDynamicVirtual | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectmethodhandle) |
| InvokeDynamicConstructor | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectfieldaccess) |
| InvokeDynamicField | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectfieldaccess) |
| DynamicProxy | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#dynamicproxy) |

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
M C UR: Uninitialized read of o in new checker.init.IntraProcedural(int)  At IntraProcedural.java:[line 16]
M C UR: Uninitialized read of o in new checker.init.IntraProcedural(int, int)  At IntraProcedural.java:[line 20]
Warnings generated: 2
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
M C UwF: Unwritten field: checker.init.ReflectFieldAccess.o  At ReflectFieldAccess.java:[line 27]
M C NP: Read of unwritten field o in checker.init.ReflectFieldAccess.main(String[])  At ReflectFieldAccess.java:[line 28]
Warnings generated: 2
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

```

| false negative | false positive | result |
| :---: | :---: | :---: |
| x | x | xxx |

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicConstructor.java)

#### docker

```
javac init/InvokeDynamicConstructor.java
findbugs init/InvokeDynamicConstructor.class
```

#### output

```

```

| false negative | false positive | result |
| :---: | :---: | :---: |
| x | x | xxx |

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicField.java)

#### docker

```
javac init/InvokeDynamicField.java
findbugs init/InvokeDynamicField.class
```

#### output

```

```

| false negative | false positive | result |
| :---: | :---: | :---: |
| x | x | xxx |

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/init/DynamicProxy.java)

#### docker

```
javac init/DynamicProxy.java
findbugs init/DynamicProxy.class init/DynamicProxy.class
```

#### output

```

```

| false negative | false positive | result |
| :---: | :---: | :---: |
| x | x | xxx |
