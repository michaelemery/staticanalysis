# staticanalysis
Static program analysis is the analysis of computer software that is performed without 
actually executing programs (analysis performed on executing programs is known as 
dynamic analysis). In most cases the analysis is performed on some version of the source 
code, and in the other cases, some form of the object code.
This repository is in support of the authors Masters Thesis on the effectiveness of 
Static Analysis tools, techniques, and frameworks.

## description
Folders at this level contain sample code for common categories of Java programming 
errors, as well as additional libraries _(lib)_ for resources required by various 
demonstrations. 

### categories
1) **Alias**: where errors may occur when an object is referenced, without consideration 
for mutations caused by an alias to the same object.
2) **Init**: where any object that is accessed at runtime prior to being fully 
initialised will cause an error.
3) **InvokeDynamic**: where type-checking is usually performed at runtime and therefore
prone to misuse of type errors.
4) **Nullness**: where dereferenced expressions are a common cause a null pointer 
exceptions.
5) **Signedness**: where signed and unsigned values are incorrectly mixed together in a
computation, and meaningless operations occur such as division on an unsigned value. 
6) **Taint**: where certain parts of an application, using a tainted value can 
compromise the application’s integrity, causing it to crash, corrupt data, leak private 
data, etc.

Some programs require annotated versions of the same source code in order for checking
tools to work. In such cases, the category will contain multiple versions of the same 
code. Additional versions are identified with underbar ("_") extensions to the filename, 
e.g. _Alias.java_ has an annotated version named _Alias_CF.java_, to indicate that it 
includes annoations for _Checker Framework_. Not all programs require annotations for the 
tools to work, so they do not require additional versions. Included versions and their 
suffixes are indicated as follows;
1) **Checker Framework** _(suffix: \_CF)_

### libraries
The library folder (lib) contains JAR files for additional tools and frameworks such as 
_JUnit_, annotated javac distributions, and checker tools.
