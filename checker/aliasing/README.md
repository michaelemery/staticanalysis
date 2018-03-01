# aliasing
Two expressions are aliased when they have the same non-primitive value; that is, they are references to the identical Java object in the heap. Errors may occur when an object is referenced, without consideration for mutations caused by an alias to the same object.

## testing
Provide a template to test the effectiveness of static analysis tools in identifying unintentional mutations of objects that were intended to be unique.

| source | description |
| --- | --- |
| [Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/Vanilla.java) | Basic assignment of a null reference. |
| [InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/InterProcedural.java) | Inter-procedural assignment of a null reference. |
| [Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/Reflection.java) | Assignment of a null reference via reflection. |
| [InvokeDynamic.java]() | Assignment of a null reference via dynamic invocation. |
| [Proxy.java]() | Assignment of a null reference via proxy. |


## results

Word picture of results.

|  | Vanilla | InterProcedural | Reflection | InvokeDynamic | Proxy |
| --- | :---: | :---: | :---: | :---: | :---: |
| [Checker Framework](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/checkerframework.md#checker-framework) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/checkerframework.md#vanilla) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/checkerframework.md#inter-procedural) | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/checkerframework.md#reflection) |  |  |
| [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/findbugs.md#findbugs) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/findbugs.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/findbugs.md#inter-procedural) | - | - | - |
| [PMD](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/pmd.md#pmd) |  [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/pmd.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/alias/pmd.md#inter-procedural) | - | - | - |