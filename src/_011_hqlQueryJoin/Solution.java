package _011_hqlQueryJoin;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.javarush.task.sql.task10.task1005.entities.Book;

import java.util.List;

/* 
task1005

In the main method , get the session from MySessionFactory.getSessionFactory() .
Write an hql query to get books from the book table whose author's full_name is 'Mark Twain'
and publisher's name is 'Chatto & Windus' .
Output the resulting books to the console.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<Book> books;
        //напишите тут ваш код
        Session session = MySessionFactory.getSessionFactory().openSession();
        String hql = "from Book b where author.fullName = 'Mark Twain' and publisher.name = 'Chatto & Windus'";
        Query<Book> query = session.createQuery(hql, Book.class);
        books = query.list();
        books.forEach(System.out::println);
    }
}