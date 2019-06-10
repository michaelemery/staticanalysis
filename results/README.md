# results

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

### results scoring

description | false negative /<br> score | false positive /<br> score | result /<br> total score | 
| --- | :---: | :---: | :---: |
| Found the error and nothing else.| false <br> *+2* | false <br> *+1* |accurate <br> *+3* | 
| Found the error but wrongly flagged safe code. | false <br> *+2* | true <br> *-1* | imprecise <br> *+1* |
| Did not find anything. | true <br> *-2*| false <br> *+1* | unsound <br> *-1* |
| Did not find the error, and wrongly flagged safe code. | true <br> *-2* | true <br> *-1* | aberrant <br> *-3* |
