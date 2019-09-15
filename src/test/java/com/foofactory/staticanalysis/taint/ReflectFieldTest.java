package com.foofactory.staticanalysis.taint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Emery on 3/09/19.
 */
class ReflectFieldTest {

    @Test
    void setFooToUntainted() {
        assertDoesNotThrow(() -> {
            ReflectField.setFooToUntainted();
        });
    }

    @Test
    void setFooToTainted() throws Exception {
        ReflectField.setFooToTainted();  // placeholder: does not test anything
//        Exception thrown = assertThrows(Exception.class, () -> {
//            ReflectField.setFooToTainted();
//        });
//        assertTrue(thrown.getMessage().contains("foo tainted"));
    }
}
