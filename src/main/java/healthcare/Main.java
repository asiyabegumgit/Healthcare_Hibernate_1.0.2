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

         try( Scanner scanner = new Scanner(System.in);
              SessionFactory sessionFactory = new Configuration().configure("healthcare.cfg.xml").buildSessionFactory();){
             System.out.println("--- MAIN MENU ---" );
             System.out.println("1. Manage Patients");
             System.out.println("2. Manage Doctors");
             System.out.println("3. Manage Appointments");
             System.out.println("Enter a choice");
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:

                    PatientMain.managePatients(sessionFactory,scanner);
                    break;
                case 2:
                    DoctorMain.mangeDoctors(sessionFactory,scanner);
                    break;
                case 3:
                    AppointmentMain.manageAppointments(sessionFactory,scanner);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }


    }

}
