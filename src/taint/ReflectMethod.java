package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

import java.lang.reflect.Method;

/**
 * Check tainting of field set via reflection method invocation.
 */
public class ReflectMethod {

    @Untainted Object foo;

    Object getUntaintedObject() {
        return new @Untainted Object();
    }

    Object getTaintedObject() {
        return new Object();
    }

    /**
     * Untainted field never throws Exception.
     */
    public static void setFooToUntainted() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Class<?> C = i.getClass();
        Method getObjectMethod = C.getDeclaredMethod("getUntaintedObject");
        i.foo = getObjectMethod.invoke(i);
    }

    /**
     * Tainted field always throws Exception.
     */
    public static void setFooToTainted() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Class<?> C = i.getClass();
        Method getObjectMethod = C.getDeclaredMethod("getTaintedObject");
        i.foo = getObjectMethod.invoke(i);
    }
}
