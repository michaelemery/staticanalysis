# pmd results (nullness)

[results](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)

<br>

Version: pmd-6.1.0

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

#### pull docker container and run interactive instance

```shell script
docker pull michaelemery/staticanalysis
docker run -it --rm michaelemery/staticanalysis
```

#### run junit tests from docker

```shell script
sh test.sh [ [ <package-name> ] | [ <package-name> <class-name> ] ]
```

<br>

## IntraProcedural

* [nullnessJavax/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/IntraProceduralTest.java)

#### checker output
```
src/main/java/nullnessJavax/IntraProcedural.java:24: warning: [NullAway] dereferenced expression foo is @Nullable
        foo.toString();
           ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 24 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## InterProcedural

* [nullnessJavax/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/InterProcedural.java)

* [nullness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/InterProceduralTest.java)

#### checker output
```
src/main/java/nullnessJavax/InterProcedural.java:13: warning: [NullAway] dereferenced expression foo is @Nullable
        foo.toString();
           ^
/src/main/java/nullnessJavax/InterProcedural.java:21: warning: [NullAway] passing @Nullable parameter 'null' where @NonNull is required
        Object foo = getObject(null);
                               ^
src/main/java/nullnessJavax/InterProcedural.java:22: warning: [NullAway] dereferenced expression foo is @Nullable
        foo.toString();
           ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 13 | FP |
| 21, 22 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise

<br>

## ReflectConstructor

* [nullnessJavax/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/ReflectConstructor.java)

* [nullness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectConstructorTest.java)

#### checker output
```
src/main/java/nullnessJavax/ReflectConstructor.java:26: warning: [NullAway] dereferenced expression ((ReflectConstructor)constructor.newInstance(new Object())).foo is @Nullable
        ((ReflectConstructor) constructor.newInstance(new Object())).foo.toString();
                                                                        ^
src/main/java/nullnessJavax/ReflectConstructor.java:34: warning: [NullAway] dereferenced expression ((ReflectConstructor)constructor.newInstance((Object)null)).foo is @Nullable
        ((ReflectConstructor) constructor.newInstance((Object) null)).foo.toString();
                                                                         ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 26 | FP |
| 34 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> imprecise

<br>

## ReflectMethod

* [nullnessJavax/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectMethodTest.java)

#### checker output
```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectField

* [nullnessJavax/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/ReflectFieldTest.java)

#### checker output
```
src/main/java/nullnessJavax/ReflectField.java:17: warning: [NullAway] dereferenced expression i.foo is @Nullable
        i.foo.toString();
             ^
src/main/java/nullnessJavax/ReflectField.java:26: warning: [NullAway] dereferenced expression i.foo is @Nullable
        i.foo.toString();
             ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 17 | FP |
| 26 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## MethodHandleConstructor

* [nullnessJavax/MethodHandleConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/MethodHandleConstructor.java)

* [nullness/MethodHandleConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleConstructorTest.java)

#### checker output
```
src/main/java/nullnessJavax/MethodHandleConstructor.java:31: warning: [NullAway] dereferenced expression i.foo is @Nullable
        i.foo.toString();
             ^
src/main/java/nullnessJavax/MethodHandleConstructor.java:41: warning: [NullAway] dereferenced expression i.foo is @Nullable
        i.foo.toString();
             ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 31 | FP |
| 41 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> imprecise

<br>

## MethodHandleMethod

* [nullnessJavax/MethodHandleMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/MethodHandleMethod.java)

* [nullness/MethodHandleMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleMethodTest.java)

#### checker output
```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## MethodHandleField

* [nullnessJavax/MethodHandleField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/MethodHandleField.java)

* [nullness/MethodHandleFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/MethodHandleFieldTest.java)

#### checker output
```
src/main/java/nullnessJavax/MethodHandleField.java:29: warning: [NullAway] dereferenced expression i.foo is @Nullable
        i.foo.toString();
             ^
src/main/java/nullnessJavax/MethodHandleField.java:39: warning: [NullAway] dereferenced expression i.foo is @Nullable
        i.foo.toString();
             ^

```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 29 | FP |
| 39 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> imprecise

<br>

## InvokeDynamic

* [nullnessJavax/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/InvokeDynamic.java)

* [nullness/InvokeDynamicTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/InvokeDynamicTest.java)

#### checker output
```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 31 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## DynamicProxy

* [nullnessJavax/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/DynamicProxyTest.java)

#### checker output
```
src/main/java/nullnessJavax/DynamicProxy.java:45: warning: [NullAway] dereferenced expression foo is @Nullable
        foo.toString();
           ^
src/main/java/nullnessJavax/DynamicProxy.java:54: warning: [NullAway] passing @Nullable parameter 'null' where @NonNull is required
        Object foo = i.getProxyInstance().getObject(null);
                                                    ^
src/main/java/nullnessJavax/DynamicProxy.java:55: warning: [NullAway] dereferenced expression foo is @Nullable
        foo.toString();
           ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 45 | FP |
| 54, 55 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

> imprecise

<br>

## UnsafeField

* [nullnessJavax/UnsafeField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/UnsafeField.java)

* [nullness/UnsafeFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeFieldTest.java)

#### checker output
```
No reported issues.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## UnsafeInitialisation

* [nullnessJavax/UnsafeInitialisation.java](https://github.com/michaelemery/staticanalysis/blob/master/src/main/java/nullnessJavax/UnsafeInitialisation.java)

* [nullness/UnsafeInitialisationTest.java](https://github.com/michaelemery/staticanalysis/blob/master/src/test/java/nullness/UnsafeInitialisationTest.java)

#### checker output
```
src/main/java/nullnessJavax/UnsafeInitialisation.java:29: warning: [NullAway] dereferenced expression new UnsafeInitialisation().foo is @Nullable
        new UnsafeInitialisation().foo.toString();
                                      ^
src/main/java/nullnessJavax/UnsafeInitialisation.java:40: warning: [NullAway] dereferenced expression i.foo is @Nullable
        i.foo.toString();
             ^
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 29 | FP |
| 40 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> imprecise
