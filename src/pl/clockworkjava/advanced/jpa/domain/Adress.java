package pl.clockworkjava.advanced.jpa.domain;

import javax.persistence.Embeddable;


@Embeddable
public class Adress {

    private String street;
    private String apartment;
    private String postalCode;
    private String city;

    public Adress() {
    }

    public Adress(String street, String apartment, String postalCode, String city) {
        this.street = street;
        this.apartment = apartment;
        this.postalCode = postalCode;
        this.city = city;
    }

}
