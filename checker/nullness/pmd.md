
# pmd

Version: pmd-bin-6.0.1

PMD checkers belonging to the "error prone" category are the only ones required for these tests.

> 1. The `pmd` command shown in all results is an alias; <br />
> `alias pmd='$PMD_HOME/bin/run.sh pmd'`
> 2. JDK must be set to 1.8 or lower.
> 3. Outputs have been simplified for brevity.

## intra-procedural

[nullness/IntraProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/IntraProcedural.java)

```java
package nullness;

/**
 * Intra-procedural assignment of a null reference.
 */
public class IntraProcedural {

    String s;

    public IntraProcedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // intra-procedural assignment of a non-null reference (correct)
        IntraProcedural foo = new IntraProcedural("text");
        System.out.println(foo.s.toString());  // "text"

        // intra-procedural assignment of a null reference (fail)
        foo = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}
```

**results:**

| True Positive<br>(TP) | False Positiv<br>(FP)  | False Positiv<br>(FN) |
| :---: | :---: | :---: |
| 1 | 0 | 0 |

```
$ pmd -d nullness/IntraProcedural.java -f text -R category/java/errorprone.xml

nullness/IntraProcedural.java:8:
Found non-transient, non-static member. Please mark as transient or provide accessors.
nullness/IntraProcedural.java:21:
Assigning an Object to null is a code smell. Consider refactoring.
```

## alias

[nullness/Alias.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Alias.java)

```java
package nullness;

/**
 * Assignment to a null reference by alias.
 */
public class Alias {

    String s;

    public Alias(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // assignment to non-null by alias (correct)
        Alias foo = new Alias("text");
        Alias bar = foo;
        System.out.println(bar.s.toString());  // "text"

        // assignment to null by alias (fail)
        foo = null;
        bar = foo;
        System.out.println(bar.s.toString());  // NullPointerException

    }

}
```

**results:**

1 x TP (True Positive)

```
$ pmd -d Alias.java -f text -R category/java/errorprone.xml

nullness/Alias.java:8: 
Found non-transient, non-static member. Please mark as transient or provide accessors.
nullness/Alias.java:22:    
Assigning an Object to null is a code smell.  Consider refactoring.
```

## inter-procedural

[nullness/InterProcedural.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Call.java)

```java
package nullness;

/**
 * Inter-procedural assignment to a null reference.
 */
public class InterProcedural {

    String s;

    public InterProcedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // inter-procedural assignment of a non-null reference (correct)
        InterProcedural foo = new InterProcedural(returnReceivedString("text"));
        System.out.println(foo.s.toString());  // "text"

        // inter-procedural assignment of a null reference (fail)
        InterProcedural bar = new InterProcedural(returnReceivedString(null));
        System.out.println(bar.s.toString());  // NullPointerException

    }

    public static String returnReceivedString(String s) {
        return s;
    }

}
```

**results:**

1 x False Negative (FN)

```
$ pmd -d Call.java -f text -R category/java/errorprone.xml

nullness/Call.java:8:  
Found non-transient, non-static member. Please mark as transient or provide accessors.
```

## reflection

[nullness/Reflection.java](https://github.com/michaelemery/staticanalysis/blob/master/checker/nullness/Reflection.java)

```java
package nullness;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Assignment to a null reference by reflection.
 */
public class Reflection {

    String s;

    public Reflection(String s) {
        this.s = s;
    }

    public static void main(String[] args) {

        Method m;

        try {
            // assignment to a non-null reference by reflection (correct)
            m = nullness.Reflection.class.getDeclaredMethod("returnText");
            Reflection foo = new Reflection((String) m.invoke(null));
            System.out.println(foo.s.toString());  // "text"

            // assignment to a null reference by reflection (fail)
            m = nullness.Reflection.class.getDeclaredMethod("returnNull");
            Reflection bar = new Reflection((String) m.invoke(null));
            System.out.println(bar.s.toString());  // NullPointerException
            
        } catch (NoSuchMethodException |
                IllegalAccessException |
                InvocationTargetException x) {
            x.printStackTrace();
        }

    }

    public static String returnText() {
        return "text";
    }

    public static String returnNull() {
        return null;
    }

}
```

**results:**

1 x False Negative (FN)

```
$ pmd -d Reflection.java -f text -R category/java/errorprone.xml

nullness/Reflection.java:11:   
Found non-transient, non-static member. Please mark as transient or provide accessors.
```
