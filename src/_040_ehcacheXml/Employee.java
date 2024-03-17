package _040_ehcacheXml;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/*
The file ehcache.xml is given. Add a custom setting to it for the Employee entity , with the following attributes:

name attribute with value "Employee";
attribute maxEntriesLocalHeap with value "10000";
maxEntriesLocalDisk attribute with value "1000";
the eternal attribute with the value "false";
diskSpoolBufferSizeMB attribute with value "20";
timeToIdleSeconds attribute with value "300";
timeToLiveSeconds attribute with value "600";
memoryStoreEvictionPolicy attribute with value "LFU";
transactionalMode attribute with value "off".
 */
@Entity
@Table(name = "employee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
