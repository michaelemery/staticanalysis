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

**checker fq names:**
1. org.checkerframework.checker.nullness.NullnessChecker

### results

```
$ javac -processor org.checkerframework.checker.nullness.NullnessChecker checker/init/Init.java 

checker/init/Init.java:17: error: [initialization.fields.uninitialized] the constructor does not 
initialize fields: o
    Init() { }
    ^
checker/init/Init.java:20: error: [initialization.fields.uninitialized] the constructor does not 
initialize fields: o
    Init(int x) {
    ^
checker/init/Init.java:25: error: [initialization.fields.uninitialized] the constructor does not 
initialize fields: o
    Init(int x, int y) {
    ^
checker/init/Init.java:26: error: [method.invocation.invalid] call to m() not allowed on the given 
receiver.
        m();
         ^
  found   : @UnderInitialization(java.lang.Object.class) @NonNull Init
  required: @Initialized @NonNull Init
4 errors
MacBook-Emery:statica
```

## metadata

### tags
constructor, inheritance, initialisation, null

### source files
Init.java
