package _002_Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* 
Entity
Add private fields to the public Animal class :id (Long),name(String),age (Integer),family (String).
The class must have @Entity and @Table annotations (table name animal_table, schema - test).
All fields must have getters and setters.
The id field must have a corresponding annotation.
The remaining fields must have the @Column annotation , which specifies the name of the column. The column name is the same as the field name.
*/
//напишите тут ваш код
@Entity
@Table (name = "animal_table", schema = "test")
public class Animal {
    //напишите тут ваш код
    @Id
    private Long id;
    @Column(name = "name")
    private  String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "family")
    private String family;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getFamily() {
        return family;
    }
}