
# pmd

Version: pmd-bin-6.0.1

PMD checkers belonging to the "error prone" category are the only ones required for these tests.

> 1. The `pmd` command shown in all results is an alias; <br>
> `alias pmd='$PMD_HOME/bin/run.sh pmd'`
> 2. JDK must be set to 1.8 or lower.
> 3. Outputs have been simplified for brevity.

## intra-procedural

[aliasing/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/IntraProcedural.java)

**results:**

```
$ pmd -d aliasing/IntraProcedural.java -f text -R category/java/errorprone.xml

aliasing/IntraProcedural.java:8:  
Found non-transient, non-static member. Please mark as transient or provide accessors.

aliasing/IntraProcedural.java:24:  
Assigning an Object to null is a code smell.  Consider refactoring.

aliasing/IntraProcedural.java:29:  
Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

## inter-procedural

[aliasing/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/InterProcedural.java)

**results:**

```
$ pmd -d NullInterProcedural.java -f text -R category/java/errorprone.xml

aliasing/InterProcedural.java:8:   
Found non-transient, non-static member. Please mark as transient or provide accessors.

aliasing/InterProcedural.java:20:  
Assigning an Object to null is a code smell.  Consider refactoring.

aliasing/InterProcedural.java:25:  
Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |

## reflection

[aliasing/Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Reflection.java)

**results:**

```
$ pmd -d NullReflection.java -f text -R category/java/errorprone.xml

/Users/michaelemery/Developer/staticanalysis/checker/aliasing/Reflection.java:11:   
Found non-transient, non-static member. Please mark as transient or provide accessors.

/Users/michaelemery/Developer/staticanalysis/checker/aliasing/Reflection.java:27:   
Assigning an Object to null is a code smell.  Consider refactoring.

/Users/michaelemery/Developer/staticanalysis/checker/aliasing/Reflection.java:33:   
Assigning an Object to null is a code smell.  Consider refactoring.
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 1 | 0 |
