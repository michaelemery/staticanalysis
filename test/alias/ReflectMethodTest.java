package alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check for changes due to aliasing an object via reflective method return.
 */
class ReflectMethodTest {

    @Test
    void setFooWithoutAlias() {
        assertDoesNotThrow(() -> {
            ReflectMethod.setFooWithoutAlias();
        });
    }

    @Test
    void setFooWithAlias() {
        Exception thrown = assertThrows(Exception.class, () -> {
            ReflectMethod.setFooWithAlias();
        });
        assertTrue(thrown.getMessage() == "foo changed by alias");
    }
}
