package taint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check tainting of field set via dynamic field access invocation.
 */
class InvokeDynamicFieldTest {

    @Test
    void setFooToUntainted() {
        assertDoesNotThrow(() -> {
            InvokeDynamicField.setFooToUntainted();
        });
    }

    @Test
    void setFooToTainted() throws Throwable {
        InvokeDynamicField.setFooToTainted();  // placeholder: does not test anything
//        Exception thrown = assertThrows(Exception.class, () -> {
//            InvokeDynamicField.setFooToTainted();
//        });
//        assertTrue(thrown.getMessage().contains("foo tainted"));
    }
}
