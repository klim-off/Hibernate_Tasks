package _010_arrangementOfAnnotations;

/*
There are three entity classes: Author , Book and Publisher .
Place annotations in them, taking into account that Author and Publisher are Book fields .
For simplicity, we assume that each book can only have one author.

Relevant tables:

table publisher with columns id , name ;
table author with columns id , first_name , last_name , full_name ;
book table with columns id , title , author_id , publisher_id , publication_year , isbn .

 */
import jakarta.persistence.*;
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "full_name")
    private String fullName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
