package generic;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Check nullness of field set via inter-procedural return.
 *  rename it to SimpleInterProcedural because ReflectMethod example is also inter-procedural
 */
public class SimpleInterProcedural {

    @NonNull Object foo;// must be non null
    @Nullable Object bar= new Object(); //either null or non null
    @Nullable Object bar2; //either null or non null

    @NonNull Object getObject() {
        return new Object();
    }

    @Nullable Object getObject2() {
        return new Object();
    }
    @Nullable Object getNullObject() {return null;}



    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() {
        SimpleInterProcedural i = new SimpleInterProcedural();
        i.foo = i.getObject();
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setBarToNull() {
        SimpleInterProcedural i = new SimpleInterProcedural();
        i.bar = i.getNullObject();
        i.bar.toString();
    }

    public static void setBar2ToNonNull() {
        SimpleInterProcedural i = new SimpleInterProcedural();
        i.bar2 = i.getObject2();
        i.bar2.toString();
    }
}
