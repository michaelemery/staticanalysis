package alias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Emery on 30/08/19.
 */
class InterProceduralTest {

    @Test
    void setOneWithAlias() {
        assertDoesNotThrow(() -> {
            InterProcedural.setOneWithAlias();
        });
    }

    @Test
    void setOneWithoutAlias() {
        assertThrows(Exception.class, () -> {
            InterProcedural.setOneWithoutAlias();
        });
    }
}
