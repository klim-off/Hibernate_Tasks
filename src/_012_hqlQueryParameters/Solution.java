package _012_hqlQueryParameters;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
task1006
***
In the getBetween method, get the session from MySessionFactory.getSessionFactory() .
Write a query in hql to get a list of Employees whose age is greater than the from parameter,
 but less than the to parameter.
Employee should be sorted by age in ascending order. Return the list you received.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        getBetween(25, 32).forEach(System.out::println);
    }

    public static List<Employee> getBetween(int from, int to) {
        //напишите тут ваш код
        Session session = MySessionFactory.getSessionFactory().openSession();
        String hql = "from Employee where age > :from and age < :to order by age";
        Query <Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("from",from);
        query.setParameter("to",to);
        return query.list();

    }
}