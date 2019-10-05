package taint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check tainting of field set via dynamic virtual (non-static) method invocation.
 */
class InvokeDynamicMethodTest {

    @Test
    void setFooToUntainted() {
        assertDoesNotThrow(() -> {
            InvokeDynamicMethod.setFooToUntainted();
        });
    }

    @Test
    void setFooToTainted() throws Throwable {
        InvokeDynamicMethod.setFooToTainted();  // placeholder: does not test anything
//        Exception thrown = assertThrows(Exception.class, () -> {
//            InvokeDynamicMethod.setFooToTainted();
//        });
//        assertTrue(thrown.getMessage().contains("foo tainted"));
    }
}
