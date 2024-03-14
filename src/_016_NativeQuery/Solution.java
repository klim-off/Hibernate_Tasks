package _016_NativeQuery;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

/* 
task1010
**
In the getAll method, get the session from MySessionFactory.getSessionFactory() .
Using a session, create a NativeQuery to retrieve all Employees from the employee table in ascending order by id .
 The getAll method should return the resulting list.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        getAll().forEach(System.out::println);
    }

    public static List<Employee> getAll() {
        //напишите тут ваш код
        Session session = MySessionFactory.getSessionFactory().openSession();
        String sql = "select * from employee order by id";
        NativeQuery <Employee> query = session.createNativeQuery(sql, Employee.class);
        return query.list();

    }
}