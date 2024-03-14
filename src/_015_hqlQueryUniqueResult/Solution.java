package _015_hqlQueryUniqueResult;

import org.hibernate.Session;
import org.hibernate.query.Query;

/* 
task1009
***
In the getSalaryFund method, get the session from MySessionFactory.getSessionFactory() .
Write a query in HQL to get the sum of the values of the salary column . The getSalaryFund
method should return the amount.

In the getAverageAge method, get the session from MySessionFactory.getSessionFactory() .
Write a query in hql to get the average value of the age column . The getAverageAge
method should return the average value
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        System.out.println("Salary fund: $" + getSalaryFund());
        System.out.println("Agerage age: " + getAverageAge());
    }

    public static Long getSalaryFund() {
        //напишите тут ваш код
        Session session = MySessionFactory.getSessionFactory().openSession();
        String hql = "select sum(salary) from Employee";
        Query <Long> query = session.createQuery(hql, Long.class);
        return query.uniqueResult();
    }

    public static Double getAverageAge() {
        //напишите тут ваш код
        Session session = MySessionFactory.getSessionFactory().openSession();
        String hql = "select avg(age) from Employee";
        Query<Double> query = session.createQuery(hql, Double.class);
        return query.uniqueResult();

    }
}