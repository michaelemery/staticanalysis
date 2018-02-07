# signedness
Signedness checking guarantees that signed and unsigned values are not mixed together 
in a computation. In addition, it should prohibit meaningless operations, such as 
division on an unsigned value. A Signedness Checker requires type annotations to indicate 
the signedness that the programmer intends an expression to have.

## description
Provide a template to test the effectiveness of static analysis tools in identifying 
unsigned expressions that have been used incorrectly.

### test objectives
Identify where the following incorrect uses of unsigned values;
1. signed and unsigned may not be mixed,
2. unsigned may not use / or mod operators, or
3. unsigned may not use comparators (<, >, <=, >=).

## checkerframework
These are the qualifiers in the signedness type system:
1. **@Unsigned** indicates that the programmer intends the value to be interpreted as 
unsigned. That is, if the most significant bit in the bitwise representation is set, then 
the bits should be interpreted as a large positive value.
2. **@Signed** indicates that the programmer intends the value to be interpreted as 
signed. That is, if the most significant bit in the bitwise representation is set, then 
the bits should be interpreted as a negative value. This is the default annotation.
3. **@Constant** indicates that a value is a compile-time constant and could be 
interpreted as unsigned or signed. This annotation is used internally, and should not be 
written by the programmer.
4. **@UnknownSignedness** indicates that a value’s type is not relevant or known to this 
checker. This annotation is used internally, and should not be written by the programmer.

**Default qualifiers:** The only type qualifier that the programmer should need to 
specify is @Unsigned. When an expression is unannotated, the Signedness Checker treats it 
in one of the following ways:
* All byte, short, int, and long literals default to @Constant.
* All byte, short, int, and long variables default to @Signed.
* All other expressions default to @UnknownSignedness.

Checker fully qualified names:
1. org.checkerframework.checker.signedness.SignednessChecker

### results

```
$ javac -processor org.checkerframework.checker.signedness.SignednessChecker Signedness_CF.java 

[NO ISSUES FOUND]
```

## findbugs

### results

```
[NO RESULTS]
```

## metadata

### tags
comparators, signed, unsigned

### source files
Signedness.java, Signedness_CF.java _(Checker Framework)_
