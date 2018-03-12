# infer

Version: tbc

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
| Vanilla | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#vanilla) |
| Interprocedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#interprocedural) |
| IntraproceduralMethodInvocation | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#intraproceduralmethodinvocation) |
| InterproceduralMethodInvocation | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#interproceduralmethodinvocation) |
| InterproceduralOverloadInvocation | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#interproceduraloverloadinvocation) |
| IntraproceduralMethodHandle | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#intraproceduralmethodhandle) |
| IntraproceduralReflectiveFieldAccess | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#intraproceduralreflectivefieldaccess) |
| InterproceduralReflectiveFieldAccess | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#interproceduralreflectivefieldaccess) |
| InvokeDynamic | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#invokedynamic) |
| Proxy | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#proxy) |

> Select results for detail.

### Vanilla

[nullness/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java)

```
infer run -a checkers --eradicate -- javac nullness/Vanilla.java
```

#### output

```
Found 1 issue

nullness/Vanilla.java:17: error: ERADICATE_NULL_METHOD_CALL
  The value of `s` in the call to `toString()` could be null. (Origin: null constant at line 16)
  15.           // intraprocedural assignment of a null reference (fail)
  16.           s = null;
  17. >         System.out.println(s.toString());  // NullPointerException
  18.       }

Summary of the reports

  ERADICATE_NULL_METHOD_CALL: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### Interprocedural

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Interprocedural.java)

```
infer run -a checkers --eradicate -- javac nullness/Interprocedural.java
```

#### output

```
Found 1 issue

nullness/Interprocedural.java:16: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `returnReceivedString(...)` needs a non-null value in parameter 1 but argument `null` can be 
  null. (Origin: null constant at line 16)
  14.   
  15.           // interprocedural assignment of a null reference (fail)
  16. >         s = returnReceivedString(null);
  17.           System.out.println(s.toString());  // NullPointerException
  18.   

Summary of the reports

  ERADICATE_PARAMETER_NOT_NULLABLE: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### IntraproceduralMethodInvocation

[nullness/IntraproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralMethodInvocation.java)

```
infer run -a checkers --eradicate -- javac nullness/IntraproceduralMethodInvocation.java
```

#### output

```
Found 1 issue

nullness/IntraproceduralMethodInvocation.java:30: error: ERADICATE_RETURN_NOT_NULLABLE
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

### InterproceduralMethodInvocation

[nullness/InterproceduralMethodInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralMethodInvocation.java)

```
infer run -a checkers --eradicate -- javac nullness/InterproceduralMethodInvocation.java
```

#### output

```
nullness/InterproceduralMethodInvocation.java:26: 
Found 1 issue

nullness/InterproceduralMethodInvocation.java:33: error: ERADICATE_RETURN_NOT_NULLABLE
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

### InterproceduralOverloadInvocation

[nullness/InterproceduralOverloadInvocation.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralOverloadInvocation.java)

```
infer run -a checkers --eradicate -- javac nullness/InterproceduralOverloadInvocation.java
```

#### output

````
Found 1 issue

nullness/InterproceduralOverloadInvocation.java:30: error: ERADICATE_RETURN_NOT_NULLABLE
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

### IntraproceduralMethodHandle

[nullness/IntraproceduralMethodHandle.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralMethodHandle.java)

```
infer run -a checkers --eradicate -- javac nullness/IntraproceduralMethodHandle.java
```

#### output

```
Found 1 issue

nullness/IntraproceduralMethodHandle.java:4: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `Message.s` is not initialized in the constructor and is not declared `@Nullable`
  2.   import java.lang.invoke.MethodHandles;
  3.   
  4. > class Message {
  5.       String s;
  6.   }

Summary of the reports

  ERADICATE_FIELD_NOT_INITIALIZED: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### IntraproceduralReflectiveFieldAccess

[nullness/IntraproceduralReflectiveFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraproceduralReflectiveFieldAccess.java)

```
infer run -a checkers --eradicate -- javac nullness/IntraproceduralReflectiveFieldAccess.java
```

#### output

```
Found 1 issue

nullness/IntraproceduralReflectiveFieldAccess.java:8: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `IntraproceduralReflectiveFieldAccess.bar` is not initialized in the constructor and is 
  not declared `@Nullable`
  6.    * Assignment of a null reference to a field accessed *intraprocedurally* via reflection.
  7.    */
  8. > public class IntraproceduralReflectiveFieldAccess {
  9.       public String bar;
  10.   

Summary of the reports

  ERADICATE_FIELD_NOT_INITIALIZED: 1
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### InterproceduralReflectiveFieldAccess

[nullness/InterproceduralReflectiveFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterproceduralReflectiveFieldAccess.java)

```
infer run -a checkers --eradicate -- javac nullness/InterproceduralReflectiveFieldAccess.java
```

#### output

```
TBC
```

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