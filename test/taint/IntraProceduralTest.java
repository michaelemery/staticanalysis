package taint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check tainting of field set via direct value assignment.
 */
class IntraProceduralTest {

    @Test
    void setFooToUntainted() {
        assertDoesNotThrow(() -> {
            IntraProcedural.setFooToUntainted();
        });
    }

    @Test
    void setFooToTainted() {
        IntraProcedural.setFooToTainted();  // placeholder: does not test anything
//        Exception thrown = assertThrows(Exception.class, () -> {
//            IntraProcedural.setFooToTainted();
//        });
//        assertTrue(thrown.getMessage().contains("foo tainted"));
    }
}
