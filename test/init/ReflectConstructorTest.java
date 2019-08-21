package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via reflective constructor.
 */
class ReflectConstructorTest {

    @Test
    void initWithObject() throws Exception {
        assertDoesNotThrow(() -> {
            ReflectConstructor.constructWithObject();
        });
    }

    @Test
    void initWithNull() throws Exception {
        assertThrows(NullPointerException.class, () -> {
            try {
                ReflectConstructor.constructWithNull();
            } catch (Exception exception) {
                throw exception.getCause();  // unwrap reflect.InvocationTargetException
            }
        });
    }
}
