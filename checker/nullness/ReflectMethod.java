package checker.nullness;

import java.lang.reflect.Method;

/**
 * Assign a null reference via reflection method invocation.
 */
public class ReflectMethod {

    Object o;

    ReflectMethod() {
        this.o = "init";
    }

    public static void main(String[] args) throws Exception {
        Class<?> C = ReflectMethod.class;
        Method m = C.getDeclaredMethod("set", Object.class);
        ReflectMethod i = new ReflectMethod();

        /* safe: set object to non-null */
        m.invoke(i, "safe");

        /* unsafe: set object to null */
        m.invoke(i, (Object) null);  // cast to suppress compiler warning
    }

    void set(Object obj) {
        this.o = obj;
        System.out.println(this.o.toString());
    }
}
