# static analysis
Static program analysis is the analysis of computer software that is performed without 
actually executing programs (analysis performed on executing programs is known as 
dynamic analysis). In most cases the analysis is performed on some version of the source 
code, and in the other cases, some form of the object code.
This repository is in support of the authors Masters Thesis on the effectiveness of 
Static Analysis tools, techniques, and frameworks.

Folders at this level contain sample code for common categories of Java programming 
errors, as well as additional libraries _(lib)_ for resources required by various 
demonstrations. 

## categories

This project conducts multiple categories of testing that include; dedicated static analysis tools 
that check for certain types of errors, tests for IDE effectiveness at refactoring code in complex 
situations, the and correctness of auto-completed and auto-generated code snippets in certain 
situations.

| category | description |
| --- | --- |
| [checker](https://github.com/michaelemery/staticanalysis/tree/master/checker) | Code for testing the effectiveness of static analysis tools in detecting errors. |
| [refactor](https://github.com/michaelemery/staticanalysis/tree/master/refactor) | Scenarios for testing refactoring effectiveness of various IDE(s).|
| [autocomplete](https://github.com/michaelemery/staticanalysis/tree/master/autocomplete) | Testing the propensity of IDE auto-complete to recommend bad code options.|
| [generator](https://github.com/michaelemery/staticanalysis/tree/master/generator) | Testing the correctness of generated code.|

## libraries
The library folder ([lib](https://github.com/michaelemery/staticanalysis/tree/master/lib)) contains JAR files for additional tools and frameworks such as 
_JUnit_, annotated javac distributions, and checker tools.

## misc
A documents folder ([doc](https://github.com/michaelemery/staticanalysis/tree/master/doc)) is provided for project documentation.