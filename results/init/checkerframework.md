# checker framework results (init)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Init checking is part of the Nullness Checker. To run the Nullness Checker, supply the `-processor org.checkerframework.checker.nullness.NullnessChecker` command-line option to javac.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

Version: checker-framework-2.1.11

<br>

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/init/IntraProcedural.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker init/IntraProcedural.java
```

#### output

```
init/IntraProcedural.java:16: error: [dereference.of.nullable] dereference of possibly-null reference this.o
        System.out.println(this.o.toString());
                               ^
1 error
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## InterProcedural

[init/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InterProcedural.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker init/InterProcedural.java
```

#### output

```
init/InterProcedural.java:17: error: [method.invocation.invalid] call to m() not allowed on the given receiver.
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

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectMethod.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker init/ReflectMethod.java
```

#### output

```
init/ReflectMethod.java:14: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this);
                 ^
  found   : @UnderInitialization(checker.init.ReflectMethod.class) @NonNull ReflectMethod
  required: @Initialized @NonNull Object
init/ReflectMethod.java:17: error: [initialization.fields.uninitialized] the constructor does not initialize fields: o
    ReflectMethod(Method m, int x) throws Exception {
    ^
init/ReflectMethod.java:18: error: [argument.type.incompatible] incompatible types in argument.
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

[init/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectMethodOverload.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker init/ReflectMethodOverload.java
```

#### output

```
init/ReflectMethodOverload.java:16: error: [argument.type.incompatible] incompatible types in argument.
        m.invoke(this, 1);
                 ^
  found   : @UnderInitialization(checker.init.ReflectMethodOverload.class) @NonNull ReflectMethodOverload
  required: @Initialized @NonNull Object
init/ReflectMethodOverload.java:19: error: [initialization.fields.uninitialized] the constructor does not initialize fields: o
    ReflectMethodOverload(int x) throws Exception {
    ^
init/ReflectMethodOverload.java:22: error: [argument.type.incompatible] incompatible types in argument.
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

[init/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectFieldAccess.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker init/ReflectFieldAccess.java
```

#### output

````
init/ReflectFieldAccess.java:16: error: [dereference.of.nullable] dereference of possibly-null reference this.o
        System.out.println(this.o.toString());
                               ^
init/ReflectFieldAccess.java:23: error: [dereference.of.nullable] dereference of possibly-null reference this.o
        System.out.println(this.o.toString());
                               ^
2 errors
````

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

## InvokeDynamicVirtual

[init/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicVirtual.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker init/InvokeDynamicVirtual.java
```

#### output

```
init/InvokeDynamicVirtual.java:16: error: [argument.type.incompatible] incompatible types in argument.
        h.invoke(this, "safe");
                 ^
  found   : @UnderInitialization(init.InvokeDynamicVirtual.class) @NonNull InvokeDynamicVirtual
  required: @Initialized @NonNull InvokeDynamicVirtual
init/InvokeDynamicVirtual.java:21: error: [argument.type.incompatible] incompatible types in argument.
        h.invoke(this, null);
                 ^
  found   : @UnderInitialization(init.InvokeDynamicVirtual.class) @NonNull InvokeDynamicVirtual
  required: @Initialized @NonNull InvokeDynamicVirtual
2 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicConstructor.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker init/InvokeDynamicConstructor.java
```

#### output

```
No rpeorted issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicField.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker init/InvokeDynamicField.java
```

#### output

```
init/InvokeDynamicField.java:15: error: [argument.type.incompatible] incompatible types in argument.
        h.invoke(this, "safe");
                 ^
  found   : @UnderInitialization(init.InvokeDynamicField.class) @NonNull InvokeDynamicField
  required: @Initialized @NonNull InvokeDynamicField
init/InvokeDynamicField.java:21: error: [argument.type.incompatible] incompatible types in argument.
        h.invoke(this, null);
                 ^
  found   : @UnderInitialization(init.InvokeDynamicField.class) @NonNull InvokeDynamicField
  required: @Initialized @NonNull InvokeDynamicField
2 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 1 | imprecise |

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/init/DynamicProxy.java)

#### docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker init/DynamicProxy.java
```

#### output

```
init/DynamicProxy.java:18: error: [argument.type.incompatible] incompatible types in argument.
        this.o = proxyInstance.get(null);
                                   ^
  found   : null
  required: @Initialized @NonNull Object
init/DynamicProxy.java:31: error: [argument.type.incompatible] incompatible types in argument.
                Foo.class.getClassLoader(),
                                        ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
2 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 1 | imprecise |
