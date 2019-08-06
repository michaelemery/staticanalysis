package nullness;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Michael Emery on 2019-08-06.
 */
class IntraProceduralTest {

    IntraProcedural i;

    @BeforeEach
    void setUp() {
        i = new IntraProcedural("init");
        assertEquals(i.o, "init");
    }

    @AfterEach
    void tearDown() {
        i = null;
    }

    @Test
    public void safeSet() {
        i.o = "safe";
        assertEquals(i.o, "safe");
        assertDoesNotThrow(() -> {
            i.o.toString();
        });
    }

    @Test
    public void unsafeSet() {
        i.o = null;
        assertThrows(NullPointerException.class, () -> {
            System.out.println(i.o.toString());
        });
    }
}