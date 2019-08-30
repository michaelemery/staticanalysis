# findbugs results (init)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

#### run checker from docker

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the checker command(s) provided with each test result, and paste them into your interactive Docker session. 

To download/update and run your project Docker container;

```
docker pull michaelemery/staticanalysis
docker run -it --rm michaelemery/staticanalysis
```

#### run junit tests from docker

```
sh test.sh [ [ init ] | [ init <class-name> ] ]
```

* `sh test.sh` will run all tests

<br>

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

[init/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/IntraProceduralTest.java)

#### checker command

```
javac -d out/ src/init/IntraProcedural.java
findbugs out/init/IntraProcedural.class
```

#### checker output

```
M C UR: Uninitialized read of foo in new init.IntraProcedural(Object, int)  At IntraProcedural.java:[line 16]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 16]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 24]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 31]
M D RV: Return value of new IntraProcedural(Object, int) ignored, but method has no side effect  At IntraProcedural.java:[line 38]
Warnings generated: 5
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16(i) | TP |
| 16(ii) | NA |
| 24 | NA |
| 31 | NA |
| 38 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>

## InterProcedural

[init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

[init/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InterProceduralTest.java)

#### checker command

```
javac -d out/ src/init/InterProcedural.java
findbugs out/init/InterProcedural.class
```

#### checker output

```
M C UR: Uninitialized read of foo in new init.InterProcedural(Object, int)  At InterProcedural.java:[line 16]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 16]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 28]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 35]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 42]
Warnings generated: 5
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16(i) | TP |
| 16(ii) | NA |
| 28 | NA |
| 35 | NA |
| 42 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>

## ReflectConstructor

[init/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectConstructor.java)

[init/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectConstructorTest.java)

#### checker command

```
javac -d out/ src/init/ReflectConstructor.java
findbugs out/init/ReflectConstructor.class
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
| 25 | NA |
| 33 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

[init/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectMethodTest.java)

#### checker command

```
javac -d out/ src/init/ReflectMethod.java
findbugs out/init/ReflectMethod.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectMethod.java:[line 26]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectMethod.java:[line 33]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 26 | NA |
| 33 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>

## ReflectField

[init/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectField.java)

[init/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectFieldTest.java)

#### checker command

```
javac -d out/ src/init/ReflectField.java
findbugs out/init/ReflectField.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectField.java:[line 22]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectField.java:[line 29]
M C UwF: Unwritten field: init.ReflectField.foo  At ReflectField.java:[line 22]
M C NP: Read of unwritten field foo in init.ReflectField.setFooToNonNull()  At ReflectField.java:[line 22]
M C NP: Read of unwritten field foo in init.ReflectField.setFooToNull()  At ReflectField.java:[line 29]
Warnings generated: 5
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 22(i) | NA |
| 29 | NA |
| 22(ii) | FP |
| 22(iii) | FP |
| 29 | FP |


#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 3 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

[init/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicConstructorTest.java)

#### checker command

```
javac -d out/ src/init/InvokeDynamicConstructor.java
findbugs out/init/InvokeDynamicConstructor.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicConstructor.java:[line 16]
Warnings generated: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>

## InvokeDynamicMethod

[init/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicMethod.java)

[init/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicMethodTest.java)

#### checker command

```
javac -d out/ src/init/InvokeDynamicMethod.java
findbugs out/init/InvokeDynamicMethod.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicMethod.java:[line 30]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicMethod.java:[line 37]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 30 | NA |
| 37 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicField.java)

[init/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicFieldTest.java)

#### checker command

```
javac -d out/ src/init/InvokeDynamicField.java
findbugs out/init/InvokeDynamicField.class
```

#### checker output

```
M C UR: Uninitialized read of foo in new init.InvokeDynamicField(Object)  At InvokeDynamicField.java:[line 15]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicField.java:[line 15]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 15(i) | FP |
| 15(ii) | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/DynamicProxy.java)

[init/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/DynamicProxyTest.java)

#### checker command

```
javac -d out/ src/init/DynamicProxy.java
findbugs out/init/DynamicProxy.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At DynamicProxy.java:[line 38]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At DynamicProxy.java:[line 45]
The following classes needed for analysis were missing:
  init.DynamicProxy$MyClass
Warnings generated: 2
Missing classes: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 38 | NA |
| 45 | NA |
| Missing Class | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>
