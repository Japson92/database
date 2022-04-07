package pl.clockworkjava.advanced.jpa;

import pl.clockworkjava.advanced.jpa.domain.Indeks;
import pl.clockworkjava.advanced.jpa.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPAApp {

   static  EntityManagerFactory factory = Persistence.createEntityManagerFactory("ClockworkPersistence");

   static  EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {
        entityManager.getTransaction().begin();
        Student pawel = entityManager.merge(new Student(0, "Pawel"));
        Indeks indeks = entityManager.merge(new Indeks(0, "123456"));

        pawel.setIndeks(indeks);

        pawel = entityManager.merge(pawel);

        indeks.setOwner(pawel);

        entityManager.merge(indeks);

        entityManager.getTransaction().commit();
        System.out.println(pawel);

        Indeks idx = entityManager.find(Indeks.class, 0);
        System.out.println(idx);


    }

    private static void deleteStudents() {
        Student student = entityManager.find(Student.class , 0);
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    private static void updateStudents() {
        Student kinga = new Student(1,"Kinga");
        entityManager.getTransaction().begin();
        Student student = entityManager.merge(kinga);

        student.setTelephone("123456789");

        entityManager.merge(student);
        entityManager.getTransaction().commit();
    }

    private static void readStudents() {
        Student student = entityManager.find(Student.class , 0);
        System.out.println(student);
        List fromStudent  = entityManager.createQuery("from Student").getResultList();
        fromStudent.forEach(System.out::println);
    }

    private static void createStudent() {
        Student pawel = new Student(0, "Paweł");

        entityManager.getTransaction().begin();
        entityManager.persist(pawel);
        entityManager.getTransaction().commit();
    }
}
