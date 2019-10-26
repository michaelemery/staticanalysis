# results

[home](https://github.com/michaelemery/staticanalysis)

| dynamic language feature | checkerfwk | infer | nullaway | pmd |  spotbugs |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#InterProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#InterProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#InterProcedural) |
| ReflectConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#ReflectConstructor) |
| ReflectMethod | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#ReflectMethod) |
| ReflectField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#ReflectField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#ReflectField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#ReflectField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#ReflectField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#ReflectField) |
| MethodHandleConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#MethodHandleConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#MethodHandleConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#MethodHandleConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#MethodHandleConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#MethodHandleConstructor) |
| MethodHandleMethod | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#MethodHandleMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#MethodHandleMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#MethodHandleMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#MethodHandleMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#MethodHandleMethod) |
| MethodHandleField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#MethodHandleField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#MethodHandleField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#MethodHandleField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#MethodHandleField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#MethodHandleField) |
| InvokeDynamic | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#InvokeDynamic) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#InvokeDynamic) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#InvokeDynamic) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#InvokeDynamic) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#InvokeDynamic) |
| DynamicProxy | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#DynamicProxy) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#DynamicProxy) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#DynamicProxy) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#DynamicProxy) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#DynamicProxy) |
| UnsafeField | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#UnsafeField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#UnsafeField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullaway.md#UnsafeField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#UnsafeField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#UnsafeField) |
| UnsafeInitialisation | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/checkerframework.md#UnsafeInitialisation) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/infer.md#UnsafeInitialisation) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#UnsafeInitialisation) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/pmd.md#UnsafeInitialisation) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/spotbugs.md#UnsafeInitialisation) |

> Select test result for detail.

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
