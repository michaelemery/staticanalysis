# taint
Taint checking prevents certain kinds of trust errors. A tainted, or untrusted, 
value is one that comes from an arbitrary, possibly malicious source, such as user input 
or unvalidated data. In certain parts of an application, using a tainted value can 
compromise the application’s integrity, causing it to crash, corrupt data, leak private 
data, etc.

A correct program must “sanitise” or “untaint” an untrusted value before using it at a 
sensitive sink. This may be done by either a) checking that it is innocuous/legal, or b) 
transforming the value to be legal. Taint checking verifies this, but does not guarantee 
that a program is free from all trust errors.

## description
Provide a template to test the effectiveness of static analysis tools in identifying 
where values that are required to be untainted may be vulnerable to tainting. 

### test objectives
Identify where the following situations have occurred;
1. taint of an untainted string with a tainted string,
2. taint of an untainted string with a tainted method return,
3. taint of an untainted reference,
4. taint of an untainted reference, or
5. wrapping an untainted object.

## checkerframework
The Tainting type system uses the following annotations:
1. **@Tainted** indicates a type that may include tainted (untrusted) or untainted 
(trusted) values. @Tainted is a supertype of @Untainted. It is the default qualifier.
2. **@Untainted** indicates a type that includes only untainted (trusted) values.
3. **@PolyTainted** is a qualifier that is polymorphic over tainting.

Checker fully qualified names:
1. org.checkerframework.checker.tainting.TaintingChecker

### results

```
$ javac -processor org.checkerframework.checker.tainting.TaintingChecker Taint_CF.java 

Taint_CF.java:28: error: [compound.assignment.type.incompatible] incompatible result type in 
compound assignment.
        u2 += taint(t);
           ^
  found   : @Tainted String
  required: @Untainted String
checker/taint/Taint_CF.java:32: error: [assignment.type.incompatible] incompatible types in 
assignment.
        @Untainted Taint_CF u3 = new Taint_CF();
                                 ^
  found   : @Tainted Taint_CF
  required: @Untainted Taint_CF
checker/taint/Taint_CF.java:37: error: [assignment.type.incompatible] incompatible types in 
assignment.
        @Untainted Taint_CF u4 = new Taint_CF();
                                 ^
  found   : @Tainted Taint_CF
  required: @Untainted Taint_CF
checker/taint/Taint_CF.java:52: error: [compound.assignment.type.incompatible] incompatible result 
type in compound assignment.
        this.u += " -> " + t;
               ^
  found   : @Tainted String
  required: @Untainted String
4 errors
```

## findbugs

### results

```
[NO RESULTS]
```

## metadata

### tags
malicious, sanitise, sensitive, sink, taint, untaint

### source files
Taint.java, Taint_CF.java _(Checker Framework)_
