package _043_joinedTableStrategy;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
}
