# nullness
Nullness checking guarantees that a program will never throw a null pointer exception. De-referenced expressions are a common cause a null pointer exceptions. Dereferences occur not only when a field is accessed, but when an array is indexed, an exception is thrown, and more. Such exceptions may also occur simply as a result of a field not being initialised by its constructor.

## testing
Individual tests provide a template to test the effectiveness of static analysis tools in identifying potential causes of null-pointer exceptions.

| test | description |
| --- | --- |
| [IntraVanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraVanilla.java) | Intra-procedural assignment of a null reference. |
| [InterVanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterVanilla.java) | Inter-procedural assignment of a null reference. |
| [InterReflect.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterReflect.java) | Inter-procedural assignment of a null reference via reflection. |
| [InterInvoke.java]() | Inter-procedural assignment of a null reference via invoke dynamic. |
| [InterProxy.java]() | Inter-procedural assignment of a null reference via proxy. |


## results

Checker Framework (CF) is consistently sound and precise in non-reflective cases. However, it handles reflection in a very rudimentary way that causes excessive false positives. CF errs on the side of caution when encountering reflective code. 

Both FindBugs and PMD are less likely to generate FP results so are more precise than CF. However, their lack of caution in complex situations compromises soundness compared to CF.

Overall, CF is recommended as the most reliable tool for nullness testing given that the FP weakness in reflection is offset by the FN results of other tools that were less sound.

### checkerframework

|  | vanilla | reflection | invoke dyn | proxy |
| --- | :---: | :---: | :---: | :---: |
| intra-procedural |  |  |  |  |
| inter-procedural |  |  |  |  |

### findbugs

|  | vanilla | reflection | invoke dyn | proxy |
| --- | :---: | :---: | :---: | :---: |
| intra-procedural |  |  |  |  |
| inter-procedural |  |  |  |  |


### pmd 

|  | vanilla | reflection | invoke dyn | proxy |
| --- | :---: | :---: | :---: | :---: |
| intra-procedural |  |  |  |  |
| inter-procedural |  |  |  |  |

> **Note:** <br />
> Irrelevant errors or warnings that are justifiably identified are not assessed.
