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
| PMD | PMD is a source code analyzer. It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. Additionally it includes CPD, the copy-paste-detector. CPD finds duplicated code in multiple languages. The CDP feature is not used in this project. PMD has numerous categories of checking options, however this project only uses the errorprone.xmlruleset. Other checking options relate more to style. |

### categories

 Java’s built-in type-checker finds and prevents many errors — but it doesn’t find and prevent enough errors. Additional checkers used in this project enhance type checking in the following categories;

| category | description |
| --- | --- |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/checker/aliasing) | Errors may occur when an object is referenced without consideration for mutations caused by an aliasing to the same object. |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/checker/init)| Objects accessed at runtime prior to being fully initialised will cause an error. |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/checker/nullness)| Dereferenced expressions are a common cause a null pointer exceptions. |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/checker/signedness)|Signed and unsigned values are incorrectly mixed together in a computation, and meaningless operations occur such as division on an unsigned value. |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/checker/taint) | Certain parts of an application, using a tainted value can compromise the application’s integrity, causing it to crash, corrupt data, leak private data, etc. |

> Select category links for results by category.

### dynamic language features

Dynamic programming languages are a class of high-level programming languages which, at runtime, execute many common programming behaviors that static programming languages perform during compilation. These behaviors could include extension of the program, by adding new code, by extending objects and definitions, or by modifying the type system. 

| feature | description |
| --- | --- |
| Vanilla | No dynmaic features. Intraprocedural. |
| Interprocedural | No dynmaic features. Test occurs across mutliple methods. |
| IntraproceduralMethodInvocation | Method invoked *intraprocedurally* via reflection. |
| IntraproceduralReflectiveFieldAcces | Field accessed *intraprocedurally* via reflection. |
| InterproceduralMethodInvocation | Method invoked *interprocedurally* via reflection. |
| InterproceduralReflectiveFieldAcces | Field accessed *interprocedurally* via reflection. |
| InterproceduralOverloadInvocation | Overloaded method invoked *interprocedurally* via reflection. |
| InvokeDynamic | A bytecode instruction that facilitates the implementation of dynamic languages (for the JVM) through dynamic method invocation. |
| Proxy | Proxy objects allow additiion or modification of functionality within an class. The proxy object is used instead of the original class. |

### reflection syntax

TYhe first argument of java.lang.reflect.Method.invoke() is the object instance on which a particular method to be invoked. If the method is static, the first argument should be null. This *null* syntax is a common cause of false positives when testing for nullness, therefore instance variables are prefered where static variables may otherwise seem preferable. 

## results (by tool)

### checker framework

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| Vanilla | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#vanilla) |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#vanilla)  |  |  |
| Interprocedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/checkerframework.md#reflect) |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#interprocedural) |  |  |
| IntraproceduralMethodInvocation | - |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#intraproceduralmethodinvocation)  |  |  |
| InterproceduralMethodInvocation | - |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#interproceduralmethodinvocation) |  |  |
| InterproceduralOverloadInvocation | - |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#interproceduraloverloadinvocation) |  |  |
| IntraproceduralReflectiveFieldAcces | - |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#intraproceduralreflectivefieldaccess) |  |  |
| InterproceduralReflectiveFieldAcces | - |  | - |  |  |
| InvokeDynamic | - |  |  |  |  |
| Proxy | - |  |  |  |  |

> Select individual results for detail.

### findbugs

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| Vanilla | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#vanilla) |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#vanilla)  |  |  |
| Interprocedural | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/findbugs.md#interprocedural) |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#interprocedural) |  |  |
| IntraproceduralMethodInvocation | - |  | - |  |  |
| InterproceduralMethodInvocation | - |  | - |  |  |
| InterproceduralOverloadInvocation | - |  | - |  |  |
| IntraproceduralReflectiveFieldAcces | - |  | - |  |  |
| InterproceduralReflectiveFieldAcces | - |  | - |  |  |
| InvokeDynamic | - |  | - |  |  |
| Proxy | - |  | - |  |  |

> Select individual results for detail.

### pmd

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| Vanilla | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#vanilla) |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#vanilla) |  |  |
| Interprocedural | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#interprocedural) |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#interprocedural) |  |  |
| IntraproceduralMethodInvocation | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/aliasing/pmd.md#reflection) |  | - |  |  |
| IntraproceduralMethodInvocation | - |  | - |  |  |
| InterproceduralMethodInvocation | - |  | - |  |  |
| InterproceduralOverloadInvocation | - |  | - |  |  |
| IntraproceduralReflectiveFieldAcces | - |  | - |  |  |
| InterproceduralReflectiveFieldAcces | - |  | - |  |  |
| InvokeDynamic | - |  | - |  |  |
| Proxy | - |  | - |  |  |

> Select individual results for detail.
