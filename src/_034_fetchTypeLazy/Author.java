package _034_fetchTypeLazy;

import jakarta.persistence.*;
import java.util.List;

/*
There are three entity classes: Author , Book and Publisher . Author and Publisher are missing margin annotationsbooks.

Add OneToMany and JoinColumn annotations to them . Make sure that when loading Author or Publisher entities , their books are not loaded with them, but proxy objects are created.

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
