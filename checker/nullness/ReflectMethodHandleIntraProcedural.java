import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

class Message {
    String s;
}

/**
* Assignment of a null reference using method invoked *intraprocedurally* via MethodHandle.
*/
public class ReflectMethodHandleIntraProcedural {

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh;
        String s;
        Message message = new Message();
            
        // get field with a non-null value
        message.s = "";
        mh = lookup.findGetter(Message.class, "s", String.class);
        s = (String) mh.invoke(message);  // safe
        System.out.println(s.toString());  // "text"

        // get field with a null value
        message.s = null;
        mh = lookup.findGetter(Message.class, "s", String.class);
        s = (String) mh.invoke(message);  // unsafe
        System.out.println(s.toString());  // NullPointerException
    }
}
