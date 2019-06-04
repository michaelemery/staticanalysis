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
| InterProcedural | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#InterProcedural) |
| ReflectMethodInvoke | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#ReflectMethodInvoke) |
| ReflectOverloadInvoke | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#ReflectOverloadInvoke) |
| ReflectFieldAccess | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectoverloadinvoke) |
| InvokeDynamicVirtual | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectmethodhandle) |
| InvokeDynamicConstructor | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectfieldaccess) |
| InvokeDynamicField | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectfieldaccess) |
| DynamicProxy | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#dynamicproxy) |

> Select results for detail.

### IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/IntraProcedural.java
```

#### output

```
Found 3 issues

checker/nullness/IntraProcedural.java:22: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `IntraProcedural.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 22).
  20.   
  21.           /* unsafe: set object to null */
  22. >         i.o = null;
  23.           System.out.println(i.o.toString());  // NullPointerException
  24.       }

checker/nullness/IntraProcedural.java:23: error: ERADICATE_NULL_METHOD_CALL
  The value of `i.o` in the call to `toString()` could be null. (Origin: null constant at line 22).
  21.           /* unsafe: set object to null */
  22.           i.o = null;
  23. >         System.out.println(i.o.toString());  // NullPointerException
  24.       }
  25.   }

checker/nullness/IntraProcedural.java:23: error: NULL_DEREFERENCE
  object `i.o` last assigned on line 22 could be null and is dereferenced at line 23.
  21.           /* unsafe: set object to null */
  22.           i.o = null;
  23. >         System.out.println(i.o.toString());  // NullPointerException
  24.       }
  25.   }


Summary of the reports

    ERADICATE_NULL_METHOD_CALL: 1
              NULL_DEREFERENCE: 1
  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 3 | 0 | 0 | accurate |

### InterProcedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/InterProcedural.java
```

#### output

```
Found 3 issues

checker/nullness/InterProcedural.java:19: error: NULL_DEREFERENCE
  object `i.o` last assigned on line 18 could be null and is dereferenced at line 19.
  17.           /* safe: set object to non-null */
  18.           i.set(true);
  19. >         System.out.println(i.o.toString());  // safe
  20.   
  21.           /* unsafe: set object to null */

checker/nullness/InterProcedural.java:23: error: NULL_DEREFERENCE
  object `i.o` last assigned on line 22 could be null and is dereferenced at line 23.
  21.           /* unsafe: set object to null */
  22.           i.set(false);
  23. >         System.out.println(i.o.toString());  // NullPointerException
  24.       }
  25.   

checker/nullness/InterProcedural.java:27: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `InterProcedural.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 27).
  25.   
  26.       public void set(Boolean safe) {
  27. >         this.o = safe ? "safe" : null;
  28.       }
  29.   }


Summary of the reports

              NULL_DEREFERENCE: 2
  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 2 | 1 | 0 | imprecise |

### ReflectMethodInvoke

[nullness/ReflectMethodInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvoke.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/ReflectMethodInvoke.java
```

#### output

```
Found 1 issue

checker/nullness/ReflectMethodInvoke.java:31: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `ReflectMethodInvoke.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 31).
  29.   
  30.       public void set(Boolean safe) {
  31. >         this.o = safe ? "safe" : null;
  32.       }
  33.   }


Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 1 | 0 | 0 | accurate |

### ReflectOverloadInvoke

[nullness/ReflectOverloadInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvoke.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/ReflectOverloadInvoke.java
```

### output

```
Found 1 issue

checker/nullness/ReflectOverloadInvoke.java:36: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `ReflectOverloadInvoke.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 36).
  34.   
  35.       void set() {
  36. >         this.o = null;
  37.       }
  38.   }


Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 1 | 0 | 0 | accurate |

### ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccess.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/ReflectFieldAccess.java
```

#### output

````
No reported issues.

````

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |

### InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicVirtual.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/InvokeDynamicVirtual.java
```

#### output

```
Found 1 issue

checker/nullness/InvokeDynamicVirtual.java:34: error: ERADICATE_FIELD_NOT_NULLABLE
  Field `InvokeDynamicVirtual.o` can be null but is not declared `@Nullable`. (Origin: null constant at line 34).
  32.   
  33.       void set(Boolean safe) {
  34. >         this.o = safe ? "safe" : null;
  35.       }
  36.   }


Summary of the reports

  ERADICATE_FIELD_NOT_NULLABLE: 1
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 1 | 0 | 0 | accurate |

### InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicConstructor.java)

```
infer run -a checkers --eradicate -- javac checker/nullness/InvokeDynamicConstructor.java
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
infer run -a checkers --eradicate -- javac checker/nullness/InvokeDynamicField.java
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
infer run -a checkers --eradicate -- javac checker/nullness/DynamicProxy.java
```

#### output

```
No reported issues.
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 0 | 0 | 0 | unsound |
