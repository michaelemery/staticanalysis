# checker framework

Version: checker-framework-2.1.11

## usage

### checkers used (fqn)

1. org.checkerframework.checker.nullness.NullnessChecker (checking for initialisation)

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
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InterProcedural) |
| ReflectMethod | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#ReflectMethod) |
| ReflectMethodOverload | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#ReflectMethodOverload) |
| ReflectFieldAccess | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InvokeDynamicField) |
| DynamicProxy | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#DynamicProxy) |

> Select results for detail.

### IntraProcedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/IntraProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/IntraProcedural.java
```

#### output

```
/Users/michaelemery/Developer/intellij/staticanalysis/src/checker/init/IntraProcedural.java:16: error: [initialization.fields.uninitialized] the constructor does not initialize fields: o
    public IntraProcedural(int x) {
           ^
/Users/michaelemery/Developer/intellij/staticanalysis/src/checker/init/IntraProcedural.java:20: error: [dereference.of.nullable] dereference of possibly-null reference this.o
        this.o.toString();
            ^
2 errors
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

### InterProcedural

[nullness/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InterProcedural.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/InterProcedural.java
```

#### output

```
/Users/michaelemery/Developer/intellij/staticanalysis/src/checker/init/InterProcedural.java:16: error: [method.invocation.invalid] call to m() not allowed on the given receiver.
        m();
         ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull InterProcedural
  required: @Initialized @NonNull InterProcedural
1 error
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

### ReflectMethod

[nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/ReflectMethod.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/ReflectMethod.java
```

#### output

```
src/checker/init/ReflectMethod.java:13: error: [dereference.of.nullable] dereference of possibly-null reference this.o
        System.out.println(this.o.toString());
                               ^
src/checker/init/ReflectMethod.java:20: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this);
                 ^
  found   : @UnderInitialization(checker.init.ReflectMethod.class) @NonNull ReflectMethod
  required: @Initialized @NonNull Object
src/checker/init/ReflectMethod.java:23: error: [initialization.fields.uninitialized] the constructor does not initialize fields: o
    ReflectMethod(int x, int y) throws Exception {
    ^
src/checker/init/ReflectMethod.java:26: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this);
                 ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull ReflectMethod
  required: @Initialized @NonNull Object
4 errors
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

### ReflectMethodOverload

[nullness/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/ReflectMethodOverload.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/ReflectMethodOverload.java
```

#### output

```
checker/init/ReflectMethodOverload.java:13: error: [dereference.of.nullable] dereference of possibly-null reference this.o
        System.out.println(this.o.toString());
                               ^
checker/init/ReflectMethodOverload.java:20: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this, 1);
                 ^
  found   : @UnderInitialization(checker.init.ReflectMethodOverload.class) @NonNull ReflectMethodOverload
  required: @Initialized @NonNull Object
checker/init/ReflectMethodOverload.java:23: error: [initialization.fields.uninitialized] the constructor does not initialize fields: o
    ReflectMethodOverload(int x, int y) throws Exception {
    ^
checker/init/ReflectMethodOverload.java:26: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this, 1);
                 ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull ReflectMethodOverload
  required: @Initialized @NonNull Object
4 errors
```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

### ReflectFieldAccess

[nullness/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/ReflectFieldAccess.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/ReflectFieldAccess.java
```

#### output

````

````

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| - | - | xxx |


### InvokeDynamicVirtual

[nullness/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InvokeDynamicVirtual.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/InvokeDynamicVirtual.java
```

#### output

```

```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| - | - | xxx |

### InvokeDynamicConstructor

[nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InvokeDynamicConstructor.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/InvokeDynamicConstructor.java
```

#### output

```

```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| - | - | xxx |

### InvokeDynamicField

[nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InvokeDynamicField.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/InvokeDynamicField.java
```

#### output

```

```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| - | - | xxx |

### DynamicProxy

[nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/DynamicProxy.java)

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/DynamicProxy.java
```

#### output

```

```

| False Neg | False Pos | Result |
| :---: | :---: | :---: |
| - | - | xxx |
