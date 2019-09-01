package alias;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Check for changes due to aliasing an object via inter-procedural return.
 */
public class InterProcedural {

    int foo = 1;

    static InterProcedural getAlias(InterProcedural object) {
        InterProcedural alias = object;
        alias.foo = 2;
        return alias;
    }

    /**
     * Non-aliased object never throws Exception.
     */
    public static void setFooWithoutAlias() throws Exception {
        @Unique InterProcedural original = new InterProcedural();
        if (original.foo != 1) {
            throw new Exception();
        }
    }

    /**
     * Aliased object always throws Exception.
     */
    public static void setFooWithAlias() throws Exception {
        @Unique InterProcedural original = new InterProcedural();
        InterProcedural alias = getAlias(original);
        if (original.foo == 2) {
            throw new Exception("original.foo == 2");
        }
    }
}
