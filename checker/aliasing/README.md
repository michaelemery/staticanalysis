# aliasing
Two expressions are aliased when they have the same non-primitive value; that is, they are references to the identical Java object in the heap. Errors may occur when an object is referenced, without consideration for mutations caused by an alias to the same object.

## testing
Provide a template to test the effectiveness of static analysis tools in identifying unintentional mutations of objects that were intended to be unique.

### objectives
Identify where objects that are intended to be unique may become mutable by;
1. Intra-procedural corruption of an object via an alias. ([IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/IntraProcedural.java))
2. Inter-procedural corruption of an object via an alias. ([InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/InterProcedural.java))
3. Inter-procedural (reflection) corruption of an object via an alias. ([Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/Reflection.java))


## results

Word picture of results.

### summary

| | [CF](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md) | [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md) | [PMD](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md) |
| --- | :---: | :---: | :---: |
| Intra-procedural | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#intra-procedural) | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#intra-procedural) | [1:TP 1:FP](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#intra-procedural) |
| Inter-procedural | [0:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#inter-procedural) | [0:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#inter-procedural) | [1:TP 1:FP](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#inter-procedural) |
| Reflection | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#reflection) | [0:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#reflection) | [1:TP 1:FP](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#reflection)|

> **Notes:** <br>
> 1. Select column heading for results of each tool, or select cell for individual test results.
> 2. Irrelevant errors or warnings that are justifiably identified are not assessed.