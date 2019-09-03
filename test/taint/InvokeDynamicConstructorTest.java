package taint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Check tainting of field set via dynamic constructor invocation.
 */
class InvokeDynamicConstructorTest {

    @Test
    void setFooToUntainted() {
        assertDoesNotThrow(() -> {
            InvokeDynamicConstructor.setFooToUntainted();
        });
    }

    @Test
    void setFooToTainted() throws Throwable {
        InvokeDynamicConstructor.setFooToTainted();  // placeholder: does not test anything
//        Exception thrown = assertThrows(Exception.class, () -> {
//            InvokeDynamicConstructor.setFooToTainted();
//        });
//        assertTrue(thrown.getMessage().contains("foo tainted"));
    }
}
