package pl.clockworkjava.advanced.jpa.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Professor {

    @Id
    private int id;
    private String name;
    private String telephone;

    @Embedded
    private Adress adress;

    private Professor(){

    }

    public Professor(int id, String name) {
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
                '}';
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



}
