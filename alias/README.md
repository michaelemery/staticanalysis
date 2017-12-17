# Alias
Two expressions are aliased when they have the same non-primitive value; that is, they 
are references to the identical Java object in the heap. Errors may occur when an object
is referenced, without consideration for mutations caused by an alias to the same object.

## description
Provide a template to test the effectiveness of static analysis tools in identifying 
unintentional mutations of objects that were intended to be unique.

## test objectives
Identify where objects that are intended to be unique may become mutable by;
1) direct assignment of an alias, 
2) referencing an existing alias, 
3) pseudo assignment of an alias to method parameters, or
4) leakage to an alias via method return value.

## tags
alias, mutability, leak

## source file(s)
Alias.java
