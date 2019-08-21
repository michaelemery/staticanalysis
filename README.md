# static analysis

[alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md) | [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) | [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) &nbsp; &#x25c0; &#x25b6; &nbsp; [checkerframework](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | [findbugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | [infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | [pmd](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md)

<br>

This repository is in support of the authors Masters Thesis on the effectiveness of Static Analysis tools, techniques, and frameworks.

Static program analysis is the analysis of computer software that is performed without actually executing programs (analysis performed on executing programs is known as dynamic analysis). In most cases the analysis is performed on some version of the source code, and in the other cases, some form of the object code.

This project combines checking tools and dynamic language features in order assess the checkers effectiveness in identifying common conditions that result in incorrect programs.

### tools

Source code in the checker section will be analysed by multiple static analysis tools. The results 
of each tool are compared in order to assess overall and relative effectiveness.

| tool | description |
| --- | --- |
| [Checker Framework](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/checkerframework.md) | The Checker Framework enhances Java's type system to make it more powerful and useful. This lets software developers detect and prevent errors in their Java programs. The Checker Framework includes compiler plug-ins ("checkers") that find bugs or verify their absence. It also permits you to write your own compiler plug-ins. |
| [FindBugs](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/findbugs.md) | FindBugs is a program which uses static analysis to look for bugs in Java code. It looks for instances of "bug patterns" — code instances that are likely to be errors. The name FindBugs™ and the FindBugs logo are trademarked by The University of Maryland. FindBugs has been downloaded more than a million times. |
| [Infer](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/infer.md) | Open-sourced by Facebook. Infer checks for null pointer exceptions, resource leaks, annotation reachability, missing lock guards, and concurrency race conditions in Android and Java code. |
| [PMD](https://github.com/michaelemery/staticanalysis/blob/master/results/tool/pmd.md) | PMD is a static source code analyzer. It is mainly concerned with Java and Apex, but supports six other languages. PMD features many built-in checks placed into categories including; best practice, code style, design, documentation, error prone, multithreading, performance and security. The checks used by this project belong primarily to the *error prone* category. |

### checker types

 Java’s built-in type-checker finds and prevents many errors — but it doesn’t find and prevent enough errors. Additional checkers used in this project enhance type checking for the following types of error;

| type | description |
| --- | --- |
| [alias](https://github.com/michaelemery/staticanalysis/blob/master/results/alias/README.md) | Errors may occur when an object is referenced without consideration for mutations caused by an alias to the same object. |
| [init](https://github.com/michaelemery/staticanalysis/blob/master/results/init/README.md) | Objects accessed at runtime prior to being fully initialised will cause an error. |
| [nullness](https://github.com/michaelemery/staticanalysis/blob/master/results/nullness/README.md)|  Dereferenced expressions are a common cause a null pointer exceptions. |
| [signedness](https://github.com/michaelemery/staticanalysis/blob/master/results/signedness/README.md) |Signed and unsigned values are incorrectly mixed together in a computation, and meaningless operations occur such as division on an unsigned value. |
| [taint](https://github.com/michaelemery/staticanalysis/blob/master/results/taint/README.md) | Certain parts of an application, using a tainted value can compromise the application’s integrity, causing it to crash, corrupt data, leak private data, etc. |

> Select type links for results by category.

### dynamic language features

Dynamic programming languages are a class of high-level programming languages which, at runtime, execute many common programming behaviors that static programming languages perform during compilation. These behaviors could include extension of the program, by adding new code, by extending objects and definitions, or by modifying the type system. 

| dynamic language feature | description |
| --- | --- |
| IntraProcedural | Single method. No dynamic features. |
| InterProcedural | Multiple methods. No dynamic features. |
| ReflectMethod | Methods invoked via reflection. |
| ReflectConstructor | Constructors invoked via reflection. |
| ReflectField | Objects directly manipulated via reflective field access. |
| InvokeDynamicMethod | Dynamically invoked via dynamically invoked methods. |
| InvokeDynamicConstructor | Objects manipulated via dynamically invoked constructor. |
| InvokeDynamicField | Objects directly manipulated via dynamic field access. |
| DynamicProxy | Proxy instances of the original class interface. |

### interpretation of results

Tests are simple programs incorporating a single deliberate error of a specific type. Each test will produce zero or more outcomes that are categorised as either false negative or false positive as follows;
 
 | test outcome| description |
 | --- | :--- |
 | false negative | Checker failed to detect an error of the type being tested. | 
 | false positive |Checker incorrectly identifies safe code as an error (or potential error) of the type being tested. |
 
Some errors may be detected at multiple locations within the code. This may occur where a checker attempts to identify not just the error, but also it's pre-cursors and cascading effects. Multiple counts of any correctly identified error are only counted once, and are not considered false positives. Where a checker correctly identifies an issue that is unrelated to the test, that outcome is recorded as Not Applicable (NA).

The final result of each test is based on the combination of false negative and false positive outcomes. Descriptions are consistent regardless of how many false negatives or false positives are identified by the the checker in each test.

| result | description |
| :---: | --- |
| **accurate** | Found the error and nothing else. |
| **imprecise** | Found the error but wrongly flagged safe code. |
| **unsound** | Did not find anything. | yes <br> *-2* |
| **NA** | Test not applicable for checker / language feature combination |
