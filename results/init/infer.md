# infer results (init)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

Version: 0.13.1

Infer:Eradicate is a type checker for @Nullable annotations for Java. It is part of the Infer static analysis suite of tools. The goal is to eradicate null pointer exceptions.
@Nullable annotations denote that a parameter, field or the return value of a method can be null. When decorating a parameter, this denotes that the parameter can legitimately be null and the method will need to deal with it. When decorating a method, this denotes the method might legitimately return null.
Starting from @Nullable-annotated programs, the checker performs a flow sensitive analysis to propagate the nullability through assignments and calls, and flags errors for unprotected accesses to nullable values or inconsistent/missing annotations. It can also be used to add annotations to a previously un-annotated program.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/IntraProcedural.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InterProcedural

[init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/InterProcedural.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/ReflectMethod.java
```

#### output

```
Found 1 issue

init/ReflectMethod.java:17: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectMethod.o` is not initialized in the constructor and is not declared `@Nullable`.
  15.       }
  16.   
  17. >     ReflectMethod(Method m, int x) throws Exception {
  18.           m.invoke(this);
  19.       }


Summary of the reports

  ERADICATE_FIELD_NOT_INITIALIZED: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | accurate |

## ReflectMethodOverload

[init/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethodOverload.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/ReflectMethodOverload.java
```

#### output

```
Found 1 issue

init/ReflectMethodOverload.java:19: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectMethodOverload.o` is not initialized in the constructor and is not declared `@Nullable`.
  17.       }
  18.   
  19. >     ReflectMethodOverload(int x) throws Exception {
  20.           Class<?> C = ReflectMethodOverload.class;
  21.           Method m = C.getDeclaredMethod("m");


Summary of the reports

  ERADICATE_FIELD_NOT_INITIALIZED: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | accurate |

## ReflectFieldAccess

[init/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectFieldAccess.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/ReflectFieldAccess.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicVirtual

[init/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicVirtual.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/InvokeDynamicVirtual.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/InvokeDynamicConstructor.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicField.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/InvokeDynamicField.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/DynamicProxy.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/DynamicProxy.java
```

#### output

```
Found 1 issue

init/DynamicProxy.java:18: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `get(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 18).
  16.   
  17.       DynamicProxy(Foo proxyInstance, int x) {
  18. >         this.o = proxyInstance.get(null);
  19.           System.out.println(this.o.toString());
  20.       }


Summary of the reports

  ERADICATE_PARAMETER_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |
