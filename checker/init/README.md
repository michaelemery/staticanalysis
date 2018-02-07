# init
An initialization checker determines whether an object is initialized or not. Any object 
that is accessed at runtime prior to being fully initialised will cause an error. An 
object is only partially initialized from the time that its constructor starts until its 
constructor finishes.

## description
Provide a template to test the effectiveness of static analysis tools in identifying 
whether or not potential errors could occur as a result of fields being accesses prior
to full initialisation.

### test objectives
Identify where the following initialisation issues occur;
1. constructor fails to initialise field before exit,
2. constructor accesses uninitialised field, or
3. constructor calls method that accesses an uninitialised field.

## checker framework
The initialization hierarchy contains these qualifiers:
1. **@Initialized** indicates a type that contains a fully-initialized object. 
Initialized is the default, so there is little need for a programmer to write this 
explicitly.
2. **@UnknownInitialization** indicates a type that may contain a partially-initialized 
object. In a partially-initialized object, fields that are annotated as @NonNull may be 
null because the field has not yet been assigned. @UnknownInitialization takes a 
parameter that is the class the object is definitely initialized up to. For instance, the 
type @UnknownInitialization(Foo.class) denotes an object in which every fields declared 
in Foo or its superclasses is initialized, but other fields might not be. 
@UnknownInitialization is equivalent to @UnknownInitialization(Object.class).
3. **@UnderInitialization** indicates a type that contains a partially-initialized object 
that is under initialization — that is, its constructor is currently executing. It is 
otherwise the same as @UnknownInitialization. Within the constructor, this has 
@UnderInitialization type until all the @NonNull fields have been assigned.

Checker fully qualified names:
1. org.checkerframework.checker.nullness.NullnessChecker

### results

```
$ javac -processor org.checkerframework.checker.nullness.NullnessChecker Init.java 

Init.java:17: error: [initialization.fields.uninitialized] the constructor does not initialize 
fields: o
    Init() { }
    ^
Init.java:20: error: [initialization.fields.uninitialized] the constructor does not 
initialize fields: o
    Init(int x) {
    ^
Init.java:25: error: [initialization.fields.uninitialized] the constructor does not 
initialize fields: o
    Init(int x, int y) {
    ^
Init.java:26: error: [method.invocation.invalid] call to m() not allowed on the given 
receiver.
        m();
         ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull Init
  required: @Initialized @NonNull Init
4 errors
```


## findbugs

**Uninitialized read of field in constructor (UR - UR_UNINIT_READ)**

This constructor reads a field which has not yet been assigned a value.  This is often caused when the programmer mistakenly uses the field instead of one of the constructor's parameters.

**Dead store to local variable O(DLS - DLS_DEAD_LOCAL_STORE)**

This instruction assigns a value to a local variable, but the value is not read or used in any subsequent instruction. Often, this indicates an error, because the value computed is never used.
Note that Sun's javac compiler often generates dead stores for final local variables. Because FindBugs is a bytecode-based tool, there is no easy way to eliminate these false positives.

**Unwritten field (UwF - UWF_UNWRITTEN_FIELD)**

This field is never written.  All reads of it will return the default value. Check for errors (should it have been initialized?), or remove it if it is useless.

### results

```
$ findbugs Init.class 

M C UR: Uninitialized read of o in new init.Init(int)  At Init.java:[line 21]
H D DLS: Dead store to $L2 in init.Init.main(String[])  At Init.java:[line 36]
M C UwF: Unwritten field: init.Init.o  At Init.java:[line 21]
Warnings generated: 3
```

## pmd

### results

```
$ pmd -d init/ -f text -R category/java/errorprone.xml

Init.java:14: Found non-transient, non-static member. Please mark as transient or provide accessors.
Init.java:26: Overridable method 'm' called during object construction
Init.java:36: Found 'DU'-anomaly for variable 'a2' (lines '36'-'38').
Init.java:37: Found 'DU'-anomaly for variable 'a3' (lines '37'-'38').
```

Output has been simplified.

## metadata

### tags
constructor, inheritance, initialisation, null

### source files
Init.java
