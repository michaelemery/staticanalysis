# static analysis

[Results Summary](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md)

<br>

This repository is in support of the authors Masters Thesis on the effectiveness of Static Analysis tools, techniques, and frameworks.

Static program analysis is the analysis of computer software that is performed without actually executing programs (analysis performed on executing programs is known as dynamic analysis). In most cases the analysis is performed on some version of the source code, and in the other cases, some form of the object code.

This project combines checking tools and dynamic language features in order assess the checkers effectiveness in identifying common conditions that result in incorrect programs.

### tools

Source code in the checker section will be analysed by multiple static analysis tools. The results 
of each tool are compared in order to assess overall and relative effectiveness.

| tool | description |
| --- | --- |
| **Checker Framework** | The Checker Framework enhances Java's type system to make it more powerful and useful. This lets software developers detect and prevent errors in their Java programs. The Checker Framework includes compiler plug-ins ("checkers") that find bugs or verify their absence. It also permits you to write your own compiler plug-ins. |
| **Infer** | Open-sourced by Facebook. Infer checks for null pointer exceptions, resource leaks, annotation reachability, missing lock guards, and concurrency race conditions in Android and Java code. |
| **PMD** | PMD is a static source code analyzer. It is mainly concerned with Java and Apex, but supports six other languages. PMD features many built-in checks placed into categories including; best practice, code style, design, documentation, error prone, multithreading, performance and security. The checks used by this project belong primarily to the *error prone* category. |
| **SpotBugs** | SpotBugs is a program to find bugs in Java programs. It looks for instances of “bug patterns” — code instances that are likely to be errors. |

### checker types

 Java’s built-in type-checker finds and prevents many errors — but it doesn’t find and prevent enough errors. Additional checkers used in this project enhance type checking for the following types of error;

| type | description |
| --- | --- |
| [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md)|  Dereferenced expressions are a common cause a null pointer exceptions. |
<!---
| [alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | Errors may occur when an object is referenced without consideration for mutations caused by an alias to the same object. |
| [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | Objects accessed at runtime prior to being fully initialised will cause an error. |
| [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) |Signed and unsigned values are incorrectly mixed together in a computation, and meaningless operations occur such as division on an unsigned value. |
| [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) | Certain parts of an application, using a tainted value can compromise the application’s integrity, causing it to crash, corrupt data, leak private data, etc. |
--->

### dynamic language features

Dynamic programming languages are a class of high-level programming languages which, at runtime, execute many common programming behaviors that static programming languages perform during compilation. These behaviors could include extension of the program, by adding new code, by extending objects and definitions, or by modifying the type system. 

| dynamic language feature | description |
| --- | --- |
| IntraProcedural | Field set via direct value assignment. |
| InterProcedural | Field set via inter-procedural return. |
| ReflectConstructor | Constructors invoked via reflection. |
| ReflectMethod | Methods invoked via reflection. |
| ReflectField | Field set by invoking virtual (non-static) method handle. |
| MethodHandleConstructor | Field set by invoking constructor method handle. |
| MethodHandleMethod | Method handle invocation of method. |
| MethodHandleField | Field set by invoking setter method handle. |
| InvokeDynamic | Field set via dynamic invocation of setter method. |
| DynamicProxy | Field set via dynamic proxy invocation. |
| UnsafeField | Field set via sun.misc.Unsafe. |
| UnsafeInitialisation | Allocate an empty instance of a class directly on the heap via sun.misc.Unsafe. |
*(12 tests)*

### results

For a brief summary of analysis and results, see [results help](https://github.com/michaelemery/staticanalysis/tree/master/results).
