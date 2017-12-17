# init

### concept
An initialization checker determines whether an object is initialized or not. Any object 
that is accessed at runtime prior to being fully initialised will cause an error. An 
object is only partially initialized from the time that its constructor starts until its 
constructor finishes.

### description
Provide a template to test the effectiveness of static analysis tools in identifying 
whether or not potential errors could occur as a result of fields being accesses prior
to full initialisation.

### test objectives
Identify where the following initialisation issues occur;
1. constructor fails to initialise field before exit,
2. constructor accesses uninitialised field, or
3. constructor calls method that accesses an uninitialised field.

### tags
constructor, inheritance, initialisation, null

### source file(s)
src/Init.java
