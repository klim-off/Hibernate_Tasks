package _008_hqlQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;

/* 
task1002
***
In the getDirector method, get the session from MySessionFactory.getSessionFactory() .
Write a query in hql to get an Employee whose smth = 'director'.
The query result expects one value, return it in the getDirector method .
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(getDirector());
    }

    public static Employee getDirector() {
        //напишите тут ваш код
        Session session = MySessionFactory.getSessionFactory().openSession();
        String hql = "from Employee e where e.smth = 'director'";
        Query<Employee> query = session.createQuery(hql);
       return query.uniqueResult();

    }
}