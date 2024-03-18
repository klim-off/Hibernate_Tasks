package _043_joinedTableStrategy;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee extends Person{
    private String company;
}
