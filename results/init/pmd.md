# pmd results (init)

<br>

Version: pmd-bin-6.1.0

* PMD checkers belonging to the "error prone" category are the only ones required for these tests.
* The `$PMD_HOME` variable must be configured to use these commands.
* JDK must be set to 1.8 or lower.
* Outputs have been simplified for brevity.

Results can be replicated using an interactive terminal from the [michaelemery/staticanalysis](https://cloud.docker.com/u/michaelemery/repository/docker/michaelemery/staticanalysis) Docker repository. Copy the docker command(s) provided with each test result, and paste them into your interactive Docker session. 

<br>

## IntraProcedural

[init/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/init/IntraProcedural.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d init/IntraProcedural.java -f text -R category/java/errorprone.xml
```

#### output

```
/src/init/IntraProcedural.java:8:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InterProcedural

[init/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InterProcedural.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d init/InterProcedural.java -f text -R category/java/errorprone.xml
```

#### output

```
/src/init/InterProcedural.java:9:	Found non-transient, non-static member. Please mark as transient or provide accessors.
/src/init/InterProcedural.java:17:	Overridable method 'm' called during object construction
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 0 | 0 | accurate |

## ReflectMethod

[init/ReflectMethod.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectMethod.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d init/ReflectMethod.java -f text -R category/java/errorprone.xml
```

#### output

```
/src/init/ReflectMethod.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectMethodOverload

[init/ReflectMethodOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectMethodOverload.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d init/ReflectMethodOverload.java -f text -R category/java/errorprone.xml
```

#### output

```
/src/init/ReflectMethodOverload.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## ReflectFieldAccess

[init/ReflectFieldAccess.java](https://github.com/michaelemery/staticanalysis/blob/master/init/ReflectFieldAccess.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d init/ReflectFieldAccess.java -f text -R category/java/errorprone.xml
```

#### output

```
/src/init/ReflectFieldAccess.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicVirtual

[init/InvokeDynamicVirtual.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicVirtual.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d init/InvokeDynamicVirtual.java -f text -R category/java/errorprone.xml
```

#### output

```
/src/init/InvokeDynamicVirtual.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicConstructor

[init/InvokeDynamicConstructor.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicConstructor.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d init/InvokeDynamicConstructor.java -f text -R category/java/errorprone.xml
```

#### output

```
/src/init/InvokeDynamicConstructor.java:12:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## InvokeDynamicField

[init/InvokeDynamicField.java](https://github.com/michaelemery/staticanalysis/blob/master/init/InvokeDynamicField.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d init/InvokeDynamicField.java -f text -R category/java/errorprone.xml
```

#### output

```
/src/init/InvokeDynamicField.java:11:	Found non-transient, non-static member. Please mark as transient or provide accessors.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 0 | unsound |

## DynamicProxy

[init/DynamicProxy.java](https://github.com/michaelemery/staticanalysis/blob/master/init/DynamicProxy.java)

#### docker

```
$PMD_HOME/bin/run.sh pmd -d init/DynamicProxy.java -f text -R category/java/errorprone.xml
```

#### output

```
/src/init/DynamicProxy.java:10:	Found non-transient, non-static member. Please mark as transient or provide accessors.
/src/init/DynamicProxy.java:30:	Found 'DU'-anomaly for variable 'proxyInstance' (lines '30'-'47').
/src/init/DynamicProxy.java:31:	In J2EE, getClassLoader() might not work as expected.  Use Thread.currentThread().getContextClassLoader() instead.
```

| false negative | false positive | result |
| :---: | :---: | :---: |
| 1 | 1 | aberrant |
