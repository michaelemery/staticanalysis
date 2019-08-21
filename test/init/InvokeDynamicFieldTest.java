package init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test initialisation of an object via dynamic invocation of a field set.
 */
class InvokeDynamicFieldTest {

    @Test
    void setWithObject() {
        assertDoesNotThrow((() -> {
            new InvokeDynamicField();
        }));
    }

    @Test
    void setWithNull() {
        assertThrows(NullPointerException.class, () -> {
            new InvokeDynamicField(1);
        });
    }

}