package checker.nullness;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Michael Emery on 2019-05-29.
 */
public class DynamicInvocationHandler implements InvocationHandler {

    private final Object target;

    private static Logger logger = Logger.getLogger(DynamicInvocationHandler.class);

    public DynamicInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("Invoked method: " + method.getName());
        return 42;
    }
}
