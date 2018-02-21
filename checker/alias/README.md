# alias
Two expressions are aliased when they have the same non-primitive value; that is, they 
are references to the identical Java object in the heap. Errors may occur when an object
is referenced, without consideration for mutations caused by an alias to the same object.

## testing
Provide a template to test the effectiveness of static analysis tools in identifying 
unintentional mutations of objects that were intended to be unique.

### objectives
Identify where objects that are intended to be unique may become mutable by;
1. direct assignment of an alias, 
2. referencing an existing alias, 
3. pseudo assignment of an alias to method parameters, or
4. leakage to an alias via method return value.

## checker framework
There are two possible types for an expression:
1. **@MaybeAliased** is the type of an expression that might have an alias. This is the 
default, so every unannotated type is @MaybeAliased. Includes the type of null.
2. **@Unique** is the type of an expression that has no aliases. The @Unique annotation is 
only allowed at local variables, method parameters, constructor results, and method 
returns. It is not allowed on fields, array elements, and type parameters. A 
constructor’s result should be annotated with @Unique only if the constructor’s body does 
not create an alias to the constructed object.

There are also two annotations, which are currently trusted instead of verified, that can 
be used on formal parameters (including the receiver parameter, this):
1. **@NonLeaked** identifies a formal parameter that is not leaked nor returned by the 
method body. For example, the formal parameter of the String copy constructor, 
String(String s), is @NonLeaked because the body of the method only makes a copy of the 
parameter.
2. **@LeakedToResult** is used when the parameter may be returned, but it is not 
otherwise leaked. For example, the receiver parameter of StringBuffer.append(StringBuffer 
this, String s) is @LeakedToResult, because the method returns the updated receiver.

Checker fully qualified names:
1. org.checkerframework.common.aliasing.AliasingChecker

### results

```
$ javac -processor org.checkerframework.common.aliasing.AliasingChecker Alias_CF.java

checker/alias/Alias_CF.java:19: error: [assignment.type.incompatible] incompatible types 
in assignment.
        @Unique Object a1 = new Object();
                            ^
  found   : @MaybeAliased Object
  required: @NonLeaked @Unique Object
checker/alias/Alias_CF.java:20: error: [unique.leaked] Reference annotated as @Unique is 
leaked.
        Object b1 = a1;
                    ^
checker/alias/Alias_CF.java:26: error: [assignment.type.incompatible] incompatible types 
in assignment.
        @Unique Object a2 = b2;
                            ^
  found   : @MaybeAliased @NonLeaked Object
  required: @NonLeaked @Unique Object
checker/alias/Alias_CF.java:31: error: [assignment.type.incompatible] incompatible types 
in assignment.
        @Unique Object a3 = new Object();
                            ^
  found   : @MaybeAliased Object
  required: @NonLeaked @Unique Object
checker/alias/Alias_CF.java:32: error: [unique.leaked] Reference annotated as @Unique is 
leaked.
        m1(a3);
           ^
checker/alias/Alias_CF.java:36: error: [assignment.type.incompatible] incompatible types 
in assignment.
        @Unique Object a4 = new Object();
                            ^
  found   : @MaybeAliased Object
  required: @NonLeaked @Unique Object
checker/alias/Alias_CF.java:37: error: [unique.leaked] Reference annotated as @Unique is 
leaked.
        Object b4 = m2(a4);
                       ^
7 errors
```

## findbugs

**Self comparison of value with itself (SA - SA_LOCAL_SELF_COMPARISON)**

This method compares a local variable with itself, and may indicate a typo or a logic error. Make sure that you are comparing the right things.

### results

```
$ findbugs Alias.class 

H C SA: Self comparison of $L1 with itself alias.Alias.main(String[])  At Alias.java:[line 19]
H C SA: Self comparison of $L3 with itself alias.Alias.main(String[])  At Alias.java:[line 25]
Warnings generated: 2
```

## pmd

### results

```
$ pmd -d alias/ -f text -R category/java/errorprone.xml

Alias.java:19: Use equals() to compare object references.
Alias.java:25: Use equals() to compare object references.
Alias.java:36: Use equals() to compare object references.
```

*Output has been simplified.*

## metadata

### tags
alias, mutability, leak

### source files
Alias.java, Alias_CF.java _(Checker Framework)_