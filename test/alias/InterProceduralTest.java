package alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CCheck for changes due to aliasing an object via inter-procedural return.
 */
class InterProceduralTest {

    @Test
    void setFooWithoutAlias() {
        assertDoesNotThrow(() -> {
            InterProcedural.setFooWithoutAlias();
        });
    }

    @Test
    void setFooWithAlias() {
        Exception thrown = assertThrows(Exception.class, () -> {
            InterProcedural.setFooWithAlias();
        });
        assertTrue(thrown.getMessage() == "original.foo == 2");
    }
}
