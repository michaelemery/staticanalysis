package init;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 */
public class IntraProceduralTest {

    IntraProcedural i;

    @AfterEach
    public void tearDown() {
        i = null;
    }

    @Test
    public void safeSet() {
        i = new IntraProcedural();
        assertEquals(this.i.object.toString(), "safe");
    }

    @Test
    public void unsafeSet() {
        i = new IntraProcedural(1);
        assertThrows(NullPointerException.class, () -> {
            this.i.object.toString();
        });
    }
}