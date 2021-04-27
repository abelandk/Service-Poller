package com.kry.services.dao;

import com.kry.services.model.PollerModel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Repository
public class PollerDAOImpl implements PollerDAO {

    @Autowired
    EntityManager entityManager;

    Session session;

    /**
     * Creates and Updates services to the services table
     * @param pollerModel the model to be created/updated
     */
    @Override
    @Transactional
    public void createServices(PollerModel pollerModel) {

        session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(pollerModel);
    }

    @Override
    @Transactional
    public List<PollerModel> getServices() {

        session = entityManager.unwrap(Session.class);
        Query<PollerModel> pollerModelQuery =
                session.createQuery("from PollerModel", PollerModel.class);

        return pollerModelQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(int id) {
        session = entityManager.unwrap(Session.class);

        PollerModel pollerModel = session.get(PollerModel.class, id);
        session.delete(pollerModel);

        //This makes the pending delete to be done
        session.flush() ;
    }
}
