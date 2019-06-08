# static analysis

This repository is in support of the authors Masters Thesis on the effectiveness of Static Analysis tools, techniques, and frameworks.

Static program analysis is the analysis of computer software that is performed without actually executing programs (analysis performed on executing programs is known as dynamic analysis). In most cases the analysis is performed on some version of the source code, and in the other cases, some form of the object code.

This project combines checking tools and dynamic language features in order assess the checkers effectiveness in identifying common conditions that result in incorrect programs.

### tools

Source code in the checker section will be analysed by multiple static analysis tools. The results 
of each tool are compared in order to assess overall and relative effectiveness.

| tool | description |
| --- | --- |
| [Checker Framework](https://github.com/michaelemery/staticanalysis#checker-framework) | The Checker Framework enhances Java’s type system by detecting and preventing specific errors in Java programs. |
| [FindBugs](https://github.com/michaelemery/staticanalysis#findbugs) | FindBugs™ is a program to find bugs in Java programs. It looks for instances of "bug patterns" — code instances that are likely to be errors. |
| [Infer](https://github.com/michaelemery/staticanalysis#infer) | Open-sourced by Facebook. Infer checks for null pointer exceptions, resource leaks, annotation reachability, missing lock guards, and concurrency race conditions in Java code. |
| [PMD](https://github.com/michaelemery/staticanalysis#pmd) | PMD is a source code analyzer. It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. Additionally it includes CPD, the copy-paste-detector. CPD finds duplicated code in multiple languages. The CDP feature is not used in this project. PMD has numerous categories of checking options, however this project only uses the errorprone.xmlruleset. Other checking options relate more to style. |

### checker types

 Java’s built-in type-checker finds and prevents many errors — but it doesn’t find and prevent enough errors. Additional checkers used in this project enhance type checking for the following types of error;

| type | description |
| --- | --- |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/src/aliasing) | Errors may occur when an object is referenced without consideration for mutations caused by an aliasing to the same object. |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/src/init)| Objects accessed at runtime prior to being fully initialised will cause an error. |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/src/nullness)| Dereferenced expressions are a common cause a null pointer exceptions. |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/src/signedness)|Signed and unsigned values are incorrectly mixed together in a computation, and meaningless operations occur such as division on an unsigned value. |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/src/taint) | Certain parts of an application, using a tainted value can compromise the application’s integrity, causing it to crash, corrupt data, leak private data, etc. |

> Select type links for results by category.

### dynamic language features

Dynamic programming languages are a class of high-level programming languages which, at runtime, execute many common programming behaviors that static programming languages perform during compilation. These behaviors could include extension of the program, by adding new code, by extending objects and definitions, or by modifying the type system. 

| feature | description |
| --- | --- |
| IntraProcedural | Single method. No dynamic features. |
| InterProcedural | Multiple methods. No dynamic features. |
| ReflectMethod | Methods invoked via reflection. |
| ReflectMethodOverload | Overloaded methods invoked via reflection. |
| ReflectFieldAccess | Objects directly manipulated via reflective field access. |
| InvokeDynamicVirtual | Dynamically invoked non-static (virtual) methods. |
| InvokeDynamicConstructor | Objects manipulated via dynamically invoked constructor. |
| InvokeDynamicField | Objects directly manipulated via dynamic field access. |
| DynamicProxy | Proxy instances of the original class interface. |

## result summary (by tool)

### checker framework

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

### findbugs

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#IntraProcedural)  |  |  |
| InterProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#InterProcedural) |  |  |
| ReflectMethod |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#ReflectMethod) |  |  |
| ReflectMethodOverload |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#ReflectMethodOverload) |  |  |
| ReflectFieldAccess |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#InvokeDynamicField) |  |  |
| DynamicProxy |  |  | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#DynamicProxy) |  |  |

> Select individual results for detail.

### infer

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/infer.md#IntraProcedural)  |  |  |
| InterProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/infer.md#InterProcedural) |  |  |
| ReflectMethod |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/infer.md#ReflectMethod) |  |  |
| ReflectMethodOverload |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/findbugs.md#ReflectMethodOverload) |  |  |
| ReflectFieldAccess |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/infer.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/infer.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/infer/findbugs.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/infer.md#InvokeDynamicField) |  |  |
| DynamicProxy |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/infer.md#DynamicProxy) |  |  |

> Select individual results for detail.

### pmd

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/pmd.md#IntraProcedural)  |  |  |
| InterProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/pmd.md#InterProcedural) |  |  |
| ReflectMethod |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/pmd.md#ReflectMethod) |  |  |
| ReflectMethodOverload |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/pmd.md#ReflectMethodOverload) |  |  |
| ReflectFieldAccess |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/pmd.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/pmd.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/pmd.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/pmd.md#InvokeDynamicField) |  |  |
| DynamicProxy |  |  | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/src/nullness/pmd.md#DynamicProxy) |  |  |

> Select individual results for detail.
