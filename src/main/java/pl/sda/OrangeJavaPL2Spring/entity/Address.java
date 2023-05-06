package pl.sda.OrangeJavaPL2Spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int number;
    private String postalCode;
    private String country;

    public Address(String name, int number, String postalCode, String country) {
        this.name = name;
        this.number = number;
        this.postalCode = postalCode;
        this.country = country;
    }
}
