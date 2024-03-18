package _044_strategyTablePerClass;

import jakarta.persistence.Entity;

/*
Look at the script for creating tables. Create three entity classes based on these tables that describe the Table per class strategy.

Client and Employee inherit from Person . Add correct annotations to the created classes. Don't forget about the necessary parameters in the annotations.

Script:

create table person
(
id int auto_increment primary key,
name varchar(100) not null,
age int not null
);

create table client
(
id int auto_increment primary key,
name varchar(100) not null,
age int not null,
bank varchar(100) not null
);

create table employee
(
id int auto_increment primary key,
name varchar(100) not null,
age int not null,
company varchar(100) not null
);


 */
@Entity
public class Client extends Person{
    private String bank;
}
