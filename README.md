# static analysis

This repository is in support of the authors Masters Thesis on the effectiveness of Static Analysis tools, techniques, and frameworks.

<br>

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerframework](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

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
| [alias](https://github.com/michaelemery/staticanalysis/tree/master/src/aliasing) | Errors may occur when an object is referenced without consideration for mutations caused by an alias to the same object. |
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

<br>

[JUMP TO RESULTS](https://github.com/michaelemery/staticanalysis/blob/master/results/README.md)
