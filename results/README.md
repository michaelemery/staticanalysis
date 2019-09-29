# results

[results summary](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md)

### analysis

* The output of each checker is analysed line by line.
* Line numbers quoted in each analysis refer to the source code line number the error or warning is referring to.
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
| accurate | Expected issue was detected (TP >= 1) without any false issues (FP = 0) |
| imprecise | Expected issue was detected (TP >= 1) as well as false issues (FP >= 1) |
| unsound | Expected issue was not detected (TP = 0)|

<br>

[home](https://github.com/michaelemery/staticanalysis)
