package nullness;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class IntraProceduralTest {

    IntraProcedural i;

    @BeforeEach
    void setUp() {
        i = new IntraProcedural("init");
        assertEquals(i.object, "init");
    }

    @AfterEach
    void tearDown() {
        i = null;
    }

    @Test
    public void safeSet() {
        i.object = "safe";
        assertEquals(i.object, "safe");
        assertDoesNotThrow(() -> {
            i.object.toString();
        });
    }

    @Test
    public void unsafeSet() {
        i.object = null;
        assertThrows(NullPointerException.class, () -> {
            System.out.println(i.object.toString());
        });
    }
}