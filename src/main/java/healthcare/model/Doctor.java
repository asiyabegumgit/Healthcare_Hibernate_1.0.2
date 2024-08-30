package healthcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DoctorID;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String speciality;
    @Column
    private String email;

    public Doctor() {
    }

    public Doctor(int doctorID, String firstName, String lastName, String speciality, String email) {
        DoctorID = doctorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.email = email;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int doctorID) {
        DoctorID = doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}