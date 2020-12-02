package blog.ordincode.event;

import blog.ordincode.event.handler.EventHandler;

import java.util.ArrayList;
import java.util.List;

public class EventDispatcher {
    private static final ThreadLocal<List<EventHandler<?>>> handlers = new ThreadLocal<>();

    private static final ThreadLocal<Boolean> publishing =
            new ThreadLocal<Boolean>() {
                @Override
                protected Boolean initialValue() {
                    return Boolean.FALSE;

                }
            };

    public static void raise(Object event) {
        if (publishing.get()) {
            return;
        }

        try {
            publishing.set(Boolean.TRUE);

            List<EventHandler<?>> eventHandlers = handlers.get();
            if (eventHandlers == null) {
                System.out.println("eventHandler is null");
                return;
            }
            for (EventHandler eventHandler : eventHandlers) {
                if (eventHandler.canHandle(event)) {
                    eventHandler.handle(event);
                }
            }
        } finally {
            publishing.set(Boolean.FALSE);
        }
    }

    public static void handle(EventHandler<?> handler) {
        if (publishing.get()) return;

        List<EventHandler<?>> eventHandlers = handlers.get();
        if (eventHandlers == null) {
            eventHandlers = new ArrayList<>();
            handlers.set(eventHandlers);
        }
        eventHandlers.add(handler);
    }

    public static void reset() {
        if (!publishing.get()) {
            handlers.remove();
        }
    }
}
