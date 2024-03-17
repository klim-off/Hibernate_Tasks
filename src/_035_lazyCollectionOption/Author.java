package _035_lazyCollectionOption;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import java.util.List;

/*
There are three entity classes: Author , Book and Publisher .

For Author and Publisher, replace the fetch parameter of the OneToMany annotation with the equivalent LazyCollection annotation .

Relevant tables:

publisher table with columns id, name, type, discoverer, discovery_date;
table author with columns id, first_name, last_name, full_name;
book table with columns id, title, author_id, publisher_id, publication_year, isbn.
 */

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

    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "author_id")
    private List<Book> books;

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
