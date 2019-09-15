package com.foofactory.staticanalysis.alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check for changes due to aliasing an object via dynamic virtual method invocation.
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
        assertTrue(thrown.getMessage() == "foo changed by alias");
    }
}
