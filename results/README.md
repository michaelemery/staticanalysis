# results

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

From the tool bar, select; 
* a dynamic language feature (alias, init, nullness, signedness, or taint), to see all results for that language feature.
* a checker (checkerframework, findbugs, infer, or pmd), to see all results for that checker.

### analysis

* The output of each checker is analysed line by line.
* Line numbers quoted in each analysis refer to the source code line number the error or warning os referring to.
* Each line is categorised as True Positive (TP), False Positive (FP), or not applicable (NA) as follows;

| Analysis | Description |
| :---: | :--- |
| TP | An expected issue was detected |
| FP | An issue occurred where none was expected |
| NA | An valid issue was detected but was not applicable to the test |

### results

* The combined analyses for each test form the result as follows;

| Result | Description |
| :---: | :--- |
| accurate | Expected issue was detected (TP = 1+) without any false issues (FP = 0) |
| imprecise | Expected issue (TP) was detected along with false issues (FP = 1+) |
| unsound | Expected issue was not detected (TP = 0)|
