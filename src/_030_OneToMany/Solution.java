package _030_OneToMany;


import _030_OneToMany.entities.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;



/* 
Автор книги или книга автора?
***
There are three entity classes: Author , Book and Publisher , and the tables that correspond to them:

publisher table with columns id, name;
table author with columns id, first_name, last_name, full_name;
book table with columns id, title, author_id, publisher_id, publication_year, isbn.
Place annotations in the Author class before the field books.

In the main method , get the session from MySessionFactory.getSessionFactory() .
 Write an hql query to get the author with the full name 'Mark Twain'.

Print all his books to the console.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        try (Session session = MySessionFactory.getSessionFactory().openSession()){
            String hql = "from Author where fullName = :authorFullName";
            Query<Author> query = session.createQuery(hql,Author.class);
            query.setParameter("authorFullName", "Mark Twain");
            Author author = query.getSingleResult();

            author.getBooks().forEach(System.out::println);
        }

    }
}
