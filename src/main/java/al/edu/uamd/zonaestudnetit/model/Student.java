package al.edu.uamd.zonaestudnetit.model;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.time.LocalDate;

public class Student {

    private String firstName;
    private String lastName;
    private Integer mosha;

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

    public Integer getMosha() {
        return mosha;
    }

    public void setMosha(Integer mosha) {
        this.mosha = mosha;
    }
}
