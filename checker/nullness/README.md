# nullness
Nullness checking guarantees that a program will never throw a null pointer exception. 
De-referenced expressions are a common cause a null pointer exceptions. Dereferences occur not only 
when a field is accessed, but when an array is indexed, an exception is thrown, and more. Such 
exceptions may also occur simply as a result of a field not being initialised by its constructor.

## testing
Individual tests provide a template to test the effectiveness of static analysis tools in 
identifying potential causes of null-pointer exceptions.

### objectives 
Each test represents different techniques for invoking potential error conditions as follows;

1. intra-procedure assignment to a null reference ([NullIntraProcedure.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullIntraProcedure.java)).
2. Assignment to a null reference by alias ([NullAlias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullAlias.java)).
3. inter-procedure assignment to a null reference ([NullInterProcedure.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullInterProcedure.java)).
4. Assignment to a null reference by reflection ([NullReflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/NullReflection.java)).


## results

Checker Framework (CF) is consistently sound and precise in non-reflective cases. However, it 
handles reflection in a very rudimentary way that causes excessive false positives. CF errs on the 
side of caution when encountering reflective code. 

Both FindBugs and PMD are less likely to generate FP results so are more precise than CF. 
However, their lack of caution in complex situations compromises soundness compared to CF.

Overall, CF is recommended as the most reliable tool for nullness testing given that the FP 
weakness in reflection is offset by the FN results of other tools that were less sound.

### summary

| | [CF](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md) | [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md) | [PMD](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md) |
| --- | :---: | :---: | :---: |
| Intra-Procedure | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#intra-procedure) | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#intra-procedure) | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#intra-procedure) |
| Alias | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#alias) | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#alias) | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#alias) |
| Inter-Procedure | [1:TP](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#inter-procedure) | [1:FN](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#inter-procedure) | [1:FN](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#inter-procedure) |
| Reflection | [1:TP 3:FP](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflection) | [1:FN](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflection) | [1:FN](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflection)|

> **Notes:** <br>
> 1. Select column heading for results of each tool, or select cell for individual test results.
> 2. Irrelevant errors or warnings that are justifiably identified are not assessed.
