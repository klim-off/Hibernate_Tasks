package _041_mappedSuperClassStrategy;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee extends Person{
private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
