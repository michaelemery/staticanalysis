# findbugs

Version: findbugs-3.0.1

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#IntraProcedural) |
| InterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#InterProcedural) |
| ReflectMethodInvoke | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodinvoke) |
| ReflectOverloadInvoke | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodinvoke) |
| ReflectFieldAccess | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectoverloadinvoke) |
| InvokeDynamicVirtual | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodhandle) |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectfieldaccess) |
| InvokeDynamicField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectfieldaccess) |
| DynamicProxy | [no result](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#dynamicproxy) |

> Select results for detail.

### IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

```
javac checker/nullness/IntraProcedural.java
findbugs checker/nullness/IntraProcedural.class
```

#### output

```
H C NP: Null pointer dereference of IntraProcedural.o in checker.nullness.IntraProcedural.main(String[])  Dereferenced at IntraProcedural.java:[line 23]
Warnings generated: 1
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 1 | 0 | 0 | accurate |

### InterProcedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
javac checker/nullness/InterProcedural.java
findbugs checker/nullness/InterProcedural.class
```

#### output

```
No reported issues.
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |

### ReflectMethodInvoke

[nullness/ReflectMethodInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvoke.java)

```
javac checker/nullness/ReflectMethodInvoke.java
findbugs checker/nullness/InvokeDynamicVirtual.class checker/nullness/ReflectMethodInvoke.class
```

#### output

```
No reported issues.
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |

### ReflectOverloadInvoke

[nullness/ReflectOverloadInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvoke.java)

```
javac checker/nullness/ReflectOverloadInvoke.java
findbugs checker/nullness/InvokeDynamicVirtual.class checker/nullness/ReflectOverloadInvoke.class
```

#### output

```
No reported issues.
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |

### ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccess.java)

```
javac checker/nullness/ReflectFieldAccess.java
findbugs checker/nullness/InvokeDynamicVirtual.class checker/nullness/ReflectFieldAccess.class
```

#### output

```
No reported issues.
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |

### InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicVirtual.java)

```
javac checker/nullness/InvokeDynamicVirtual.java
findbugs checker/nullness/InvokeDynamicVirtual.class checker/nullness/InvokeDynamicVirtual.class
```

#### output

```
No reported issues.
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |

### InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicConstructor.java)

```
javac checker/nullness/InvokeDynamicConstructor.java
findbugs checker/nullness/InvokeDynamicConstructor.class
```

#### output

```
No reported issues.
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |

### InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicField.java)

```
javac checker/nullness/InvokeDynamicField.java
findbugs checker/nullness/InvokeDynamicField.class
```

#### output

```
No reported issues.
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |

### DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/DynamicProxy.java)

```
javac checker/nullness/DynamicProxy.java
findbugs checker/nullness/DynamicProxy.class
```

#### output

```
root@de7f4557a7e1:/# findbugs checker/nullness/DynamicProxy.class
The following classes needed for analysis were missing:
  checker.nullness.DynamicProxy$Foo
Missing classes: 1
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |
