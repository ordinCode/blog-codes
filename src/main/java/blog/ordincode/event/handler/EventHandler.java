package blog.ordincode.event.handler;

import net.jodah.typetools.TypeResolver;

public interface EventHandler<T> {
    void handle(T event);

    default boolean canHandle(Object event) {
        Class<?> typeArgs = TypeResolver.resolveRawArgument(EventHandler.class, this.getClass());
        return typeArgs.isAssignableFrom(event.getClass());
    }
}
