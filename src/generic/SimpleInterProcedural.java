package generic;

/**
 * Check nullness of field set via inter-procedural return.
 *  rename it to SimpleInterProcedural because ReflectMethod example is also inter-procedural
 */
public class SimpleInterProcedural {

    Object foo;
    Object bar= new Object();

    Object getObject() {
        return new Object();
    }
    Object getNullObject() {return null;}

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
}
