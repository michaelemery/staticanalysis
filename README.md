# staticanalysis
Static program analysis is the analysis of computer software that is performed without 
actually executing programs (analysis performed on executing programs is known as 
dynamic analysis). In most cases the analysis is performed on some version of the source 
code, and in the other cases, some form of the object code.

## description
Folders at this level contain sample code for common Java programming errors, and 
additional libraries for additional resources required for various demonstrations. 

### categories
They are named in accordance to the categories that these errors belong to. Categories 
include;
1) **Alias**, where errors may occur when an object is referenced, without consideration 
for mutations caused by an alias to the same object.
2) **Init**, where any object that is accessed at runtime prior to being fully 
initialised will cause an error.
3) **Nullness**, where dereferenced expressions are a common cause a null pointer 
exceptions.
4) **Signedness**, where signed and unsigned values are incorrectly mixed together in a
computation, and meaningless operations occur such as division on an unsigned value. 
5. **Taint**, where certain parts of an application, using a tainted value can 
compromise the application’s integrity, causing it to crash, corrupt data, leak private 
data, etc.

Each folder contains slightly modified different versions of the same code. The base 
version is raw unannotated code. A filename without any underbar suffix is a base 
version. There are also versions that contain annotation for various static analysis 
tools such as _Checkerframework_. Annotated versions have an underbar suffix after the 
filename, eg. _Alias_cf_ for a _Checkerframework_ version. Aside from annotations, the
code is always the same as the raw version.

### libraries
The library folder contains JAR files for additional tools and frameworks such as _JUnit_,
and _Checkerframework_.
