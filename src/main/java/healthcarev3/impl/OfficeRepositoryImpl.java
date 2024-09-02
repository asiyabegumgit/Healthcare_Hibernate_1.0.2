package healthcarev3.impl;

import healthcarev3.model.Office;
import healthcarev3.repository.OfficeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OfficeRepositoryImpl implements OfficeRepository {
   private SessionFactory sessionFactory;

    public OfficeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createOffice(Office office) {
        try(Session session= sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(office);
            session.getTransaction().commit();
        }
    }

    @Override
    public Office getOfficeById(int officeId) {
        try(Session session= sessionFactory.openSession()) {
            return session.get(Office.class, officeId);
        }

    }

    @Override
    public void updateOffice(Office office) {
try(Session session= sessionFactory.openSession()) {
    session.beginTransaction();
    session.merge(office);
    session.getTransaction().commit();
}
    }

    @Override
    public void deleteOffice(int officeId) {
    try(Session session= sessionFactory.openSession()) {
        session.beginTransaction();
        Office office = session.get(Office.class, officeId);
        session.remove(office);
        session.getTransaction().commit();
    }
    }

    @Override
    public List<Office> getAllOffices() {
        try(Session session= sessionFactory.openSession()) {
            return session.createQuery("from Office",Office.class).list();
        }
    }
}
