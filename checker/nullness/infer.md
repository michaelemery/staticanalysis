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
| VanillaIntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#vanillaintraprocedural) |
| VanillaInterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#vanillainterprocedural) |
| ReflectMethodInvokeIntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectmethodinvokeintraprocedural) |
| ReflectMethodInvokeInterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectmethodinvokeinterprocedural) |
| ReflectOverloadInvokeInterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectoverloadinvokeinterprocedural) |
| ReflectMethodHandleIntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectmethodhandleintraprocedural) |
| ReflectFieldAccessIntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectfieldaccessintraprocedural) |
| ReflectFieldAccessInterProcedural | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectfieldaccessinterprocedural) |
| InvokeDynamic | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#invokedynamic) |
| Proxy | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#proxy) |

> Select results for detail.

### VanillaIntraProcedural

[nullness/VanillaIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/VanillaIntraProcedural.java)

```
infer run -a checkers --eradicate -- javac nullness/VanillaIntraProcedural.java
```

#### output

```
Found 2 issues

nullness/VanillaIntraProcedural.java:17: error: ERADICATE_NULL_METHOD_CALL
  The value of `s` in the call to `toString()` could be null. (Origin: null constant at line 16).
  15.           // intraprocedural assignment of a null reference (fail)
  16.           s = null;
  17. >         System.out.println(s.toString());  // NullPointerException
  18.       }

nullness/VanillaIntraProcedural.java:17: error: NULL_DEREFERENCE
  object `s` last assigned on line 16 could be null and is dereferenced at line 17.
  15.           // intraprocedural assignment of a null reference (fail)
  16.           s = null;
  17. >         System.out.println(s.toString());  // NullPointerException
  18.       }


Summary of the reports

            NULL_DEREFERENCE: 1
  ERADICATE_NULL_METHOD_CALL: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### VanillaInterProcedural

[nullness/VanillaInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/VanillaInterProcedural.java)

```
infer run -a checkers --eradicate -- javac nullness/VanillaInterProcedural.java
```

#### output

```
Found 2 issues

nullness/VanillaInterProcedural.java:16: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `returnReceivedString(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 16).
  14.   
  15.           // interprocedural assignment of a null reference (fail)
  16. >         s = returnReceivedString(null);
  17.           System.out.println(s.toString());  // NullPointerException
  18.   

nullness/VanillaInterProcedural.java:17: error: NULL_DEREFERENCE
  object `s` last assigned on line 16 could be null and is dereferenced at line 17.
  15.           // interprocedural assignment of a null reference (fail)
  16.           s = returnReceivedString(null);
  17. >         System.out.println(s.toString());  // NullPointerException
  18.   
  19.       }


Summary of the reports

  ERADICATE_PARAMETER_NOT_NULLABLE: 1
                  NULL_DEREFERENCE: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### ReflectMethodInvokeIntraProcedural

[nullness/ReflectMethodInvokeIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvokeIntraProcedural.java)

```
infer run -a checkers --eradicate -- javac nullness/ReflectMethodInvokeIntraProcedural.java
```

#### output

```
Found 1 issue

nullness/ReflectMethodInvokeIntraProcedural.java:30: error: ERADICATE_RETURN_NOT_NULLABLE
  Method `returnNull()` may return null but it is not annotated with `@Nullable`. 
  (Origin: null constant at line 31)
  28.       }
  29.   
  30. >     public static String returnNull() {
  31.           return null;
  32.       }


Summary of the reports

  ERADICATE_RETURN_NOT_NULLABLE: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### ReflectMethodInvokeInterProcedural

[nullness/ReflectMethodInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvokeInterProcedural.java)

```
infer run -a checkers --eradicate -- javac nullness/ReflectMethodInvokeInterProcedural.java
```

#### output

```
nullness/ReflectMethodInvokeInterProcedural.java:26: 
Found 1 issue

nullness/ReflectMethodInvokeInterProcedural.java:33: error: ERADICATE_RETURN_NOT_NULLABLE
  Method `returnNull()` may return null but it is not annotated with `@Nullable`. 
  (Origin: null constant at line 34)
  31.       }
  32.   
  33. >     public static String returnNull() {
  34.           return null;
  35.       }


Summary of the reports

  ERADICATE_RETURN_NOT_NULLABLE: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### ReflectOverloadInvokeInterProcedural

[nullness/ReflectOverloadInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvokeInterProcedural.java)

```
infer run -a checkers --eradicate -- javac nullness/ReflectOverloadInvokeInterProcedural.java
```

#### output

````
Found 1 issue

nullness/ReflectOverloadInvokeInterProcedural.java:30: error: ERADICATE_RETURN_NOT_NULLABLE
  Method `returnText(...)` may return null but it is not annotated with `@Nullable`. (Origin: null constant at line 31)
  28.       }
  29.   
  30. >     public static String returnText(boolean b) {
  31.           return null;
  32.       }


Summary of the reports

  ERADICATE_RETURN_NOT_NULLABLE: 1
````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### ReflectMethodHandleIntraProcedural

[nullness/ReflectMethodHandleIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodHandleIntraProcedural.java)

```
infer run -a checkers --eradicate -- javac nullness/ReflectMethodHandleIntraProcedural.java
```

#### output

```
Found 2 issues

nullness/ReflectMethodHandleIntraProcedural.java:4: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `Message.s` is not initialized in the constructor and is not declared `@Nullable`.
  2.   import java.lang.invoke.MethodHandles;
  3.   
  4. > class Message {
  5.       String s;
  6.   }

nullness/ReflectMethodHandleIntraProcedural.java:27: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `Message.s` can be null but is not declared `@Nullable`. (Origin: null constant at line 27).
  25.           // get field with a null value (fail)
  26.           
  27. >         message.s = null; // null !
  28.           mh = lookup.findGetter(Message.class, "s", String.class);
  29.           s = (String) mh.invoke(message);


Summary of the reports

     ERADICATE_FIELD_NOT_NULLABLE: 1
  ERADICATE_FIELD_NOT_INITIALIZED: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### ReflectFieldAccessIntraProcedural

[nullness/ReflectFieldAccessIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccessIntraProcedural.java)

```
infer run -a checkers --eradicate -- javac nullness/ReflectFieldAccessIntraProcedural.java
```

#### output

```
Found 1 issue

nullness/ReflectFieldAccessIntraProcedural.java:8: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectFieldAccessIntraProcedural.bar` is not initialized in the constructor and is 
  not declared `@Nullable`
  6.    * Assignment of a null reference to a field accessed *intraprocedurally* via reflection.
  7.    */
  8. > public class ReflectFieldAccessIntraProcedural {
  9.       public String bar;
  10.   

Summary of the reports

  ERADICATE_FIELD_NOT_INITIALIZED: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### ReflectFieldAccessInterProcedural

[nullness/ReflectFieldAccessInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccessInterProcedural.java)

```
infer run -a checkers --eradicate -- javac nullness/ReflectFieldAccessInterProcedural.java
```

#### output

```
TBC
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| TBC | TBC | TBC |

### InvokeDynamic

[nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamic.java)

```
infer run -a checkers --eradicate -- javac nullness/InvokeDynamic.java
```

#### output

```
TBC
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| TBC | TBC | TBC |

### Proxy

[nullness/Proxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Proxy.java)

```
infer run -a checkers --eradicate -- javac nullness/Proxy.java
```

#### output

```
TBC
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| TBC | TBC | TBC |

## redundant tests

Tests are considered redundant when prerequisite tests are unsound.

[No Redundant Tests]
