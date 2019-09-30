# infer results (taint)

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

* [taint/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/IntraProcedural.java)

* [taint/IntraProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/IntraProceduralTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/IntraProcedural.java
```

#### checker output

```
Found 1 issue

src/taint/IntraProcedural.java:8: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `IntraProcedural.foo` is not initialized in the constructor and is not declared `@Nullable`
  6.    * Check tainting of field set via direct value assignment.
  7.    */
  8. > class IntraProcedural {
  9.   
  10.       @Untainted Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InterProcedural

* [taint/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InterProcedural.java)

* [taint/InterProceduralTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InterProceduralTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/InterProcedural.java
```

#### checker output

```
c/taint/InterProcedural.java:8: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `InterProcedural.foo` is not initialized in the constructor and is not declared `@Nullable`
  6.    * Check tainting of field set via inter-procedural return.
  7.    */
  8. > class InterProcedural {
  9.   
  10.       @Untainted Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectConstructor

* [taint/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectConstructor.java)

* [taint/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectConstructorTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/ReflectConstructor.java
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

## ReflectConstructor

* [taint/ReflectConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectConstructor.java)

* [taint/ReflectConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectConstructorTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/ReflectConstructor.java
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

## ReflectMethod

* [taint/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectMethod.java)

* [taint/ReflectMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectMethodTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/ReflectMethod.java
```

#### checker output

```
src/taint/ReflectMethod.java:10: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectMethod.foo` is not initialized in the constructor and is not declared `@Nullable`
  8.    * Check tainting of field set via reflection method invocation.
  9.    */
  10. > public class ReflectMethod {
  11.   
  12.       @Untainted Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## ReflectField

* [taint/ReflectField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/ReflectField.java)

* [taint/ReflectFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/ReflectFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/ReflectField.java
```

#### checker output

```
Found 1 issue

src/taint/ReflectField.java:8: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectField.foo` is not initialized in the constructor and is not declared `@Nullable`
  6.    * Check tainting of field set via reflective field access.
  7.    */
  8. > public class ReflectField {
  9.   
  10.       @Untainted Object foo;

```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 8 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InvokeDynamicConstructor

* [taint/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InvokeDynamicConstructor.java)

* [taint/InvokeDynamicConstructorTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InvokeDynamicConstructorTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/InvokeDynamicConstructor.java
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

* [taint/InvokeDynamicMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InvokeDynamicMethod.java)

* [taint/InvokeDynamicMethodTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InvokeDynamicMethodTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/InvokeDynamicMethod.java
```

#### checker output

```
Found 1 issue

src/taint/InvokeDynamicMethod.java:12: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `InvokeDynamicMethod.foo` is not initialized in the constructor and is not declared `@Nullable`
  10.    * Check tainting of field set via dynamic virtual (non-static) method invocation.
  11.    */
  12. > public class InvokeDynamicMethod {
  13.   
  14.       @Untainted Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 12 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound

<br>

## InvokeDynamicField

* [taint/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/InvokeDynamicField.java)

* [taint/InvokeDynamicFieldTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/InvokeDynamicFieldTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/InvokeDynamicField.java
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

* [taint/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/src/taint/DynamicProxy.java)

* [taint/DynamicProxyTest.java](https://github.com/michaelemery/staticanalysis/blob/master/test/taint/DynamicProxyTest.java)

#### checker command

```shell script
infer run -a checkers --eradicate -- javac -d out/ src/taint/DynamicProxy.java
```

#### checker output

```
Found 1 issue

src/taint/DynamicProxy.java:10: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `DynamicProxy.foo` is not initialized in the constructor and is not declared `@Nullable`
  8.    * Check tainting for field set via dynamic proxy invocation.
  9.    */
  10. > public class DynamicProxy {
  11.   
  12.       @Untainted Object foo;
```

#### output analysis

| line(s) | event |
| :---: | :---: |
| 10 | NA |

#### expected / actual errors

|  | + | - |
| :---: | :---: | :---: |
| + | 0 | 0 |
| - | 1 | 1 |

> unsound
