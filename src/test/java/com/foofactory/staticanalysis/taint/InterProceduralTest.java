package com.foofactory.staticanalysis.taint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check tainting of field set via direct value assignment.
 */
class InterProceduralTest {

    @Test
    void setFooToUntainted() {
        assertDoesNotThrow(() -> {
            InterProcedural.setFooToUntainted();
        });
    }

    @Test
    void setFooToTainted() {
        InterProcedural.setFooToTainted();  // placeholder: does not test anything
//        Exception thrown = assertThrows(Exception.class, () -> {
//            InterProcedural.setFooToTainted();
//        });
//        assertTrue(thrown.getMessage().contains("foo tainted"));
    }
}
