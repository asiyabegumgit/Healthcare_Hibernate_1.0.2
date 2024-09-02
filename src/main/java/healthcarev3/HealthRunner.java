package healthcarev3;

import healthcarev3.impl.AppointmentRepositoryImpl;
import healthcarev3.impl.DoctorRepositoryImpl;
import healthcarev3.impl.OfficeRepositoryImpl;
import healthcarev3.impl.PatientRepositoryImpl;
import healthcarev3.model.Appointment;
import healthcarev3.model.Doctor;
import healthcarev3.model.Office;
import healthcarev3.model.Patient;
import healthcarev3.service.AppointmentService;
import healthcarev3.service.DoctorService;
import healthcarev3.service.OfficeService;
import healthcarev3.service.PatientService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class HealthRunner {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Instantiate the repositories
        DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl(sessionFactory);
        PatientRepositoryImpl patientRepository = new PatientRepositoryImpl(sessionFactory);
        AppointmentRepositoryImpl appointmentRepository = new AppointmentRepositoryImpl(sessionFactory);
        OfficeRepositoryImpl officeRepository = new OfficeRepositoryImpl(sessionFactory);

        // Instantiate the services using the repositories
        DoctorService doctorService = new DoctorService(doctorRepository);
        PatientService patientService = new PatientService(patientRepository);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);
        OfficeService officeService = new OfficeService(officeRepository);

        Scanner scanner = new Scanner(System.in);

        int choice;

      do{
          System.out.println();

          System.out.println("1. Manage Patients");
          System.out.println("2. Manage Doctors");
          System.out.println("3. Manage Appointments");
          System.out.println("4. Manage Offices");
          System.out.println("5.Exit");

          System.out.print("Enter your choice: ");
          choice = scanner.nextInt();
          switch (choice) {
              case 1:
                  managePatients(patientService, scanner);
                  break;
              case 2:
                  manageDoctors(doctorService, scanner);
                  break;
              case 3:
                  manageAppointments(appointmentService, doctorService, patientService, scanner);
                  break;
              case 4:
                  manageOffices(officeService, doctorService, scanner);
                  break;
             case 5:

                 System.exit(0);

              default:
                  System.out.println("Invalid choice.");
          }
      }
      while(choice != 5);
            sessionFactory.close();
            scanner.close();

    }
    private static void managePatients(PatientService patientService, Scanner scanner) {



      int choice;
        do {
            System.out.println();

            System.out.println("1. Create Patient");
            System.out.println("2. Read Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");

            choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    scanner.nextLine();
                    Patient newPatient = new Patient();
                    System.out.print("Enter first name: ");
                    newPatient.setFirstName(scanner.nextLine());
                    System.out.print("Enter last name: ");
                    newPatient.setLastName(scanner.nextLine());
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    newPatient.setDateOfBirth(scanner.nextLine());
                    System.out.print("Enter email: ");
                    newPatient.setEmail(scanner.nextLine());
                    System.out.print("Enter phone number: ");
                    newPatient.setPhoneNumber(scanner.nextLine());
                    patientService.createPatient(newPatient);
                    System.out.println("Patient created successfully.");
                    break;
                case 2:
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    Patient patient = patientService.getPatientById(patientId);
                    if (patient != null) {
                        System.out.println("Patient ID: " + patient.getId());
                        System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
                        System.out.println("Date of Birth: " + patient.getDateOfBirth());
                        System.out.println("Email: " + patient.getEmail());
                        System.out.println("Phone: " + patient.getPhoneNumber());

                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Patient ID: ");
                    patientId = scanner.nextInt();
                    scanner.nextLine();
                    patient = patientService.getPatientById(patientId);
                    if (patient != null) {
                        System.out.print("Enter new first name: ");
                        patient.setFirstName(scanner.nextLine());
                        System.out.print("Enter new last name: ");
                        patient.setLastName(scanner.nextLine());
                        System.out.print("Enter new date of birth (YYYY-MM-DD): ");
                        patient.setDateOfBirth(scanner.nextLine());
                        System.out.print("Enter new email: ");
                        patient.setEmail(scanner.nextLine());
                        System.out.print("Enter new phone number: ");
                        patient.setPhoneNumber(scanner.nextLine());
                        patientService.updatePatient(patient);
                        System.out.println("Patient updated successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Patient ID: ");
                    patientId = scanner.nextInt();
                    patientService.deletePatient(patientId);
                    System.out.println("Patient deleted successfully.");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        }
            while (choice != 5) ;

    }

    private static void manageDoctors(DoctorService doctorService, Scanner scanner) {
        int choice;

do {
    System.out.println("1. Create Doctor");
    System.out.println("2. Read Doctor");
    System.out.println("3. Update Doctor");
    System.out.println("4. Delete Doctor");
    System.out.println("5. Exit");

    choice= scanner.nextInt();
    switch (choice) {
        case 1:
            Doctor newDoctor = new Doctor();
            scanner.nextLine();
            System.out.print("Enter first name: ");
            newDoctor.setFirstName(scanner.nextLine());
            System.out.print("Enter last name: ");
            newDoctor.setLastName(scanner.nextLine());
            System.out.print("Enter specialty: ");
            newDoctor.setSpecialty(scanner.nextLine());
            System.out.print("Enter email: ");
            newDoctor.setEmail(scanner.nextLine());
            doctorService.createDoctor(newDoctor);
            System.out.println("Doctor created successfully.");
            break;
        case 2:
            System.out.print("Enter Doctor ID: ");
            int doctorId = scanner.nextInt();
            Doctor doctor = doctorService.getDoctorById(doctorId);
            if (doctor != null) {
                System.out.println("Doctor ID: " + doctor.getId());
                System.out.println("Name: " + doctor.getFirstName() + " " + doctor.getLastName());
                System.out.println("Specialty: " + doctor.getSpecialty());
                System.out.println("Email: " + doctor.getEmail());
            } else {
                System.out.println("Doctor not found.");
            }
            choice=5;
            break;
        case 3:
            System.out.print("Enter Doctor ID: ");
            doctorId = scanner.nextInt();
            scanner.nextLine();
            doctor = doctorService.getDoctorById(doctorId);
            if (doctor != null) {
                System.out.print("Enter new first name: ");
                doctor.setFirstName(scanner.nextLine());
                System.out.print("Enter new last name: ");
                doctor.setLastName(scanner.nextLine());
                System.out.print("Enter new specialty: ");
                doctor.setSpecialty(scanner.nextLine());
                System.out.print("Enter new email: ");
                doctor.setEmail(scanner.nextLine());
                doctorService.updateDoctor(doctor);
                System.out.println("Doctor updated successfully.");
            } else {
                System.out.println("Doctor not found.");
            }
            break;
        case 4:
            System.out.print("Enter Doctor ID: ");
            doctorId = scanner.nextInt();
            doctorService.deleteDoctor(doctorId);
            System.out.println("Doctor deleted successfully.");
            break;
            case 5:
                break;
        default:
            System.out.println("Invalid choice.");
    }
}
while(choice!=5);

    }
    private static void manageAppointments(AppointmentService appointmentService, DoctorService doctorService, PatientService patientService, Scanner scanner) {
        int choice;
        do {
            System.out.println("1. Create Appointment");
            System.out.println("2. Read Appointment");
            System.out.println("3. Update Appointment");
            System.out.println("4. Delete Appointment");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

           switch (choice) {
        case 1:
            Appointment newAppointment = new Appointment();
            System.out.print("Enter Patient ID: ");
            int patientId = scanner.nextInt();
            Patient patient = patientService.getPatientById(patientId);
            newAppointment.setPatient(patient);

            System.out.print("Enter Doctor ID: ");
            int doctorId = scanner.nextInt();
            Doctor doctor = doctorService.getDoctorById(doctorId);
            newAppointment.setDoctor(doctor);

            // Add the patient to the doctor's patient set and vice versa
            doctor.getPatients().add(patient);
            patient.getDoctors().add(doctor);

            scanner.nextLine();  // consume newline
            System.out.print("Enter appointment date (YYYY-MM-DD): ");
            newAppointment.setAppointmentDate(scanner.nextLine());
            System.out.print("Enter notes: ");
            newAppointment.setNotes(scanner.nextLine());
            appointmentService.createAppointment(newAppointment);

            // Update the doctor and patient in the database
            doctorService.updateDoctor(doctor);
            patientService.updatePatient(patient);

            System.out.println("Appointment created successfully.");
            break;

        case 2:
            System.out.print("Enter Appointment ID: ");
            int appointmentId = scanner.nextInt();
            Appointment appointment = appointmentService.getAppointmentById(appointmentId);
            if (appointment != null) {
                System.out.println("Appointment ID: " + appointment.getId());
                System.out.println("Patient ID: " + appointment.getPatient().getId());
                System.out.println("Doctor ID: " + appointment.getDoctor().getId());
                System.out.println("Appointment Date: " + appointment.getAppointmentDate());
                System.out.println("Notes: " + appointment.getNotes());
            } else {
                System.out.println("Appointment not found.");
            }
            break;

        case 3:
            System.out.print("Enter Appointment ID: ");
            appointmentId = scanner.nextInt();
            scanner.nextLine();  // consume newline
            appointment = appointmentService.getAppointmentById(appointmentId);
            if (appointment != null) {
                System.out.print("Enter new Patient ID: ");
                patientId = scanner.nextInt();
                patient = patientService.getPatientById(patientId);
                appointment.setPatient(patient);

                System.out.print("Enter new Doctor ID: ");
                doctorId = scanner.nextInt();
                doctor = doctorService.getDoctorById(doctorId);
                appointment.setDoctor(doctor);

                // Add the patient to the doctor's patient set and vice versa
                doctor.getPatients().add(patient);
                patient.getDoctors().add(doctor);

                scanner.nextLine();
                System.out.print("Enter new appointment date (YYYY-MM-DD): ");
                appointment.setAppointmentDate(scanner.nextLine());
                System.out.print("Enter new notes: ");
                appointment.setNotes(scanner.nextLine());
                appointmentService.updateAppointment(appointment);

                // Update the doctor and patient in the database
                doctorService.updateDoctor(doctor);
                patientService.updatePatient(patient);

                System.out.println("Appointment updated successfully.");
            } else {
                System.out.println("Appointment not found.");
            }
            break;

        case 4:
            System.out.print("Enter Appointment ID: ");
            appointmentId = scanner.nextInt();
            appointmentService.deleteAppointment(appointmentId);
            System.out.println("Appointment deleted successfully.");
            break;
        case 5:
            break;
        default:
            System.out.println("Invalid choice.");
    }

}
        while(choice!=5);
    }
    private static void manageOffices(OfficeService officeService, DoctorService doctorService,Scanner scanner) {
        int choice;

        do {

            System.out.println("1. Create Office");
            System.out.println("2. Read Office");
            System.out.println("3. Update Office");
            System.out.println("4. Delete Office");
            System.out.println("5. Read All Offices");
            System.out.println("6. Exit");
            choice = scanner.nextInt();

            switch (choice) {
        case 1:
            Office newOffice = new Office();
            System.out.print("Enter Doctor ID: ");
            int doctorId = scanner.nextInt();
            Doctor doctor = doctorService.getDoctorById(doctorId);
            if (doctor != null) {
                newOffice.setDoctor(doctor);
                scanner.nextLine();
                System.out.print("Enter Location: ");
                newOffice.setLocation(scanner.nextLine());
                System.out.print("Enter Phone Number: ");
                newOffice.setPhone(scanner.nextLine());
                officeService.createOffice(newOffice);
                //doctorService.updateDoctor(doctor);

                System.out.println("Office created successfully.");
            } else {
                System.out.println("Doctor not found.");
            }
            break;

        case 2:
            System.out.print("Enter Office ID: ");
            int officeId = scanner.nextInt();
            Office office = officeService.getOfficeById(officeId);
            if (office != null) {
                System.out.println("Office ID: " + office.getOfficeId());
                System.out.println("Doctor Name: " + office.getDoctor().getFirstName()+" "+office.getDoctor().getLastName());
                System.out.println("Office Location: " + office.getLocation());
                System.out.println("Phone: " + office.getPhone());
            } else {
                System.out.println("Office not found.");
            }
            break;

        case 3:
            System.out.print("Enter Office ID: ");
            officeId = scanner.nextInt();
            scanner.nextLine();  // consume newline
            office = officeService.getOfficeById(officeId);
            if (office != null) {
                System.out.print("Enter new Doctor ID: ");
                doctorId = scanner.nextInt();
                doctor = doctorService.getDoctorById(doctorId);
                office.setDoctor(doctor);
                scanner.nextLine();
                System.out.print("Enter new location: ");
                office.setLocation(scanner.nextLine());
                System.out.print("Enter new phone number: ");
                office.setPhone(scanner.nextLine());
                officeService.updateOffice(office);
                System.out.println("Office updated successfully.");
            } else {
                System.out.println("Office not found.");
            }
            break;

        case 4:
            System.out.print("Enter Office ID: ");
            officeId = scanner.nextInt();
            officeService.deleteOffice(officeId);
            System.out.println("Office deleted successfully.");
            break;
        case 5:
            List<Office> offices = officeService.getAllOffices();
            for (Office office1 : offices) {
                System.out.println("Office ID: " + office1.getOfficeId());
                System.out.println("Doctor Name: " + office1.getDoctor().getFirstName()+" "+office1.getDoctor().getLastName());
                System.out.println("Office Location: " + office1.getLocation());
                System.out.println("Phone: " + office1.getPhone());
            }
        case 6:
            break;
        default:
            System.out.println("Invalid choice.");
    }

}
while(choice!=6);
    }
}
