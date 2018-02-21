package alias;

public class MethodReturn {

    String s;

    public MethodReturn(String s) {
        this.s = s;
    }

    public static void main(String[] args) {

        MethodReturn foo = new MethodReturn("foo");
        MethodReturn barfoo = bar(foo);
        barfoo.s = null;
        System.out.println(foo.s.toString());  // null pointer exception

    }

    // pseudo assignment of an alias via method parameter
    static MethodReturn bar(MethodReturn o) {
        return o;
    }
    
}