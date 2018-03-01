# checker
A “checker” is a tool that warns you about certain errors or gives you a guarantee that 
those errors do not occur.

This project combines checking tools and dynamic language features in order assess the checkers effectiveness in identifying common causes of incorrect programs.

## tools
Source code in the checker section will be analysed by multiple static analysis tools. The results 
of each tool are compared in order to assess overall and relative effectiveness.

| tool | description |
| --- | --- |
| **Checker Framework** | The Checker Framework enhances Java’s type system by detecting and preventing specific errors in Java programs. |
| **FindBugs** | FindBugs™ is a program to find bugs in Java programs. It looks for instances of "bug patterns" — code instances that are likely to be errors. |
| **PMD** | PMD is a source code analyzer. It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. Additionally it includes CPD, the copy-paste-detector. CPD finds duplicated code in multiple languages. The CDP feature is not used in this project. PMD has numerous categories of checking options, however this project only uses the errorprone.xmlruleset. Other checking options relate more to style. |

## dynamic language features

| feature | description |
| :---: | :---: | :---: |
| **Vanilla** |  |
| **Inter-procedural** |  |
| **Reflection** |  |
| **Invoke Dynamic** |  |
| **Proxy** |  |

## tests
A "checker" generally tests for a variety of conditions that are organised by category. This 
project tests for potential program errors within the following categories:

| test | descrption |
| --- | --- |
| **Aliasing** | Errors may occur when an object is referenced without consideration for mutations caused by an aliasing to the same object. |
| **Inititialisation** | Objects accessed at runtime prior to being fully initialised will cause an error. |
| **Nullness** | Dereferenced expressions are a common cause a null pointer exceptions. |
| **Signedness** |Signed and unsigned values are incorrectly mixed together in a computation, and meaningless operations occur such as division on an unsigned value. |
| **Tainting** | Certain parts of an application, using a tainted value can compromise the application’s integrity, causing it to crash, corrupt data, leak private data, etc. |

## results

### checker framework
|  | vanilla | inter-procedural | reflection | invoke dynamic | proxy |
| --- | :---: | :---: | :---: | :---: | :---: |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/checker/aliasing) |  |  |  |  |  |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/checker/init) |  |  |  |  |  |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/checker/nullness) |  |  |  |  |  |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/checker/signedness) |  |  |  |  |  |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/checker/taint) |  |  |  |  |  |

### findbugs
|  | vanilla | inter-procedural | reflection | invoke dynamic | proxy |
| --- | :---: | :---: | :---: | :---: | :---: |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/checker/aliasing) |  |  |  |  |  |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/checker/init) |  |  |  |  |  |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/checker/nullness) |  |  |  |  |  |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/checker/signedness) |  |  |  |  |  |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/checker/taint) |  |  |  |  |  |


### pmd
|  | vanilla | inter-procedural | reflection | invoke dynamic | proxy |
| --- | :---: | :---: | :---: | :---: | :---: |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/checker/aliasing) |  |  |  |  |  |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/checker/init) |  |  |  |  |  |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/checker/nullness) |  |  |  |  |  |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/checker/signedness) |  |  |  |  |  |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/checker/taint) |  |  |  |  |  |
