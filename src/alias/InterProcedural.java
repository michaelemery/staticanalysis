package alias;

import org.checkerframework.common.aliasing.qual.Unique;

/**
 *
 */
public class InterProcedural {

    Object o = "init";

    public static void main(String[] args) {
        @Unique InterProcedural original = new InterProcedural();

        /* safe: set unique object uniquely */
        original.o = "safe";
        System.out.println(original.o.toString());

        /* unsafe: make object null via alias */
        InterProcedural alias = aliasOf(original);
        alias.o = null;
        System.out.println(original.o.toString());
    }

    static InterProcedural aliasOf(InterProcedural original) {
        return original;
    }
}