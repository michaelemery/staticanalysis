# findbugs

Version: findbugs-3.0.1

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

### summary

| feature | result |
| --- | :---: |
| IntraProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#IntraProcedural) |
| InterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#InterProcedural) |
| ReflectMethod | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectmethodinvoke) |
| ReflectMethodOverload | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectmethodinvoke) |
| ReflectFieldAccess | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectoverloadinvoke) |
| InvokeDynamicVirtual | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectmethodhandle) |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectfieldaccess) |
| InvokeDynamicField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#reflectfieldaccess) |
| DynamicProxy | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#dynamicproxy) |

> Select results for detail.

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/init/IntraProcedural.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/IntraProcedural.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InterProcedural

[init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InterProcedural.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/InterProcedural.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectMethod.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/ReflectMethod.java
```

#### output

```
Found 1 issue

init/ReflectMethod.java:17: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectMethod.o` is not initialized in the constructor and is not declared `@Nullable`.
  15.       }
  16.   
  17. >     ReflectMethod(Method m, int x) throws Exception {
  18.           m.invoke(this);
  19.       }


Summary of the reports

  ERADICATE_FIELD_NOT_INITIALIZED: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | accurate |

## ReflectMethodOverload

[init/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectMethodOverload.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/ReflectMethodOverload.java
```

#### output

```
Found 1 issue

init/ReflectMethodOverload.java:19: error: ERADICATE_FIELD_NOT_INITIALIZED
  Field `ReflectMethodOverload.o` is not initialized in the constructor and is not declared `@Nullable`.
  17.       }
  18.   
  19. >     ReflectMethodOverload(int x) throws Exception {
  20.           Class<?> C = ReflectMethodOverload.class;
  21.           Method m = C.getDeclaredMethod("m");


Summary of the reports

  ERADICATE_FIELD_NOT_INITIALIZED: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | accurate |

## ReflectFieldAccess

[init/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectFieldAccess.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/ReflectFieldAccess.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicVirtual

[init/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicVirtual.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/InvokeDynamicVirtual.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicConstructor.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/InvokeDynamicConstructor.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicField.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/InvokeDynamicField.java
```

#### output

```
No reported issues.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/init/DynamicProxy.java)

#### docker

```
infer run -a checkers --eradicate -- javac init/DynamicProxy.java
```

#### output

```
Found 1 issue

init/DynamicProxy.java:18: error: ERADICATE_PARAMETER_NOT_NULLABLE
  `get(...)` needs a non-null value in parameter 1 but argument `null` can be null. (Origin: null constant at line 18).
  16.   
  17.       DynamicProxy(Foo proxyInstance, int x) {
  18. >         this.o = proxyInstance.get(null);
  19.           System.out.println(this.o.toString());
  20.       }


Summary of the reports

  ERADICATE_PARAMETER_NOT_NULLABLE: 1
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |
