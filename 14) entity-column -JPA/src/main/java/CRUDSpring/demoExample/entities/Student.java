package CRUDSpring.demoExample.entities;

import jakarta.persistence.*;

/* ! In questo file abbiamo messo in atto una MAPPATURA di un oggetto, o di una classe ad una
   ! tabella nel db
*/
@Entity
@Table(name = "student")
public class Student{

// !   Definisci i campi della classe cosi come sono quelli della tabella

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")

    private String lastName;
    @Column(name = "email")

    private String email;

// !   Definisci un costruttore
    Student() {
    }

// *   Come puoi notare il campo id viene gestito dal database quindi puoi evitare
// *   di inserirlo come parametro del costruttore
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


// !   Definisci i get e set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
