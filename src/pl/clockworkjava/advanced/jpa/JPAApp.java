package pl.clockworkjava.advanced.jpa;

import pl.clockworkjava.advanced.jpa.domain.Indeks;
import pl.clockworkjava.advanced.jpa.domain.Student;
import pl.clockworkjava.advanced.jpa.domain.University;

import javax.persistence.*;
import java.util.List;

public class JPAApp {

   static  EntityManagerFactory factory = Persistence.createEntityManagerFactory("ClockworkPersistence");

   static  EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {

        createData();
        TypedQuery<QueryResult> query = entityManager.createQuery("SELECT new pl.clockworkjava.advanced.jpa.QueryResult(s.name, s.indeks.number) FROM Student s WHERE s.name IN ('Pawel', 'John')", QueryResult.class);

      //  query.getResultList().forEach(System.out::println);

        List<CountResult> resultList = entityManager.createQuery("SELECT new pl.clockworkjava.advanced.jpa.CountResult(s.name, COUNT(s)) FROM Student s GROUP BY s.name HAVING s.name IN ('Pawel', 'John') ORDER BY s.name", CountResult.class).getResultList();
        resultList.forEach(System.out::println);


//        TypedQuery<Indeks> query = entityManager.createQuery("SELECT s.indeks FROM Student s WHERE s.name = :studentName", Indeks.class);
//        query.setParameter("studentName","John");
//        System.out.println(query.getSingleResult());
    }

    private static void createData() {
        entityManager.getTransaction().begin();
        entityManager.merge(new Student("Pawel", "123456"));
        entityManager.merge(new Student("John", "654321"));
        entityManager.merge(new Student("Pawel", "123459"));
        entityManager.merge(new Student("Pawel", "126556"));

        entityManager.getTransaction().commit();
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
