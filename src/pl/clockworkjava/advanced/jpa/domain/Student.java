package pl.clockworkjava.advanced.jpa.domain;


import javax.persistence.*;

@Entity

public class Student {

    @Id
    private int id;
    private String name;
    private String telephone;

    @Embedded
    private Adress adress;

    @OneToOne
    private Indeks indeks;

    public Indeks getIndeks() {
        return indeks;
    }

    private Student(){

    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
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
