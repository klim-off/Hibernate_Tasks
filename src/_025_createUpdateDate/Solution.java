package _025_createUpdateDate;

/* 
Время создания и изменения данных
***
Add private fields to the public class Solutionid (Long),name(String),createDate(Date)AndupdateDate(Date).
The Solution class must have @Entity and @Table annotations (table name is names_table, schema is test).
All fields must have getters and setters.
All fields must have appropriate annotations.
By the fieldidThe @Id annotation must be present .
By the fieldnamethere must be a @Column annotation that specifies the name of the column "name".
By the fieldcreateDateThe @Column annotation must be present , which specifies the column name "create_date", and all other necessary annotations that are required for the column that stores the creation date of the record.
By the fieldupdateDateThe @Column annotation must be present , which specifies the column name "update_date", and all other necessary annotations that are required for the column that stores the date the record was last modified.
*/

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

//напишите тут ваш код
@Entity
@Table(name = "names_table", schema = "test")
public class Solution {
        //напишите тут ваш код
    @Id
    private Long  id;
    @Column(name = "name")
    private String name;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}
