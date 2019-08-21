# infer results (init)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/src/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/src/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/src/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/src/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/src/results/tool/pmd.md)

<br>

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

If you have Docker installed on your system, you may pull/update and run the Docker instance for this project with;

```
docker pull michaelemery/staticanalysis
docker run -it --rm michaelemery/staticanalysis
```

<br>

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/IntraProcedural.java)

[init/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/IntraProceduralTest.java)

#### run checker from docker

```
infer run -a checkers --eradicate -- javac src/init/IntraProcedural.java
```

#### checker output

```
Found 1 issue

src/init/IntraProcedural.java:17: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `IntraProcedural.object` is not initialized in the constructor and is not declared `@Nullable`
  15.   
  16.       // fail to initialise
  17. >     IntraProcedural(int x) {
  18.           this.object.toString();
  19.       }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 17 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 0 |
| - | 0 | 1 |

&nbsp; ⟶ &nbsp; accurate

<br>

## InterProcedural

[init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InterProcedural.java)

[init/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InterProceduralTest.java)

#### run checker from docker

```
infer run -a checkers --eradicate -- javac src/init/InterProcedural.java
```

#### checker output

```
Found 1 issue

src/init/InterProcedural.java:18: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `returnObject(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 18)
  16.       // fail to initialise
  17.       InterProcedural(int x) {
  18. >         this.object = returnObject(null);
  19.           this.object.toString();
  20.       }
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

&nbsp; ⟶ &nbsp; accurate

<br>

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectMethod.java)

[init/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectMethodTest.java)

#### run checker from docker

```
infer run -a checkers --eradicate -- javac src/init/ReflectMethod.java
```

#### checker output

```
No issues found.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 0 |

&nbsp; ⟶ &nbsp; unsound

<br>

## ReflectConstructor

[init/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectConstructor.java)

[init/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectConstructorTest.java)

#### run checker from docker

```
infer run -a checkers --eradicate -- javac src/init/ReflectConstructor.java
```

#### checker output

```
No issues found.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 0 |

&nbsp; ⟶ &nbsp; unsound

<br>

## ReflectField

[init/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/ReflectField.java)

[init/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/ReflectFieldTest.java)

#### run checker from docker

```
infer run -a checkers --eradicate -- javac src/init/ReflectField.java
```

#### checker output

```
Found 2 issues

src/init/ReflectField.java:13: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectField.object` is not initialized in the constructor and is not declared `@Nullable`
  11.   
  12.       // initialises field
  13. >     ReflectField() throws Exception {
  14.           Field field = this.getClass().getDeclaredField("object");
  15.           field.set(this, new Object());

src/init/ReflectField.java:20: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectField.object` is not initialized in the constructor and is not declared `@Nullable`
  18.   
  19.       // fails to initialise field
  20. >     ReflectField(int x) throws Exception {
  21.           Field field = this.getClass().getDeclaredField("object");
  22.           field.set(this, (Object) null);
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 13 | FP |
| 20 | TP |

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
infer run -a checkers --eradicate -- javac src/init/InvokeDynamicMethod.java
```

#### checker output

```
No issues found.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 0 |

&nbsp; ⟶ &nbsp; unsound

<br>

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicConstructor.java)

[init/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicConstructorTest.java)

#### run checker from docker

```
infer run -a checkers --eradicate -- javac src/init/InvokeDynamicConstructor.java
```

#### checker output

```
No issues found.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 0 |

&nbsp; ⟶ &nbsp; unsound

<br>

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/InvokeDynamicField.java)

[init/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/InvokeDynamicFieldTest.java)

#### run checker from docker

```
infer run -a checkers --eradicate -- javac src/init/InvokeDynamicField.java
```

#### checker output

```
No issues found.
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| - | - |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 0 |

&nbsp; ⟶ &nbsp; unsound

<br>

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/init/DynamicProxy.java)

[init/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/init/DynamicProxyTest.java)

#### run checker from docker

```
infer run -a checkers --eradicate -- javac src/init/DynamicProxy.java
```

#### checker output

```
Found 1 issue

src/init/DynamicProxy.java:18: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `get(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 18)
  16.   
  17.       DynamicProxy(Foo proxyInstance, int x) {
  18. >         this.o = proxyInstance.get(null);
  19.           this.o.toString();
  20.       }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 18 | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 0 |

&nbsp; ⟶ &nbsp; unsound

<br>
