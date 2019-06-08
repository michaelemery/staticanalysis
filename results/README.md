# results

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerframework](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

Use &uarr; this &uarr; navigation bar to group results by the selected *checker type* &#x25c0; **or** &#x25b6; *checker tool*.

### interpretation

Tests are simple programs incorporating a single deliberate error of a specific type. Each test will produce zero or more outcomes that are categorised as either false negative or false positive as follows;
 
 | test outcome| description |
 | --- | :--- |
 | false negative | Checker failed to detect an error of the type being tested. | 
 | false positive |Checker incorrectly identifies safe code as an error (or potential error) of the type being tested. |
 
Although each test incorporates only one intentional error, that error may be detected at multiple locations within the code. This may occur where a checker attempts to identify not just the error, but also it's pre-cursors and cascading effects. Multiple counts of any correctly identified error are only counted once, and are not considered false positives. Where a checker correctly identifies an issue that is unrelated to the test, that outcome is ignored. 

The final result of each test is based on the combination of false negative and false positive outcomes. Outcomes are categorised as either true or false, regardless of the number of occurrences.   

| false negative found | false positive found | result | 
| :---: | :---: | :---: |
| false | false |accurate | 
| false | true | imprecise |
| true | false | unsound |
| true | true | aberrant |
