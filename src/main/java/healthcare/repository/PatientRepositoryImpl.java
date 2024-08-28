package healthcare.repository;

import healthcare.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
public class PatientRepositoryImpl {
    private SessionFactory sessionFactory;

    public PatientRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void createPatient(Patient patient)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(patient);
        session.getTransaction().commit();
    }


    public Patient getPatientById(int patientID)
    {
        try(Session session=sessionFactory.openSession()) {
            return session.get(Patient.class,patientID);
        }
    }
    public void updatePatient(Patient patient)
    {
        try(Session session=sessionFactory.openSession())
        {
            session.beginTransaction();
            session.update(patient);
            session.getTransaction().commit();
        }
    }
    public void deletePatient(int patientID)
    {
        try(Session session=sessionFactory.openSession())
        {
            session.beginTransaction();
            session.delete(session.get(Patient.class,patientID));
            session.getTransaction().commit();
        }
    }
    public List<Patient> getAllPatients()
    {
        try(Session session = sessionFactory.openSession())
        {
            return session.createQuery("from Patient",Patient.class).list();
        }
    }
}
