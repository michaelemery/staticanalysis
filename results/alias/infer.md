# infer results (alias)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: 0.13.1

Infer does not have a checker to detect an alias.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[alias/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/IntraProcedural.java)

#### checker command

```
infer run -a checkers --eradicate -- javac alias/IntraProcedural.java
```

#### checker output

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

#### checker command

```
infer run -a checkers --eradicate -- javac alias/InterProcedural.java
```

#### checker output

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

#### checker command

```
infer run -a checkers --eradicate -- javac alias/ReflectMethod.java
```

#### checker output

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

## ReflectConstructor

[alias/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectConstructor.java)

#### checker command

```
infer run -a checkers --eradicate -- javac alias/ReflectConstructor.java
```

#### checker output

```
Found 1 issue

alias/ReflectConstructor.java:26: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `ReflectConstructor.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 26)
  24.           ReflectConstructor alias =
  25.                   (ReflectConstructor) m.invoke(new ReflectConstructor(), original, 1);
  26. >         alias.o = null;
  27.           System.out.println(original.o.toString());
  28.       }

Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectField

[//]: [alias/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/ReflectField.java)

This language feature is not applicable to the checker being tested.

#### checker command

```
NA
```

#### checker output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## InvokeDynamicMethod

[alias/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/InvokeDynamicMethod.java)

#### checker command

```
infer run -a checkers --eradicate -- javac alias/InvokeDynamicMethod.java
```

#### checker output

```
Found 1 issue

alias/InvokeDynamicMethod.java:29: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `InvokeDynamicMethod.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 29)
  27.           InvokeDynamicMethod alias =
  28.                   (InvokeDynamicMethod) h.invoke(new InvokeDynamicMethod(), original);
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

#### checker command

```
infer run -a checkers --eradicate -- javac alias/InvokeDynamicConstructor.java
```

#### checker output

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

#### checker command

```
NA
```

#### checker output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |

## DynamicProxy

[//]: [alias/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/alias/DynamicProxy.java)

This language feature is not applicable to the checker being tested.

#### checker command

```
NA
```

#### checker output

```
NA
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | NA |
