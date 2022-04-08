package pl.clockworkjava.advanced.jpa.domain;

import javax.persistence.*;

@Entity
public class Indeks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String number;

    @OneToOne(mappedBy = "indeks")
    private Student owner;

    public void setOwner(Student owner) {
        this.owner = owner;
    }

    public Student getOwner() {
        return owner;
    }


    private Indeks(){

    }

    public Indeks(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Indeks{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }



}

