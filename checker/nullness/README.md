# nullness
Nullness checking guarantees that a program will never throw a null pointer exception. De-referenced expressions are a common cause a null pointer exceptions. Dereferences occur not only when a field is accessed, but when an array is indexed, an exception is thrown, and more. Such exceptions may also occur simply as a result of a field not being initialised by its constructor.

## testing
Test the effectiveness of static analysis tools in identifying potential causes of null-pointer exceptions.

| source | description |
| --- | --- |
| [Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java) | Basic assignment of a null reference. |
| [Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Interprocedural.java) | Interprocedural assignment of a null reference. |
| [Reflect.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflect.java) | Assignment of a null reference via reflection. |
| [ReflectInterprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectInterprocedural.java) | Interprocedural assignment of a null reference via reflection. |
| [ReflectOverload.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/ReflectOverload.java) | Overload assignment of a null reference via reflection. |
| [InvokeDynamic.java]() | Assignment of a null reference via dynamic invocation. |
| [Proxy.java]() | Assignment of a null reference via proxy. |

## results

Checker Framework is consistently sound and precise in non-reflective cases. However, it handles reflection in a very rudimentary way that causes excessive false positives. Checker Framework errs on the side of caution when encountering reflective code. 

Both FindBugs and PMD are less likely to generate FP results so are more precise than Checker Framework. However, their lack of caution in complex situations compromises soundness compared to Checker Framework.

Overall, Checker Framework is recommended as the most reliable tool for nullness testing given that the FP weakness in reflection is offset by the FN results of other tools that were less sound.

| feature | [Checker Framework](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#checker-framework) | [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#findbugs) | [PMD](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#pmd) |
| --- | :---: |:---: |:---: |
| Vanilla | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanilla) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanilla) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanilla) |
| Interprocedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#interprocedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interprocedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#interprocedural) |
| Reflect | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflect) | - | - |
| ReflectInterprocedural | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectinterprocedural) | - | - |
| ReflectOverload |  | - | - |
| InvokeDynamic |  | - | - |
| Proxy |  | - | - |

> Select individual results for detail.
