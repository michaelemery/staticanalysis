package alias;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Check for changes due to aliasing an object via direct value assignment.
 */
public class IntraProcedural {

    int foo = 1;

    /**
     * Non-aliased object never throws Exception.
     */
    public static void setFooWithoutAlias() throws Exception {
        @Unique IntraProcedural original = new IntraProcedural();
        if (original.foo != 1) {
            throw new Exception();
        }
    }

    /**
     * Aliased object always throws Exception.
     */
    public static void setFooWithAlias() throws Exception {
        @Unique IntraProcedural original = new IntraProcedural();
        IntraProcedural alias = original;
        alias.foo = 2;
        if (original.foo == 2) {
            throw new Exception("foo changed by alias");
        }
    }
}
