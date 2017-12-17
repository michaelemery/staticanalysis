# nullness
Nullness checking guarantees that a program will never throw a null pointer exception.
De-referenced expressions afe a common cause a null pointer exceptions. Dereferences 
occur not only when a field is accessed, but when an array is indexed, an exception is 
thrown, and more. Such exceptions may also occur simply as a result of a field not being 
initialised by its constructor.

### description
Provide a template to test the effectiveness of static analysis tools in identifying 
potential causes of null-pointer exceptions.

### test objectives
When the following issues occur for an expression that may never be null;
    1) assignment to an uninitialised object,
    2) directly de-referenced with null,
    3) assignment to a null reference,
    4) assignment to null via a method return value,
    5) assignment to an uninitialised object of an under-initialised class, or
    6) assignment to an uninitialised object of an under-initialised extended class.

### tags
constructor, de-reference, implicit, initialisation, inheritance, null

### source file(s)
Nullness.java
