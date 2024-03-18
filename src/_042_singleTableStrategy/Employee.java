package _042_singleTableStrategy;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("2")
public class Employee extends Person{
    private String company;

}
