# results



[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md)

[CheckerFwk]() | [FindBugs]() | [Infer]() | [PMD]()


The final result of each test is based on the combination of false negative and false positive outcomes. Outcomes are categorised as either true or false, regardless of the number of occurrences.   

| false negative found | false positive found | result | 
| :---: | :---: | :---: |
| false | false |accurate | 
| false | true | imprecise |
| true | false | unsound |
| true | true | aberrant |
