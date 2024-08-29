package healthcare;

import healthcare.model.Appointment;
import healthcare.model.Doctor;
import healthcare.model.Patient;
import healthcare.repository.AppointmentRepositoryImpl;
import healthcare.repository.DoctorRepositoryImpl;
import healthcare.repository.PatientRepositoryImpl;
import healthcare.service.AppointmentService;
import healthcare.service.DoctorService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AppointmentMain {
    public static void manageAppointments(AppointmentService appointmentService,Scanner scanner) throws SQLException
    {


        System.out.println("1. Create Appointment");
        System.out.println("2. Read Appointment");
        System.out.println("3. Update Appointment");
        System.out.println("4. Delete Appointment");
System.out.println("5. Read All Appointments");
System.out.println("6. Exit");
        int choice = scanner.nextInt();
        while(choice != 6) {
            scanner.nextLine();


            switch (choice) {
                case 1:
                    // Application calls the service layer, not the repository directly
                    Appointment newAppointment = new Appointment();
                    System.out.print("Enter Doctor ID: ");
                    newAppointment.setDoctorId(scanner.nextInt());
                    System.out.print("Enter Patient ID: ");
                    newAppointment.setPatientId(scanner.nextInt());
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    newAppointment.setAppointmentDate(scanner.nextLine());
                    System.out.print("Enter Notes: ");
                    newAppointment.setNotes(scanner.nextLine());
                    appointmentService.createAppointment(newAppointment);  // Use service here
                    System.out.println("Appointment created successfully.");
                    break;
                case 2:
                    // Application calls the service layer, not the repository directly
                    System.out.print("Enter Appointment ID: ");
                    int appointmentID = scanner.nextInt();
                    Appointment appointment = appointmentService.getAppointmentById(appointmentID); // Use service here
                    if (appointment != null) {
                        System.out.println("Appointment ID: " + appointment.getAppointmentId());
                        System.out.println("Doctor ID: " + appointment.getDoctorId());
                        System.out.println("PatientID: " + appointment.getPatientId());
                        System.out.println("Appointment Date: " + appointment.getAppointmentDate());
                        System.out.println("Notes: " + appointment.getNotes());
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;
                case 3:
                    // Application calls the service layer, not the repository directly
                    System.out.print("Enter Appointment ID: ");
                    appointmentID = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    appointment = appointmentService.getAppointmentById(appointmentID);  // Use service here
                    if (appointment != null) {
                        System.out.print("Enter new Doctor ID: ");
                        appointment.setDoctorId(scanner.nextInt());
                        System.out.print("Enter new Patient ID: ");
                        appointment.setPatientId(scanner.nextInt());
                        System.out.print("Enter new Appointment Date: ");
                        appointment.setAppointmentDate(scanner.nextLine());
                        System.out.print("Enter new notes: ");
                        appointment.setNotes(scanner.nextLine());
                        appointmentService.updateAppointment(appointment);  // Use service here
                        System.out.println("Appointment updated successfully.");
                    } else {
                        System.out.println("Appointment not found.");
                    }
                    break;
                case 4:
                    // Application calls the service layer, not the repository directly
                    System.out.print("Enter Appointment ID: ");
                    appointmentID = scanner.nextInt();
                    appointmentService.deleteAppointment(appointmentID);  // Use service here
                    System.out.println("Appointment deleted successfully.");
                    break;
                case 5:
                    // Application calls the service layer, not the repository directly
                    List<Appointment> appointments=appointmentService.getAllAppointments();
                    for(Appointment appointment1:appointments) {
                        System.out.println("Appointment ID: " + appointment1.getAppointmentId());
                        System.out.println("Doctor ID: " + appointment1.getDoctorId());
                        System.out.println("PatientID: " + appointment1.getPatientId());
                        System.out.println("Appointment Date: " + appointment1.getAppointmentDate());
                        System.out.println("Notes: " + appointment1.getNotes());
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
