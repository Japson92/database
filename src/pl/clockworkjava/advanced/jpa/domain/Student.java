package pl.clockworkjava.advanced.jpa.domain;


import javax.persistence.*;

@Entity

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

    public Student(String name, String indexNumber) {
        this.name = name;
        this.indeks = new Indeks(indexNumber);
    }


    public Indeks getIndeks() {
        return indeks;
    }

    private Student(){

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


}
