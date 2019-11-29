# results

[home](https://github.com/michaelemery/staticanalysis)

#### no annotation

| dynamic language feature | checkerfwk | infer | nullaway | pmd |  spotbugs |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#IntraProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#InterProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#InterProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#InterProcedural) |
| ReflectConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#ReflectConstructor) |
| ReflectMethod | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#ReflectMethod) |
| ReflectField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#ReflectField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#ReflectField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#ReflectField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#ReflectField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#ReflectField) |
| MethodHandleConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#MethodHandleConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#MethodHandleConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#MethodHandleConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#MethodHandleConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#MethodHandleConstructor) |
| MethodHandleMethod | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#MethodHandleMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#MethodHandleMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#MethodHandleMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#MethodHandleMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#MethodHandleMethod) |
| MethodHandleField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#MethodHandleField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#MethodHandleField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#MethodHandleField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#MethodHandleField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#MethodHandleField) |
| InvokeDynamic | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#InvokeDynamic) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#InvokeDynamic) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#InvokeDynamic) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InvokeDynamic) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#InvokeDynamic) |
| DynamicProxy | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#DynamicProxy) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#DynamicProxy) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#DynamicProxy) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#DynamicProxy) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#DynamicProxy) |
| UnsafeField | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#UnsafeField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#UnsafeField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/nullaway.md#UnsafeField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#UnsafeField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#UnsafeField) |
| UnsafeInitialisation | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#UnsafeInitialisation) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#UnsafeInitialisation) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#UnsafeInitialisation) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#UnsafeInitialisation) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/spotbugs.md#UnsafeInitialisation) |

> Select test result for detail.

#### annotation

| dynamic language feature | checkerfwk | nullaway |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#InterProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#InterProcedural) | |
| ReflectConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#ReflectConstructor) |
| ReflectMethod | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#ReflectMethod)| [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#ReflectMethod) |
| ReflectField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#ReflectField)| [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#ReflectField) |
| MethodHandleConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#MethodHandleConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#MethodHandleConstructor) |
| MethodHandleMethod | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#MethodHandleMethod)| [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#MethodHandleMethod) |
| MethodHandleField | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#MethodHandleField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#MethodHandleField) |
| InvokeDynamic | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#InvokeDynamic)| [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#InvokeDynamic) |
| DynamicProxy | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#DynamicProxy) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#DynamicProxy) |
| UnsafeField | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#UnsafeField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/nullaway.md#UnsafeField) |
| UnsafeInitialisation | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessCheckerFramework/checkerframework.md#UnsafeInitialisation) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullnessJavax/spotbugs.md#UnsafeInitialisation) |

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
