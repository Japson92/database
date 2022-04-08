package pl.clockworkjava.advanced.jpa;

import pl.clockworkjava.advanced.jpa.domain.Student;
import pl.clockworkjava.advanced.jpa.domain.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPAApp {

   static  EntityManagerFactory factory = Persistence.createEntityManagerFactory("ClockworkPersistence");

   static  EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {
        entityManager.getTransaction().begin();
        Student pawel = entityManager.merge(new Student("Pawel", "123456"));
        University psk = entityManager.merge(new University("PSK"));

        pawel.setUniversity(psk);
        psk.addStudent(pawel);

        entityManager.merge(pawel);
        entityManager.merge(psk);

        entityManager.getTransaction().commit();

        University university = entityManager.find(University.class, psk.getId());
        System.out.println(university);
    }

    private static void deleteStudents() {
        Student student = entityManager.find(Student.class , 0);
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    private static void updateStudents() {
        Student kinga = new Student("Kinga");
        entityManager.getTransaction().begin();
        Student student = entityManager.merge(kinga);

        student.setTelephone("123456789");

        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }

    private static void readStudents() {
        Student student = entityManager.find(Student.class ,0);
        System.out.println(student);
        List fromStudent  = entityManager.createQuery("from Student").getResultList();
        fromStudent.forEach(System.out::println);
    }

    private static void createStudent() {
        Student pawel = new Student("Paweł");

        entityManager.getTransaction().begin();
        entityManager.persist(pawel);
        entityManager.getTransaction().commit();
    }
}
