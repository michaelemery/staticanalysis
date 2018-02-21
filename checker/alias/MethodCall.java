package alias;

public class MethodCall {

    String s;

    // public MethodCall(String s) {
    //     this.s = s;
    // }

    public static void main(String[] args) {

        // creates a temporary alias that does not transform
        // MethodCall foo = new MethodCall("foo");
        MethodCall o = new MethodCall();
        foo(o);  // does not create alias

        System.out.println(foo.s.toString());  // "foo"

        // creates a temporary alias that transforms
        transform(foo);
        System.out.println(foo.s.toString());  // null pointer exception

    }

    // callers argument is not transformed
    static void foo(Object o) {
        //
    }
    
}