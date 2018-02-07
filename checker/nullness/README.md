# nullness
Nullness checking guarantees that a program will never throw a null pointer exception.
De-referenced expressions are a common cause a null pointer exceptions. Dereferences 
occur not only when a field is accessed, but when an array is indexed, an exception is 
thrown, and more. Such exceptions may also occur simply as a result of a field not being 
initialised by its constructor.

## description
Provide a template to test the effectiveness of static analysis tools in identifying 
potential causes of null-pointer exceptions.

### test objectives
When the following issues occur for an expression that may never be null;
1) assignment to an uninitialised object,
2) directly de-referenced with null,
3) assignment to a null reference,
4) assignment to null via a method return value,
5) assignment to an uninitialised object of an under-initialised class, or
6) assignment to an uninitialised object of an under-initialised extended class.

### tags
constructor, de-reference, implicit, initialisation, inheritance, null

### source file(s)
Nullness.java

## checker framework
The nullness hierarchy contains these qualifiers:
1. **@Nullable** indicates a type that includes the null value. For example, the type 
Boolean is nullable: a variable of type Boolean always has one of the values TRUE, FALSE, 
or null.
2. **@NonNull** indicates a type that does not include the null value. The type boolean 
is non-null; a variable of type boolean always has one of the values true or false. The 
type @NonNull Boolean is also non-null: a variable of type @NonNull Boolean always has 
one of the values TRUE or FALSE — never null. Dereferencing an expression of non-null 
type can never cause a null pointer exception.
The Nullness Checker supports several annotations that specify method behavior. These are 
declaration annotations, not type annotations as they apply to the method itself rather 
than to some particular type:
1. **@RequiresNonNull** indicates a method precondition: The annotated method expects the 
specified variables (typically field references) to be non-null when the method is 
invoked.
2. **@EnsuresNonNull**
3. **@EnsuresNonNullIf** indicates a method postcondition. With @EnsuresNonNull, the 
given expressions are non-null after the method returns; this is useful for a method that 
initializes a field, for example. With @EnsuresNonNullIf, if the annotated method returns 
the given boolean value (true or false), then the given expressions are non-null.
**Checker FQName(s):**
1) org.checkerframework.checker.nullness.NullnessChecker

### results

`$ javac -processor org.checkerframework.checker.nullness.NullnessChecker Nullness.java`

**Output**

```
Nullness.java:11: error: [initialization.fields.uninitialized] the constructor does not 
initialize fields: o
public class Nullness {
       ^
Nullness.java:44: error: [return.type.incompatible] incompatible types in return.
        return null;
               ^
  found   : null
  required: @Initialized @NonNull Object
Nullness.java:53: error: [initialization.fields.uninitialized] the constructor does not 
initialize fields: o2
    C1() {
    ^
3 errors
```


