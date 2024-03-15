package _023_EntityWithCalculation;

/* 
Entity с вычислением
***
Add private fields to the public class SalariesemployeeID (Long),paymentCode (Boolean),employeeName(String),
basicSalary (double),bonus (double),tax (double)Andtotal (double).
The class must have @Entity and @Table annotations (table name is salaries_table, schema is salaries).
All fields must have getters and setters.
By the field employeeIDAn appropriate annotation must be present.
By the field paymentCode there must be an @Type annotation that correctly specifies the NumericBooleanType .
By the field totalThe @Formula annotation must be present , which calculates the total amount using the formula "basicSalary + bonus - tax".
All fields except employeeID, the @Column annotation must be present , which specifies the name of the column. The column name must match the field name.
*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

//напишите тут ваш код
@Entity
@Table(name = "salaries_table",schema = "salaries")
public class Salaries {
    //напишите тут ваш код
    @Id
    private Long employeeID;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "paymentCode")
    private Boolean paymentCode;
    @Column(name = "employeeName")
    private String employeeName;
    @Column(name = "basicSalary")
    private double basicSalary;
    @Column(name = "bonus")
    private double bonus;
    @Column(name = "tax")
    private double tax;
    @Formula(value ="basicSalary + bonus - tax")
    @Column(name="total")
    private double total;

    public Long getEmployeeID() {
        return employeeID;
    }

    public Boolean getPaymentCode() {
        return paymentCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public void setPaymentCode(Boolean paymentCode) {
        this.paymentCode = paymentCode;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
