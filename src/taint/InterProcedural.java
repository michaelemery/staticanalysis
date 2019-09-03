package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

/**
 * Check tainting of field set via inter-procedural return.
 */
class InterProcedural {

    @Untainted Object foo;

    @Untainted Object getUntaintedObject() {
        return new @Untainted Object();
    }

    Object getObject() {
        return new Object();
    }

    /**
     * Untainted field never throws Exception.
     */
    public static void setFooToUntainted() {
        InterProcedural i = new InterProcedural();
        i.foo = i.getUntaintedObject();
    }

    /**
     * Tainted field always throws Exception.
     */
    public static void setFooToTainted() {
        InterProcedural i = new InterProcedural();
        i.foo = i.getObject();
    }
}
