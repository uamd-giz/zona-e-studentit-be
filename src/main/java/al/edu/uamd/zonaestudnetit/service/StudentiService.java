package al.edu.uamd.zonaestudnetit.service;

import al.edu.uamd.zonaestudnetit.entity.StudentEntity;
import al.edu.uamd.zonaestudnetit.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentiService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void ruajTeDhenatEStudentit(Student studenti){
        StudentEntity se = new StudentEntity();
        se.setFirstName(studenti.getFirstName());
        se.setLastName(studenti.getLastName());
        se.setTest("Testi i dyte");
        entityManager.persist(se);
    }

    public List<Student> ngarkoStudentet(){
        List<StudentEntity> studentet =
                entityManager.createNamedQuery("StudentEntity.getAll", StudentEntity.class).getResultList();
        List result = new ArrayList();
        for(StudentEntity student : studentet){
            Student studentResult = new Student();
            studentResult.setFirstName(student.getFirstName());
            studentResult.setLastName(student.getLastName());
            result.add(studentResult);
        }
        return  result;
    }
}
