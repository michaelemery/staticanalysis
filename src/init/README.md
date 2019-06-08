# init
An initialization checker determines whether an object is initialized or not. Any object 
that is accessed at runtime prior to being fully initialised will cause an error. An 
object is only partially initialized from the time that its constructor starts until its 
constructor finishes.

### test objectives
Identify where the following initialisation issues occur;
1. constructor fails to initialise field before exit,
2. constructor accesses uninitialised field, or
3. constructor calls method that accesses an uninitialised field.

### results

| feature | [Checker FW](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md) | [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md) | [Infer](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md) | [PMD](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md) | 
| --- | :---: | :---: | :---: | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md#IntraProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md#IntraProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md#InterProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md#InterProcedural) |
| ReflectMethod | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md#ReflectMethod) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md#ReflectMethod) |
| ReflectOMethodOverload | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md#ReflectOMethodOverload) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md#ReflectOMethodOverload) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md#ReflectOMethodOverload) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md#ReflectOMethodOverload) |
| ReflectFieldAccess | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md#ReflectFieldAccess) | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md#ReflectFieldAccess) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md#ReflectFieldAccess) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md#InvokeDynamicVirtual) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md#InvokeDynamicConstructor) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md#InvokeDynamicField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md#InvokeDynamicField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md#InvokeDynamicField) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md#InvokeDynamicField) |
| DynamicProxy | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/src/init/checkerframework.md#DynamicProxy) | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/src/init/findbugs.md#DynamicProxy) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/init/infer.md#DynamicProxy) | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/src/init/pmd.md#DynamicProxy) |

> Select individual results for detail.
