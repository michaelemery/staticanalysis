# Results

Nullness tests for conducted for the following tools;

1. Checker Framework
2. FindBugs
3. PMD

Detailed results available in the links.

## Summary

Checker Framework (CFW) is consistently sound and precise in non-reflective cases. However, it 
handles reflection in a very rudimentary way that causes excessive false positives. CFW errs on the 
side of caution when encountering reflective code. 

Both FindBugs and PMD are less likely to generate FP results are are more precise than CFW. 
However, their lack of caution in complex situations compromises soundness compared to CFW.

| | CFW | FindBugs | PMD |
| --- | --- | --- | --- |
| Direct | 1:TP | 1:TP | 1:TP |
| Alias | 1:TP | 1:TP | 1:TP |
| Method Call | 1:TP | 1:FN | 1:FN |
| Reflection | 1:TP 3:FP | 1:FN | 1:FN|

> **Note:** Irrelevant errors or warnings that are justifiably identified are not assessed.

Overall, CFW is recommended as the most reliable tool for nullness testing given that the FP 
weakness in reflection is offset by the FN results of other tools that were less sound.
