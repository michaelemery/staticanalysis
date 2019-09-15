package com.foofactory.staticanalysis.init;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check initialisation of field set via reflective method return.
 */
class ReflectMethodTest {

    @Test
    public void setFooToNonNull() {
        assertDoesNotThrow(() -> {
            ReflectMethod.setFooToNonNull();
        });
    }

    @Test
    public void setFooToNull() {
        assertThrows(NullPointerException.class, () -> {
            ReflectMethod.setFooToNull();
        });
    }
}
