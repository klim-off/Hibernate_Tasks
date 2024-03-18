package _041_mappedSuperClassStrategy;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*

Look at the script for creating tables. Create entity classes for these tables. Pay attention to the fields that are repeated.

To avoid duplication, use inheritance. Add correct annotations to the created classes. Don't forget about the field Long idin each entity class.

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
`id` INT not null auto_increment,
`name` VARCHAR(100) not null,
`age` INT not null,
`company` VARCHAR(100) not null,
PRIMARY KEY (id)
);

CREATE TABLE `client`
(
`id` INT not null auto_increment,
`name` VARCHAR(100) not null,
`age` INT not null,
`bank` VARCHAR(100) not null,
PRIMARY KEY (id)
);
 */

@Entity
@Table
public class Client extends Person {
    private String bank;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
