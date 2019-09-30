# spotbugs results (nullness)

[results](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)

<br>

Version: spotbugs-3.1.12

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

* [nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/IntraProcedural.java)

* [nullness/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/IntraProceduralTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/IntraProcedural.java
spotbugs -effort:max out/nullness/IntraProcedural.class
```

#### checker output

```
H C NP: Null pointer dereference of IntraProcedural.foo in nullness.IntraProcedural.setFooToNull()  Dereferenced at IntraProcedural.java:[line 26]
M D UC: Useless object stored in variable var$0 of method nullness.IntraProcedural.setFooToNonNull()  At IntraProcedural.java:[line 14]
M D UC: Useless object stored in variable var$0 of method nullness.IntraProcedural.setFooToNull()  At IntraProcedural.java:[line 24]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 16]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 26]
Warnings generated: 5
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 26i | TP |
| 14, 24, 16, 26ii | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

> accurate

<br>

## InterProcedural

* [nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InterProcedural.java)

* [nullness/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InterProceduralTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/InterProcedural.java
spotbugs -effort:max out/nullness/InterProcedural.class
```

#### checker output

```
M D UC: Useless object stored in variable var$0 of method nullness.InterProcedural.setFooToNull()  At InterProcedural.java:[line 28]
M D UC: Useless object stored in variable var$0 of method nullness.InterProcedural.setFooToNonNull()  At InterProcedural.java:[line 18]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 20]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 30]
Warnings generated: 4
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 28, 18, 20, 30 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## ReflectConstructor

* [nullness/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectConstructor.java)

* [nullness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectConstructorTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/ReflectConstructor.java
spotbugs -effort:max out/nullness/ReflectConstructor.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectConstructor.java:[line 25]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectConstructor.java:[line 33]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 25, 33 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## ReflectMethod

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectMethodTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/ReflectMethod.java
spotbugs -effort:max out/nullness/ReflectMethod.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectMethod.java:[line 24]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectMethod.java:[line 35]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 24, 35 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectFieldTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/ReflectField.java
spotbugs -effort:max out/nullness/ReflectField.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectField.java:[line 16]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectField.java:[line 25]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16, 25 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## MethodHandleConstructor

* [nullness/MethodHandleConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleConstructor.java)

* [nullness/MethodHandleConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleConstructorTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/MethodHandleConstructor.java
spotbugs -effort:max out/nullness/MethodHandleConstructor.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At MethodHandleConstructor.java:[line 30]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At MethodHandleConstructor.java:[line 40]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 30, 40 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## MethodHandleMethod

* [nullness/MethodHandleMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleMethod.java)

* [nullness/MethodHandleMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleMethodTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/MethodHandleMethod.java
spotbugs -effort:max out/nullness/MethodHandleMethod.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At MethodHandleMethod.java:[line 29]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At MethodHandleMethod.java:[line 39]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 29, 39 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## MethodHandleField

* [nullness/MethodHandleField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/MethodHandleField.java)

* [nullness/MethodHandleFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/MethodHandleFieldTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/MethodHandleField.java
spotbugs -effort:max out/nullness/MethodHandleField.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At MethodHandleField.java:[line 28]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At MethodHandleField.java:[line 38]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 28, 38 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## InvokeDynamic

* [nullness/InvokeDynamic.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamic.java)

* [nullness/InvokeDynamicTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/InvokeDynamic.java
spotbugs -effort:max out/nullness/InvokeDynamic.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamic.java:[line 21]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamic.java:[line 32]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 21, 32 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## DynamicProxy

* [nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/DynamicProxyTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/DynamicProxy.java
spotbugs -effort:max out/nullness/DynamicProxy.class nullness.DynamicProxy$MyInvocationHandler
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At DynamicProxy.java:[line 44]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At DynamicProxy.java:[line 54]
The following classes needed for analysis were missing:
  nullness.DynamicProxy$MyInvocationHandler
  nullness.DynamicProxy$MyInterface
  nullness.DynamicProxy$MyClass
Warnings generated: 2
Missing classes: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 44, 54 | NA |
| Missing classes | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound

<br>

## UnsafeField

* [nullness/UnsafeField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/UnsafeField.java)

* [nullness/UnsafeFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/UnsafeFieldTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/UnsafeField.java
spotbugs -effort:max out/nullness/UnsafeField.class
```

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
| - | 0 | 1 |

> unsound

<br>

## UnsafeInitialisation

* [nullness/UnsafeInitialisation.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/UnsafeInitialisation.java)

* [nullness/UnsafeInitialisationTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/UnsafeInitialisationTest.java)

#### checker command

```shell script
javac -d out/ src/nullness/UnsafeInitialisation.java
spotbugs -effort:max out/nullness/UnsafeInitialisation.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At UnsafeInitialisation.java:[line 26]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At UnsafeInitialisation.java:[line 36]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 26, 36 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 0 | 1 |

> unsound
