# checker
A “checker” is a tool that warns you about certain errors or gives you a guarantee that 
those errors do not occur.

## description
Folders at this level contain sample code for common categories of Java programming 
errors. Some code has been annotated specifically for Checker Framework.

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

### checkerframework
The Checker Framework enhances Java’s type system by detecting and preventing specific 
errors in Java programs. Some programs require annotated versions of the same source code 
in order for checkingtools to work. In such cases, the category will contain multiple 
versions of the same code. Additional versions are identified with underbar ("\_") 
extensions to the filename.

**Example**
 _Alias.java_ has an annotated version named _Alias_CF.java_, to indicate that it 
includes annoations for _Checker Framework_. Not all programs require annotations for the 
tools to work, so they do not require additional versions. Included versions and their 
suffixes are indicated as follows;

1) **Checker Framework** _(suffix: \_CF)_
