package alias;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Check for null alias of field set via inter-procedural return.
 */
public class InterProcedural {

    int one;

    InterProcedural() {
        this.one = 1;
    }

    static InterProcedural getAlias(InterProcedural object) {
        InterProcedural alias = object;
        alias.one = 2;
        return alias;
    }

    /**
     * Non-aliased object never throws Exception.
     */
    public static void setOneWithAlias() throws Exception {
        @Unique InterProcedural original = new InterProcedural();
        if (original.one + 1 == 3) {
            throw new Exception();
        }
    }

    /**
     * Aliased object always throws Exception.
     */
    public static void setOneWithoutAlias() throws Exception {
        @Unique InterProcedural original = new InterProcedural();
        InterProcedural alias = getAlias(original);
        if (original.one + 1 == 3) {
            throw new Exception();
        }
    }
}
