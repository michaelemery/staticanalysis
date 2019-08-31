package alias;

import org.checkerframework.common.aliasing.qual.Unique;

import java.lang.reflect.Constructor;

/**
 * Check field for changes caused via dynamic invocation of a constructor.
 */
public class ReflectConstructor {

    int one;

    ReflectConstructor(int x) {
        this.one = x;
    }

    ReflectConstructor(Object object) {
        this.one = (int) object;  ///////////////////// WRONG!!!!!!
    }

    static Constructor getConstructWithInt(int x) throws NoSuchMethodException {
        return ReflectConstructor.class.getDeclaredConstructor(int.class);
    }

    static Constructor getConstructWithObject(Class Object) throws NoSuchMethodException {
        return ReflectConstructor.class.getDeclaredConstructor(Object.class);
    }

    /**
     * Non-aliased object never throws Exception.
     */
    public static void setOneWithAlias() throws Exception {
        Constructor constructor = getConstructWithObject(int.class);
        @Unique ReflectConstructor original =
                ((ReflectConstructor) constructor.newInstance(1));
        if (original.one + 1 == 3) {  /////////////// NOT GOOD ENOUGH !!!!!
            throw new Exception();
        }
    }
    /////////// METHODS BACK TO FRONT!!!!!
    /**
     * Aliased object always throws Exception.
     */
    public static void setOneWithoutAlias() throws Exception {
        Constructor constructor = getConstructWithObject(int.class);
        @Unique ReflectConstructor original =
                ((ReflectConstructor) constructor.newInstance(1));
        ReflectConstructor alias =
                ((ReflectConstructor) constructor.newInstance(original));
        if (original.one + 1 == 3) {
            throw new Exception();
        }
    }
}
