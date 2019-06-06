# infer

Version: 0.13.1

## usage

### checkers used 

1. eradicate

Infer:Eradicate is a type checker for @Nullable annotations for Java. It is part of the Infer static analysis suite of tools. The goal is to eradicate null pointer exceptions.
@Nullable annotations denote that a parameter, field or the return value of a method can be null. When decorating a parameter, this denotes that the parameter can legitimately be null and the method will need to deal with it. When decorating a method, this denotes the method might legitimately return null.
Starting from @Nullable-annotated programs, the checker performs a flow sensitive analysis to propagate the nullability through assignments and calls, and flags errors for unprotected accesses to nullable values or inconsistent/missing annotations. It can also be used to add annotations to a previously un-annotated program.

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#InterProcedural) |
| ReflectMethod | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#ReflectMethod) |
| ReflectMethodOverload | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#ReflectMethodOverload) |
| ReflectFieldAccess | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectoverloadinvoke) |
| InvokeDynamicVirtual | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectmethodhandle) |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectfieldaccess) |
| InvokeDynamicField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectfieldaccess) |
| DynamicProxy | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#dynamicproxy) |

> Select results for detail.

### IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/IntraProcedural.java
```

#### output

```
Found 2 issues

checker/nullness/IntraProcedural.java:23: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `IntraProcedural.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 23)
  21.   
  22.           /* unsafe: set object to null */
  23. >         i.o = null;
  24.           System.out.println(i.o.toString());
  25.       }

checker/nullness/IntraProcedural.java:24: error: ERADICATE_NULL_METHOD_CALL
  The value of `i.o` in the call to `toString()` could be null. (Origin: null constant at line 23)
  22.           /* unsafe: set object to null */
  23.           i.o = null;
  24. >         System.out.println(i.o.toString());
  25.       }
  26.   }

Summary of the reports

    ERADICATE_NULL_METHOD_CALL: 1
  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

### InterProcedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/InterProcedural.java
```

#### output

```
Found 1 issue

checker/nullness/InterProcedural.java:22: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `set(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 22)
  20.   
  21.           /* unsafe: set object to null */
  22. >         i.set(null);
  23.           System.out.println(i.o.toString());
  24.       }

Summary of the reports

  ERADICATE_PARAMETER_NOT_NULLABLE: 1
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

### ReflectMethod

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethod.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/ReflectMethod.java
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

### ReflectMethodOverload

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodOverload.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/ReflectMethodOverload.java
```

### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

### ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccess.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/ReflectFieldAccess.java
```

#### output

````
No reported issues.

````

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

### InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicVirtual.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/InvokeDynamicVirtual.java
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

### InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicConstructor.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/InvokeDynamicConstructor.java
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

### InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicField.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/InvokeDynamicField.java
```

#### output

```
No reported issues.
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

### DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/DynamicProxy.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/DynamicProxy.java
```

#### output

```
Found 1 issue

checker/nullness/DynamicProxy.java:34: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `get(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 34)
  32.   
  33.           /* unsafe: simulate setting object to null */
  34. >         System.out.println(proxyInstance.get(null).toString());
  35.       }
  36.   }

Summary of the reports

  ERADICATE_PARAMETER_NOT_NULLABLE: 1
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |
