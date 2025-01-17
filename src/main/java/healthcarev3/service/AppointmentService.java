package healthcarev3.service;


import healthcarev3.model.Appointment;
import healthcarev3.repository.AppointmentRepository;

import java.util.List;

public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public Appointment getAppointmentById(int id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void updateAppointment(Appointment appointment) {
        appointmentRepository.update(appointment);
    }

    public void deleteAppointment(int id) {
        appointmentRepository.delete(id);
    }
}
