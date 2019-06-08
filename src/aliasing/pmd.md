# pmd

Version: pmd-bin-6.0.1

PMD checkers belonging to the "error prone" category are the only ones required for these tests.

> 1. The `pmd` command shown in all results is an alias; <br>
> `alias pmd='$PMD_HOME/bin/run.sh pmd'`
> 2. JDK must be set to 1.8 or lower.
> 3. Outputs have been simplified for brevity.

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| Vanilla | Interprocedural | Reflect | InvokeDynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#vanilla) | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#interprocedural) |[imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#reflect) | - | - |

### vanilla

[aliasing/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Vanilla.java)

```
$PMD_HOME/bin/run.sh pmd -d aliasing/Vanilla.java -f text -R category/java/errorprone.xml
```

#### output
```
aliasing/Vanilla.java:8:  
Found non-transient, non-static member. Please mark as transient or provide accessors.

aliasing/Vanilla.java:24:  
Assigning an Object to null is a code smell.  Consider refactoring.

aliasing/Vanilla.java:29:  
Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

### interprocedural

[aliasing/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Interprocedural.java)

```
$PMD_HOME/bin/run.sh pmd -d Interprocedural.java -f text -R category/java/errorprone.xml
```

#### output
```
aliasing/Interprocedural.java:8:   
Found non-transient, non-static member. Please mark as transient or provide accessors.

aliasing/Interprocedural.java:20:  
Assigning an Object to null is a code smell.  Consider refactoring.

aliasing/Interprocedural.java:25:  
Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

### reflect

[aliasing/Reflect.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Reflect.java)

```
$PMD_HOME/bin/run.sh pmd -d NullReflect.java -f text -R category/java/errorprone.xml
```

#### output
```
aliasing/Reflect.java:11:   
Found non-transient, non-static member. Please mark as transient or provide accessors.

aliasing/Reflect.java:27:   
Assigning an Object to null is a code smell.  Consider refactoring.

aliasing/Reflect.java:33:   
Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |