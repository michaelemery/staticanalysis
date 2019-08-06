# infer results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

Version: 0.13.1

Infer does not have a checker to detect an alias.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[alias/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/IntraProcedural.java)

#### docker

```
infer run -a checkers --eradicate -- javac alias/IntraProcedural.java
```

#### output

```
Found 1 issue

alias/IntraProcedural.java:21: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `IntraProcedural.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 21)
  19.           /* unsafe: make object null via alias */
  20.           IntraProcedural alias = original;
  21. >         alias.o = null;
  22.           System.out.println(original.o.toString());
  23.       }

Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InterProcedural

[alias/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InterProcedural.java)

#### docker

```
infer run -a checkers --eradicate -- javac alias/InterProcedural.java
```

#### output

```
Found 1 issue

alias/InterProcedural.java:21: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `InterProcedural.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 21)
  19.           /* unsafe: make object null via alias */
  20.           InterProcedural alias = aliasOf(original);
  21. >         alias.o = null;
  22.           System.out.println(original.o.toString());
  23.       }

Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethod

[alias/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectMethod.java)

#### docker

```
infer run -a checkers --eradicate -- javac alias/ReflectMethod.java
```

#### output

```
Found 1 issue

alias/ReflectMethod.java:25: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `ReflectMethod.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 25)
  23.           Method m = C.getDeclaredMethod("aliasOf", Object.class);
  24.           ReflectMethod alias = (ReflectMethod) m.invoke(new ReflectMethod(), original);
  25. >         alias.o = null;
  26.           System.out.println(original.o.toString());
  27.       }

Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethodOverload

[alias/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectMethodOverload.java)

#### docker

```
infer run -a checkers --eradicate -- javac alias/ReflectMethodOverload.java
```

#### output

```
Found 1 issue

alias/ReflectMethodOverload.java:26: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `ReflectMethodOverload.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 26)
  24.           ReflectMethodOverload alias =
  25.                   (ReflectMethodOverload) m.invoke(new ReflectMethodOverload(), original, 1);
  26. >         alias.o = null;
  27.           System.out.println(original.o.toString());
  28.       }

Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectFieldAccess

[//]: [alias/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectFieldAccess.java)

This language feature is not applicable to the checker being tested.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | N/A |

## InvokeDynamicVirtual

[alias/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicVirtual.java)

#### docker

```
infer run -a checkers --eradicate -- javac alias/InvokeDynamicVirtual.java
```

#### output

```
Found 1 issue

alias/InvokeDynamicVirtual.java:29: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `InvokeDynamicVirtual.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 29)
  27.           InvokeDynamicVirtual alias =
  28.                   (InvokeDynamicVirtual) h.invoke(new InvokeDynamicVirtual(), original);
  29. >         alias.o = null;
  30.           System.out.println(original.o.toString());
  31.       }

Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[alias/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicConstructor.java)

#### docker

```
infer run -a checkers --eradicate -- javac alias/InvokeDynamicConstructor.java
```

#### output

```
Found 1 issue

alias/InvokeDynamicConstructor.java:31: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `InvokeDynamicConstructor.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 31)
  29.           /* unsafe: make object null via alias */
  30.           InvokeDynamicConstructor alias = original;
  31. >         alias.o = null;
  32.           System.out.println(original.o.toString());
  33.       }

Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[//]: [alias/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicField.java)

This language feature is not applicable to the checker being tested.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | N/A |

## DynamicProxy

[//]: [alias/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/DynamicProxy.java)

This language feature is not applicable to the checker being tested.

#### docker

```
N/A
```

#### output

```
N/A
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | N/A |
