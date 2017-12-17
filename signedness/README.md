# signedness

### concept
Signedness checking guarantees that signed and unsigned values are not mixed together 
in a computation. In addition, it should prohibit meaningless operations, such as 
division on an unsigned value. A Signedness Checker requires type annotations to indicate 
the signedness that the programmer intends an expression to have.

### description
Provide a template to test the effectiveness of static analysis tools in identifying 
unsigned expressions that have been used incorrectly.

### test objectives
Identify where the following incorrect uses of unsigned values;
1. signed and unsigned may not be mixed,
2. unsigned may not use / or mod operators, or
3. unsigned may not use comparators (<, >, <=, >=).

### tags
comparators, signed, unsigned

### source file(s)
src/Signedness.java
