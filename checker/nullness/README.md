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

1. IntraProcedural assignment to a null reference ([IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)).
2. Assignment to a null reference by alias ([Alias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Alias.java)).
3. InterProcedural assignment to a null reference ([InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)).
4. Assignment to a null reference by reflection ([Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java)).

### source files
[IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java), 
[Alias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Alias.java), 
[InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java), 
[Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java).

## results

Checker Framework (CFW) is consistently sound and precise in non-reflective cases. However, it 
handles reflection in a very rudimentary way that causes excessive false positives. CFW errs on the 
side of caution when encountering reflective code. 

Both FindBugs and PMD are less likely to generate FP results so are more precise than CFW. 
However, their lack of caution in complex situations compromises soundness compared to CFW.

Overall, CFW is recommended as the most reliable tool for nullness testing given that the FP 
weakness in reflection is offset by the FN results of other tools that were less sound.

| | CFW | FindBugs | PMD |
| --- | --- | --- | --- |
| Direct | 1:TP | 1:TP | 1:TP |
| Alias | 1:TP | 1:TP | 1:TP |
| Method Call | 1:TP | 1:FN | 1:FN |
| Reflection | 1:TP 3:FP | 1:FN | 1:FN|

> **Note:** Irrelevant errors or warnings that are justifiably identified are not assessed.

### results by tool

Results for individual tools available as follows;

1. [Checker Framework](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md)
2. [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md)
3. [PMD](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md)
