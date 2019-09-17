package generic;

/**
 * Check nullness of field set via inter-procedural return.
 *  rename it to SimpleInterProcedural because ReflectMethod example is also inter-procedural
 */
public class SimpleInterProcedural {

    Object foo;

    Object getObject(Object object) {
        return object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() {
        SimpleInterProcedural i = new SimpleInterProcedural();
        i.foo = i.getObject(new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() {
        SimpleInterProcedural i = new SimpleInterProcedural();
        i.foo = i.getObject(null);
        i.foo.toString();
    }
}
