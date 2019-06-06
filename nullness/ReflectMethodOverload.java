package nullness;

import java.lang.reflect.Method;

/**
 * Assign a null reference via overloaded reflection method invocation.
 */
public class ReflectMethodOverload {

    Object o;

    ReflectMethodOverload() {
        this.o = "init";
    }

    public static void main(String[] args) throws Exception {
        Class<?> C = ReflectMethodOverload.class;
        Method m; C.getDeclaredMethod("set", Object.class);
        ReflectMethodOverload i = new ReflectMethodOverload();

        /* safe: set object to non-null */
        m = C.getDeclaredMethod("set", Object.class, int.class);
        m.invoke(i, "safe", 1);

        /* unsafe: set object to null */
        m = C.getDeclaredMethod("set", Object.class);
        m.invoke(i, (Object) null);  // cast to suppress compiler warning
    }

    void set(Object obj) {
        this.o = obj;
        System.out.println(this.o.toString());
    }

    void set(Object obj, int x) {
        this.o = obj;
        System.out.println(this.o.toString());
    }
}
