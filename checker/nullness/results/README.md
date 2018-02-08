# Results

Nullness tests for conducted for the following tools;

1. Checker Framework
2. FindBugs
3. PMD

Detailed results available in the links.

## Summary

Checker Framework (CFW) is consistently sound and precise in non-reflective cases. However, it 
handles reflection in a very rudimentry way that causes excessive false positives. CFW errs on the 
side of caution when encountering reflective code.  

| | CFW | FindBugs | PMD |
| --- | --- | --- | --- |
| Direct | 1:TP | 1:TP | 1:TP |
| Alias | 1:TP | 1:TP | 1:TP |
| Method Call | 1:TP | 1:FN | 1:FN |
| Reflection | 1:TP 3:FP | 1:FN | 1:FN|

> **Note:** Errors or warnings identified that are irrelevanrt to the test are not assessed.