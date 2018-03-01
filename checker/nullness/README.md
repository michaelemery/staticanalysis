# nullness
Nullness checking guarantees that a program will never throw a null pointer exception. De-referenced expressions are a common cause a null pointer exceptions. Dereferences occur not only when a field is accessed, but when an array is indexed, an exception is thrown, and more. Such exceptions may also occur simply as a result of a field not being initialised by its constructor.

## testing
Individual tests provide a template to test the effectiveness of static analysis tools in identifying potential causes of null-pointer exceptions.

| test | description |
| --- | --- |
| [Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Vanilla.java) | Intra-procedural assignment of a null reference. |
| [InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/IntraVanillachecker/nullness/InterProcedural.java) | Inter-procedural assignment of a null reference. |
| [Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java) | Inter-procedural assignment of a null reference via reflection. |
| [InvokeDynamic.java]() | Inter-procedural assignment of a null reference via invoke dynamic. |
| [Proxy.java]() | Inter-procedural assignment of a null reference via proxy. |

## results summary

Checker Framework (CF) is consistently sound and precise in non-reflective cases. However, it handles reflection in a very rudimentary way that causes excessive false positives. CF errs on the side of caution when encountering reflective code. 

Both FindBugs and PMD are less likely to generate FP results so are more precise than CF. However, their lack of caution in complex situations compromises soundness compared to CF.

Overall, CF is recommended as the most reliable tool for nullness testing given that the FP weakness in reflection is offset by the FN results of other tools that were less sound.

|  | vanilla | inter-procedural | reflection | invoke dynamic | proxy |
| --- | :---: | :---: | :---: | :---: | :---: |
| [checker framework](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#checker-framework) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanilla) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#inter-procedural) | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflection) |  |  |
| [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#findbugs) |  |  |  |  |  |
| [pmd](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#pmd) |  |  |  |  |  |