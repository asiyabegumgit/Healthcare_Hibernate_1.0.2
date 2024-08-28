package healthcare.repository;

import healthcare.model.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DoctorRepositoryImpl {
    private SessionFactory sessionFactory;
    public DoctorRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void createDoctor(Doctor doctor) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        }
    }
    public Doctor getDoctorById(int doctorID) {
        try (Session session = this.sessionFactory.openSession()) {
            return session.get(Doctor.class, doctorID);
        }
    }
    public void updateDoctor(Doctor doctor) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(doctor);
            session.getTransaction().commit();
        }
    }
    public void deleteDoctor(int doctorID) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, doctorID);
            if(doctor != null) {
                session.delete(doctor);
            }
            session.getTransaction().commit();
        }
    }
    public List<Doctor> getAllDoctors() {
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from Doctor").list();
        }
    }
}
