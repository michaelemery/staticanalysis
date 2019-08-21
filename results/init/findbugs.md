# findbugs results (init)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

Start a Docker interactive session with; `docker run -it --rm michaelemery/staticanalysis`

<br>

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

[init/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/IntraProceduralTest.java)

#### run checker from docker

```
javac -d out/ src/init/IntraProcedural.java
findbugs out/init/IntraProcedural.class
```

#### checker output

```
M C UR: Uninitialized read of object in new init.IntraProcedural(int)  At IntraProcedural.java:[line 18]
M C UR: Uninitialized read of object in new init.IntraProcedural(int, int)  At IntraProcedural.java:[line 23]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 13]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 18]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At IntraProcedural.java:[line 23]
Warnings generated: 5
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18(i) | TP |
| 23(i) | TP |
| 13 | NA |
| 18(ii) | NA |
| 23(ii) | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 2 | 0 |
| - | 0 | 1 |

&nbsp; ⟶ &nbsp; accurate

<br>

## InterProcedural

[init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

[init/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InterProceduralTest.java)

#### run checker from docker

```
javac -d out/ src/init/InterProcedural.java
findbugs out/init/InterProcedural.class
```

#### checker output

```
M C UR: Uninitialized read of object in new init.InterProcedural(int)  At InterProcedural.java:[line 18]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 13]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InterProcedural.java:[line 18]
Warnings generated: 3
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18(i) | TP |
| 13 | NA |
| 18(ii) | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

&nbsp; ⟶ &nbsp; accurate

<br>

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

[init/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectMethodTest.java)

#### run checker from docker

```
javac -d out/ src/init/ReflectMethod.java
findbugs out/init/ReflectMethod.class
```

#### checker output

```
M C UR: Uninitialized read of object in new init.ReflectMethod(int)  At ReflectMethod.java:[line 20]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectMethod.java:[line 15]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectMethod.java:[line 21]
Warnings generated: 3
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 20 | TP |
| 15 | NA |
| 21 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

&nbsp; ⟶ &nbsp; accurate

<br>

## ReflectConstructor

[init/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectConstructor.java)

[init/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectConstructorTest.java)

#### run checker from docker

```
javac -d out/ src/init/ReflectConstructor.java
findbugs out/init/ReflectConstructor.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectConstructor.java:[line 14]
Warnings generated: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 14 | NA |

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

#### run checker from docker

```
javac -d out/ src/init/ReflectField.java
findbugs out/init/ReflectField.class
```

#### checker output

```
M C UR: Uninitialized read of object in new init.ReflectField()  At ReflectField.java:[line 16]
M C UR: Uninitialized read of object in new init.ReflectField(int)  At ReflectField.java:[line 23]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectField.java:[line 16]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At ReflectField.java:[line 23]
M C UwF: Unwritten field: init.ReflectField.object  At ReflectField.java:[line 16]
M C NP: Read of unwritten field object in new init.ReflectField(int)  At ReflectField.java:[line 23]
M C NP: Read of unwritten field object in new init.ReflectField()  At ReflectField.java:[line 16]
Warnings generated: 7
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 16(i), 16(iii), 16(iv) | FP |
| 23(i), 23(iii) | TP |
| 16(ii) | NA |
| 23(ii) | NA |

| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 0 |

&nbsp; ⟶ &nbsp; imprecise

<br>

## InvokeDynamicMethod

[init/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicMethod.java)

[init/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicMethodTest.java)

#### run checker from docker

```
javac -d out/ src/init/InvokeDynamicMethod.java
findbugs out/init/InvokeDynamicMethod.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicMethod.java:[line 17]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicMethod.java:[line 23]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 17 | NA |
| 23 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

&nbsp; ⟶ &nbsp; unsound

<br>

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

[init/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicConstructorTest.java)

#### run checker from docker

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

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicField.java)

[init/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicFieldTest.java)

#### run checker from docker

```
javac -d out/ src/init/InvokeDynamicField.java
findbugs out/init/InvokeDynamicField.class
```

#### checker output

```
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicField.java:[line 18]
M D RV: Return value of Object.toString() ignored, but method has no side effect  At InvokeDynamicField.java:[line 25]
Warnings generated: 2
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18 | NA |
| 25 | NA |

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

#### run checker from docker

```
javac -d out/ src/init/DynamicProxy.java
findbugs out/init/DynamicProxy.class
```

#### checker output

```
The following classes needed for analysis were missing:
  init.DynamicProxy$Foo
Missing classes: 1
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | FN |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 0 |

&nbsp; ⟶ &nbsp; unsound

<br>
