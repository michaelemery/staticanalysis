# findbugs

Version: findbugs-3.0.1

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example.

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#IntraProcedural) |
| InterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#InterProcedural) |
| ReflectMethod | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#reflectmethodinvoke) |
| ReflectMethodOverload | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#reflectmethodinvoke) |
| ReflectFieldAccess | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#reflectoverloadinvoke) |
| InvokeDynamicVirtual | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#reflectmethodhandle) |
| InvokeDynamicConstructor | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#reflectfieldaccess) |
| InvokeDynamicField | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#reflectfieldaccess) |
| DynamicProxy | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#dynamicproxy) |

> Select results for detail.

### IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/IntraProcedural.java)

```
javac checker/init/IntraProcedural.java
findbugs checker/init/IntraProcedural.class
```

#### output

```
M C UR: Uninitialized read of o in new checker.init.IntraProcedural(int)  At IntraProcedural.java:[line 16]
M C UR: Uninitialized read of o in new checker.init.IntraProcedural(int, int)  At IntraProcedural.java:[line 20]
Warnings generated: 2
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

### InterProcedural

[init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InterProcedural.java)

```
javac checker/init/InterProcedural.java
findbugs checker/init/InterProcedural.class
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 2 | 0 | unsound |

### ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/ReflectMethod.java)

```
javac checker/init/ReflectMethod.java
findbugs checker/init/ReflectMethod.class
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | o | unsound |

### ReflectMethodOverload

[init/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/ReflectMethodOverload.java)

```
javac checker/init/ReflectMethodOverload.java
findbugs checker/init/ReflectMethodOverload.class
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | o | unsound |

### ReflectFieldAccess

[init/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/ReflectFieldAccess.java)

```
javac checker/init/ReflectFieldAccess.java
findbugs checker/init/ReflectFieldAccess.class
```

#### output

```
M C UwF: Unwritten field: checker.init.ReflectFieldAccess.o  At ReflectFieldAccess.java:[line 27]
M C NP: Read of unwritten field o in checker.init.ReflectFieldAccess.main(String[])  At ReflectFieldAccess.java:[line 28]
Warnings generated: 2
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 1 | aberrant |

### InvokeDynamicVirtual

[init/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InvokeDynamicVirtual.java)

```
javac checker/init/InvokeDynamicVirtual.java
findbugs checker/init/InvokeDynamicVirtual.class checker/init/InvokeDynamicVirtual.class
```

#### output

```

```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| x | x | xxx |

### InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InvokeDynamicConstructor.java)

```
javac checker/init/InvokeDynamicConstructor.java
findbugs checker/init/InvokeDynamicConstructor.class
```

#### output

```

```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| x | x | xxx |

### InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InvokeDynamicField.java)

```
javac checker/init/InvokeDynamicField.java
findbugs checker/init/InvokeDynamicField.class
```

#### output

```

```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| x | x | xxx |

### DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/DynamicProxy.java)

```
javac checker/init/DynamicProxy.java
findbugs checker/init/DynamicProxy.class checker/init/DynamicProxy.class
```

#### output

```

```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| x | x | xxx |
