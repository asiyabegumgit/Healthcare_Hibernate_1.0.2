package healthcare.service;

import healthcare.model.Appointment;
import healthcare.repository.AppointmentRepositoryImpl;

import java.util.List;

public class AppointmentService {
    private final AppointmentRepositoryImpl appointmentRepository;
    public AppointmentService(AppointmentRepositoryImpl appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public void createAppointment(Appointment appointment) {
        appointmentRepository.createAppointment(appointment);
    }
    public Appointment getAppointmentById(int appointmentID) {
        return appointmentRepository.getAppointment(appointmentID);

    }
    public void updateAppointment(Appointment appointment) {
        appointmentRepository.updateAppointment(appointment);
    }
    public void deleteAppointment(int appointmentID) {
        appointmentRepository.deleteAppointment(appointmentID);
    }
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAllAppointments();
    }
}
