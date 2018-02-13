# nullness
Nullness checking guarantees that a program will never throw a null pointer exception. 
De-referenced expressions are a common cause a null pointer exceptions. Dereferences occur not only 
when a field is accessed, but when an array is indexed, an exception is thrown, and more. Such 
exceptions may also occur simply as a result of a field not being initialised by its constructor.

## testing
Inidividual tests provide a template to test the effectiveness of static analysis tools in 
identifying potential causes of null-pointer exceptions.

### objectives 
Each test represents different techniques for invoking potential error conditions as follows;

1. IntraProcedural assignment to a null reference ([IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)).
2. Assignment to a null reference by alias ([Alias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Alias.java)).
3. InterProcedural assignment to a null reference ([InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java)).
4. Assignment to a null reference by reflection ([Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java)).

## metadata

### tags
constructor, de-reference, implicit, initialisation, inheritance, null

### source files
[IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java), 
[Alias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Alias.java), 
[InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/InterProcedural.java), 
[Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java).
