# findbugs

Version: findbugs-3.0.1

## results

Results can be replicated on [Docker](https://docs.docker.com/docker-hub/) repository `michaelemery/staticanalysis`. Copy and paste the commands provided in each example. Some outputs have been reformatted for readability.

| Vanilla | Interprocedural | Reflect | InvokeDynamic | Proxy |
| :---: | :---: | :---: | :---: | :---: |
| [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#interprocedural) | - | - | - |

### vanilla

[alias/Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Vanilla.java)

```
findbugs alias/Vanilla.class 
```

#### output
```
H C NP: Null pointer dereference of Vanilla.s in alias.Vanilla.main(String[]) 
Dereferenced at Vanilla.java:[line 30]

M D UC: Useless object stored in variable var$2 of method alias.Vanilla.main(String[]) 
At Vanilla.java:[line 23]

Warnings generated: 2
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

### interprocedural

[alias/Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Interprocedural.java)

```
findbugs alias/Interprocedural.class 
```

#### output
```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 0 |

### reflect

[alias/Reflect.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Reflect.java)

```
findbugs alias/Reflect.class 
```

#### output
```
[NO ISSUES IDENTIFIED]
```

| True Pos | False Pos | False Neg |
| :---: | :---: | :---: |
| 0 | 0 | 0 |
