package healthcare;

import healthcare.model.Doctor;
import healthcare.repository.DoctorRepositoryImpl;
import healthcare.service.DoctorService;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DoctorMain {
    public static void mangeDoctors(SessionFactory sessionFactory , Scanner scanner) throws SQLException {
        DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl(sessionFactory);
        DoctorService doctorService = new DoctorService(doctorRepository);

        System.out.println("1. Create Doctor");
        System.out.println("2. Read Doctor");
        System.out.println("3. Update Doctor");
        System.out.println("4. Delete Doctor");
        System.out.println("5. Read All Doctors");
        System.out.println("6. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 6) {
            switch (choice) {
                case 1:
                    // Application calls the service layer, not the repository directly
                    Doctor newDoctor = new Doctor();
                    System.out.print("Enter first name: ");
                    newDoctor.setFirstName(scanner.nextLine());
                    System.out.print("Enter last name: ");
                    newDoctor.setLastName(scanner.nextLine());
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    newDoctor.setSpeciality(scanner.nextLine());
                    System.out.print("Enter email: ");
                    newDoctor.setEmail(scanner.nextLine());
                    doctorService.createDoctor(newDoctor);  // Use service here
                    System.out.println("Doctor created successfully.");
                    break;
                case 2:
                    // Application calls the service layer, not the repository directly
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    Doctor doctor1 = doctorService.getDoctorById(doctorId);  // Use service here
                    if (doctor1 != null) {
                        System.out.println("Doctor ID: " + doctor1.getDoctorID());
                        System.out.println("Name: " + doctor1.getFirstName() + " " + doctor1.getLastName());
                        System.out.println("Speciality: " + doctor1.getSpeciality());
                        System.out.println("Email: " + doctor1.getEmail());

                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;
                case 3:
                    // Application calls the service layer, not the repository directly
                    System.out.print("Enter Doctor ID: ");
                    int doctorID = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    Doctor doctor2 = doctorService.getDoctorById(doctorID);  // Use service here
                    if (doctor2 != null) {
                        System.out.print("Enter new first name: ");
                        doctor2.setFirstName(scanner.nextLine());
                        System.out.print("Enter new last name: ");
                        doctor2.setLastName(scanner.nextLine());
                        System.out.print("Enter new speciality: ");
                        doctor2.setSpeciality(scanner.nextLine());
                        System.out.print("Enter new email: ");
                        doctor2.setEmail(scanner.nextLine());
                        doctorService.updateDoctor(doctor2);  // Use service here
                        System.out.println("Doctor updated successfully.");
                    } else {
                        System.out.println("Doctor not found.");
                    }
                    break;
                case 4:
                    // Application calls the service layer, not the repository directly
                    System.out.print("Enter Doctor ID: ");
                    doctorID = scanner.nextInt();
                    doctorService.deleteDoctor(doctorID);  // Use service here
                    System.out.println("Doctor deleted successfully.");
                    break;
                case 5:
                    List<Doctor> doctors = doctorService.getAllDoctors();  // Use service here
                    for (Doctor doctor : doctors) {
                        System.out.println("Doctor ID: " + doctor.getDoctorID());
                        System.out.println("Name: " + doctor.getFirstName() + " " + doctor.getLastName());
                        System.out.println("Speciality: " + doctor.getSpeciality());
                        System.out.println("Email: " + doctor.getEmail());

                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println("Enter a choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();

        }
    }
}