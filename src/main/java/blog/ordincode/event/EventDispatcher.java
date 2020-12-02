package blog.ordincode.event;

import blog.ordincode.event.handler.EventHandler;
import blog.ordincode.event.handler.HandlerGroup;

import java.util.List;

public class EventDispatcher {
    private static final HandlerGroup handlers = new HandlerGroup();
    private static final EventThreadPoolExecutor executor = new EventThreadPoolExecutor();

    public static void raise(Object event) {
        List<EventHandler<?>> eventHandlers = handlers.getHandlers();
        for (EventHandler eventHandler : eventHandlers) {
            if (eventHandler.canHandle(event)) {
                executor.submit(() -> eventHandler.handle(event));
            }
        }
    }
}
