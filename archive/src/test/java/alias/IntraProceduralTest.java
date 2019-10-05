package alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check for changes due to aliasing an object via direct value assignment.
 */
class IntraProceduralTest {

    @Test
    void setFooWithoutAlias() {
        assertDoesNotThrow(() -> {
            IntraProcedural.setFooWithoutAlias();
        });
    }

    @Test
    void setFooWithAlias() {
        Exception thrown = assertThrows(Exception.class, () -> {
            IntraProcedural.setFooWithAlias();
        });
        assertTrue(thrown.getMessage() == "foo changed by alias");
    }
}
