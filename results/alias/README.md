# results for alias

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerfwk](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

| dynamic language feature | checkerfwk | findbugs | infer | pmd | 
| --- | :---: | :---: | :---: | :---: |
| IntraProcedural | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#IntraProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#IntraProcedural) | [unsound(https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#IntraProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#IntraProcedural) |
| InterProcedural | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#InterProcedural) |
| ReflectMethod | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#ReflectMethod) |
| ReflectMethodOverload | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#ReflectOMethodOverload) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#ReflectOMethodOverload) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#ReflectOMethodOverload) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#ReflectOMethodOverload) |
| ReflectFieldAccess | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#ReflectFieldAccess) | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#ReflectFieldAccess) | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#ReflectFieldAccess) | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#InvokeDynamicField) | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#InvokeDynamicField) | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#InvokeDynamicField) | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#InvokeDynamicField) |
| DynamicProxy | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/checkerframework.md#DynamicProxy) | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/findbugs.md#DynamicProxy) | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/infer.md#DynamicProxy) | [N/A](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/pmd.md#DynamicProxy) |

> Select test result for detail.

<br>

The Aliasing Checker identifies expressions that definitely have no aliases.

Two expressions are aliased when they have the same non-primitive value; that is, they are references to the identical Java object in the heap. Another way of saying this is that two expressions, exprA and exprB, are aliases of each other when exprA == exprB at the same program point.

Assigning to a variable or field typically creates an alias. For example, after the statement a = b;, the variables a and b are aliased.

Knowing that an expression is not aliased permits more accurate reasoning about how side effects modify the expression’s value.

<br>

[home](https://github.com/michaelemery/staticanalysis) | [results help](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)
