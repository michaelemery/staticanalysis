package alias;

import org.checkerframework.common.aliasing.qual.LeakedToResult;
import org.checkerframework.common.aliasing.qual.Unique;

/**
 * Check field for changes caused via direct value assignment to an alias.
 */
public class IntraProcedural {

    int one;

    IntraProcedural() {
        this.one = 1;
    }

    /**
     * Non-aliased object never throws Exception.
     */
    public void setFieldWithoutAlias() throws Exception {
        @Unique IntraProcedural original = new IntraProcedural();
        if (original.one + 1 != 2) {
            throw new Exception();
        }
    }

    /**
     * Aliased object always throws Exception.
     */
    public static void setFieldWithAlias() throws Exception {
        @Unique IntraProcedural original = new IntraProcedural();
        IntraProcedural alias = original;
        alias.one = 2;
        if (original.one + 1 != 2) {
            throw new Exception();
        }
    }
}
