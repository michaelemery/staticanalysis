package alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Emery on 2/09/19.
 */
class InvokeDynamicMethodTest {

    @Test
    void setFooWithoutAlias() {
        assertDoesNotThrow(() -> {
            InvokeDynamicMethod.setFooWithoutAlias();
        });
    }

    @Test
    void setFooWithAlias() {
        Exception thrown = assertThrows(Exception.class, () -> {
            InvokeDynamicMethod.setFooWithAlias();
        });
        assertTrue(thrown.getMessage() == "original.foo == 2");
    }
}
