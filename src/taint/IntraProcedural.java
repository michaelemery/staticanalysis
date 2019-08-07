package taint;

import org.checkerframework.checker.tainting.qual.Untainted;

/**
 *
 */
class IntraProcedural {

    @Untainted String s;

    public static void main(String[] args) {

        IntraProcedural i = new IntraProcedural();

        // safe: modified with untainted value
        @Untainted String safe = "safe";
        i.s = safe;
        System.out.println(i.s.toString());

        // unsafe: modified with untainted value
        String unsafe = null;
        i.s = unsafe;
        System.out.println(i.s.toString());
    }
}
