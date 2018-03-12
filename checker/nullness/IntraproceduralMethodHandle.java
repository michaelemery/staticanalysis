import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

class Message {
    String s;
}

/**
* Assignment of a null reference using method invoked *intraprocedurally* via MethodHandle.
*/
public class IntraproceduralMethodHandle {

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh;
        Message message = new Message();
        String s;

        // set/get field with a non-null value (correct)
        mh = lookup.findSetter(Message.class, "s", String.class);
        mh.invoke(message, "text");
        mh = lookup.findGetter(Message.class, "s", String.class);
        s = (String) mh.invoke(message);
        System.out.println(s.toString());  // "text"

        // set/get field with a null value (fail)
        mh = lookup.findSetter(Message.class, "s", String.class);
        mh.invoke(message, null);
        mh = lookup.findGetter(Message.class, "s", String.class);
        s = (String) mh.invoke(message);
        System.out.println(s.toString());  // NullPointerException
    }
}
