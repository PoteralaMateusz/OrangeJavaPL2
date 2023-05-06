package pl.sda.OrangeJavaPL2Spring.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Owner {
    private String firstName;
    private String lastName;
    private int age;

    public Owner(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Owner() {

    }
}
