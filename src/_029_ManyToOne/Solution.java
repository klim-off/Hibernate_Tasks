package _029_ManyToOne;

import _029_ManyToOne.entities.Publisher;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

/* 
Опять книги
***
There are three entity classes: Author , Book and Publisher , and the tables that correspond to them:

publisher table with columns id, name;
table author with columns id, first_name, last_name, full_name;
book table with columns id, title, author_id, publisher_id, publication_year, isbn.
Pace annotations in the Book class before the fields author And publisher.
 At the moment we believe that each book can have only one author and only one publisher.
In the main method , get the session from MySessionFactory.getSessionFactory() .
Write an hql query to get all publishers who published the author 'Mark Twain'.
Print the names of the resulting publishers to the console.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<Publisher> publishers;
        Session session = MySessionFactory.getSessionFactory().openSession();
        String hql = "select b.publisher from Book b where b.author.fullName = : author_full_name";
        Query<Publisher> query = session.createQuery(hql, Publisher.class);
        query.setParameter("author_full_name", "Mark Twain");
        publishers = query.list();
        //напишите тут ваш код
        session.close();
        publishers.stream().map(Publisher::getName).forEach(System.out::println);
    }
}
