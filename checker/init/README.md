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

| feature | [Checker FW](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md) | [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md) | [Infer](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md) | [PMD](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md) | 
| --- | :---: | :---: | :---: | :---: |
| IntraProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#IntraProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#IntraProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md#IntraProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md#IntraProcedural) |
| InterProcedural | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InterProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#InterProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md#InterProcedural) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md#InterProcedural) |
| ReflectMethodInvoke | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#ReflectMethodInvoke) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#ReflectMethodInvoke) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md#ReflectMethodInvoke) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md#ReflectMethodInvoke) |
| ReflectOverloadInvoke | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#ReflectOverloadInvoke) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#ReflectOverloadInvoke) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md#ReflectOverloadInvoke) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md#ReflectOverloadInvoke) |
| ReflectFieldAccess | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#ReflectFieldAccess) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#ReflectFieldAccess) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md#ReflectFieldAccess) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md#ReflectFieldAccess) |
| InvokeDynamicVirtual | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InvokeDynamicVirtual) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#InvokeDynamicVirtual) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md#InvokeDynamicVirtual) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md#InvokeDynamicVirtual) |
| InvokeDynamicConstructor | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InvokeDynamicConstructor) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#InvokeDynamicConstructor) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md#InvokeDynamicConstructor) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md#InvokeDynamicConstructor) |
| InvokeDynamicField | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#InvokeDynamicField) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#InvokeDynamicField) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md#InvokeDynamicField) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md#InvokeDynamicField) |
| Dynamicproxy | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/checkerframework.md#Dynamicproxy) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/findbugs.md#Dynamicproxy) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/infer.md#Dynamicproxy) | [xxx](https://github.com/michaelemery/staticanalysis/blob/master/checker/init/pmd.md#Dynamicproxy) |


> Select individual results for detail.
