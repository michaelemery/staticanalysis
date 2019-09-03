package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

/**
 * Check tainting of field set via direct value assignment.
 */
class IntraProcedural {

    @Untainted Object foo;

    /**
     * Untainted field never throws Exception.
     */
    public static void setFooToUntainted() {
        IntraProcedural i = new IntraProcedural();
        i.foo = new @Untainted Object();
    }

    /**
     * Tainted field always throws Exception.
     */
    public static void setFooToTainted() {
        IntraProcedural i = new IntraProcedural();
        i.foo = new Object();
    }
}
