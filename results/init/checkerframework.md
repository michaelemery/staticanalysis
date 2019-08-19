# checker framework results (init)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

#### checker

Version: checker-framework-2.1.11

Init checking is part of the Nullness Checker. To run the Nullness Checker, supply the `-processor org.checkerframework.checker.nullness.NullnessChecker` command-line option to javac.

#### run checker from docker

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

#### run junit tests from docker

```
sh test.sh [ [ package-name ] | [ package-name class-name ] ]
```

* `sh test.sh` will run all tests
* do not include `.class` suffix for class name

<br>

## IntraProcedural

[src/init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

[test/init/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/IntraProceduralTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker src/init/IntraProcedural.java
```

#### checker output

```
src/init/IntraProcedural.java:18: error: [dereference.of.nullable] dereference of possibly-null reference object
        object.toString();
        ^
src/init/IntraProcedural.java:23: error: [dereference.of.nullable] dereference of possibly-null reference object
        object.toString();
        ^
2 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18 | TP |
| 23 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 2 | 0 |
| - | 0 | 1 |

&nbsp; ⟶ &nbsp; accurate

<br>

## InterProcedural

[src/init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

[test/init/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InterProceduralTest.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker src/init/InterProcedural.java
```

#### checker output

```
src/init/InterProcedural.java:18: error: [dereference.of.nullable] dereference of possibly-null reference this.object
        this.object.toString();
            ^
1 error
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

#### result

* accurate

<br>

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker src/init/ReflectMethod.java
```

#### checker output

```
src/init/ReflectMethod.java:15: error: [argument.type.incompatible] incompatible types in argument.
        method.invoke(this);
                      ^
  found   : @UnderInitialization(init.ReflectMethod.class) @NonNull ReflectMethod
  required: @Initialized @NonNull Object
src/init/ReflectMethod.java:19: error: [initialization.fields.uninitialized] the constructor does not initialize fields: object
    ReflectMethod(Method method, int x) throws Exception {
    ^
src/init/ReflectMethod.java:20: error: [argument.type.incompatible] incompatible types in argument.
        method.invoke(this);
                      ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull ReflectMethod
  required: @Initialized @NonNull Object
src/init/ReflectMethod.java:25: error: [argument.type.incompatible] incompatible types in argument.
        method.invoke(this);
                      ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull ReflectMethod
  required: @Initialized @NonNull Object
4 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 15 | FP |
| 19, 20 | TP |
| 25 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 2 | 1 |
| - | 0 | 0 |

#### result

* imprecise

<br>

## ReflectMethodOverload

[init/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethodOverload.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker src/init/ReflectMethodOverload.java
```

#### checker output

```
src/init/ReflectMethodOverload.java:16: error: [assignment.type.incompatible] incompatible types in assignment.
        this.object = method.invoke(this);
                                   ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/init/ReflectMethodOverload.java:16: error: [argument.type.incompatible] incompatible types in argument.
        this.object = method.invoke(this);
                                    ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull ReflectMethodOverload
  required: @Initialized @NonNull Object
src/init/ReflectMethodOverload.java:24: error: [assignment.type.incompatible] incompatible types in assignment.
        this.object = method.invoke(this);
                                   ^
  found   : @Initialized @Nullable Object
  required: @Initialized @NonNull Object
src/init/ReflectMethodOverload.java:24: error: [argument.type.incompatible] incompatible types in argument.
        this.object = method.invoke(this);
                                    ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull ReflectMethodOverload
  required: @Initialized @NonNull Object
src/init/ReflectMethodOverload.java:33: error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull Object
5 errors
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16(i), 16(ii) | FP |
| 24(i), 24(ii) | TP |
| 33 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

#### result

* unsound

<br>

## ReflectFieldAccess

[init/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectFieldAccess.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker src/init/ReflectFieldAccess.java
```

#### checker output

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

<br>

## InvokeDynamicVirtual

[init/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicVirtual.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker src/init/InvokeDynamicVirtual.java
```

#### checker output

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

<br>

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker src/init/InvokeDynamicConstructor.java
```

#### checker output

```
No rpeorted issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

<br>

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicField.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker src/init/InvokeDynamicField.java
```

#### checker output

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
 
<br>

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/DynamicProxy.java)

#### run checker from docker

```
javac -processor org.checkerframework.checker.nullness.NullnessChecker src/init/DynamicProxy.java
```

#### checker output

```
src/init/DynamicProxy.java:18: error: [argument.type.incompatible] incompatible types in argument.
        this.o = proxyInstance.get(null);
                                   ^
  found   : null
  required: @Initialized @NonNull Object
src/init/DynamicProxy.java:30: error: [argument.type.incompatible] incompatible types in argument.
                Foo.class.getClassLoader(),
                                        ^
  found   : @Initialized @Nullable ClassLoader
  required: @Initialized @NonNull ClassLoader
2 errors
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 1 | imprecise |
