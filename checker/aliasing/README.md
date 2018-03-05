# aliasing
Two expressions are aliasinged when they have the same non-primitive value; that is, they are references to the identical Java object in the heap. Errors may occur when an object is referenced, without consideration for mutations caused by an aliasing to the same object.

## testing
Test the effectiveness of static analysis tools in identifying unintentional mutations of objects that were intended to be unique.

| source | description |
| --- | --- |
| [Vanilla.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Vanilla.java) | Basic assignment of a null reference. |
| [Interprocedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Interprocedural.java) | Inter-procedural assignment of a null reference. |
| [Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Reflection.java) | Assignment of a null reference via reflection. |
| [InvokeDynamic.java]() | Assignment of a null reference via dynamic invocation. |
| [Proxy.java]() | Assignment of a null reference via proxy. |

## results

Word picture of results.

|  | Vanilla | Interprocedural | Reflection | InvokeDynamic | Proxy |
| --- | :---: | :---: | :---: | :---: | :---: |
| [Checker Framework](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#checker-framework) | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#vanilla) | [imprecise & unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#interprocedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#reflection) |  |  |
| [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#findbugs) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#interprocedural) | - | - | - |
| [PMD](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#pmd) |  [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#vanilla) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#interprocedural) | - | - | - |

> Select individual results for detail.