
# findbugs

Version: findbugs-3.0.1

## intra-procedurual

[aliasing/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/IntraProcedural.java)

**results:**

```
$ findbugs aliasing/IntraProcedural.class 

H C NP: Null pointer dereference of IntraProcedural.s in aliasing.IntraProcedural.main(String[]) 
Dereferenced at IntraProcedural.java:[line 30]

M D UC: Useless object stored in variable var$2 of method aliasing.IntraProcedural.main(String[]) 
At IntraProcedural.java:[line 23]

Warnings generated: 2

```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |


## inter-procedural

[aliasing/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/InterProcedural.java)

**results:**

```
$ findbugs aliasing/InterProcedural.class 

[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 0 |

## reflection

[aliasing/Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Reflection.java)

**results:**

```
$ findbugs aliasing/Reflection.class 

[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 0 |
