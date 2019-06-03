# checker framework

Version: checker-framework-2.1.11

## usage

### checkers used (fqn)

1. org.checkerframework.checker.nullness.NullnessChecker

### qualifiers

The nullness hierarchy contains these qualifiers:

| qualifier | description |
| --- | --- |
| @Nullable | Indicates a type that includes the null value. For example, the type Boolean is nullable: a variable of type Boolean always has one of the values TRUE, FALSE, or null. |
| @NonNull *(default)*| Indicates a type that does not include the null value. The type boolean is non-null; a variable of type boolean always has one of the values true or false. The type @NonNull Boolean is also non-null: a variable of type @NonNull Boolean always has one of the values TRUE or FALSE — never null. Dereferencing an expression of non-null type can never cause a null pointer exception. |

> The default state of any object in Checker Framework is *@NonNull*.

### annotations

The Nullness Checker supports several annotations that specify method behavior. These are 
declaration annotations, not type annotations as they apply to the method itself rather than to 
some particular type:

| annotation | description |
| --- | --- |
| @RequiresNonNull | Indicates a method precondition: The annotated method expects the specified variables (typically field references) to be non-null when the method is invoked. |
| @EnsuresNonNull | |
| @EnsuresNonNullIf | Indicates a method postcondition. With @EnsuresNonNull, the given expressions are non-null after the method returns; this is useful for a method that initializes a field, for example. With @EnsuresNonNullIf, if the annotated method returns the given boolean value (true or false), then the given expressions are non-null. |

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#IntraProcedural) |
| InterProcedural | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InterProcedural) |
| ReflectMethodInvoke | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectMethodInvoke) |
| ReflectOverloadInvoke | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectOverloadInvoke) |
| ReflectFieldAccess | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicField) |
| DynamicProxy | [xxc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#DynamicProxy) |

> Select results for detail.

### IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/IntraProcedural.java
```

#### output

```
nullness/IntraProcedural.java:22: error: [assignment.type.incompatible] incompatible types in assignment.
        i.o = null;
              ^
  found   : null
  required: @Initialized @NonNull Object
1 error
```

| True Pos | False Pos | False Neg | Result |
| :---: | :---: | :---: | :---: |
| 1 | 0 | 0 | accurate |

### InterProcedural

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InterProcedural.java
```

#### output

```
nullness/InterProcedural.java:16: 
error: [argument.type.incompatible] incompatible types in argument.
        s = returnReceivedString(null);
                                 ^
  found   : null
  required: @Initialized @NonNull String
  
1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### ReflectMethodInvoke

[nullness/ReflectMethodInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectMethodInvoke.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectMethodInvoke.java
```

#### output

```
nullness/ReflectMethodInvoke.java:18: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // "text"
                           ^

nullness/ReflectMethodInvoke.java:23: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

nullness/ReflectMethodInvoke.java:31: 
error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

3 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

### ReflectOverloadInvoke

[nullness/ReflectOverloadInvoke.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvoke.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectOverloadInvoke.java
```

#### output

```
nullness/ReflectOverloadInvoke.java:26: 
error: [return.type.incompatible] incompatible types in return.
        return s;
               ^
  found   : @Initialized @Nullable String
  required: @Initialized @NonNull String

nullness/ReflectOverloadInvoke.java:34: 
error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

2 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### ReflectOverloadInvokeInterProcedural

[nullness/ReflectOverloadInvokeInterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverloadInvokeInterProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectOverloadInvokeInterProcedural.java
```

#### output

````
nullness/ReflectOverloadInvokeInterProcedural.java:18: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // "text"
                           ^

nullness/ReflectOverloadInvokeInterProcedural.java:23: 
error: [dereference.of.nullable] dereference of possibly-null reference s
        System.out.println(s.toString());  // NullPointerException
                           ^

nullness/ReflectOverloadInvokeInterProcedural.java:31: error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull String

3 errors
````

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

### ReflectFieldAccessIntraProcedural

[nullness/ReflectFieldAccessIntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectFieldAccessIntraProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/ReflectFieldAccessIntraProcedural.java
```

#### output

```
nullness/ReflectFieldAccessIntraProcedural.java:4: 
error: [initialization.fields.uninitialized] the constructor does not initialize fields: s
class Message {
^

1 error
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 1 |

### DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/DynamicProxy.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/DynamicProxy.java
```

#### output

```
nullness/DynamicProxy.java:19: 
error: [argument.type.incompatible] incompatible types in argument.
        proxy = (MyInterface) Proxy.newProxyInstance(clLoader, 
                                                     ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader

nullness/DynamicProxy.java:48: error: [override.return.invalid] 
@Initialized @Nullable Object invoke(
        @Initialized @NonNull UnsafeInvocationHandler this, 
        @Initialized @NonNull Object p0, @Initialized @NonNull Method p1, 
        @Initialized @NonNull Object @Initialized @NonNull [] p2
        ) throws @Initialized @NonNull Throwable in nullness.DynamicProxy.UnsafeInvocationHandler cannot override 
@Initialized @NonNull Object invoke(
        @Initialized @NonNull InvocationHandler this, 
        @Initialized @NonNull Object p0, 
        @Initialized @NonNull Method p1,
        @Initialized @NonNull Object @Initialized @NonNull [] p2
        ) throws @Initialized @NonNull Throwable in java.lang.reflect.InvocationHandler; 
attempting to use an incompatible return type
        public @Nullable Object invoke(Object obj, Method m, Object[] arg) throws Throwable {
                         ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object

2 errors
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

### InvokeDynamic

[nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamic.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InvokeDynamic.java
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

### InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InvokeDynamicField.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker nullness/InvokeDynamicField.java
```
