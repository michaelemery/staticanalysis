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

| feature | [Checker FW](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md) | [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md) | [Infer](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md) | [PMD](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md) | 
| --- | :---: | :---: | :---: | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md#IntraProcedural) | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#IntraProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md#IntraProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md#InterProcedural) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#InterProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md#InterProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md#InterProcedural) |
| ReflectMethod | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md#ReflectMethod) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#ReflectMethod) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md#ReflectMethod) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md#ReflectMethod) |
| ReflectOMethodOverload | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md#ReflectOMethodOverload) | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#ReflectOMethodOverload) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md#ReflectOMethodOverload) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md#ReflectOMethodOverload) |
| ReflectFieldAccess | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md#ReflectFieldAccess) | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#ReflectFieldAccess) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md#ReflectFieldAccess) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md#InvokeDynamicVirtual) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#InvokeDynamicVirtual) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md#InvokeDynamicVirtual) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md#InvokeDynamicConstructor) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#InvokeDynamicConstructor) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md#InvokeDynamicConstructor) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md#InvokeDynamicField) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#InvokeDynamicField) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md#InvokeDynamicField) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md#InvokeDynamicField) |
| DynamicProxy | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/checkerframework.md#DynamicProxy) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/findbugs.md#DynamicProxy) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/infer.md#DynamicProxy) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/init/pmd.md#DynamicProxy) |


> Select individual results for detail.
