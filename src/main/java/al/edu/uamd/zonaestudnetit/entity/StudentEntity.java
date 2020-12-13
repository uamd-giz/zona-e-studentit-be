package al.edu.uamd.zonaestudnetit.entity;

import javax.persistence.*;

@Entity
@NamedQueries({@NamedQuery(name = "StudentEntity.getAll", query = "Select s StudentEntity s")})
public class StudentEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "emri")
    private String firstName;
    private String lastName;
    private String test;

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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

}
