package _042_singleTableStrategy;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/*
Look at the script for creating the person table. Create three entity classes for this table, which describe the Single Table strategy: in addition to the Person entity, Client entity classes should be created (with a fieldbank) and Employee (with fieldcompany), which you inherit from Person .

Objects of the Client and Employee classes must be stored in the same table (person) using numeric descriptors. For Client use descriptor value 1, for Employee - 2.

Correctly place annotations on the created classes. Don't forget about the necessary parameters in the annotations.

Script:

CREATE TABLE `person`
(
`id` INT not null auto_increment,
`name` VARCHAR(100) null,
`age` INT null,
`bank` VARCHAR(100) null,
`company` VARCHAR(100) null,
`person_type` INT not null,
PRIMARY KEY (id)
);


 */
@Entity
@DiscriminatorValue("1")
public class Client extends Person{
    private String bank;

}
