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
| [Checker Framework](https://github.com/michaelemery/staticanalysis/tree/master/checker#checker-framework) | The Checker Framework enhances Java’s type system by detecting and preventing specific errors in Java programs. |
| [FindBugs](https://github.com/michaelemery/staticanalysis/tree/master/checker#findbugs) | FindBugs™ is a program to find bugs in Java programs. It looks for instances of "bug patterns" — code instances that are likely to be errors. |
| [Infer](https://github.com/michaelemery/staticanalysis/tree/master/checker#infer) | Open-sourced by Facebook. Infer checks for null pointer exceptions, resource leaks, annotation reachability, missing lock guards, and concurrency race conditions in Java code. |
| [PMD](https://github.com/michaelemery/staticanalysis/tree/master/checker#pmd) | PMD is a source code analyzer. It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. Additionally it includes CPD, the copy-paste-detector. CPD finds duplicated code in multiple languages. The CDP feature is not used in this project. PMD has numerous categories of checking options, however this project only uses the errorprone.xmlruleset. Other checking options relate more to style. |

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
| IntraProcedural | Test nullness safety within a single method. No dynamic features. |
| InterProcedural | Test nullness safety within multiple methods. No dynamic features. |
| ReflectMethodInvoke | Test nullness safety within methods invoked via reflection. |
| ReflectOverloadInvoke | Test nullness safety within overloaded methods invoked via reflection. |
| ReflectFieldAccess | Test nullness safety on objects directly manipulated via reflective field access. |
| InvokeDynamicVirtual | Test nullness safety within dynamically invoked non-static (virtual) methods. |
| InvokeDynamicConstructor | Test nullness safety on objects manipulated via dynamically invoked constructor. |
| InvokeDynamicField | Test nullness safety on objects directly manipulated via dynamic field access. |
| DynamicProxy | Test nullness safety on proxy instances of the original class interface. |

### reflection syntax and use of instance variables

The first argument of java.lang.reflect.Method.invoke() is the object instance on which a particular method to be invoked. If the method is static, the first argument should be null. This *null* syntax is a common cause of false positives when testing for nullness, therefore instance variables are prefered where static variables may otherwise seem preferable. 

## results

Tests are simple programs incorporating a single deliberate error of a specific type. Each test will produce zero or more outcomes that are categorised as either false negative or false positive as follows;

| outcome| description |
| --- | :--- |
| false negative | Checker failed to detect an error of the type being tested. | 
| false positive |Checker incorrectly identifies safe code as an error (or potential error) of the type being tested. |

Although each test incorporates only one intentional error, that error may be detected at multiple locations within the code. This may occur where a checker attempts to identify not just the error, but also it's pre-cursors and cascading effects. Multiple counts of any correctly identified error are only counted once, and are not considered false positives. Where a checker correctly identifies an error or concern that is unrelated to the test, that outcome is ignored. 

The final result of each test is based on the combination of false negative and false positive outcomes. Outcomes are categorised as either true or false, regardless of the number of occurrences.   

| false negative found | false positive found | result | 
| :---: | :---: | :---: |
| false | false |accurate | 
| false | true | imprecise |
| true | false | unsound |
| true | true | aberrant |

## result summary (by tool)

### checker framework

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#IntraProcedural)  |  |  |
| InterProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InterProcedural) |  |  |
| ReflectMethodInvoke |  |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectMethodInvoke) |  |  |
| ReflectOverloadInvoke |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectOverloadInvoke) |  |  |
| ReflectFieldAccess |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#InvokeDynamicField) |  |  |
| DynamicProxy |  |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/checkerframework.md#DynamicProxy) |  |  |

> Select individual results for detail.

### findbugs

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#IntraProcedural)  |  |  |
| InterProcedural |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#InterProcedural) |  |  |
| ReflectMethodInvoke |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#ReflectMethodInvoke) |  |  |
| ReflectOverloadInvoke |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#ReflectOverloadInvoke) |  |  |
| ReflectFieldAccess |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#InvokeDynamicField) |  |  |
| DynamicProxy |  |  | [aberrant](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#DynamicProxy) |  |  |

> Select individual results for detail.

### infer

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#IntraProcedural)  |  |  |
| InterProcedural |  |  | [imprecise](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#InterProcedural) |  |  |
| ReflectMethodInvoke |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#ReflectMethodInvoke) |  |  |
| ReflectOverloadInvoke |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/findbugs.md#ReflectOverloadInvoke) |  |  |
| ReflectFieldAccess |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/infer/findbugs.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#InvokeDynamicField) |  |  |
| DynamicProxy |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/infer.md#DynamicProxy) |  |  |

> Select individual results for detail.

### pmd

| feature | aliasing | init | nullness | signedness | taint |
| --- | :---: | :---: | :---: | :---: | :---: |
| IntraProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#IntraProcedural)  |  |  |
| InterProcedural |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#InterProcedural) |  |  |
| ReflectMethodInvoke |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#ReflectMethodInvoke) |  |  |
| ReflectOverloadInvoke |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#ReflectOverloadInvoke) |  |  |
| ReflectFieldAccess |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#ReflectFieldAccess) |  |  |
| InvokeDynamicVirtual |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#InvokeDynamicVirtual) |  |  |
| InvokeDynamicConstructor |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#InvokeDynamicConstructor) |  |  |
| InvokeDynamicField |  |  | [unsound](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#InvokeDynamicField) |  |  |
| DynamicProxy |  |  | [accurate](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/pmd.md#DynamicProxy) |  |  |

> Select individual results for detail.
