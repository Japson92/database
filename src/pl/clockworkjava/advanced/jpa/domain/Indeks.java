package pl.clockworkjava.advanced.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Indeks {
    @Id
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

    public Indeks(int id, String number) {
        this.id = id;
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

