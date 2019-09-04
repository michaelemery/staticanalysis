# infer results (nullness)

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

Version: infer-0.13.1

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
infer run -a checkers --eradicate -- javac -d out/ src/nullness/IntraProcedural.java
```

#### checker output

```
Found 1 issue

src/init/IntraProcedural.java:31: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `IntraProcedural(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 31)
  29.        */
  30.       public static void setFooToNull() {
  31. >         new IntraProcedural(null).foo.toString();
  32.       }
  33.   
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 31 | TP |

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
infer run -a checkers --eradicate -- javac -d out/ src/nullness/InterProcedural.java
```

#### checker output

```
Found 2 issues

src/nullness/InterProcedural.java:6: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `InterProcedural.foo` is not initialized in the constructor and is not declared `@Nullable`
  4.    * Check nullness of field set via inter-procedural return.
  5.    */
  6. > public class InterProcedural {
  7.   
  8.       Object foo;

src/nullness/InterProcedural.java:28: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `getObject(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 28)
  26.       public static void setFooToNull() {
  27.           InterProcedural i = new InterProcedural();
  28. >         i.foo = i.getObject(null);
  29.           i.foo.toString();
  30.       }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 6 | FP |
| 28 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 1 |

> imprecise
>
> * line 6 error occurs with or without setFooToNull() and is therefore FP

<br>

## ReflectConstructor

* [nullness/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectConstructor.java)

* [nullness/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectConstructorTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/ReflectConstructor.java
```

### checker output

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

## ReflectMethod

* [nullness/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectMethod.java)

* [nullness/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectMethodTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/ReflectMethod.java
```

#### checker output

```
Found 1 issue

src/nullness/ReflectMethod.java:8: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectMethod.foo` is not initialized in the constructor and is not declared `@Nullable`
  6.    * Check nullness of field set via reflection method invocation.
  7.    */
  8. > public class ReflectMethod {
  9.   
  10.       Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 1 |

> unsound
>
> * line 8 error occurs with or without setFooToNull() and is therefore FP

<br>

## ReflectField

* [nullness/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/ReflectField.java)

* [nullness/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/ReflectFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/ReflectField.java
```

#### checker output

````
Found 1 issue

src/nullness/ReflectField.java:6: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectField.foo` is not initialized in the constructor and is not declared `@Nullable`
  4.    * Check nullness of field set via reflection field access.
  5.    */
  6. > public class ReflectField {
  7.   
  8.       Object foo;
````

#### output analysis
 
 | line(s) | event |
 | :---: | :---: |
 | 6 | FP |
 
#### expected / actual errors
 
 |  | + | - |
 | :---: | :---: | :---: |
 | + | 0 | 0 |
 | - | 1 | 1 |
 
 > unsound
>
> * line 6 error occurs with or without setFooToNull() and is therefore FP
 
 <br>

## InvokeDynamicConstructor

* [nullness/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicConstructor.java)

* [nullness/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicConstructorTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/InvokeDynamicConstructor.java
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
| - | 1 | 1 |

> unsound

<br>

## InvokeDynamicMethod

* [nullness/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicMethod.java)

* [nullness/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicMethodTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/InvokeDynamicMethod.java
```

#### checker output

```
Found 1 issue

src/nullness/InvokeDynamicMethod.java:10: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `InvokeDynamicMethod.foo` is not initialized in the constructor and is not declared `@Nullable`
  8.    * Check nullness of field set via dynamic virtual (non-static) method invocation.
  9.    */
  10. > public class InvokeDynamicMethod {
  11.   
  12.       Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | FP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 1 |
| - | 1 | 1 |

> unsound
>
> * line 10 error occurs with or without setFooToNull() and is therefore FP

<br>

## InvokeDynamicField

* [nullness/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/InvokeDynamicField.java)

* [nullness/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/InvokeDynamicFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/InvokeDynamicField.java
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
| - | 1 | 1 |

> unsound

<br>

## DynamicProxy

* [nullness/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/DynamicProxy.java)

* [nullness/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/nullness/DynamicProxyTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/nullness/DynamicProxy.java
```

#### checker output

```
Found 2 issues

src/nullness/DynamicProxy.java:8: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `DynamicProxy.foo` is not initialized in the constructor and is not declared `@Nullable`
  6.    * Check nullness for field set via dynamic proxy invocation.
  7.    */
  8. > public class DynamicProxy {
  9.   
  10.       Object foo;

src/nullness/DynamicProxy.java:43: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `getObject(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 43)
  41.       public static void setFooToNull() {
  42.           DynamicProxy i = new DynamicProxy();
  43. >         i.foo = i.getProxyInstance().getObject(null);
  44.           i.foo.toString();
  45.       }
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | FP |
| 44 | TP |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 1 | 1 |
| - | 0 | 1 |

> imprecise
>
> * line 8 error occurs with or without setFooToNull() and is therefore FP
