package init;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class IntraProceduralTest {

    IntraProcedural i;

    @AfterEach
    void tearDown() {
        i = null;
    }

    @Test
    void testSafeSet() {
        i = new IntraProcedural();
        assertEquals(this.i.toString(), "safe");
    }

    @Test
    void unsafeSet() {
        new IntraProcedural(1);
        assertThrows(NullPointerException.class, () -> {
            this.i.toString();
        });

    }
}