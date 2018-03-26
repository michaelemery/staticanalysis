package nullness;

/**
 * Intraprocedural assignment of a null reference.
 */
public class VanillaIntraProcedural {

    public static void main(String[] args) throws NullPointerException {
        String s;

        // intraprocedural assignment of a non-null reference
        s = "text";  // safe
        System.out.println(s.toString());  // "text"

        // intraprocedural assignment of a null reference
        s = null;  // unsafe
        System.out.println(s.toString());  // NullPointerException
    }
}
