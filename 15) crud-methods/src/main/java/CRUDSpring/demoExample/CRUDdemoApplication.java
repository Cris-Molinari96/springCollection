package CRUDSpring.demoExample;

import CRUDSpring.demoExample.dao.StudentDao;
import CRUDSpring.demoExample.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CRUDdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CRUDdemoApplication.class, args);
    }

    // Questa istruzione sarà eseguita appena verrà eseguita l'applicazione
    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            readAllStudentBySurname(studentDao);
        };
    }



    // ! READ METHOD
/** Metodo che legge un singolo studente in base al nome passato
     * */
    private void readSingleStudent(StudentDao studentDao) {
        Student myStudent = studentDao.findStudentByName("Cristian");
        System.out.println(myStudent.toString());
    }

/** metodo che legge e ritorna una lista di studenti in base al cognome
*/
    private void readAllStudentBySurname(StudentDao studentDao) {
        List<Student> studentList = studentDao.findAllStudentBySurname("MHOOL");
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

/** metodo che ritorna uno studente in base al suo id
     * */
    private void readStudentById(StudentDao studentDao) {
        // creazione di uno studente
//        Student s = new Student("Franco","Bolgiani","bogliani@gmail.com");
//        studentDao.save(s);
//        System.out.println("Studente Correttamente salvato");
//        System.out.println(s.toString());
        System.out.println("-----");
        Student myStudentRead = studentDao.findStudent(1);

        System.out.println(myStudentRead.toString());
    }

    // ! CREATE METHOD
/** metodo che crea una lista di studenti e li inserisci nel database
     * */
    private void createMultipleStudent(StudentDao studentDao){
        List<Student> studentList=new ArrayList<>();
        // create 3 student
        System.out.println("Creazione studenti");
        Student s1 = new Student("Chad","Molinari","chad@gmail.com");
        Student s2 = new Student("Max","Molinari","max@gmail.com");
        Student s3 = new Student("Frank","Molinari","frank@gmail.com");
        Student s4 = new Student("Davide","Molinari","davide@gmail.com");
        Student s5 = new Student("Eduardo","Molinari","eduardo@gmail.com");
        System.out.println("Studenti creati, ci apprestiamo al salvataggio....");

        studentList.addAll(Arrays.asList(s1,s2,s3,s4,s5));

        studentDao.saveListStudent(studentList);
        System.out.println("Studenti correttamente salvati");
    }

/** metodo che crea un singolo studente e lo inserisce nel dataabse*/
    private void createStudent(StudentDao studentDao) {
        System.out.println("Creazione di un nuovo studente");
        Student s = new Student("Cristian", "Molinari", "cris@gmail.com");

        System.out.println("Salvataggio studente.....");
        studentDao.save(s);
        System.out.println("Studente salvato!!!");
    };

    // ! UPDATE METHOD
    private void upStudent(StudentDao studentDao){
        System.out.println("Cerco lo studente....");
        // assegniamo i valori di ritorno della query ad un new Student
        Student s = studentDao.findStudent(1);
        // settiamo il nostro studente
        s.setFirstName("Scoby-Dog");
        // e lo mergiamo al valore first_name già esistente
        studentDao.updateStudent(s);
        System.out.println("Studente aggiornato con successo");
    }

    private void upListStudent(StudentDao studentDao){
        List<Student> newStudentList = new ArrayList<>();
        List<Student> studentList = studentDao.findAllStudentBySurname("MHOOL");

        System.out.println("lista creata");
        for (Student student : studentList) {
            student.setLastName("Molinari");
            newStudentList.add(student);
        }

        studentDao.updateListStudent(newStudentList);
        System.out.println("Studenti correttamente aggiornati!!");
    }

    // ! DELETE

    private void deleteById(StudentDao studentDao){
        System.out.println("Rimozione studente...");
        studentDao.deleteById(1);
        System.out.println("Studente rimosso");
    }

    private void deleteStudentBySurname(StudentDao studentDao) {
        System.out.println(studentDao.deleteListStudentBySurname("Molinari"));
    }
}
