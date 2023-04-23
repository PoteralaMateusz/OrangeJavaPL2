package pl.sda.OrangeJavaPL2Spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "bakeries")
public class Bakery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Bread> breadList;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Embedded
    private Owner owner;
}
