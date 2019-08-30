# results for infer

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

| dynamic language feature | alias | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/init/infer.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#IntraProcedural) |  |  |
| InterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InterProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/init/infer.md#InterProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#InterProcedural) |  |  |
| ReflectMethod | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/infer.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#ReflectMethod) |  |  |
| ReflectConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/infer.md#ReflectConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#ReflectConstructor) |  |  |
| ReflectField | [NA](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#ReflectField) |  [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/init/infer.md#ReflectField)| [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#ReflectField) |  |  |
| InvokeDynamicMethod | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InvokeDynamicMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/infer.md#InvokeDynamicMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#InvokeDynamicMethod) |  |  |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/infer.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/infer/findbugs.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField | [NA](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InvokeDynamicField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/infer.md#InvokeDynamicField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#InvokeDynamicField) |  |  |
| DynamicProxy | [NA](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#DynamicProxy) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/infer.md#DynamicProxy) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/infer.md#DynamicProxy) |  |  |

> Select test result for detail.

<br>

Open-sourced by Facebook. Infer checks for null pointer exceptions, resource leaks, annotation reachability, missing lock guards, and concurrency race conditions in Android and Java code.

<br>

[home](https://github.com/michaelemery/staticanalysis) | [results help](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)
