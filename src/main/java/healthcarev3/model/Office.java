package healthcarev3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity

@Getter
@Setter
@NoArgsConstructor

//@ToString(exclude = {"patients", "appointments"})
@Table(name="Offices")
public class Office
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int officeId;
    @Column
    String location;
    @Column
    String phone;
    @OneToOne
    @JoinColumn(name="DoctorID")
    Doctor doctor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return officeId == office.officeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeId);
    }

}
