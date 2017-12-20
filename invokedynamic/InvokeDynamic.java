import java.lang.reflect.*;

public class InvokeDynamic {

    interface A {
        public void foo();
    }

    static class B implements A {
        @Override
        public void foo() {
            System.out.println("B.foo()");
        }
    }

    static class ProxyOfA implements InvocationHandler {
        private A delegate;

        ProxyOfA(A delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (delegate instanceof Proxy) {
                // This is a proxy
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(delegate);
                invocationHandler.invoke(delegate, method, args);
            } else {
                // This is not a proxy
                method.invoke(delegate, args);
            }
            System.out.println("Proxy of Proxy invoked");
            return null;
        }

    }

    public static void main(String[] args) {
        //instantiate targets
        A b = new B();
        A proxy = (A) Proxy.newProxyInstance(A.class.getClassLoader(), new Class[] { A.class },
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("I am a Proxy");
                        return null;
                    }
                });

        //instantiate proxies
        A proxyOfb = (A) Proxy.newProxyInstance(A.class.getClassLoader(), new Class[] { A.class }, new ProxyOfA(b));
        A proxyOfproxy = (A) Proxy.newProxyInstance(A.class.getClassLoader(), new Class[] { A.class }, new ProxyOfA(proxy));

        //invoke
        proxyOfb.foo();
        proxyOfproxy.foo();
    }
}