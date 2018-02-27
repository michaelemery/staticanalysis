# checker
A “checker” is a tool that warns you about certain errors or gives you a guarantee that 
those errors do not occur.

Folders at this level contain sample code for common categories of Java programming 
errors. Some source files have annotated versions for certain tools that require them.

## categories
A "checker" generally tests for a variety of conditions that are organised by category. This 
project tests for potential program errors within the following categories:

| category | description |
| --- | --- |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/checker/aliasing) | Errors may occur when an object is referenced without consideration for mutations caused by an aliasing to the same object. |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/checker/init) | Objects accessed at runtime prior to being fully initialised will cause an error. |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/checker/nullness) | Dereferenced expressions are a common cause a null pointer exceptions. |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/checker/signedness) | Signed and unsigned values are incorrectly mixed together in a computation, and meaningless operations occur such as division on an unsigned value. |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/checker/taint) | Certain parts of an application, using a tainted value can compromise the application’s integrity, causing it to crash, corrupt data, leak private data, etc. |

## tools
Source code in the checker section will be analysed by multiple static analysis tools. The results 
of each tool are compared in order to assess overall and relative effectiveness.

### checkerframework
The Checker Framework enhances Java’s type system by detecting and preventing specific 
errors in Java programs. Some programs require annotated versions of the same source code 
in order for checkingtools to work. In such cases, the category will contain multiple 
versions of the same code. Additional versions are identified with underbar ("\_") 
extensions to the filename.

**Example** <br>
_InterProcedural.java_ has an annotated version named _InterProcedural_CF.java_, to indicate that 
it includes annotaions for _Checker Framework_. Not all programs require annotations for the 
tools to work, so they do not require additional versions. Included versions and their 
suffixes are indicated as follows;

1) **Checker Framework** _(suffix: \_CF)_

### findbugs
FindBugs™ is a program to find bugs in Java programs. It looks for instances of "bug patterns" — 
code instances that are likely to be errors.

### pmd
PMD is a source code analyzer. It finds common programming flaws like unused variables, empty catch 
blocks, unnecessary object creation, and so forth. Additionally it includes CPD, the 
copy-paste-detector. CPD finds duplicated code in multiple languages. The CDP feature is not used 
in this project.

PMD has numerous categories of checking options, however this project only uses the errorprone.xml
ruleset. Other checking options relate more to style.

## results

### checker framework

| | intra-proc | inter-proc | &nbsp alias &nbsp | reflection | invoke dyn |
| --- | :---: | :---: | :---: | :---: | :---: |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/checker/aliasing) | Pass | Fail | N/A | Pass | ? |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/checker/init) | | | | | |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/checker/nullness) | Pass | Pass | Pass | Pass | ? |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/checker/signedness) | | | | | |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/checker/taint) | | | | | |

### findbugs

| | intra-proc | inter-proc | alias | reflection | invoke dyn |
| --- | :---: | :---: | :---: | :---: | :---: |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/checker/aliasing) | | | | | |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/checker/init) | | | | | |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/checker/nullness) | | | | | |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/checker/signedness) | | | | | |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/checker/taint) | | | | | |

### pmd

| | intra-proc | inter-proc | alias | reflection | invoke dyn |
| --- | :---: | :---: | :---: | :---: | :---: |
| [aliasing](https://github.com/michaelemery/staticanalysis/tree/master/checker/aliasing) | | | | | |
| [init](https://github.com/michaelemery/staticanalysis/tree/master/checker/init) | | | | | |
| [nullness](https://github.com/michaelemery/staticanalysis/tree/master/checker/nullness) | | | | | |
| [signedness](https://github.com/michaelemery/staticanalysis/tree/master/checker/signedness) | | | | | |
| [taint](https://github.com/michaelemery/staticanalysis/tree/master/checker/taint) | | | | | |

