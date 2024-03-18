package _044_strategyTablePerClass;

import jakarta.persistence.Entity;

@Entity
public class Employee extends Person {
    private String company;
}
