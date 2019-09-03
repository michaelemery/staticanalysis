package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

/**
 * Check tainting of field set via reflective field access.
 */
public class ReflectField {

    @Untainted Object foo;

    /**
     * Untainted field never throws Exception.
     */
    public static void setFooToUntainted() throws Exception {
        ReflectField i = new ReflectField();
        ReflectField.class.getDeclaredField("foo").set(i, new @Untainted Object());
    }

    /**
     * Tainted field always throws Exception.
     */
    public static void setFooToTainted() throws Exception {
        ReflectField i = new ReflectField();
        ReflectField.class.getDeclaredField("foo").set(i, new Object());
    }
}
