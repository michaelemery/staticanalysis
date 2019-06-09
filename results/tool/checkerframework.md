# results for checkerframework

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

| dynamic language feature | alias | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/init/checkerframework.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#IntraProcedural)  |  |  |
| InterProcedural |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/init/checkerframework.md#InterProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#InterProcedural) |  |  |
| ReflectMethod |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/init/checkerframework.md#ReflectMethod) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#ReflectMethod) |  |  |
| ReflectMethodOverload |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/init/checkerframework.md#ReflectMethodOverload) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#ReflectMethodOverload) |  |  |
| ReflectFieldAccess |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/init/checkerframework.md#ReflectFieldAccess) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/init/checkerframework.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/checkerframework.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/init/checkerframework.md#InvokeDynamicField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#InvokeDynamicField) |  |  |
| DynamicProxy |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/init/checkerframework.md#DynamicProxy) | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/checkerframework.md#DynamicProxy) |  |  |
| **Score** | - | 16 | 6 | - | - |
 
> Select test result for detail.

<br>

The Checker Framework enhances Java's type system to make it more powerful and useful. This lets software developers detect and prevent errors in their Java programs. The Checker Framework includes compiler plug-ins ("checkers") that find bugs or verify their absence. It also permits you to write your own compiler plug-ins.

<br>

[home](https://github.com/michaelemery/staticanalysis) | [results](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)
