package pl.clockworkjava.advanced.jpa.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Student.GetAll", query = "SELECT s FROM Student s"),
        @NamedQuery(name = "Student.byName", query = "SELECT s FROM Student s WHERE s.name = :name")
})

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    private String telephone;

    @Embedded
    private Adress adress;

    @OneToOne(cascade = CascadeType.ALL)
    private Indeks indeks;

    @ManyToOne
    private University university;

    @ManyToMany
    private Set<Classes> classes;

    public Student(String name, String indexNumber) {
        this.name = name;
        this.indeks = new Indeks(indexNumber);
        this.classes = new HashSet<>();
    }

    private Student(){

    }

    public Indeks getIndeks() {
        return indeks;
    }


    public Student(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", indeks=" + indeks +
                '}';
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setIndeks(Indeks idx){
        this.indeks = idx;
    }


    public void setUniversity(University university) {
        this.university = university;
    }

    public void addClasses(Classes classes){
        this.classes.add(classes);
    }
}


