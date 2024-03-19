package _048_nativeQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
Метод list
In the main method , get all the values of the id, title, created_time columns of the project table. Use NativeQuery.

Print all the results to the console, separating the columns with a comma and a space, each entry on a new line.

For example:

4, Moon Lander, 2018-11-28 14:56:35.0
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            List<Object[]> list = session.createNativeQuery("select id, title, created_time from project").list();
            list.forEach(a -> System.out.printf("%s, %s, %s\n", a[0], a[1], a[2]));
        }
    }
}