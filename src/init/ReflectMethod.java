package init;

import java.lang.reflect.Method;

/**
 * Initialisation of an object via reflective methods.
 */
public class ReflectMethod {

    Object object;

    ReflectMethod() throws Exception {
        Method method = this.getClass().getDeclaredMethod("returnObject", Object.class);
        this.object = method.invoke(null, new Object());
        this.object.toString();
    }

    ReflectMethod(int x) throws Exception {
        Method method = this.getClass().getDeclaredMethod("returnObject", Object.class);
        this.object = method.invoke(null, (Object) object);
        this.object.toString();
    }

    static Object returnObject(Object object) {
        return object;
    }
}
