# results for alias

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

| dynamic language feature | checkerfwk | findbugs | infer | pmd | 
| --- | :---: | :---: | :---: | :---: |
| IntraProcedural | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#IntraProcedural) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#IntraProcedural) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#IntraProcedural) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#IntraProcedural) |
| InterProcedural | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#InterProcedural) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InterProcedural) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InterProcedural) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#InterProcedural) |
| ReflectMethod | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#ReflectMethod) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#ReflectMethod) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#ReflectMethod) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#ReflectMethod) |
| ReflectOMethodOverload | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#ReflectOMethodOverload) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#ReflectOMethodOverload) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#ReflectOMethodOverload) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#ReflectOMethodOverload) |
| ReflectFieldAccess | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#ReflectFieldAccess) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#ReflectFieldAccess) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#ReflectFieldAccess) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#InvokeDynamicVirtual) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InvokeDynamicVirtual) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InvokeDynamicVirtual) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#InvokeDynamicConstructor) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InvokeDynamicConstructor) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InvokeDynamicConstructor) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#InvokeDynamicField) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InvokeDynamicField) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InvokeDynamicField) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#InvokeDynamicField) |
| DynamicProxy | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#DynamicProxy) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#DynamicProxy) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#DynamicProxy) | [](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#DynamicProxy) |
| **score** |  |  |  |  |  |

> Select test result for detail.

<br>

The Aliasing Checker identifies expressions that definitely have no aliases.

Two expressions are aliased when they have the same non-primitive value; that is, they are references to the identical Java object in the heap. Another way of saying this is that two expressions, exprA and exprB, are aliases of each other when exprA == exprB at the same program point.

Assigning to a variable or field typically creates an alias. For example, after the statement a = b;, the variables a and b are aliased.

Knowing that an expression is not aliased permits more accurate reasoning about how side effects modify the expression’s value.

<br>

[home](https://github.com/michaelemery/staticanalysis) | [results help](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)
