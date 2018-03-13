# checker
A “checker” is a tool that warns you about certain errors or gives you a guarantee that 
those errors do not occur.

This project combines checking tools and dynamic language features in order assess the checkers effectiveness in identifying common conditions that result in incorrect programs.

## test components

### tools

Source code in the checker section will be analysed by multiple static analysis tools. The results 
of each tool are compared in order to assess overall and relative effectiveness.

| tool | description |
| --- | --- |
| Checker Framework | The Checker Framework enhances Java’s type system by detecting and preventing specific errors in Java programs. |
| FindBugs | FindBugs™ is a program to find bugs in Java programs. It looks for instances of "bug patterns" — code instances that are likely to be errors. |
| Infer | Open-sourced by Facebook. Infer checks for null pointer exceptions, resource leaks, annotation reachability, missing lock guards, and concurrency race conditions in Java code. |
| PMD | PMD is a source code analyzer. It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. Additionally it includes CPD, the copy-paste-detector. CPD finds duplicated code in multiple languages. The CDP feature is not used in this project. PMD has numerous categories of checking options, however this project only uses the errorprone.xmlruleset. Other checking options relate more to style. |

### checker types

 Java’s built-in type-checker finds and prevents many errors — but it doesn’t find and prevent enough errors. Additional checkers used in this project enhance type checking for the following types of error;

| type | description |
| --- | --- |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/checker/aliasing) | Errors may occur when an object is referenced without consideration for mutations caused by an aliasing to the same object. |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/checker/init)| Objects accessed at runtime prior to being fully initialised will cause an error. |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/checker/nullness)| Dereferenced expressions are a common cause a null pointer exceptions. |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/checker/signedness)|Signed and unsigned values are incorrectly mixed together in a computation, and meaningless operations occur such as division on an unsigned value. |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/checker/taint) | Certain parts of an application, using a tainted value can compromise the application’s integrity, causing it to crash, corrupt data, leak private data, etc. |

> Select type links for results by category.

### dynamic language features

Dynamic programming languages are a class of high-level programming languages which, at runtime, execute many common programming behaviors that static programming languages perform during compilation. These behaviors could include extension of the program, by adding new code, by extending objects and definitions, or by modifying the type system. 

| feature | description |
| --- | --- |
| VanillaIntraProcedural | No dynamic features. Intraprocedural. |
| VanillaInterProcedural | No dynamic features. Uses interprocedural data flow. |
| ReflectMethodInvokeIntraProcedural | Method invocation via reflection only using locally defined parameters. |
| ReflectMethodInvokeInterProcedural | Method invocation via reflection using parameters defined in other methods. |
| ReflectOverloadInvokeInterProcedural | Overloaded method invocation via reflection using parameters defined in other methods. |
| ReflectMethodHandleIntraProcedural | Method invocation via method handle only using locally defined parameters. |
| ReflectFieldAccessIntraProcedural | Field access via reflection only using locally defined parameters. |
| ReflectFieldAccessInterProcedural | Field access via reflection using parameters defined in other methods. |
| InvokeDynamic | A bytecode instruction that facilitates the implementation of dynamic languages (for the JVM) through dynamic method invocation. |
| Proxy | Proxy objects allow additiion or modification of functionality within an class. The proxy object is used instead of the original class. |

### reflection syntax and use of instance variables

The first argument of java.lang.reflect.Method.invoke() is the object instance on which a particular method to be invoked. If the method is static, the first argument should be null. This *null* syntax is a common cause of false positives when testing for nullness, therefore instance variables are prefered where static variables may otherwise seem preferable. 

## result summary (by tool)

### checker framework

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| VanillaIntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanillaintraprocedural)  |  |  |
| VanillaInterProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanillainterprocedural) |  |  |
| ReflectMethodInvokeIntraProcedural |  |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectmethodinvokeintraprocedural) |  |  |
| ReflectMethodInvokeInterProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectmethodinvokeinterprocedural) |  |  |
| ReflectOverloadInvokeInterProcedural |  |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectoverloadinvokeinterprocedural) |  |  |
| ReflectMethodHandleIntraProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectmethodhandleintraprocedural) |  |  |
| ReflectFieldAccessIntraProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectfieldaccessintraprocedural) |  |  |
| ReflectFieldAccessInterProcedural |  |  | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#reflectfieldaccessinterprocedural) |  |  |
| InvokeDynamic |  |  | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#invokedynamic) |  |  |
| Proxy |  |  | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#proxy) |  |  |

> Select individual results for detail.

### findbugs

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| VanillaIntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanillaintraprocedural)  |  |  |
| VanillaInterProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanillainterprocedural) |  |  |
| ReflectMethodInvokeIntraProcedural |  |  | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodinvokeintraprocedural) |  |  |
| ReflectMethodInvokeInterProcedural |  |  | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodinvokeinterprocedural) |  |  |
| ReflectOverloadInvokeInterProcedural |  |  | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectoverloadinvokeinterprocedural) |  |  |
| ReflectMethodHandleIntraProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectmethodhandleintraprocedural) |  |  |
| ReflectFieldAccessIntraProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectfieldaccessintraprocedural) |  |  |
| ReflectFieldAccessInterProcedural |   |  | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#reflectfieldaccessinterprocedural) |  |  |
| InvokeDynamic |  |  | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#invokedynamic) |  |  |
| Proxy |  |  | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#proxy) |  |  |

> Select individual results for detail.

### pmd

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| VanillaIntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanillaintraprocedural) |  |  |
| VanillaInterProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanillainterprocedural) |  |  |
| ReflectMethodInvokeIntraProcedural |  |  | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectmethodinvokeintraprocedural) |  |  |
| ReflectMethodInvokeInterProcedural |  |  | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectmethodinvokeinterprocedural) |  |  |
| ReflectOverloadInvokeInterProcedural |  |  | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectoverloadinvokeinterprocedural) |  |  |
| ReflectMethodHandleIntraProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectmethodhandleintraprocedural) |  |  |
| ReflectFieldAccessIntraProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectfieldaccessintraprocedural) |  |  |
| ReflectFieldAccessInterProcedural |  |  | [redundant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#reflectfieldaccessinterprocedural) |  |  |
| InvokeDynamic |  |  | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#invokedynamic) |  |  |
| Proxy |  |  | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#proxy) |  |  |

> Select individual results for detail.

### infer

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| VanillaIntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#vanillaintraprocedural) |  |  |
| VanillaInterProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#vanillainterprocedural) |  |  |
| ReflectMethodInvokeIntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectmethodinvokeintraprocedural) |  |  |
| ReflectMethodInvokeInterProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectmethodinvokeinterprocedural) |  |  |
| ReflectOverloadInvokeInterProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectoverloadinvokeinterprocedural) |  |  |
| ReflectMethodHandleIntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectmethodhandleintraprocedural) |  |  |
| ReflectFieldAccessIntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectfieldaccessintraprocedural) |  |  |
| ReflectFieldAccessInterProcedural |  |  | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#reflectfieldaccessinterprocedural) |  |  |
| InvokeDynamic |  |  | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#invokedynamic) |  |  |
| Proxy |  |  | [tbc](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#proxy) |  |  |

> Select individual results for detail.
