package com.example.cqrs_example.hibernaterlistener;

import com.example.cqrs_example.entity.model.Student;
import org.hibernate.event.spi.*;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

@Component
public class StudentHibernateEventListener implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener {

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return true;
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        System.out.println("onPostDelete");
        Object entity = event.getEntity();
        handleEntity(entity);
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        System.out.println("onPostInsert");
        Object entity = event.getEntity();
        handleEntity(entity);
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        System.out.println("onPostUpdate");
        Object entity = event.getEntity();
        handleEntity(entity);
    }

    private void handleEntity(Object entity) {
        if (entity instanceof Student) {
            //todo StudentView 데이터 업데이트
        }
    }
}
