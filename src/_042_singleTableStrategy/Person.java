package _042_singleTableStrategy;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type",discriminatorType = DiscriminatorType.INTEGER)
@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;




}
