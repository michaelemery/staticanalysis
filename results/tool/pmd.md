# results for pmd

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

| dynamic language feature | alias | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#IntraProcedural)  |  |  |
| InterProcedural |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InterProcedural) |  |  |
| ReflectMethod |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#ReflectMethod) |  |  |
| ReflectMethodOverload |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#ReflectMethodOverload) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#ReflectMethodOverload) |  |  |
| ReflectFieldAccess |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#ReflectFieldAccess) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  |  [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InvokeDynamicConstructor)| [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InvokeDynamicField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#InvokeDynamicField) |  |  |
| DynamicProxy |  | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#DynamicProxy) | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/pmd.md#DynamicProxy) |  |  |

> Select test result for detail.

<br>

PMD is a static source code analyzer. It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. It’s mainly concerned with Java and Apex, but supports six other languages.

PMD features many built-in checks placed into categories including; best practice, code style, design, documentation, error prone, multithreading, performance and security. This project is primarily concerned with those rules belonging to the *error prone* category.

<br>

[home](https://github.com/michaelemery/staticanalysis) | [results](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)
