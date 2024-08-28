package healthcare.service;

import healthcare.model.Doctor;
import healthcare.model.Patient;
import healthcare.repository.DoctorRepositoryImpl;
import healthcare.repository.PatientRepositoryImpl;

import java.util.List;

public class DoctorService {
    private final DoctorRepositoryImpl doctorRepository;
    public DoctorService(DoctorRepositoryImpl doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public void createDoctor(Doctor doctor) {
        doctorRepository.createDoctor(doctor);
    }
    public Doctor getDoctorById(int doctorID) {
        return doctorRepository.getDoctorById(doctorID);
    }
    public void updateDoctor(Doctor doctor) {
        doctorRepository.updateDoctor(doctor);
    }
    public void deleteDoctor(int doctorID) {
        doctorRepository.deleteDoctor(doctorID);
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepository.getAllDoctors();
    }

}
