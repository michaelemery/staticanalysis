package alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Emery on 1/09/19.
 */
class ReflectConstructorTest {

    @Test
    void setOneWithAlias() {
        assertDoesNotThrow(() -> {
            ReflectConstructor.setOneWithAlias();
        });
    }

    @Test
    void setOneWithoutAlias() {
        assertThrows(Exception.class, () -> {
            ReflectConstructor.setOneWithoutAlias();
        });
    }
}
