package CRUDSpring.demoExample.dao;

import CRUDSpring.demoExample.entities.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

//    ! definiamo il gestore di entità
    private EntityManager entityManager;


// ! Inietta o effettua un cablaggio col gestore
    @Autowired
    StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

/* ! Quindi sovrascrivo il metodo dell'interfaccia, marcando questo metodo
   ! come un metodo che deve essere eseguito in modo transazionale,
   ! ricordandoci di utilizza la notation di springFramework
 */
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
