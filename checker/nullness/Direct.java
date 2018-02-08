package nullness;

/**
 * Direct assignment to a null reference.
 */
public class Direct {

    String s;

    public Direct(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // direct assignment to non-null (correct)
        Direct foo = new Direct("text");
        System.out.println(foo.s.toString());  // "text"

        // direct assignment to null (fail)
        foo = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}