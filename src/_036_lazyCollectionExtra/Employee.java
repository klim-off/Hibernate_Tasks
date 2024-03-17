package _036_lazyCollectionExtra;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;

/*
There are two entity classes: Employee and StatisticView .
For Employee , replace the fetch parameter of the OneToMany annotation with the LazyCollection annotation
with the value EXTRA.
 Replace the JoinColumn annotation with OrderColumn with the same parameter.
 */

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "smth")
    private String smth;

    @Column(name = "salary")
    private Integer salary;

    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.EXTRA)
    @OrderColumn(name = "employee_id")
    //@JoinColumn(name = "employee_id")
    private List<StatisticView> statistics = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSmth() {
        return smth;
    }

    public void setSmth(String smth) {
        this.smth = smth;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

