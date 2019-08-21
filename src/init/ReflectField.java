package init;

import java.lang.reflect.Field;

/**
 * Validate initialisation of an object via reflective field access.
 */
public class ReflectField {

    Object object;

    // initialises field
    ReflectField() throws Exception {
        Field field = this.getClass().getDeclaredField("object");
        field.set(this, new Object());
        this.object.toString();
    }

    // fails to initialise field
    ReflectField(int x) throws Exception {
        Field field = this.getClass().getDeclaredField("object");
        field.set(this, (Object) null);
        this.object.toString();
    }

    static void initialiseWithObject() throws Exception {
        new ReflectField();
    }

    static void failToInitialise() throws Exception {
        new ReflectField(1);
    }
}
