# alias
Two expressions are aliased when they have the same non-primitive value; that is, they are references to the identical Java object in the heap. Errors may occur when an object is referenced, without consideration for mutations caused by an alias to the same object.

## testing
Provide a template to test the effectiveness of static analysis tools in identifying unintentional mutations of objects that were intended to be unique.

### objectives
Identify where objects that are intended to be unique may become mutable by;
1. Intra-procedural assignment of an alias.
2. Referencing an existing alias.
3. Pseudo assignment of an alias to method parameters.
4. Leakage to an alias via method return value.


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