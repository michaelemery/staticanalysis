# taint
Taint checking prevents certain kinds of trust errors. A tainted, or untrusted, 
value is one that comes from an arbitrary, possibly malicious source, such as user input 
or unvalidated data. In certain parts of your application, using a tainted value can 
compromise the application’s integrity, causing it to crash, corrupt data, leak private 
data, etc.

A correct program must “sanitise” or “untaint” an untrusted value before using it at a 
sensitive sink. This may be done by either a) checking that it is innocuous/legal, or b) 
transforming the value to be legal. Taint checking verifies this, but does not guarantee 
that a program is free from all trust errors.

## description
Provide a template to test the effectiveness of static analysis tools in identifying 
where values that are required to be untainted may be vulnerable to tainting. 

## test objectives
Identify where the following situations have occurred;
1) taint of an untainted string with a tainted string,
2) taint of an untainted string with a tainted method return,
3) taint of an untainted reference,
4) taint of an untainted reference, or
5) wrapping an untainted object.

## annotations
@Untainted, @Tainted, @PolyTainted

### checkerframework
The Tainting type system uses the following annotations:
1. **@Untainted** indicates a type that includes only untainted (trusted) values.
2. **@Tainted** indicates a type that may include tainted (untrusted) or untainted 
(trusted) values. @Tainted is a supertype of @Untainted. It is the default qualifier.
3. **@PolyTainted** is a qualifier that is polymorphic over tainting.

## tags
malicious, sanitise, sensitive, sink, taint, untaint

## source file(s)
Taint.java
