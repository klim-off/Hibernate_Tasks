package _043_joinedTableStrategy;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
/*
Look at the script for creating tables. Create three entity classes for these tables that describe the Joined Table strategy.

Client and Employee inherit from Person . Add correct annotations to the created classes. Don't forget about the necessary parameters in the annotations.

Script:

CREATE TABLE `person`
(
`id` INT not null auto_increment,
`name` VARCHAR(100) not null,
`age` INT not null,
PRIMARY KEY (id)
);

CREATE TABLE `employee`
(
`person_id` INT not null,
`company` VARCHAR(100) not null
);

CREATE TABLE `client`
(
`person_id` INT not null,
`bank` VARCHAR(100) not null
);


 */
@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class Client extends Person{
    private String bank;
}
