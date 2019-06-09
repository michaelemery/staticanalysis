# infer results (nullness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: 0.13.1

Infer:Eradicate is a type checker for @Nullable annotations for Java. It is part of the Infer static analysis suite of tools. The goal is to eradicate null pointer exceptions.
@Nullable annotations denote that a parameter, field or the return value of a method can be null. When decorating a parameter, this denotes that the parameter can legitimately be null and the method will need to deal with it. When decorating a method, this denotes the method might legitimately return null.
Starting from @Nullable-annotated programs, the checker performs a flow sensitive analysis to propagate the nullability through assignments and calls, and flags errors for unprotected accesses to nullable values or inconsistent/missing annotations. It can also be used to add annotations to a previously un-annotated program.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/IntraProcedural.java)

#### docker

```
infer run -a checkers --eradicate -- javac nullness/IntraProcedural.java
```

#### output

```
Found 2 issues

nullness/IntraProcedural.java:23: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `IntraProcedural.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 23)
  21.   
  22.           /* unsafe: set object to null */
  23. >         i.o = null;
  24.           System.out.println(i.o.toString());
  25.       }

nullness/IntraProcedural.java:24: error: ERADICATE_NULL_METHOD_CALL
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

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## InterProcedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/InterProcedural.java)

#### docker

```
infer run -a checkers --eradicate -- javac nullness/InterProcedural.java
```

#### output

```
Found 1 issue

nullness/InterProcedural.java:22: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `set(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 22)
  20.   
  21.           /* unsafe: set object to null */
  22. >         i.set(null);
  23.           System.out.println(i.o.toString());
  24.       }

Summary of the reports

  ERADICATE_PARAMETER_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## ReflectMethod

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/ReflectMethod.java)

#### docker

```
infer run -a checkers --eradicate -- javac nullness/ReflectMethod.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethodOverload

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/ReflectMethodOverload.java)

#### docker

```
infer run -a checkers --eradicate -- javac nullness/ReflectMethodOverload.java
```

### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/ReflectFieldAccess.java)

#### docker

```
infer run -a checkers --eradicate -- javac nullness/ReflectFieldAccess.java
```

#### output

````
No reported issues.

````

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/InvokeDynamicVirtual.java)

#### docker

```
infer run -a checkers --eradicate -- javac nullness/InvokeDynamicVirtual.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/InvokeDynamicConstructor.java)

#### docker

```
infer run -a checkers --eradicate -- javac nullness/InvokeDynamicConstructor.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/InvokeDynamicField.java)

#### docker

```
infer run -a checkers --eradicate -- javac nullness/InvokeDynamicField.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/nullness/DynamicProxy.java)

#### docker

```
infer run -a checkers --eradicate -- javac nullness/DynamicProxy.java
```

#### output

```
Found 1 issue

nullness/DynamicProxy.java:34: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `get(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 34)
  32.   
  33.           /* unsafe: simulate setting object to null */
  34. >         System.out.println(proxyInstance.get(null).toString());
  35.       }
  36.   }

Summary of the reports

  ERADICATE_PARAMETER_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |
