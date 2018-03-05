public class Proxy {

    public interface MyInterface {
        Object get();
    }

    public class RunExample {

        public static void main(String[] args) {
            MyInterface proxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(),new Class[] { MyInterface.class },new MyInvocationHandler());
            proxy.get().toString();
        }

    }

    public class MyInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object obj, Method m, Object[] arg) throws Throwable {
            return null;  
        }

    }

    public class MyClass implements MyInterface {

         public Object get() {
            return new Object();
        }

    }

}
