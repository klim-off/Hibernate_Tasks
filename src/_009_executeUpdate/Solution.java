package _009_executeUpdate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/* 
task1003
***
In the promoteAll method, get the session from MySessionFactory.getSessionFactory() .
Write a query in hql to add 'senior' to the beginning of the current value of the smth column for all employees.
For example, if the value of smth was 'admin' , then it should become 'senior admin' .
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        promoteAll();
    }

    public static void promoteAll() {
        //напишите тут ваш код
        Session session = MySessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "update Employee set smth = concat('senior ', smth)";
        Query<Employee> query = session.createQuery(hql);
        query.executeUpdate();
        tx.commit();

    }
}