package _013_hqlQuerySetParameter;

import jdk.jfr.StackTrace;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
task1007
***
In the getIn method , get the session from MySessionFactory.getSessionFactory() .
Write a query in hql to get a list of Employees whose smth is equal to one of the rows from the list in .
Employee should be sorted by age in ascending order. Return the list you received.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        getIn(List.of("hr", "dev", "qa")).forEach(System.out::println);
    }

    public static List<Employee> getIn(List<String> in) {
        //напишите тут ваш код
        Session session = MySessionFactory.getSessionFactory().openSession();
        String hql = "from Employee where smth in (:smthList) order by age";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        query.setParameter("smthList",in);
        return  query.list();

    }
}