package _022_Enumerated;

import jakarta.persistence.*;

/* 
Создаём Entity из класса
***
Add private fields to the public Library classid (Long),status(PublicationStatus),
publicationName (String)Andisbn (String).
The class must have the annotations @Entity and @Table (table name library_table).
All fields must have getters and setters.
By the fieldidAn appropriate annotation must be present.
By the fieldstatusthere must be an @Enumerated annotation, which specifies the ordinal enum type, as well as a @Column
annotation , which specifies the column name, which is the same as the field name.
The remaining fields must have the @Column annotation , which specifies the name of the column.
The column name must match the field name.
*/

//напишите тут ваш код
@Entity
@Table(name = "library_table")
public class Library {
    //напишите тут ваш код
    @Id
    private  Long id;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private PublicationStatus status;
    @Column(name = "publicationName")
    private String publicationName;
    @Column(name = "isbn")
    private String isbn;

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(PublicationStatus status) {
        this.status = status;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public PublicationStatus getStatus() {
        return status;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public String getIsbn() {
        return isbn;
    }
}
