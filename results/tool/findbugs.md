# results for findbugs

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

| dynamic language feature | alias | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/init/findbugs.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#IntraProcedural)  |  |  |
| InterProcedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/findbugs.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#InterProcedural) |  |  |
| ReflectMethod | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/findbugs.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#ReflectMethod) |  |  |
| ReflectMethodOverload | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#ReflectMethodOverload) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/findbugs.md#ReflectMethodOverload) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#ReflectMethodOverload) |  |  |
| ReflectFieldAccess | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#ReflectFieldAccess) | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/results/init/findbugs.md#ReflectFieldAccess) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/findbugs.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/findbugs.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InvokeDynamicField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/findbugs.md#InvokeDynamicField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#InvokeDynamicField) |  |  |
| DynamicProxy | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#DynamicProxy) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/init/findbugs.md#DynamicProxy) | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/findbugs.md#DynamicProxy) |  |  |

> Select test result for detail.

<br>

FindBugs is a program which uses static analysis to look for bugs in Java code. It looks for instances of "bug patterns" — code instances that are likely to be errors. The name FindBugs™ and the FindBugs logo are trademarked by The University of Maryland. FindBugs has been downloaded more than a million times.

<br>

[home](https://github.com/michaelemery/staticanalysis) | [results help](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)
