# checker framework results (init)

Version: checker-framework-2.1.11

Init checking is part of the Nullness Checker. To run the Nullness Checker, supply the `-processor org.checkerframework.checker.nullness.NullnessChecker` command-line option to javac.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

### summary

| feature | result |
| --- | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InterProcedural) |
| ReflectMethod | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#ReflectMethod) |
| ReflectMethodOverload | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#ReflectMethodOverload) |
| ReflectFieldAccess | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InvokeDynamicField) |
| DynamicProxy | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#DynamicProxy) |

> Select results for detail.

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/IntraProcedural.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/IntraProcedural.java
```

#### output

```
checker/init/IntraProcedural.java:16: error: [dereference.of.nullable] dereference of possibly-null reference this.o
        System.out.println(this.o.toString());
                               ^
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## InterProcedural

[init/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InterProcedural.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/InterProcedural.java
```

#### output

```
checker/init/InterProcedural.java:17: error: [method.invocation.invalid] call to m() not allowed on the given receiver.
        m();
         ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull InterProcedural
  required: @Initialized @NonNull InterProcedural
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/ReflectMethod.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/ReflectMethod.java
```

#### output

```
checker/init/ReflectMethod.java:14: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this);
                 ^
  found   : @UnderInitialization(checker.init.ReflectMethod.class) @NonNull ReflectMethod
  required: @Initialized @NonNull Object
checker/init/ReflectMethod.java:17: error: [initialization.fields.uninitialized] the constructor does not initialize fields: o
    ReflectMethod(Method m, int x) throws Exception {
    ^
checker/init/ReflectMethod.java:18: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this);
                 ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull ReflectMethod
  required: @Initialized @NonNull Object
3 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

## ReflectMethodOverload

[init/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/ReflectMethodOverload.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/ReflectMethodOverload.java
```

#### output

```
checker/init/ReflectMethodOverload.java:16: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this, 1);
                 ^
  found   : @UnderInitialization(checker.init.ReflectMethodOverload.class) @NonNull ReflectMethodOverload
  required: @Initialized @NonNull Object
checker/init/ReflectMethodOverload.java:19: error: [initialization.fields.uninitialized] the constructor does not initialize fields: o
    ReflectMethodOverload(int x) throws Exception {
    ^
checker/init/ReflectMethodOverload.java:22: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this, 1);
                 ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull ReflectMethodOverload
  required: @Initialized @NonNull Object
3 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

## ReflectFieldAccess

[init/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/ReflectFieldAccess.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/ReflectFieldAccess.java
```

#### output

````
checker/init/ReflectFieldAccess.java:16: error: [dereference.of.nullable] dereference of possibly-null reference this.o
        System.out.println(this.o.toString());
                               ^
checker/init/ReflectFieldAccess.java:23: error: [dereference.of.nullable] dereference of possibly-null reference this.o
        System.out.println(this.o.toString());
                               ^
2 errors
````

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

## InvokeDynamicVirtual

[init/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InvokeDynamicVirtual.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/InvokeDynamicVirtual.java
```

#### output

```

```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | xxx |

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InvokeDynamicConstructor.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/InvokeDynamicConstructor.java
```

#### output

```

```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | xxx |

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/InvokeDynamicField.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/InvokeDynamicField.java
```

#### output

```

```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | xxx |

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/DynamicProxy.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/DynamicProxy.java
```

#### output

```

```

| false negative | false positive | result |
| :---: | :---: | :---: |
| - | - | xxx |