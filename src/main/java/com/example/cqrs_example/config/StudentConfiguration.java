package com.example.cqrs_example.config;

import com.example.cqrs_example.hibernaterlistener.StudentHibernateEventListener;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Configuration
public class StudentConfiguration {
    private final EntityManagerFactory entityManagerFactory;
    private final StudentHibernateEventListener studentHibernateEventListener;

    @PostConstruct
    private void init() {
        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);

        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(studentHibernateEventListener);
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(studentHibernateEventListener);
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(studentHibernateEventListener);
    }
}
