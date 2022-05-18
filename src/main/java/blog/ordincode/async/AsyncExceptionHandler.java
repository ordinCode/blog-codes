package blog.ordincode.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(AsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        logger.info("Exception Message :: {}", throwable.getMessage());
        logger.info("Method Name :: {}", method.getName());
        for (Object param : obj) {
            logger.info("Parameter Value :: {}", param);
        }
    }
}
