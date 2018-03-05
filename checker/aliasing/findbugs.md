# findbugs

Version: findbugs-3.0.1

## Vanilla

[aliasing/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Vanilla.java)

**results:**

```
$ findbugs aliasing/Vanilla.class 

H C NP: Null pointer dereference of Vanilla.s in aliasing.Vanilla.main(String[]) 
Dereferenced at Vanilla.java:[line 30]

M D UC: Useless object stored in variable var$2 of method aliasing.Vanilla.main(String[]) 
At Vanilla.java:[line 23]

Warnings generated: 2

```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |


## interprocedural

[aliasing/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Interprocedural.java)

**results:**

```
$ findbugs aliasing/Interprocedural.class 

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
