package pl.sda.OrangeJavaPL2Spring.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Owner {
    private String firstName;
    private String lastName;
    private int age;

}
