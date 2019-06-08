# results for CheckerFwk

[alias](https://github.com/michaelemery/staticanalysis/tree/master/results/alias) | [init](https://github.com/michaelemery/staticanalysis/tree/master/results/init)| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/results/nullness) | [signedness](https://github.com/michaelemery/staticanalysis/tree/master/results/signedness) | [taint](https://github.com/michaelemery/staticanalysis/tree/master/results/taint) &nbsp; &#x25c0; &#x25b6; &nbsp; [CheckerFwk]() | [FindBugs]() | [Infer]() | [PMD]()

<br>

| dynamic language feature | CheckerFwk | FindBugs | Infer | PMD | 
| --- | :---: | :---: | :---: | :---: |
| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/checkerframework.md#IntraProcedural)  |  |  |
| InterProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/checkerframework.md#InterProcedural) |  |  |
| ReflectMethod |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/checkerframework.md#ReflectMethod) |  |  |
| ReflectMethodOverload |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/checkerframework.md#ReflectMethodOverload) |  |  |
| ReflectFieldAccess |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/checkerframework.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/checkerframework.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/checkerframework.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/checkerframework.md#InvokeDynamicField) |  |  |
| DynamicProxy |  |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/checkerframework.md#DynamicProxy) |  |  |

> Select individual results for detail.

<br>

An initialization checker determines whether an object is initialized or not. Any object that is accessed at runtime prior to being fully initialised will cause an error. An object is only partially initialized from the time that its constructor starts until its constructor finishes.

<br>

[home](https://github.com/michaelemery/staticanalysis) | [results](https://github.com/michaelemery/staticanalysis/tree/master/results)
