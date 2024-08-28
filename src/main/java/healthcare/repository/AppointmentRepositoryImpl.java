package healthcare.repository;


import healthcare.model.Appointment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AppointmentRepositoryImpl {
    private SessionFactory sessionFactory;
    public AppointmentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void createAppointment(Appointment appointment) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(appointment);
            session.getTransaction().commit();
        }
    }
    public Appointment getAppointment(int appointmentID) {
        try(Session session = sessionFactory.openSession()) {
        return session.get(Appointment.class,appointmentID);
    }

}
public void updateAppointment(Appointment appointment) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(appointment);
            session.getTransaction().commit();
        }
}
public void deleteAppointment(int appointmentID) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Appointment appointment = session.get(Appointment.class,appointmentID);
            if(appointment != null) {
                session.delete(appointment);
            }
            session.getTransaction().commit();
        }
}
public List<Appointment> getAllAppointments() {
    try(Session session = sessionFactory.openSession()) {
        return session.createQuery("from Appointment").list();
    }
}
}
