package checker.nullness;

import java.lang.reflect.Method;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Assignment of a null reference via InvokeDynamic.
 */
class Foo {
   String s;
}

public class InvokeDynamic {
   
   public static void main(String[] args) throws Throwable {

      MethodHandles.Lookup lookup = MethodHandles.lookup();
      MethodHandle mh;
      Foo foo = new Foo();

      // set foo to valid string
      mh = lookup.findSetter(Foo.class, "s", String.class);
      mh.invoke(foo, "text");
      mh = lookup.findGetter(Foo.class, "s", String.class);
      System.out.println(mh.invoke(foo).toString());

      // set foo to null
      mh = lookup.findSetter(Foo.class, "s", String.class);
      mh.invoke(foo, null);
      mh = lookup.findGetter(Foo.class, "s", String.class);
      System.out.println(mh.invoke(foo).toString());
   }
}