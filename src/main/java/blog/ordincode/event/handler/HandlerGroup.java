package blog.ordincode.event.handler;

import java.util.ArrayList;
import java.util.List;

public class HandlerGroup {
    private final List<EventHandler<?>> eventHandlers;

    public HandlerGroup() {
        List<EventHandler<?>> eventHandlers = new ArrayList<>();
        eventHandlers.add(new RoundCompletedHandler());
        eventHandlers.add(new GameFinishedHandler());
        this.eventHandlers = eventHandlers;
    }

    public List<EventHandler<?>> getHandlers() {
        return eventHandlers;
    }
}
