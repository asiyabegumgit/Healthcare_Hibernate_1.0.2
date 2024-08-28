package healthcare.service;

import healthcare.model.Patient;
import healthcare.repository.PatientRepositoryImpl;

import java.util.List;

public class PatientService {
    private final PatientRepositoryImpl patientRepository;
    public PatientService(PatientRepositoryImpl patientRepository) {
        this.patientRepository = patientRepository;
    }
    public void createPatient(Patient patient) {
        patientRepository.createPatient(patient);
    }
    public Patient getPatientById(int patientID) {
        return patientRepository.getPatientById(patientID);
    }
    public void updatePatient(Patient patient) {
        patientRepository.updatePatient(patient);
    }
    public void deletePatient(int patientID) {
        patientRepository.deletePatient(patientID);
    }
    public List<Patient> getAllPatients() {
        return patientRepository.getAllPatients();
    }

}
