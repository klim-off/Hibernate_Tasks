package _032_ManyToMany;

import _032_ManyToMany.entities.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;

/* 
Соавторство
***
There are two entity classes: Author and Book . Tables that correspond to them:

table author with columns id, first_name, last_name, full_name;
table book with columns id, title, publication_year, isbn.
There is also a table author_book, which stores information about which authors wrote which books. It has columns author_id and book_id. Each author can have several books, and each book can have several authors.

Place annotations in the Author class before the field booksand in the Book class before the field authors.

In the main method , get the session from MySessionFactory.getSessionFactory() . Print all 'Mark Twain' co-authors to the console. Let's imagine that in our database there are books that have more than one author and one of them is 'Mark Twain'.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            Query<Author> query = session.createQuery("from Author where fullName = :AUTHOR_FULLNAME", Author.class);
            query.setParameter("AUTHOR_FULLNAME", "Mark Twain");
            Author authorMarkTwain = query.getSingleResult();

            authorMarkTwain.getBooks()
                    .stream()
                    .flatMap(book -> book.getAuthors().stream())
                    .filter(author -> !authorMarkTwain.equals(author))
                    .distinct()
                    .map(Author::getFullName)
                    .forEach(System.out::println);
        }
    }
}
