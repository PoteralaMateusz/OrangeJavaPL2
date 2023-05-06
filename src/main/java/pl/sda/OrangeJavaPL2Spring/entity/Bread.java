package pl.sda.OrangeJavaPL2Spring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "breads")
public class Bread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    private BigDecimal price;


    public Bread(String name, BreadType breadType, BigDecimal price) {
        this.name = name;
        this.breadType = breadType;
        this.price = price;
    }
}
