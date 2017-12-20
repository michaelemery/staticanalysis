# staticanalysis
Static program analysis is the analysis of computer software that is performed without 
actually executing programs (analysis performed on executing programs is known as 
dynamic analysis). In most cases the analysis is performed on some version of the source 
code, and in the other cases, some form of the object code.

## description
Folders at this level contain sample code for common categories of Java programming 
errors, and additional libraries for the resources required for various demonstrations. 

### categories
1) **Alias**, where errors may occur when an object is referenced, without consideration 
for mutations caused by an alias to the same object.
2) **Init**, where any object that is accessed at runtime prior to being fully 
initialised will cause an error.
3) **InvokeDynamic**, where type-checking is usually performed at runtime and therefore
prone to misuse of type errors.
4) **Nullness**, where dereferenced expressions are a common cause a null pointer 
exceptions.
5) **Signedness**, where signed and unsigned values are incorrectly mixed together in a
computation, and meaningless operations occur such as division on an unsigned value. 
6) **Taint**, where certain parts of an application, using a tainted value can 
compromise the application’s integrity, causing it to crash, corrupt data, leak private 
data, etc.

Each folder contains slightly modified different versions of the same code. The base 
version is raw unannotated code. Other versions, indentified with an underbar suffix, 
contain annotations for various static analysis tools such as _Checkerframework_. Aside 
from annotations, the code is always the same as the raw version. Versions include;
1) **Checkerframework** _(suffix _cf)

### libraries
The library folder contains JAR files for additional tools and frameworks such as _JUnit_,
and _Checkerframework_.
