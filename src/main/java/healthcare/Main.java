package healthcare;

import healthcare.repository.AppointmentRepositoryImpl;
import healthcare.repository.DoctorRepositoryImpl;
import healthcare.repository.PatientRepositoryImpl;
import healthcare.service.AppointmentService;
import healthcare.service.DoctorService;
import healthcare.service.PatientService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("healthcare.cfg.xml").buildSessionFactory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- MAIN MENU ---" );
        System.out.println("1. Manage Patients");
        System.out.println("2. Manage Doctors");
        System.out.println("3. Manage Appointments");
        System.out.println("Enter a choice");
        int choice = scanner.nextInt();
        try{
            switch(choice)
            {
                case 1:

                    PatientRepositoryImpl patientRepository = new PatientRepositoryImpl(sessionFactory);
                    PatientService patientService = new PatientService(patientRepository);

                    PatientMain.managePatients(patientService,scanner);
                    break;
                case 2:
                    DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl(sessionFactory);
                    DoctorService doctorService = new DoctorService(doctorRepository);

                    DoctorMain.mangeDoctors(doctorService,scanner);

                    break;
                case 3:
                    AppointmentRepositoryImpl appointmentRepository = new AppointmentRepositoryImpl(sessionFactory);
                    AppointmentService appointmentService = new AppointmentService(appointmentRepository);

                    AppointmentMain.manageAppointments(appointmentService,scanner);

                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
            finally
         {
            scanner.close();
            sessionFactory.close();
        }

    }

}
