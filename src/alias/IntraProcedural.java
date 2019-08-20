package alias;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 *
 */
public class IntraProcedural {

    Object o = "init";

    public static void main(String[] args) throws Throwable {
        @Unique IntraProcedural original = new IntraProcedural();

        /* safe: set unique object uniquely */
        original.o = "safe";
        System.out.println(original.o.toString());

        /* unsafe: make object null via alias */
        IntraProcedural alias = original;
        alias.o = null;
        System.out.println(original.o.toString());
    }
}
