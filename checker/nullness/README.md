# nullness
Nullness checking guarantees that a program will never throw a null pointer exception. De-referenced expressions are a common cause a null pointer exceptions. Dereferences occur not only when a field is accessed, but when an array is indexed, an exception is thrown, and more. Such exceptions may also occur simply as a result of a field not being initialised by its constructor.

## testing
Test the effectiveness of static analysis tools in identifying potential causes of null-pointer exceptions.

| source | description |
| --- | --- |
| [Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java) | Basic assignment of a null reference. |
| [Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Interprocedural.java) | Inter-procedural assignment of a null reference. |
| [Reflect.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflect.java) | Assignment of a null reference via reflection. |
| [InvokeDynamic.java]() | Assignment of a null reference via dynamic invocation. |
| [Proxy.java]() | Assignment of a null reference via proxy. |

## results

Checker Framework (CF) is consistently sound and precise in non-reflective cases. However, it handles reflection in a very rudimentary way that causes excessive false positives. CF errs on the side of caution when encountering reflective code. 

Both FindBugs and PMD are less likely to generate FP results so are more precise than CF. However, their lack of caution in complex situations compromises soundness compared to CF.

Overall, CF is recommended as the most reliable tool for nullness testing given that the FP weakness in reflection is offset by the FN results of other tools that were less sound.

|  | Vanilla | Interprocedural | Reflect | InvokeDynamic | Proxy |
| --- | :---: | :---: | :---: | :---: | :---: |
| [Checker Framework](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#checker-framework) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanilla) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#interprocedural) | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflection) |  |  |
| [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#findbugs) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interprocedural) | - | - | - |
| [PMD](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#pmd) |  [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#interprocedural) | - | - | - |

> Select individual results for detail.