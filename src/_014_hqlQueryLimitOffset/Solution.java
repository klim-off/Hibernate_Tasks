package _014_hqlQueryLimitOffset;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/* 
task1008
***
In the getSorted method, get the session from MySessionFactory.getSessionFactory() .
Write a query in hql to get a list of Employees sorted by age.
 The query should return limit Employee starting from offset. The getSorted
method should return the resulting list.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        getSorted(3, 5).forEach(System.out::println);
    }

    public static List<Employee> getSorted(int offset, int limit) {
        //напишите тут ваш код
        Session session = MySessionFactory.getSessionFactory().openSession();
        String hql = "from Employee order by age";
        Query<Employee> query = session.createQuery(hql);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }
}