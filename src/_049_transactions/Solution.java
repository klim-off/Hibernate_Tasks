package _049_transactions;

import org.hibernate.Session;
import org.hibernate.Transaction;

/* 
Транзакции
In the switchToRemote method :

In the employee table, add the row 'virtual' to the beginning of smth for all users whose smth began with 'office'.
For example, if the value of smth was 'office manager', then it should become 'virtual office manager'.
In the task table, delete all records whose title column was 'Buy coffee' or 'Clean up the office'.
Everything must happen in one transaction.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        switchToRemote();
    }

    public static void switchToRemote() {
        try (Session session = MySessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();

            session.createQuery("update Employee e set e.smth = concat('virtual ', e.smth) where e.smth like 'office%'").executeUpdate();
            session.createQuery("delete from Task t where t.title = 'Buy coffee' or t.title = 'Clean up the office'").executeUpdate();

            transaction.commit();
        }
    }
}