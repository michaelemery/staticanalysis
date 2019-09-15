package com.foofactory.staticanalysis.taint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check tainting for field set via dynamic proxy invocation.
 */
class DynamicProxyTest {

    @Test
    void setFooToUntainted() {
        assertDoesNotThrow(() -> {
            DynamicProxy.setFooToUntainted();
        });
    }

    @Test
    void setFooToTainted() throws Throwable {
        DynamicProxy.setFooToTainted();  // placeholder: does not test anything
//        Exception thrown = assertThrows(Exception.class, () -> {
//            DynamicProxy.setFooToTainted();
//        });
//        assertTrue(thrown.getMessage().contains("foo tainted"));
    }
}
