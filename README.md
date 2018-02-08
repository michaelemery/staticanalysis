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

This project conducts muplitple categories of testing that include; dedicated static analysis tools 
that check for certain types of errors, and tests for IDE effectiveness at refactoring code in complex 
situations. 

| category | description |
| --- | --- |
| [checker](https://github.com/michaelemery/staticanalysis/tree/master/checker) | Code for testing the effectiveness of static analysis tools in detecting errors. |
| [refactor](https://github.com/michaelemery/staticanalysis/tree/master/refactor) | Code for testing refactoring effectivness of various IDE(s).|

### libraries
The library folder (lib) contains JAR files for additional tools and frameworks such as 
_JUnit_, annotated javac distributions, and checker tools.
